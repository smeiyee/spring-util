package my.com.myriadeas.spring.core.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
* reference http://blog.springsource.org/2011/06/21/spring-3-1-m2-testing-with-configuration-classes-and-profiles/
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = { Config.class })
@ActiveProfiles(SpringEnvironmentUtil.DEV)
public class SpringEnvironmentUtilTest {

	@Autowired
	private SpringEnvironmentUtil envUtil;

	@Test
	public void test() {
		assertTrue(envUtil.isDev());
		assertFalse(envUtil.isProd());
		assertFalse(envUtil.isStaging());
		assertFalse(envUtil.isTest(	));
	}

}
