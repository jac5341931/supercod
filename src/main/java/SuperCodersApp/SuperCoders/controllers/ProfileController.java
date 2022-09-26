package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Employee;
import SuperCodersApp.SuperCoders.entities.Profile;
import SuperCodersApp.SuperCoders.services.ProfileService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//Generaliza la ruta a todos los metodos
@RequestMapping("profile")
public class ProfileController {

    ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    //@GetMapping
    public List<Profile> getAllProfile() {
        return this.profileService.getAllProfileS();
    }

    public List<Profile> getAllProfileWithoutEmployee() {
        return this.profileService.getProfilesByEmployeeIsNull();
    }


    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable("id") long id) {
        return this.profileService.getProfileS(id);
    }

    public Profile getProfileByOuth0Id(String Outh0Id){
        return this.profileService.getProfileByOuth0IdIs(Outh0Id);
    }


    //@PostMapping
    public Profile createProfile(@RequestBody Profile profile) {
        return this.profileService.createProfileS(profile);
    }

    @PatchMapping("/{id}")
    public Boolean updateProfile(@PathVariable("id") long id, @RequestBody Profile profile) {
        Profile e1 = this.profileService.getProfileS(id);
        if (e1 != null) {
            try {
                return this.profileService.updateProfileS(profile);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @DeleteMapping("/{id}")
    public Boolean deleteProfile(@PathVariable("id") long id) {
        return this.profileService.deleteProfileS(id);
    }

    public Profile getOrCreateProfile(Map<String, Object> userData){
        return this.profileService.getOrCreateProfileS(userData);
    }
}
