package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Profile;

import java.util.List;
import java.util.Map;

public interface IProfileService {
    List<Profile> getAllProfileS();
    Profile getProfileS(long id);
    Profile getProfileByOuth0IdIs(String Outh0Id);
    Profile getProfileByEmailS(String email);
    Profile createProfileS(Profile employee);
    Boolean updateProfileS(Profile employee);
    Boolean deleteProfileS(long id);
    Profile getOrCreateProfileS(Map<String, Object> userData);
}


