package com.jdk.features.classes;

import com.jdk.features.interfaces.LambdaBasic;

public class Calculator {

	public Integer add(Integer arg1, Integer arg2 ) {
		return arg1+arg2;
	}
	
	public Integer substract(Integer arg1, Integer arg2 ) {
		return arg1-arg2;
	}
	
	public Integer multiply(Integer arg1, Integer arg2 ) {
		return arg1*arg2;
	}
	
	public Integer divide(Integer arg1, Integer arg2 ) {
		return arg1/arg2;
	}
	
	public Integer mod(Integer arg1, Integer arg2 ) {
		return arg1%arg2;
	}
	
	public void showResult(LambdaBasic lumbdaBasicInteface, Integer arg1, Integer arg2, String message) {
		System.out.println(message + lumbdaBasicInteface.apply(arg1, arg2));
	}
}
