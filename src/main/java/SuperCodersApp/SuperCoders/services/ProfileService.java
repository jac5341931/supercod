package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Employee;
import SuperCodersApp.SuperCoders.entities.Profile;
import SuperCodersApp.SuperCoders.repositories.IProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProfileService implements IProfileService{

    IProfileRepository profileRepository;

    public ProfileService(IProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAllProfileS() {
        return this.profileRepository.findAll();
    }

    public List<Profile> getProfilesByEmployeeIsNull() {
        return this.profileRepository.findProfilesByEmployeeIsNull();
    }

    @Override
    public Profile getProfileS(long id) {
        return this.profileRepository.findById(id);
    }

    @Override
    public Profile createProfileS(Profile profile) {
        return this.profileRepository.save(profile);
    }

    @Override
    public Boolean updateProfileS(Profile profile) {
        try {
            this.profileRepository.save(profile);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Boolean deleteProfileS(long id) {
        try {
            this.profileRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Profile getProfileByOuth0IdIs(String Outh0Id){
        return this.profileRepository.findByOuth0IdIs(Outh0Id);
    }

    @Override
    public Profile getProfileByEmailS(String email) {
        return this.profileRepository.findByEmail(email);
    }

    public Profile getOrCreateProfileS(Map<String, Object> userData){
        String email = (String) userData.get("email");
        Profile user = getProfileByEmailS(email);
        Employee employee= null;

        if(user==null){
            String name = (String) userData.get("name");
            String nickname = (String) userData.get("nickname");
            String email1 = (String) userData.get("email");
            String outh0Id = (String) userData.get("sub");
            String image = (String) userData.get("picture");
            String phone = (String) userData.get("phone");

            Profile newUser = new Profile(name, nickname, email1, image, phone,outh0Id,employee);
            return createProfileS(newUser);
        }
        return user;
    }
}





