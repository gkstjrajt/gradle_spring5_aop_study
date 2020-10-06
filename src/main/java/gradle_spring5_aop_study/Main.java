package gradle_spring5_aop_study;

import gradle_spring5_aop_study_aspect.Calculator;
import gradle_spring5_aop_study_aspect.ImpeCalculator;
import gradle_spring5_aop_study_aspect.RecCalculator;

public class Main {
	public static void main(String[] args) {
		int num = 5;
		long res = -1;
		long start = 0;
		long end = 0;
		
		Calculator impeCal = new ImpeCalculator();
		start = System.currentTimeMillis();
		res = impeCal.factorial(num);
		end = System.currentTimeMillis();
		System.out.printf("ImpeCalculator.factorial(%d) ����ð� = %d%n", num, (end-start));
		System.out.printf("%d! = %d%n", num, res);
		
		Calculator recCal = new RecCalculator();
		start = System.currentTimeMillis();
		res = recCal.factorial(num);
		end = System.currentTimeMillis();
		System.out.printf("ImpeCalculator.factorial(%d) ����ð� = %d%n", num, (end-start));
		System.out.printf("%d! = %d%n", num, res);
	}
}
