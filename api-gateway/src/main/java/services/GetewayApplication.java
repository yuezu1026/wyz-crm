package services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import services.filter.AccessTokenFilter;

@EnableSidecar
@EnableZuulProxy
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class GetewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(GetewayApplication.class, args);
	}
	
	@Bean
    public AccessTokenFilter accessFilter() {
        return new AccessTokenFilter();
    }
	
}
