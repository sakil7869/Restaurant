package Restaurant.RestaurantManagement.Repository;

import Restaurant.RestaurantManagement.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role , Long> {
   Optional<Role> findByName(String roleName);

}
