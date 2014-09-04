package my.com.myriadeas.spring.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * Utility class based on {@link Environment} to determine current environment.
 * Specifically designed for Spring Environment
 * @author hutingung
 *
 */
@Service("envUtil")
public class SpringEnvironmentUtil {

	public static final String PROD = "production";

	public static final String STAGING = "staging";

	public static final String TEST = "testing";

	public static final String DEV = "development";

	@Autowired
	private Environment env;

	public Boolean isProd() {
		return env.acceptsProfiles(PROD);
	}

	public Boolean isDev() {
		return env.acceptsProfiles(DEV);
	}

	public Boolean isStaging() {
		return env.acceptsProfiles(STAGING);
	}

	public Boolean isTest() {
		return env.acceptsProfiles(TEST);
	}

	public Environment getEnv() {
		return env;
	}
}
