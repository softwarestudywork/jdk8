package com.jdk.features.main;

import com.jdk.features.classes.Calculator;
import com.jdk.features.classes.ExampleClassOfMethodAndConstructorRef;
import com.jdk.features.interfaces.LambdaBasic;
import com.jdk.features.interfaces.LambdaSyntax;
import com.jdk.features.interfaces.LambdaSyntax2;
import com.jdk.features.interfaces.MethodRefInterface;
import com.jdk.features.interfaces.ConstructorRefInterface;
import com.jdk.features.interfaces.ConstructorRefInterface2;
import com.jdk.features.interfaces.ConstructorRefInterface3;

public class LambdaBasicExamples {

	public static void main(String[] args) {
		
		//lambdaExpressions();
		//instanceMethodReference();
		methodAndConstructorRefDemo();
	}

	
	public static void lambdaExpressions() {
		
		String title = "Lambda Expression ";
		
		/*
		 * We are passing functionality to the abstract method of LambdaBasic. LambdaBasic is 
		 * functional interface because it has only one abstract method which is apply(Integer arg1, Integer ar2) with returned type
		 * of Integer. LambdaBasic interface is defined as follows
		 * 
		 * public interface LambdaBasic {
		 *  //Abstract method
		 * 	public Integer apply(Integer arg1, Integer ar2);
		 * }
		 * 
		 * Now we passed the functionality to this apply method using lambda expression as follows 
		 * 
		 *    LambdaBasic lumbdaBasic = (Integer a1, Integer a2) -> a1 + a2;
		 *    
		 * Now interface LamdaBasic reference has functionality attached to it that is provided by above lambda expression. Whenever  
		 * caller calls the method of LambdaBasic by passing two integer arguments, The method performs operation as defined by our lambda expression.
		 * If you want to do it in traditional way then It could have looked like as follows
		 * 
		 *  LambdaBasic lumbdaBasic = new LambdaBasic () {
		 *   public Integer apply(Integer arg1, Integer arg2) {
		 *   	return arg1 + arg2;
		 *   }
		 *  }
		 *  
		 *  bits and pieces of Lambda expression are shown in following.
		 *  
		 *  (arg-list) -> {body}
		 *  
		 *  arg-list represent abstract method arg list and body represent operation attached to this method. You can use arg-list 
		 *  in body as part of operation. These place holder arg-list in your functionality will be replaced by actual argument list that is passed during 
		 *  method call of your interface attached to lambda expression in caller code.
		 *  
		 *  Some Syntax rules:
		 *  1. If argument-list has one arg then you can omit parentheses for example instead of writing (x)->{return x*x}; you could have written x->return x*x;
		 *     Do not declare data type of argment when you omit parentheses for example 'Integer x -> x*x will be invalid instead write x -> x*x. This is will be
		 *     valid. 
		 *  2. If lambda expression has only one coding statement in body then you can omit body braces and return statement 
		 *     for instead of writing such lambda expression (x) -> {return x*x} you could have written (x)->x*x;
		 *     
		 *  3. You should use return statement explicitly even for one statement if you are using parentheses for body of lambda expression 
		 *  
		 *  4. Do not count on compatibility of primitive and wrapper type with respect to argument list of lambda expression. If argument type of abstract method of 
		 *     functional interface is primitive type then corresponding wrapper type will be invalid in lambda argument list or visa versa  
		 *  
		 */
		
		LambdaBasic lumbdaBasic = (Integer a1, Integer a2) -> a1 + a2;
		System.out.println(title + "10 + 10 = " + lumbdaBasic.apply(10, 10));
		
		lumbdaBasic = (num1, num2) -> num1 - num2;
		System.out.println(title + "25 - 10 = " + lumbdaBasic.apply(25, 10));
		
		Calculator calculator = new Calculator();
		
		StringBuffer strBuf = new StringBuffer().append(title).append(7).append("*").append(8).append("=");
		calculator.showResult((Integer oprand1, Integer oprand2) -> oprand1 + oprand2, 7, 8, strBuf.toString());
		
		
		strBuf = new StringBuffer().append(title).append(100).append("/").append(25).append("=");
		calculator.showResult((op1, op2) -> op1 / op2, 100, 25, strBuf.toString());
		
	}
	
	
	public static void instanceMethodReference() {
		
		/*
		 * We can assign the method functionality to abstract method of functional interface if argument list and 
		 * returned type of both of them matches. for Example LumbdaBasic interface Integer apply(Integer arg1, Integer arg2)
		 * matches with Calculator's instance method add signature that is Integer add(Integer arg1, Integer arg2).
		 * 
		 *  You can assign instance method signature with using :: operator. For example
		 *  
		 *  Calculator calculator = new Calculator();
		 *  LambdaBasic lambdaBasic = calculator::add;
		 *  
		 *  OR 
		 *  
		 *  LambdaBasic lambdaBasic = new Calculator()::add;
		 *  
		 *  After that you can use add method functionality attached to apply method of LambdaBasic for example
		 *  
		 *  Integer result = lambdaBasic.apply(10,10);
		 *  
		 *  NOTE:- Instance method reference can replace lambda expression where it is possible. This is how you 
		 *  can further reduce code of lambda expression. I mean lambda expression reduces the boiler plate codes 
		 *  of method overriding of anonymous class and instance method reference further reduces the code of 
		 *  lambda expression.
		 */
		
		String title = "Instance Method Reference ";
		Calculator calculator = new Calculator();
		
		LambdaBasic lumbdaBasic = calculator::add;
		System.out.println(title + "10 + 10: " + lumbdaBasic.apply(10, 10));
		
		lumbdaBasic = calculator::substract;
		System.out.println(title + "10 - 5: " + lumbdaBasic.apply(10, 5));
		
		lumbdaBasic = calculator::multiply;
		System.out.println(title + "10 * 5: " + lumbdaBasic.apply(10, 5));
		
		lumbdaBasic = calculator::divide;
		System.out.println(title + "10 / 5: " + lumbdaBasic.apply(10, 5));
		
		lumbdaBasic = calculator::mod;
		System.out.println(title + "9 % 7: " + lumbdaBasic.apply(9, 7));
		
	}
	
	
	public static void lambdaSyntaxDemo() {
		
		String title = "";
		LambdaSyntax lambdaSyntax = x->10*10;
		System.out.println(title + "9*9 : " + lambdaSyntax.doSomeThing(9));
		
		lambdaSyntax = (x)->9+9;
		System.out.println(title + "9+9: " + lambdaSyntax.doSomeThing(9));
		
		lambdaSyntax = (Integer x)->9/9;
		System.out.println(title + "9/9: " + lambdaSyntax.doSomeThing(9));
		
		lambdaSyntax = (Integer x)->{return 9-9;};
		System.out.println(title + "9-9: " + lambdaSyntax.doSomeThing(9));
		
		lambdaSyntax =  x->{return 9*9*9/3;};
		System.out.println(title + "9*9*9/3: " + lambdaSyntax.doSomeThing(9));
		
		
		/*
		 * Do not count on compatibility of primitive and wrapper type with respect to argument list of lambda expression. If argument type of abstract method of 
		 * functional interface is wrapper type then  corresponding primitive type will be invalid in lambda argument list or visa versa
		 * 
		 * lambdaSyntax =  (int x) -> {return 9*9*9/3;};
		 * System.out.println(title + "9*9*9/3: " + lambdaSyntax.doSomeThing(9));
		 */
		
		LambdaSyntax2 lambdaSyntax2 = (int x)->{return 9*9*9;};
		System.out.println(title + "9*9*9: " + lambdaSyntax2.youCanUsePrimitive(9));
		
		
		/*
		 * Do not count on compatibility of primitive and wrapper type with respect to argument list of lambda expression. If argument type of abstract method of 
		 * functional interface is primitive type then  corresponding wrapper type will be invalid in lambda argument list or visa versa
		 * 
		 * lambdaSyntax2 = (Integer x)->{return 9*9*9;}; System.out.println(title +
		 * "9*9*9: " + lambdaSyntax2.youCanUsePrimitive(9));
		 */ 
		
	}
	
