package SuperCodersApp.SuperCoders.repositories;

import SuperCodersApp.SuperCoders.entities.Employee;
import SuperCodersApp.SuperCoders.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfileRepository extends JpaRepository<Profile, Long> {
    Profile findById(long Id);
    Profile findByEmail(String email);

    Profile findByNickname(String nickname);

    Profile findByOuth0IdIs(String Outh0Id);

    List<Profile> findProfilesByEmployeeIsNull();


}


