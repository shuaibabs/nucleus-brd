package brd.config;

import brd.model.MasterCustomer;
import brd.model.TempCustomer;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.annotation.Resource;
import java.util.Properties;

@Configuration
@ComponentScan("brd")
@EnableTransactionManagement
@EnableWebMvc
@PropertySource("classpath:db.properties")
public class AppConfig {
	@Resource
	Environment env;
	@Bean
	public InternalResourceViewResolver getResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	@Bean
	public LocalSessionFactoryBean getSessionFactoryBean(){
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setHibernateProperties(hibernateProperties());
		bean.setAnnotatedClasses(TempCustomer.class, MasterCustomer.class);
		return bean;
	}
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.hbm2ddl.auto","update");
		properties.put("current_session_context_class","thread");
		return properties;
    }
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("db.driver"));
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.username"));
		ds.setPassword(env.getProperty("db.password"));
		return ds;
		
	}
	 @Bean
	     public HibernateTransactionManager transactionManager() {
		 HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	 	        transactionManager.setSessionFactory(getSessionFactoryBean().getObject());
	 	        return transactionManager;
	}
}



