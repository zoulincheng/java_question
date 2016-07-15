package com.zlkj.stream;

import java.io.IOException;

public class Client {
	public static void main(String[] args) throws IOException {
		//StreamUtil.fileCopy("E:/eclipseworkspace/testfile/file.txt", "E:/eclipseworkspace/testfile/file2.txt");
		StreamUtil.fileCopyNIO("E:/eclipseworkspace/testfile/file.txt", "E:/eclipseworkspace/testfile/filenio.txt");
	}
}
