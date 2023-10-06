package com.example.wondugallery.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * @author admin
 * @version 1.0
 * @project wondu-gallery
 * @package com.example.wondugallery.config
 * @date 2023-10-06
 * @explanation
 */
@Configuration
@Profile( value = { "local" , "dev" , "prod" })
public class DBConfig {
    private static final Logger dbConfigLog = LoggerFactory.getLogger(DBConfig.class);
    private HikariConfig hikariConfig;

    @Autowired
    @Qualifier("mySqlHikariConfig")
    public void setDataSource(HikariConfig hikariConfig){
        this.hikariConfig = hikariConfig;
    }

    @Bean
    public DataSource dataSource(){

        HikariDataSource hd = null;

        try {
            String profile = System.getProperty( "spring.profiles.active" , "local" );
            HikariConfig config = hikariConfig;
            hd = new HikariDataSource( config );

            dbConfigLog.info( "===========================" );
            dbConfigLog.info( "환경  : " + profile );
            dbConfigLog.info( "URL  : " + config.getJdbcUrl() );
            dbConfigLog.info( "USER : " + config.getUsername() );
            dbConfigLog.info( "돌아가고 있나용: " + hd.isRunning() );
            dbConfigLog.info( "===========================" );

        }
        catch ( Exception e ) {
            dbConfigLog.error( "DB 연결 실패" );
            e.printStackTrace();
        }

        return hd;
    }

    /** JAVA 설정 사용시 아래 Bean을 등록하고 여기서 처리해야 함 */
		/*@Bean
		public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
				return new PersistenceExceptionTranslationPostProcessor();
		}

		@Bean
		public PlatformTransactionManager transactionManager() {
				JpaTransactionManager transactionManager = new JpaTransactionManager();
				transactionManager.setEntityManagerFactory( entityManagerFactory().getObject() );

				return transactionManager;
		}

		@Bean
		public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

				LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

				em.setDataSource( dataSource() );
				em.setPackagesToScan( "com.minhyun" );
				JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
				em.setJpaVendorAdapter( vendorAdapter );
				return em;
		}*/


}

