package vn.iotstar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import vn.iotstar.configs.MySiteMeshFilter;

@SpringBootApplication
public class Demo1SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Demo1SpringbootApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<MySiteMeshFilter> siteMeshFilter() {
	    FilterRegistrationBean<MySiteMeshFilter> filterRegistrationBean = 
	            new FilterRegistrationBean<MySiteMeshFilter>();
	    filterRegistrationBean.setFilter(new MySiteMeshFilter()); // adding sitemesh filter ??
	    filterRegistrationBean.addUrlPatterns("/*");
	    return filterRegistrationBean;
	}


}
