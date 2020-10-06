package gradle_spring5_aop_study_aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

public class CacheAspect {
	private Map<Long, Object> cache = new HashMap<>();
	
	@Pointcut("execution(public * gradle_spring5_aop_study_aop03..*(long))")
	public void cacheTarget() {}
	
	@Around("cacheTarget()")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		Long num = (Long) joinPoint.getArgs()[0];
		System.out.println(num);
		if(cache.containsKey(num)) {
			System.out.printf("CacheAspect : Cache���� ����[%d]%n", num);
			return cache.get(num);
		}
		
		Object result = joinPoint.proceed();
		cache.put(num, result);
		System.out.printf("CacheAspect : Cache�� �߰�[%d]%n", num);
		return result;
	}
	
}
