package com.technobangla.spring.config;

import javax.sql.DataSource;

import com.technobangla.spring.dao.*;

import com.technobangla.spring.model.OrganizationIndustry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages={"com.technobangla.spring.controller"})
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");

		//resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/erpdb");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		
		return dataSource;
	}
	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}

	@Bean
	public TestDAO getTesDAO() {
		return new TestDAOImpl(getDataSource());
	}

	@Bean
	public OrganizationTypeDAO getOrganizationTypeDAO() {
		return new OrganizationTypeDAOImpl(getDataSource());
	}

	@Bean
	public OrganizationIndustryDAO getOrganizationIndustryDAO() {
		return new OrganizationIndustryDAOImpl(getDataSource());
	}

	@Bean
	public DepartmentDAO getDepartmentDAO() {
		return new DepartmentDAOImpl(getDataSource());
	}

	@Bean
	public DesignationDAO getDesignationDAO() {
		return new DesignationDAOImpl(getDataSource());
	}

	@Bean
	public LeadStepsDAO getLeadStepsDAO() {
		return new LeadStepsDAOImpl(getDataSource());
	}

	@Bean
	public CompanyDAO getCompanyDAO() {
		return new CompanyDAOImpl(getDataSource());
	}

	@Bean
	public EmployeeDAO getEmployeeDAO() {
		return new EmployeeDAOImpl(getDataSource());
	}

	@Bean
	public AccountInfoDAO getAccountInfoDAO() {
		return new AccountInfoDAOImpl(getDataSource());
	}

	@Bean
	public AccountContactDAO getAccountContactDAO() {
		return new AccountContactDAOImpl(getDataSource());
	}

	@Bean
	public UserDAO getUserDAO() {
		return new UserDAOImpl(getDataSource());
	}


}
