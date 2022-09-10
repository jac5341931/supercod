package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Profile;
import SuperCodersApp.SuperCoders.repositories.IProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Profile getProfileS(long id) {

        return this.profileRepository.findById(id);
    }

    @Override
    public Boolean createProfileS(Profile profile) {
        if(profile.getId() == 0L){
            //employee.setId(0L);
            this.profileRepository.save(profile);
            return true;
        }else{
            return false;
        }
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
}





