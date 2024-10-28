package Restaurant.RestaurantManagement.Service;

import Restaurant.RestaurantManagement.Entity.Role;

public interface RoleService {
    Role saveRole(Role role);
    Role findByName(String roleName);
}
