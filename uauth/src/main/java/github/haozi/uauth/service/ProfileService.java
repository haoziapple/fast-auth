package github.haozi.uauth.service;

import github.haozi.uauth.common.PageInfo;
import github.haozi.uauth.common.SearchCommonVO;
import github.haozi.uauth.domain.ProfileQueryDTO;
import github.haozi.uauth.domain.ProfileEntity;
import github.haozi.uauth.repository.ProfileRepo;
import github.haozi.uauth.service.dto.ProfileDTO;
import github.haozi.uauth.service.mapper.ProfileMapper;
import org.nutz.dao.Condition;
import org.nutz.dao.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 14:22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProfileService {
    @Autowired
    private ProfileRepo profileRepo;

    public ProfileDTO create(ProfileDTO profileDTO) {
        Assert.notNull(profileDTO, "profileDTO is null!");
        ProfileEntity entity = ProfileMapper.INSTANCE.dtoToEntity(profileDTO);
        ProfileEntity created = profileRepo.create(entity);
        return ProfileMapper.INSTANCE.entityToDto(created);
    }

    public int update(ProfileDTO profileDTO) {
        Assert.notNull(profileDTO, "profileDTO is null!");
        ProfileEntity entity = ProfileMapper.INSTANCE.dtoToEntity(profileDTO);
        return profileRepo.update(entity);
    }

    public List<ProfileDTO> query(ProfileQueryDTO criteria) {
        Assert.notNull(criteria, "criteria is null!");
        Condition cnd = criteria.condition();
        List<ProfileEntity> entityList = profileRepo.query(cnd);
        return ProfileMapper.INSTANCE.entitiesToDtos(entityList);
    }

    public PageInfo<ProfileDTO> pageQuery(SearchCommonVO<ProfileQueryDTO> search) {
        Assert.notNull(search, "search is null!");
        Assert.notNull(search.getFilters(), "criteria is null!");
        Condition cnd = search.getFilters().condition();
        PageInfo pageInfo = profileRepo.pageQuery(cnd, new Pager(search.getPageNum(), search.getPageSize()));
        pageInfo.setList(ProfileMapper.INSTANCE.entitiesToDtos(pageInfo.getList()));
        return pageInfo;
    }

    public ProfileDTO detail(String id) {
        Assert.hasText(id, "id is empty!");
        ProfileEntity entity = profileRepo.detail(id);
        return ProfileMapper.INSTANCE.entityToDto(entity);
    }

    public int delete(String id) {
        Assert.hasText(id, "id is empty!");
        return profileRepo.delete(id);
    }
}
