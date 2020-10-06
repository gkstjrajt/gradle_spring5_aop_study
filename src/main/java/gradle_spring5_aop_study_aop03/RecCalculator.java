package gradle_spring5_aop_study_aop03;

public class RecCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		if (num == 1) {
			return 1;
		} else {
			return num * factorial(num - 1);
		}
	}

}
