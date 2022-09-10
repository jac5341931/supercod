package SuperCodersApp.SuperCoders.services;

import SuperCodersApp.SuperCoders.entities.Profile;

import java.util.List;

public interface IProfileService {
    List<Profile> getAllProfileS();
    Profile getProfileS(long id);
    Boolean createProfileS(Profile employee);
    Boolean updateProfileS(Profile employee);
    Boolean deleteProfileS(long id);
}


