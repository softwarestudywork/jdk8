package com.jdk.features.main;


import com.jdk.features.interfaces.LambdaBasic;
import com.jdk.features.interfaces.OneArgumentMethod;
import com.jdk.features.interfaces.VoidAndEmptyArgListFunctionalInteface;
import com.jdk.features.interfaces.VoidTypeFunctionalMethod;

public class LamdaExample {

	
	private static Integer staticVar = 1000;
	private Integer instanceVar = 89;
	
	public static void main(String[] args) {
		
	}
	
	public static void optionalAndMandatoryPartOfLambda() {
		
		/*
		 * Lambda expression can has optional type declaration for arg-list. If there are more than one arguments 
		 * in args-list then you can either omit all type declaration or use type declaration for all. Return
		 * statement is also optional when there is one
		 * line of code in body of lambda expression otherwise it is mandatory. Lambda body enclosing braces are also mandatory when lambda functional method is void.
		 * Enclosing parenthesis of method argument list
		 * can be optional when there is one argument in argument list section of lambda expression but in that case,
		 * you should not use type declaration in argument list section for example Integer x->x is invalid whereas x->x is valid.
		 * You can also use local variable as well as static variable captures but in case of local variable capture, the local
		 * variable should not be used in reassignment after it is used in lambda expression body.
		 */
		
		
		/*
		 * All optional things of lambda expression is written such as 
		 * Enclosing parentheses of argument list declaration in argument list
		 * section, returned statement in lambda body and lambda body braces.
		 * 
		 */
		OneArgumentMethod oneArgumentMethod = (Integer arg) ->{return arg;};
		System.out.println("One Argumented method of lamba expression oneArgumentMethod = (Integer arg) ->{return arg;}; : " 
				+ oneArgumentMethod.doSomeThing(100));
		
		
		/*
		 * Optional argument list declaration is omitted but optional returned statement and optional body
		 * braces are not omitted
		 * 
		 */
		oneArgumentMethod = (arg) ->{return arg;};
		System.out.println("Optional argument-list declaration oneArgumentMethod = (arg) ->{return arg;}; : "
				+ oneArgumentMethod.doSomeThing(100));
		
		/*
		 * Optional return statement and body brace of lambda body are omitted but 
		 * optional argument declaration in argument declaration section is not omitted.
		 */
		oneArgumentMethod = (Integer arg) ->arg;
		System.out.println("Optional returned statement oneArgumentMethod = (Integer arg) ->arg; : "
				+ oneArgumentMethod.doSomeThing(100));
		
		/*
		 * In Following lambda expression all optional are omitted such as argument declaration in
		 * argument declaration section and returned statement in body section of lambda expression.
		 */
		oneArgumentMethod = arg -> arg;
		System.out.println("Optional argument list and optional returned statement are omitted. oneArgumentMethod = arg -> arg;) : "
				+ oneArgumentMethod.doSomeThing(100));
		
		LambdaBasic lambdaBasic = (Integer arg1, Integer arg2) -> {return arg1 + arg2;};
		lambdaBasic.apply(10, 10);
		
		/*
		 * Optional arg-list declaration is omitted although returned Statement is also optional.
		 * Remember returned statement and lambda body braces are optional
		 * only when there is one line of code in lambda expression otherwise they are mandatory.
		 *  Enclosing parenthesis of method argument list
		 * can be optional when there is one argument in argument list section of lambda expression
		 */
		lambdaBasic = (arg1, arg2) -> {return arg1 + arg2;};
		System.out.println("Argument type declaration is omitted in argument list section (arg1, arg2) -> {return arg1 + arg2;} : " 
				+ lambdaBasic.apply(1000, 1000));
		

		/*
		 * Optional returned statement is omitted although argument declaration list is
		 * also optional. Remember returned statement and lambda body braces are optional
		 * only when there is one line of code in lambda expression otherwise they are mandatory.
		 *  Enclosing parenthesis of method argument list
		 * can be optional when there is one argument in argument list section of lambda expression 
		 */
		lambdaBasic = (Integer arg1, Integer arg2) -> arg1 + arg2;
		System.out.println("Returned statement and body braces are omitted lambdaBasic = (Integer arg1, Integer arg2) -> arg1 + arg2; : " 
				+ lambdaBasic.apply(10, 10));
		
		
		/*
		 * Argument-list declaration and returned statement is omitted because they are
		 * Optional. Remember returned statement and lambda body braces are optional
		 * only when there is one line of code in lambda expression otherwise they are mandatory.
		 * Enclosing parenthesis of method argument list
		 * can be optional when there is one argument in argument list section of lambda expression 
		 */
		lambdaBasic = (arg1, arg2) -> arg1 * arg2;
		lambdaBasic.apply(10, 10);
		
		
		/*
		 * Argument list type declaration is optional but you have to 
		 * omit it for argument list if do not want. You can not
		 * do like that such as declare type for one argument and 
		 * not for other
		 */
		
		/*
		lambdaBasic = (Integer arg1, arg2) -> arg1 * arg2;
		lambdaBasic.apply(10, 10);
		
		lambdaBasic = (arg1, Integer arg2) -> arg1 * arg2;
		lambdaBasic.apply(10, 10);
		*/
		
		/*
		 * If Functional interface method is void type then method body with enclosing braces 
		 * is mandatory.
		 */
		VoidTypeFunctionalMethod voidTypeFunctionalMethod = (Integer x)->{x=100;};
		voidTypeFunctionalMethod.functionaMethod(100);
		
		
		VoidAndEmptyArgListFunctionalInteface emptyArgListFunctionalInteface = ()->{System.out.println("No returned type and argument list ()->{some codes}");};
		emptyArgListFunctionalInteface.noReturnedTypeAndArgList();
		
		emptyArgListFunctionalInteface = ()->{/*Empty;*/};
		emptyArgListFunctionalInteface.noReturnedTypeAndArgList();
		
		
		/*
		 * Following are wrong syntax for void functional method with empty arg list. 
		 * In such case empty parentheses for argument list
		 * is required with mandatory body enclosed with braces.
		 */
		//emptyArgListFunctionalInteface = ->;
		//emptyArgListFunctionalInteface = ->{/*Empty;*/};
		
		
		/*
		 * Invalid lambda expression because you can not omit parenthesis of argument list 
		 * section of lambda expression when you are using argument declaration. If do not
		 * want to use parentheses then you should also omit argument type declaration.
		 */
		//lambdaSyntax = Integer x -> x;
		

	}
	
	
	public static void mislenousOfLamnda() {
		
		
		/*
		 *####LOCAL VARIABLE CAPTURE 
		 */
		
		
		/*
		 * In JDK 11, Arg keyword is introduced in Lambda expression. You can use it as argument-list
		 * type declaration
		 */
		//lambdaBasic = (Arg arg1, Arg arg2) -> arg1 + arg2;
		//lambdaBasic.apply(10, 10);
		
		/*
		 * You can use local variable in lambda expression but remember one thing that if you local variable in lambda
		 * expression then such local variable should not be reassigned the value by code that follows lambda expression 
		 * which used this local variable in its body. 
		 */ 
		Integer localVariable =100;
		LambdaBasic lambdaBasic = (arg1, arg2) -> {return arg1+arg2*localVariable;};
		System.out.println("Local variable used in lambda expression: " + lambdaBasic.apply(20, 10));
		
		/*
		 * If you uncomment following assignment then compiler give error on above code
		 * inside of lambda expression body over a use of localVariable.
		 */
		//localVariable =90;
		
		
		/***
		 * ###STATIC VARIABLE CAPTURE.
		 */
		
		/*
		 * You can also use static variable in lambda expression. 
		 */
		lambdaBasic = (arg1, arg2) -> {return arg1+arg2*localVariable + staticVar;};
		System.out.println("static variable used in lambda expression: " + lambdaBasic.apply(20, 10));
		
		
		/***
		 * ###INSTANCE VARIABLE CAPTURE.
		 */
		
		/*
		 * You can also use instance variable in lambda expression.
		 * You can change instance variable captured even after it is 
		 * use in lambda unlike local variable capture. instance variable
		 * can referenced by this operator inside of lambda expression even using
		 * this keyword refer to properties of enclosing object of lambda unlike
		 * anonymous class where this refer to instance of anonymous class.  
		 */
		
		new LamdaExample().instanceVariableCapture();
		System.out.println("Instance variable used in lambda expression: " + lambdaBasic.apply(20, 10));
		
		 
		
	}
	
