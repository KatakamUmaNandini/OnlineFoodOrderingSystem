package services;
//import models.*;
import models.Item;
import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private List<Item> menu = new ArrayList<>();
    private int itemId = 1;

    public MenuService() {
        addItem("Burger", 99.0);
        addItem("Pizza", 199.0);
        addItem("Fries", 49.0);
    }

    public void addItem(String name, double price) {
        menu.add(new Item(itemId++, name, price));
    }

    public void removeItem(int id) {
        menu.removeIf(item -> item.getId() == id);
    }

    public List<Item> getMenu() {
        return menu;
    }

    public Item getItemById(int id) {
        for (Item item : menu) {
            if (item.getId() == id) return item;
        }
        return null;
    }

    public List<Item> getMenuSortedByPriceUsingMergeSort(boolean ascending) {
        List<Item> sortedMenu = new ArrayList<>(menu);
        mergeSort(sortedMenu, 0, sortedMenu.size() - 1, ascending);
        return sortedMenu;
    }

    private void mergeSort(List<Item> items, int left, int right, boolean ascending) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(items, left, mid, ascending);
            mergeSort(items, mid + 1, right, ascending);

            merge(items, left, mid, right, ascending);
        }
    }

    private void merge(List<Item> items, int left, int mid, int right, boolean ascending) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<Item> L = new ArrayList<>();
        List<Item> R = new ArrayList<>();

        for (int i = 0; i < n1; i++) L.add(items.get(left + i));
        for (int j = 0; j < n2; j++) R.add(items.get(mid + 1 + j));

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if ((ascending && L.get(i).getPrice() <= R.get(j).getPrice()) ||
                (!ascending && L.get(i).getPrice() >= R.get(j).getPrice())) {
                items.set(k++, L.get(i++));
            } else {
                items.set(k++, R.get(j++));
            }
        }

        while (i < n1) items.set(k++, L.get(i++));
        while (j < n2) items.set(k++, R.get(j++));
    }
}