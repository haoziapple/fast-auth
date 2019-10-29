package github.haozi.uauth.repository;

import github.haozi.uauth.domain.ProfileEntity;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.QueryResult;
import org.nutz.dao.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public ProfileEntity addProfile(ProfileEntity profileEntity) {
        ProfileEntity added = dao.insert(profileEntity);
        return added;
    }

    public List<ProfileEntity> query(Condition condition, Pager pager) {
        return dao.query(ProfileEntity.class, condition, pager);
    }

    public int count(Condition condition) {
        return dao.count(ProfileEntity.class, condition);
    }
}
