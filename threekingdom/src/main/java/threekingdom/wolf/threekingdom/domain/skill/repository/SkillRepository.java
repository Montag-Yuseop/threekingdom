package threekingdom.wolf.threekingdom.domain.skill.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threekingdom.wolf.threekingdom.domain.skill.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
