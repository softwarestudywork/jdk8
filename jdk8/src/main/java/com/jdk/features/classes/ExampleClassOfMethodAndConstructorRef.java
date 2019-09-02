package com.jdk.features.classes;

public class ExampleClassOfMethodAndConstructorRef extends Ancestor {

	private String message;
	private String value;

	public ExampleClassOfMethodAndConstructorRef() {
	}

	public ExampleClassOfMethodAndConstructorRef(String msg, Integer value) {
		System.out.println( "Hi I am Constructor. Message: " + msg + " and Value: " + value);
	}
	
	public ExampleClassOfMethodAndConstructorRef(String msg) {
		System.out.println( "Hi I am Constructor. Message: " + msg);
	}
	
	public static String staticMethod(String msg, Integer value) {
		return "Hi I am static method. Message: " + msg + " and Value: " + value;
	}
	
	public  String instanceMethod(String msg, Integer value) {
		return "Hi I am instance method. Message:" + msg + " and Value: " + value;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ExampleClassOfMethodAndConstructorRef [message=" + message + ", value=" + value + "]";
	}

}
