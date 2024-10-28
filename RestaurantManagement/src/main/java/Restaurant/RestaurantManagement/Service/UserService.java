package Restaurant.RestaurantManagement.Service;

import Restaurant.RestaurantManagement.Entity.User;

public interface UserService {

    User findByUserName(String username);

    User saveUser(User user);

    void assignRoleToUser(String username, String roleName);
}
