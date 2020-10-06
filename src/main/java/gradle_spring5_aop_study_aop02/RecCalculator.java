package gradle_spring5_aop_study_aop02;

public class RecCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		long start = System.currentTimeMillis();
		try {
			if (num == 1) {
				return 1;
			} else {
				return num * factorial(num - 1);
			}
		} finally {
			long end = System.currentTimeMillis();
			System.out.printf("RecCalculator.factorial(%d) ����ð� = %d%n", num, (end-start));
		}
	}

}