	public static void lambdaAsArglistDemo() {
		
		/* ----STATIC METHOD-- 
		 * Lambda expression is passed as argument to static method call. 
		 * Use functional interface as method argument to pass lambda expression as method parameter.
		 * */
		lambdaAsMethodArgInStaticMethod((arg1,arg2)->{return arg1 * arg2;}, 30,50);
		
		/* ----INSTANCE METHOD---
		 * Lambda expression is passed as argument to instance method call. 
		 * Use functional interface as method argument to pass lambda expression as method parameter.
		 * */
		new LamdaExample().lambdaAsMethodArgInInstanceMethod((arg1,arg2)->{return arg1 - arg2;}, 70,23);
		
		
	}
	
	
	public void instanceVariableCapture() {
		
		/*
		 * You can also use instance variable in lambda expression.
		 * You can change instance variable captured even after it is 
		 * use in lambda unlike local variable capture. instance variable
		 * can referenced by this operator inside of lambda expression even using
		 * this keyword refer to properties of enclosing object of lambda unlike
		 * anonymous class where this refer to instance of anonymous class.  
		 */
		
		LambdaBasic lambdaBasic = (arg1, arg2) -> {return this.instanceVar += arg1 *arg2;};
		System.out.println(lambdaBasic.apply(70, 50));
		
	}
	
	
	public void lambdaAsMethodArgInInstanceMethod(LambdaBasic lambdaBasic, Integer x, Integer y) {
		
		Integer result = lambdaBasic.apply(x, x);
		System.out.println("Lambda used as method parameter in stance method" +  result);
	}
	
	public static void lambdaAsMethodArgInStaticMethod(LambdaBasic lambdaBasic, Integer x, Integer y) {
		
		Integer result = lambdaBasic.apply(x, x);
		System.out.println("Lambda used as method parameter in static method" +  result);
	}

}
