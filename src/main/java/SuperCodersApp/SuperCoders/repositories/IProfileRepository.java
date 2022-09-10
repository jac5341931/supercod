package SuperCodersApp.SuperCoders.repositories;

import SuperCodersApp.SuperCoders.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfileRepository extends JpaRepository<Profile, Long> {
    Profile findById(long Id);
}


