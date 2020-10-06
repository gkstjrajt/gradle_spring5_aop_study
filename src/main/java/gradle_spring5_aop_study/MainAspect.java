package gradle_spring5_aop_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gradle_spring5_aop_study.config.AppCtx;
import gradle_spring5_aop_study_aop03.RecCalculator;

public class MainAspect {
	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);){
//			Calculator cal = ctx.getBean("calculator", calculator.class);
			RecCalculator cal = ctx.getBean("calculator", RecCalculator.class);
			long fiveFact = cal.factorial(5);
			System.out.printf("cal.factorial(5) = %d%n", fiveFact);
			System.out.println(cal.getClass().getName());
		}
	}
}
