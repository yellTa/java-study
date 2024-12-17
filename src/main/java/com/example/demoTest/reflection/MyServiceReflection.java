package com.example.demoTest.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MyServiceReflection {
	public static void main(String[] args) {
		String className = "com.example.demoTest.reflection.MyServiceImpl";

		try {
			Class<?> clazz = Class.forName(className);

			//객체 생성
			Constructor<?> constructor = clazz.getDeclaredConstructor();
			Object obj = constructor.newInstance();

			//인터페이스로 형 변환하기
			if (obj instanceof MyService) {
				MyService myService = (MyService)obj;
				myService.execute();
			} else {
				throw new IllegalArgumentException("provied class doesn't implement MyService");
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
