package github.haozi.uauth.config;

import github.haozi.uauth.domain.ProfileEntity;
import github.haozi.uauth.domain.enumeration.Sex;
import github.haozi.uauth.repository.ProfileRepo;
import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.util.Daos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 15:56
 */
@Configuration
public class DbConfig implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(DbConfig.class);
    @Autowired
    private Dao dao;
    @Autowired
    private ProfileRepo profileRepo;

    @Bean
    public Dao nutDao(DataSource dataSource) {
        Dao dao = new NutDao(dataSource);
        return dao;
    }

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
        Pager pager = new Pager(1, 1);
        List<ProfileEntity> list = profileRepo.query(Cnd.where("name", "=", "wanghao"), pager);
        if (profileRepo.count(Cnd.where("name", "=", "wanghao")) > 0) {
            return;
        }
        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setName("wanghao");
        profileEntity.setSex(Sex.MALE);
        profileEntity.setIdNumber("320");
        ProfileEntity added = profileRepo.addProfile(profileEntity);
        log.info("add profile success: {}", added.getId());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        initSchema(dao);
        initData(profileRepo);
        migrateSchema(dao);
    }
}
