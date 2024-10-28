package Restaurant.RestaurantManagement.Repository;

import Restaurant.RestaurantManagement.Entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem , Long> {
}
