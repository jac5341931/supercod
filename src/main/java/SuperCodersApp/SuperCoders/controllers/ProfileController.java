package SuperCodersApp.SuperCoders.controllers;

import SuperCodersApp.SuperCoders.entities.Profile;
import SuperCodersApp.SuperCoders.services.ProfileService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Generaliza la ruta a todos los metodos
@RequestMapping("profile")
public class ProfileController {

    ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping
    public List<Profile> getAllProfile() {
        return this.profileService.getAllProfileS();
    }

    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable("id") long id) {
        return this.profileService.getProfileS(id);
    }


    @PostMapping
    public Boolean createProfile(@RequestBody Profile profile) {
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
}
