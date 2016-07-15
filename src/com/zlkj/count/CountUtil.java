package com.zlkj.count;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountUtil {

	private CountUtil() {
	}
	
	public static int countWordInFile(String filename, String word){
		int counter = 0;
		
		try(FileReader fr = new FileReader(filename)){
			try(BufferedReader br = new BufferedReader(fr)){
				String line = null;
				while((line = br.readLine()) != null){
					int index = -1;
					System.out.println(line);
					while(line.length() >= word.length() && (index = line.indexOf(word)) >=0){
						counter++;
						line = line.substring(index+word.length());
						System.out.println(line);
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return counter;
	}
}
