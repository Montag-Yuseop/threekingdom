package threekingdom.wolf.threekingdom.domain.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threekingdom.wolf.threekingdom.domain.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
