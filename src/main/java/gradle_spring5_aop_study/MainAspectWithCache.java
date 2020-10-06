package gradle_spring5_aop_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gradle_spring5_aop_study.config.AppCtx;
import gradle_spring5_aop_study_aop03.Calculator;

public class MainAspectWithCache {
	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);){
			Calculator cal = ctx.getBean("calculator", Calculator.class);
			cal.factorial(7);
			cal.factorial(7);
			cal.factorial(5);
			cal.factorial(5);
		}
	}
}
