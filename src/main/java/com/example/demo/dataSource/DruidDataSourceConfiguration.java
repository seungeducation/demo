/*
 * package com.example.demo.dataSource; import java.util.ArrayList; import
 * java.util.List; import org.apache.ibatis.session.SqlSessionFactory; import
 * org.mybatis.spring.SqlSessionFactoryBean; import
 * org.mybatis.spring.annotation.MapperScan; import org.slf4j.Logger; import
 * org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.beans.factory.annotation.Qualifier; import
 * org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
 * import
 * org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
 * import
 * org.springframework.boot.context.properties.EnableConfigurationProperties;
 * import org.springframework.boot.web.servlet.ServletRegistrationBean; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.io.support.PathMatchingResourcePatternResolver;
 * import org.springframework.jdbc.datasource.DataSourceTransactionManager;
 * import org.springframework.transaction.PlatformTransactionManager; import
 * org.springframework.transaction.support.TransactionTemplate; import
 * com.alibaba.druid.filter.Filter; import
 * com.alibaba.druid.filter.stat.StatFilter; import
 * com.alibaba.druid.pool.DruidDataSource;
 *//**
    * @author yuanxingwei
    * @date 2018/9/6 14:07
    */
/*
 * @Configuration
 * @EnableConfigurationProperties({ DruidDataSourceProperties.class })
 * @MapperScan(value = { "com.example.demo.dal" }, sqlSessionFactoryRef =
 * "SqlSessionFactory")
 * @ConditionalOnProperty(name = "druid.datasource.url", matchIfMissing = false)
 * public class DruidDataSourceConfiguration { private static final Logger
 * logger = LoggerFactory.getLogger(DruidDataSourceConfiguration.class); private
 * static final String MAPPER_LOCATION = "classpath*:sqlmap/*Mapper.xml";
 * @Autowired() private DruidDataSourceProperties druidDataSourceProperties;
 * @Bean(name = "DruidDataSource", initMethod = "init", destroyMethod = "close")
 * @ConditionalOnMissingBean(name = "DruidDataSource") public DruidDataSource
 * javaReadDruidDataSource() { DruidDataSource result = new DruidDataSource();
 * try { result.setName(druidDataSourceProperties.getName());
 * result.setUrl(druidDataSourceProperties.getUrl());
 * result.setUsername(druidDataSourceProperties.getUsername());
 * result.setPassword(druidDataSourceProperties.getPassword());
 * result.setConnectionProperties( "config.decrypt=true;config.decrypt.key=" +
 * druidDataSourceProperties.getPwdPublicKey()); result.setFilters("config");
 * result.setMaxActive(druidDataSourceProperties.getMaxActive());
 * result.setInitialSize(druidDataSourceProperties.getInitialSize());
 * result.setMaxWait(druidDataSourceProperties.getMaxWait());
 * result.setMinIdle(druidDataSourceProperties.getMinIdle());
 * result.setTimeBetweenEvictionRunsMillis(druidDataSourceProperties.
 * getTimeBetweenEvictionRunsMillis());
 * result.setMinEvictableIdleTimeMillis(druidDataSourceProperties.
 * getMinEvictableIdleTimeMillis());
 * result.setValidationQuery(druidDataSourceProperties.getValidationQuery());
 * result.setTestWhileIdle(druidDataSourceProperties.isTestWhileIdle());
 * result.setTestOnBorrow(druidDataSourceProperties.isTestOnBorrow());
 * result.setTestOnReturn(druidDataSourceProperties.isTestOnReturn());
 * result.setPoolPreparedStatements(druidDataSourceProperties.
 * isPoolPreparedStatements());
 * result.setMaxOpenPreparedStatements(druidDataSourceProperties.
 * getMaxOpenPreparedStatements()); result.setUseGlobalDataSourceStat(true); if
 * (druidDataSourceProperties.isEnableMonitor()) { StatFilter filter = new
 * StatFilter(); filter.setLogSlowSql(druidDataSourceProperties.isLogSlowSql());
 * filter.setMergeSql(druidDataSourceProperties.isMergeSql());
 * filter.setSlowSqlMillis(druidDataSourceProperties.getSlowSqlMillis());
 * List<Filter> list = new ArrayList<>(); list.add(filter);
 * result.setProxyFilters(list); } } catch (Exception e) {
 * logger.error("数据源加载失败:{}", e); } finally { result.close(); } return result; }
 * @Bean(name = "TransactionManager")
 * @ConditionalOnMissingBean(name = "TransactionManager") public
 * DataSourceTransactionManager transactionManager(@Qualifier("DruidDataSource")
 * DruidDataSource druidDataSource) { return new
 * DataSourceTransactionManager(druidDataSource); }
 * @Bean(name = "TransactionManager")
 * @ConditionalOnMissingBean(name = "TransactionManager") public
 * TransactionTemplate transactionTemplate(@Qualifier("TransactionManager")
 * PlatformTransactionManager platformTransactionManager) { return new
 * TransactionTemplate(platformTransactionManager); }
 * @Bean(name = "SqlSessionFactory")
 * @ConditionalOnMissingBean(name = "SqlSessionFactory") public
 * SqlSessionFactory sqlSessionFactory(@Qualifier("DruidDataSource")
 * DruidDataSource druidDataSource) throws Exception { final
 * SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
 * sessionFactory.setDataSource(druidDataSource);
 * sessionFactory.setMapperLocations(new
 * PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION)); return
 * sessionFactory.getObject(); }
 *//**
    * 注册druid数据源统计servlet， 用于监控数据源页面
    * <p>
    * 访问地址：http://ip:port/druid/index.html
    *
    * @return
    *//*
       * @Bean(name = "druidServlet")
       * @ConditionalOnProperty(name = "druid.datasource.enable-monitor",
       * havingValue = "true")
       * @ConditionalOnMissingBean(name = "druidServlet") public
       * ServletRegistrationBean registerDruidStatServlet() { return new
       * ServletRegistrationBean(new
       * com.alibaba.druid.support.http.StatViewServlet(), "/druid/*"); } }
       */
