package com.zlkj.count;

public class Client {
	public static void main(String[] args) {
		
		int count = CountUtil.countWordInFile("E:/eclipseworkspace/testfile/test.txt", "world");
		System.out.println(count);
	}
}
