package github.haozi.uauth.repository;

import github.haozi.uauth.common.PageInfo;
import github.haozi.uauth.domain.ProfileEntity;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 16:21
 */
@Repository
public class ProfileRepo {
    @Autowired
    private Dao dao;

    public ProfileEntity create(ProfileEntity profileEntity) {
        ProfileEntity added = dao.insert(profileEntity);
        return added;
    }

    public int update(ProfileEntity profileEntity) {
        int updated = dao.update(profileEntity);
        return updated;
    }

    public int conditionUpdate(ProfileEntity profileEntity, Condition condition) {
        int updated = dao.update(profileEntity, condition);
        return updated;
    }

    public List<ProfileEntity> query(Condition condition) {
        return dao.query(ProfileEntity.class, condition, null);
    }

    public PageInfo<ProfileEntity> pageQuery(Condition condition, Pager pager) {
        if (pager == null) {
            pager = new Pager(1, Integer.MAX_VALUE);
        }
        pager.setRecordCount(count(condition));

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pager.getPageNumber());
        pageInfo.setPageSize(pager.getPageSize());
        pageInfo.setTotal(pager.getRecordCount());
        pageInfo.setPages(pager.getPageCount());
        if (pageInfo.getTotal() == 0) {
            pageInfo.setList(new ArrayList(0));
        } else {
            pageInfo.setList(dao.query(ProfileEntity.class, condition, pager));
        }
        return pageInfo;
    }

    public int count(Condition condition) {
        return dao.count(ProfileEntity.class, condition);
    }

    public ProfileEntity detail(String id) {
        return dao.fetch(ProfileEntity.class, id);
    }

    public int delete(String id) {
        int deleted = dao.delete(ProfileEntity.class, id);
        return deleted;
    }
}
