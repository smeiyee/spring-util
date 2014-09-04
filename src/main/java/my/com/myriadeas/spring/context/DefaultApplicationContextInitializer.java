package my.com.myriadeas.spring.context;

import java.io.IOException;

import my.com.myriadeas.spring.core.util.SpringEnvironmentUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

/**
 * Default Application Context Initializer for Myriadeas. Default implementation
 * will load environment initialization
 * reference http://gordondickens.com/wordpress/2012/06/12/spring-3-1-environment-profiles/
 * @author hutingung
 */
public class DefaultApplicationContextInitializer implements
		ApplicationContextInitializer<ConfigurableApplicationContext> {

	/**
	 * Default environment properties file.
	 */
	private static final String ENV_PROPERTIES = "env.properties";

	private static final Logger logger = LoggerFactory
			.getLogger(DefaultApplicationContextInitializer.class);

	public void initialize(ConfigurableApplicationContext applicationContext) {
		logger.debug("Initializing application context for environment");
		ConfigurableEnvironment environment = applicationContext
				.getEnvironment();
		try {
			logger.debug("Register env.properties");
			environment.getPropertySources().addFirst(
					new ResourcePropertySource("classpath:" + ENV_PROPERTIES));
			for(String activeProfile : environment.getActiveProfiles()) {
				logger.debug("Active profile set to= " + activeProfile);	
			}
		} catch (IOException e) {
			logger.info("didn't find env.properties in classpath so not loading it in the AppContextInitialized");
			logger.info("Set default profile to " + SpringEnvironmentUtil.DEV);
			environment.setDefaultProfiles(SpringEnvironmentUtil.DEV);
		}
	}
}