	public static void methodAndConstructorRefDemo() {
		
		/*
		 * You can assign the reference of static or instance method of class to abstract method provided that signature and return type of abstract method
		 * must matches with methods to be assigned. In the same way you can the assign the constructor to abstract method of interface provided that
		 * abstract method return type should be the class of assigned constructor or its super class and secondly abstract method signature must match constructor signature. 
		 * 
		 * In case of constructor reference, The instance will be created by constructor and returned to caller only when you call the method
		 * that refer to constructor hence statement refInterface = SomeClass::new; will not create object of SomeClass and constructor will 
		 * not be executed unless you call the method of refInterface that ref the constructor.
		 */
		
		MethodRefInterface refInterface = ExampleClassOfMethodAndConstructorRef::staticMethod;
		System.out.println(refInterface.refMethod("Static method has been referenced by abstract method refMethod() of interface", 100));
		
		refInterface = new ExampleClassOfMethodAndConstructorRef()::instanceMethod;
		System.out.println(refInterface.refMethod("Instance method has been referenced by abstract method refMethod() of interface", 100));
		
		ConstructorRefInterface constructorRefInterface = ExampleClassOfMethodAndConstructorRef::new;
		
		ExampleClassOfMethodAndConstructorRef instanceOfExampleClass = constructorRefInterface.refMethod("Constructor is refernecd by abstract method of ConstructorRefInterface which name is refMethod ", 10);
		
		
		
		ConstructorRefInterface2 constructorRefInterface2 = ExampleClassOfMethodAndConstructorRef::new;
		
		instanceOfExampleClass = constructorRefInterface2.refMethod("Constructor is refernecd by abstract method of ConstructorRefInterface2 which name is refMethod");
		
		
		ConstructorRefInterface3 constructorRefInterface3 = ExampleClassOfMethodAndConstructorRef::new;
		
		instanceOfExampleClass = (ExampleClassOfMethodAndConstructorRef) constructorRefInterface3.refMethod("Constructor is refernecd by abstract method of ConstructorRefInterface3 which name is refMethod. Its returned type is super type of constructor class");
		
	}
}
