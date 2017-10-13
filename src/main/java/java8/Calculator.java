package java8;

public class Calculator {

	public double execute(Operation operation) {
		return operation.execute(10, 30);
	}
	
	public void doSomething(Something something) {
		something.execute(10);
	}
}
