package com.zlkj.listfile;

import java.io.File;

public class ListDirAndFiles {
	public static void main(String[] args) {
		showDirectory(new File("E:/eclipseworkspace/java_question_job"));
	}
	
	public static void showDirectory(File file){
		_walkDirectory(file, 0);
	}
	
	private static void _walkDirectory(File file, int level){
		if (file.isDirectory()){
			for (File temp : file.listFiles()){
				_walkDirectory(temp, level+1);
			}
		} else {
			System.out.println("\t");
			System.out.println(file.getName());
		}
	}
}
