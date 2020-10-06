package gradle_spring5_aop_study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import gradle_spring5_aop_study_aop03.Calculator;
import gradle_spring5_aop_study_aop03.RecCalculator;
import gradle_spring5_aop_study_aspect.CacheAspect;
import gradle_spring5_aop_study_aspect.ExeTimeAspect;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppCtx {
	
	@Bean
	public CacheAspect cacheAspect() {
		return new CacheAspect();
	}
	
	@Bean
	public ExeTimeAspect exeTimeAspect() {
		return new ExeTimeAspect();
	}
	
	@Bean
	public  Calculator calculator() {
		return new RecCalculator();
	}
}
