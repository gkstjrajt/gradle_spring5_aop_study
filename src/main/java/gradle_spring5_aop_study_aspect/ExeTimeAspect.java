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
	 * @Around�ֳ����̼���Around Advice������
	* publicTarget()�޼��忡 ������ Pointcut�� �������� �������� spring5_aop_study��Ű���� ������Ű���� ����
	* ��ü�� public �޼��忡 @around�� ����measure() �޼��带����
	* measure() �޼����� ProceedingJoinPointŸ���Ķ���ʹ� ���Ͻô��ü�� �޼��带 ȣ���Ҷ� ����ϸ� preceed()�޼��带
	* ����ؼ� �������ü��
	* �޼��带 ȣ���Ѵ�.
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
			System.out.printf("%s.%s(%s) ���� �ð� : %d ns%n", joinPoint.getTarget().getClass().getSimpleName(), sig.getName(),
					Arrays.deepToString(joinPoint.getArgs()), (finish - start));
		}
	}
	
	
	
}
