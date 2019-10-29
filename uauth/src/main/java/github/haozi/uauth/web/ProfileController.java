package github.haozi.uauth.web;

import github.haozi.uauth.common.ActionResult;
import github.haozi.uauth.service.dto.ProfileDTO;
import lombok.extern.slf4j.Slf4j;
import org.nutz.lang.random.R;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 13:41
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class ProfileController {

    /**
     * @param profileDTO
     * @return
     * @throws URISyntaxException
     */
    @PostMapping("/createProfile")
    public ActionResult<ProfileDTO> createProfile(@RequestBody ProfileDTO profileDTO) throws URISyntaxException {
        // TODO create profile
        profileDTO.setId(R.UU16());
        return ActionResult.ok(profileDTO);
    }

    /**
     * @param profileDTO
     * @return
     * @throws URISyntaxException
     */
    @PostMapping("/updateProfile")
    public ActionResult<ProfileDTO> updateProfile(@RequestBody ProfileDTO profileDTO) throws URISyntaxException {
        // TODO update profile
        return ActionResult.ok(profileDTO);
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/getProfile/{id}")
    public ActionResult<ProfileDTO> getProfile(@PathVariable String id) {
        // TODO get profile detail
        return ActionResult.ok(new ProfileDTO());
    }

    /**
     * @param id
     * @return
     */
    @PostMapping("/deleteProfile/{id}")
    public ActionResult<Void> deleteProfile(@PathVariable String id) {
        // TODO delete profile
        return ActionResult.ok(null);
    }
}
