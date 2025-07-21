package services;

//import models.Item;
//import services.MenuService;

public class AdminService {
    private MenuService menuService;

    public AdminService(MenuService menuService) {
        this.menuService = menuService;
    }

    public void addItem(String name, double price) {
        menuService.addItem(name, price);
    }

    public void removeItem(int id) {
        menuService.removeItem(id);
    }
}