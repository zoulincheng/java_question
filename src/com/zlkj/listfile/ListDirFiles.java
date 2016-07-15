package com.zlkj.listfile;

import java.io.File;

public class ListDirFiles {
	public static void main(String[] args) {
		File file = new File("E:/eclipseworkspace/testfile");
		
		for (File tem : file.listFiles()){
			System.out.println(tem.getName());
		}
	}
}
