package Restaurant.RestaurantManagement.Service;

import Restaurant.RestaurantManagement.Entity.MenuItem;

import java.util.List;

public interface MenuItemService {
    MenuItem createMenuItem(MenuItem menuItem);
    MenuItem updateMenuItem(Long id, MenuItem menuItem);
    void deleteMenuItem(Long id);
    List<MenuItem> getAllMenuItems();
}
