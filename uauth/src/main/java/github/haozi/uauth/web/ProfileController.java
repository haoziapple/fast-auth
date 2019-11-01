package github.haozi.uauth.web;

import github.haozi.uauth.common.ActionResult;
import github.haozi.uauth.common.PageInfo;
import github.haozi.uauth.common.SearchCommonVO;
import github.haozi.uauth.domain.ProfileQueryDTO;
import github.haozi.uauth.service.ProfileService;
import github.haozi.uauth.service.dto.ProfileDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

import static github.haozi.uauth.common.Constants.API_URL;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 13:41
 */
@RestController
@RequestMapping(API_URL + "profile")
@Slf4j
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    /**
     * @param profileDTO
     * @return
     * @throws URISyntaxException
     */
    @PostMapping("/create")
    public ActionResult<ProfileDTO> create(@RequestBody ProfileDTO profileDTO) {
        // create profile
        return ActionResult.ok(profileService.create(profileDTO));
    }

    /**
     * @param profileDTO
     * @return
     * @throws URISyntaxException
     */
    @PostMapping("/update")
    public ActionResult<Void> update(@RequestBody ProfileDTO profileDTO) {
        int updated = profileService.update(profileDTO);
        if(updated > 0) {
            return ActionResult.ok(null);
        }else {
            return ActionResult.fail(null);
        }
    }

    @PostMapping("/query")
    public ActionResult<List<ProfileDTO>> query(@RequestBody ProfileQueryDTO criteria) {
        return ActionResult.ok(profileService.query(criteria));
    }

    @PostMapping("/pageQuery")
    public ActionResult<PageInfo<ProfileDTO>> pageQuery(@RequestBody SearchCommonVO<ProfileQueryDTO> search) {
        return ActionResult.ok(profileService.pageQuery(search));
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    public ActionResult<ProfileDTO> detail(@PathVariable String id) {
        // get profile detail
        return ActionResult.ok(profileService.detail(id));
    }

    /**
     * @param id
     * @return
     */
    @PostMapping("/delete/{id}")
    public ActionResult<Void> delete(@PathVariable String id) {
        // delete profile
        profileService.delete(id);
        return ActionResult.ok(null);
    }
}
