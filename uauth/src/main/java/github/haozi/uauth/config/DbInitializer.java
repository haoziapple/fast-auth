package github.haozi.uauth.config;

import com.google.common.collect.Lists;
import github.haozi.uauth.domain.ProfileEntity;
import github.haozi.uauth.domain.enumeration.Sex;
import github.haozi.uauth.repository.ProfileRepo;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.util.Daos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanghao
 * @Description
 * @date 2019-11-01 11:03
 */
@Component
public class DbInitializer implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(DbInitializer.class);
    @Autowired
    private Dao dao;
    @Autowired
    private ProfileRepo profileRepo;

    public void initSchema(Dao dao) {
        // dao.create(ProfileEntity.class, false);
        // 初始化多个表
        Daos.createTablesInPackage(dao, "github.haozi.uauth.domain", false);
    }

    public void initData(ProfileRepo profileRepo) {
        initProfileData(profileRepo);
    }

    public void migrateSchema(Dao dao) {
        Daos.migration(dao, "github.haozi.uauth.domain", true, false, false);
    }

    private void initProfileData(ProfileRepo profileRepo) {
        Cnd where = Cnd.where("name", "=", "wanghao");
        // 尝试条件查询
        List<ProfileEntity> list = profileRepo.query(where);
        profileRepo.count(where);
        // 尝试批量更新
        profileRepo.conditionUpdate(Chain
                .makeSpecial("age", "+1")
                .add("creator", "admin"), where);

        // 测试单条插入
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setName("wanghao");
        profileEntity.setSex(Sex.MALE);
        profileEntity.setIdNumber("320");
        profileEntity.setAge(18);
        ProfileEntity added = profileRepo.create(profileEntity);
        log.info("add profile success: {}", added);

        List<ProfileEntity> entityList = Lists.asList(new ProfileEntity(), new ProfileEntity(), new ProfileEntity[]{});
        // 测试批量插入
        entityList = profileRepo.batchCreate(entityList);
        log.info("batch add success: {}", entityList);

        // 测试根据id批量查询
        entityList = profileRepo.batchDetails(list.stream().map(ProfileEntity::getId).collect(Collectors.toList()));
        log.info("batch detail success: {}", entityList);

        // 测试根据id批量删除
        int deleted = profileRepo.batchDelete(list.stream().map(ProfileEntity::getId).collect(Collectors.toList()));
        log.info("batch delete success: {}", deleted);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initSchema(dao);
        migrateSchema(dao);
        initData(profileRepo);
    }
}
