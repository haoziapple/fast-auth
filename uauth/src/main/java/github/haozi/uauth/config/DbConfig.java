package github.haozi.uauth.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 15:56
 */
@Configuration
public class DbConfig {
    private static final Logger log = LoggerFactory.getLogger(DbConfig.class);

    @Bean
    public Dao nutDao(DataSource dataSource, @Value("${validationQuery}") String validationQuery) {
        if(dataSource instanceof DruidDataSource) {
            ((DruidDataSource) dataSource).setValidationQuery(validationQuery);
        }

        Dao dao = new NutDao(dataSource);
        return dao;
    }
}
