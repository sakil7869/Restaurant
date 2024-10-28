package Restaurant.RestaurantManagement.Controller;

import Restaurant.RestaurantManagement.Entity.User;
import Restaurant.RestaurantManagement.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/admin")
public class UserController {

    private final UserService userService;

    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/assign-role")
    public void assignRole(@RequestParam String username, @RequestParam String role) {
        userService.assignRoleToUser(username, role);
    }
}
