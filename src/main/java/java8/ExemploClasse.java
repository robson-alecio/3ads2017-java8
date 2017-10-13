package java8;

public class ExemploClasse {

	public static void main(String[] args) {
		String a = "blah";
		String b = "bleh";
		
		System.out.println(a instanceof String);
		System.out.println(b instanceof String);
		
		System.out.println("==================");
		String c = "bl";
		c += "eh";
		
		String d = "bl" + "eh";
		
		System.out.println(b instanceof String);
		System.out.println(c == b);
		System.out.println(c.equals(b));
		System.out.println(d == b);
		
		System.out.println("==================");
		
		Class<String> classe = String.class;
		System.out.println(classe);
		
		System.out.println(a.getClass() == classe);
		System.out.println(b.getClass() == classe);
		System.out.println(c.getClass() == classe);
		System.out.println(d.getClass() == classe);
		
		Runnable r = new Runnable() {
			
			public void run() {
				System.out.println("Anonymous inner class na variável");
			}
		};
		
		r.run();
		
		new Thread(r).start();
		
		
		new Thread(new Runnable() {
			
			public void run() {
				System.out.println("Anonymous inner class direto no parametro");
			}
		}).start();
		
		new Thread(() -> System.out.println("Lambda function!")).start();
		new Thread(() -> {
			System.out.println("Lambda function line 1!");	
			System.out.println("Lambda function line 2!");	
			System.out.println("Lambda function line 3!");	
		}).start();
	}

}
