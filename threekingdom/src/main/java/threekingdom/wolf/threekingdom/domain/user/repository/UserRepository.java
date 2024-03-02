package threekingdom.wolf.threekingdom.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import threekingdom.wolf.threekingdom.domain.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNicknameContaining(String nickname);

    Optional<User> findByNickname(String nickname);

}
