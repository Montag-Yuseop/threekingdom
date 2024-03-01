package threekingdom.wolf.threekingdom.domain.hero.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threekingdom.wolf.threekingdom.domain.hero.entity.Hero;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
