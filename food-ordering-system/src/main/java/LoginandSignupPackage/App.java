package LoginandSignupPackage;

import services.UserService;
import services.MenuService;
import services.ItemService;
import models.Item;

import static spark.Spark.*;

import java.util.List;

import com.google.gson.Gson;

public class App {

    // Shared service instances
    private static UserService userService = new UserService();
    private static MenuService menuService = new MenuService();
    private static ItemService itemService = new ItemService(); // Create itemService object
    private static Gson gson = new Gson();            

    public static void main(String[] args) {
        staticFiles.location("/public"); // HTML, CSS, JS in resources/public/

        // Redirect root to signup.html
        get("/", (req, res) -> {
            res.redirect("/signup.html");
            return null;
        });

        // Signup route
        post("/signup", (req, res) -> {
            String name = req.queryParams("name");
            String password = req.queryParams("password");

            boolean success = userService.register(name, password);
            return success ? "Signup successful for: " + name : "Username already exists. Please try another.";
        });

        // Login route
        post("/login", (req, res) -> {
            String name = req.queryParams("name");
            String password = req.queryParams("password");

            boolean loggedIn = userService.login(name, password);
            return loggedIn ? "Login successful. Welcome " + name + "!" : "Invalid username or password.";
        });

        // ✅ API Route to get menu items (JSON)
        get("/menu", (req, res) -> {
            res.type("application/json");
            return new com.google.gson.Gson().toJson(menuService.getMenu());
        });
        get("/search", (req, res) -> {
            String keyword = req.queryParams("keyword");

            List<Item> results = itemService.searchItems(keyword);

            res.type("application/json");
            return gson.toJson(results);
        });
    }
}
