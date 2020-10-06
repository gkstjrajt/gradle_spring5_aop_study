package gradle_spring5_aop_study_aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeTimeAspect {
	@Pointcut("execution(public * gradle_spring5_aop_study_aop03..*(..))")
	private void publicTarget() {}
	/** @throws Throwable 
	 * @Around애노테이션은Around Advice를설정
	* publicTarget()메서드에 정의한 Pointcut에 공통기능을 적용으로 spring5_aop_study패키지나 하위패키지에 속한
	* 빈객체의 public 메서드에 @around가 붙은measure() 메서드를적용
	* measure() 메서드의 ProceedingJoinPoint타입파라미터는 프록시대상객체의 메서드를 호출할때 사용하며 preceed()메서드를
	* 사용해서 실제대상객체의
	* 메서드를 호출한다.
	*/
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행 시간 : %d ns%n", joinPoint.getTarget().getClass().getSimpleName(), sig.getName(),
					Arrays.deepToString(joinPoint.getArgs()), (finish - start));
		}
	}
	
	
	
}
