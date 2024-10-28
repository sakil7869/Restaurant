package Restaurant.RestaurantManagement.Controller;

import Restaurant.RestaurantManagement.Entity.MenuItem;
import Restaurant.RestaurantManagement.Service.MenuItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class MenuItemController {

    private final MenuItemService menuItemService;

    @PostMapping("/admin/menu-items")
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.createMenuItem(menuItem);
    }

    @PutMapping("/admin/menu-items/{id}")
    public MenuItem updateMenuItem(@PathVariable Long id, @RequestBody MenuItem menuItem) {
        return menuItemService.updateMenuItem(id, menuItem);
    }

    @DeleteMapping("/admin/menu-items/{id}")
    public void deleteMenuItem(@PathVariable Long id) {
        menuItemService.deleteMenuItem(id);
    }

    @GetMapping("/user/menu-items")
    public List<MenuItem> getAllMenuItems() {
        return menuItemService.getAllMenuItems();
    }
}
