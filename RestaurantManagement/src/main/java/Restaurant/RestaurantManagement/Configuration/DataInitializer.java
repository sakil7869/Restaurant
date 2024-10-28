package Restaurant.RestaurantManagement.Configuration;

import Restaurant.RestaurantManagement.Entity.Role;
import Restaurant.RestaurantManagement.Entity.User;
import Restaurant.RestaurantManagement.Repository.RoleRepository;
import Restaurant.RestaurantManagement.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class DataInitializer {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner init(RoleRepository roleRepository, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        return args -> {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);

            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);

            User adminUser = new User();
            adminUser.setUserName("admin");
            adminUser.setPassword(bCryptPasswordEncoder.encode("adminpassword"));
            Set<Role> adminRoles = new HashSet<>();
            adminRoles.add(adminRole);
            adminUser.setRoles(adminRoles);
            userRepository.save(adminUser);

            User normalUser = new User();
            normalUser.setUserName("user");
            normalUser.setPassword(bCryptPasswordEncoder.encode("userpassword"));
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(userRole);
            normalUser.setRoles(userRoles);
            userRepository.save(normalUser);


        };
    }
}
