package java8;

public class RunCalculator {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		System.out.println(calculator.execute(new Sum()));
		System.out.println(calculator.execute(new Operation() {
			
			@Override
			public double execute(double a, double b) {
				return a - b;
			}
		}));
		
		System.out.println(calculator.execute((a, b) -> a - b));
		
		System.out.println(calculator.execute((a, b) -> a * b));
		calculator.doSomething(a -> {});
		calculator.doSomething(a -> System.out.println(a));
		calculator.doSomething(a -> {double x = a * a;});
		
		final double[] result = {0};
		
		new Operation() {
			
			@Override
			public double execute(double a, double b) {
				result[0] = a / b;
				return result[0];
			}
		};
		
		double resultado[] = {0};
		calculator.execute((a, b) -> {
			resultado[0] = a / b;
			return resultado[0];
		});
		
	}
}
