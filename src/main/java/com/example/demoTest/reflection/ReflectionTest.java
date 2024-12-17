package com.example.demoTest.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

	private static long startTime = System.nanoTime();

	public static void main(String[] args) {

		Class<?> constClass = null;
		try {
			constClass = Class.forName("com.example.demoTest.reflection.ConstFile");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		try {
			Constructor<?> constructor = constClass.getDeclaredConstructor();
			constructor.setAccessible(true);

			Object instance = constructor.newInstance();
			System.out.println("instance created : " + instance);

			//private field 가져오기
			Field staticField = constClass.getDeclaredField("IMCONST");
			staticField.setAccessible(true);
			String staticValue = (String)staticField.get(null);
			System.out.println("staticValue : " + staticValue);

			//private 메서드 가져오기
			Method privateMethod = constClass.getDeclaredMethod("hello");
			privateMethod.setAccessible(true);

			//메서드 실행해보기
			String result = (String)privateMethod.invoke(instance);
			System.out.println(result);

		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		}

		long endTime = System.nanoTime();
		System.out.println("process time = " + (endTime - startTime) / 1_000_000 + " ms");
	}
}
