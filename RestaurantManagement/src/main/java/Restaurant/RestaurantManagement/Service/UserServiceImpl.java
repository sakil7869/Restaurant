package Restaurant.RestaurantManagement.Service;

import Restaurant.RestaurantManagement.Entity.Role;
import Restaurant.RestaurantManagement.Entity.User;
import Restaurant.RestaurantManagement.Repository.RoleRepository;
import Restaurant.RestaurantManagement.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public User findByUserName(String username) {
        return userRepository.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User saveUser(User user) {
        // Create a set to hold managed roles
        Set<Role> managedRoles = new HashSet<>();

        // For each role in the user's role set, retrieve it from the database
        for (Role role : user.getRoles()) {
            Optional<Role> existingRole = roleRepository.findByName(role.getName());
            existingRole.ifPresent(managedRoles::add); // Add existing role to the managed set
        }

        // Assign the managed roles to the user
        user.setRoles(managedRoles);

        // Save the user to the database
        return userRepository.save(user);
    }

    @Override
    public void assignRoleToUser(String username, String roleName) {
        // Find the user by username
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Find the role by name
        Role role = roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // Add the role to the user's roles
        user.getRoles().add(role);

        // Save the user back to the database
        userRepository.save(user);
    }
}
