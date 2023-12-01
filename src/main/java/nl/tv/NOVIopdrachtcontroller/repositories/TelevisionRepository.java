package nl.tv.NOVIopdrachtcontroller.repositories;

import nl.tv.NOVIopdrachtcontroller.model.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository  extends JpaRepository<Television, Long> {
    List<Television> findByNameContaining(String name);

}
