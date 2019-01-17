package os.visshal.osbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"os.visshal.osbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	private final static String DATABASE_URL = "jdbc:h2:~/test";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USRENAME = "sa";
	private final static String DATABASE_PASSWORD = "";
	
	//dataSource bean will be available
	@Bean
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		//providing  database connection information; 
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USRENAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
			
	}
	
	//sessionFactory bean will be available
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
	
	LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);	
		
	builder.addProperties(getHibernateProperties()); 
	builder.scanPackages("os.visshal.osbackend.dto");
		
	return builder.buildSessionFactory();
				
	}

	//all the hibernte propeties will be returned in this method
	private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
	
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.format_sql","true");
		
		return properties;
	}
	
	@Bean
	public HibernateTransactionManager  getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
	
	return transactionManager;	
	
	}
	
	
	
	}
	
	
	
	
	
	

