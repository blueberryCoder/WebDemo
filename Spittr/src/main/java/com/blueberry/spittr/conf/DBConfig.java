package com.blueberry.spittr.conf;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;


/**
 * Created by Administrator on 11/29/2016.
 */
@PropertySource("classpath:/conf/database.properties")
@Configuration
public class DBConfig {


    @Autowired
    Environment env;

    /**
     * 使用嵌入式数据源，作为开发数据源。
     *
     * @return {@link EmbeddedDatabase}
     */
    @Profile("development")
    @Bean
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:/h2/schema.sql")
                .addScript("classpath:/h2/test-data.sql")
                .build();
    }

    /**
     * 使用数据源连接池,使用Apache Commons DBCP的开源实现。作为QA数据源
     *
     * @return {@link BasicDataSource}
     */
    @Profile("qa")
    @Bean
    public BasicDataSource data() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        ds.setUrl(env.getProperty("jdbc.url"));
        ds.setUsername(env.getProperty("jdbc.username"));
        ds.setPassword(env.getProperty("jdbc.password"));
        ds.setInitialSize(Integer.parseInt(env.getProperty("jdbc.initialSize")));
        ds.setMaxActive(Integer.parseInt(env.getProperty("jdbc.maxActive")));
        return ds;
    }

    /**
     * 使用JNDI数据源，可以在WebSphere,JBoss或Tomcat这样的Web容器中，配置JNDI数据源。作为生产环境数据源。
     *
     * @return {@link JndiObjectFactoryBean}
     */
    @Profile("production")
    @Bean
    public JndiObjectFactoryBean dataSource() {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName("jdbc/spittrDS");
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
        return jndiObjectFactoryBean;
    }

    /**
     * 使用JDBC驱动的数据源。
     *
     * @return
     */
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//        ds.setUrl(env.getProperty("jdbc.url"));
//        ds.setUsername(env.getProperty("jdbc.username"));
//        ds.setPassword(env.getProperty("jdbc.password"));
//        return ds;
//    }

    /**
     * 使用jdbc模板。
     *
     * @param dataSource
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 获得SessionFactory.会自动调用{@link LocalSessionFactoryBean#getObject()}方法
     *
     * @param dataSource
     * @return
     */
//    @Bean
//    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
//        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
//        sfb.setDataSource(dataSource);
//        sfb.setPackagesToScan("com.blueberry.spittr.beans");
//        Properties properties = new Properties();
//
//        setDatabaseDialect(dataSource, properties);
//
//        sfb.setHibernateProperties(properties);
////        sfb.setAnnotatedClasses(new );
//        return sfb;
//    }

    private void setDatabaseDialect(DataSource dataSource, Properties properties) {
        if (dataSource instanceof EmbeddedDatabase) {
            properties.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        } else {
            properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        }
    }

    /**
     * 异常转换功能。
     *
     * @return
     */
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }


    /**
     * 使用容器管理类型的JPA
     *
     * @param dataSource
     * @param jpaVendorAdapter
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            DataSource dataSource, JpaVendorAdapter jpaVendorAdapter
    ) {
        LocalContainerEntityManagerFactoryBean emfb
                = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        emfb.setPackagesToScan("com.blueberry.beans");
        return emfb;
    }

    @Profile("development")
    @Bean
    public JpaVendorAdapter h2JpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.H2);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
        return adapter;
    }

    @Profile({"qa", "production"})
    @Bean
    public JpaVendorAdapter mysqlJpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.MYSQL);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
        return adapter;
    }


}
