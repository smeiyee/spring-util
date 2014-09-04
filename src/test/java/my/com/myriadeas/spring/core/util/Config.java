package my.com.myriadeas.spring.core.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(basePackages = "my.com.myriadeas", excludeFilters = { @Filter(Configuration.class) })
@Profile(SpringEnvironmentUtil.DEV)
public class Config {

}
