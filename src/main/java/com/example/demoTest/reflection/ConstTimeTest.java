package com.example.demoTest.reflection;

public class ConstTimeTest {
	private static long startTime = System.nanoTime();

	public static void main(String[] args) {

		String constpublic = ConstPublic.CONSTPUBLIC;
		System.out.println("ConstPublic contents = "+constpublic);

		String hello = ConstPublic.hello();
		System.out.println("ConstPublic Method = "+hello);

		long endTime = System.nanoTime();
		System.out.println("process time = " + (endTime - startTime) / 1_000_000 + " ms");
	}
}
