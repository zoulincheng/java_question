package com.zlkj.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class StreamUtil {
	
	private  StreamUtil() {
		throw new AssertionError();
	}
	
	public static void fileCopy(String source, String target) throws IOException{
		InputStream inputStream = new FileInputStream(source);
		OutputStream outputStream = new FileOutputStream(target);
		byte[] buffer = new byte[4096];
		int bytesToRead;
		
		while((bytesToRead = inputStream.read(buffer)) != -1){
			outputStream.write(buffer, 0 , bytesToRead);
		}
	}
	
	public static void fileCopyNIO(String source, String target) throws IOException{
		FileInputStream in = new FileInputStream(source);
		FileOutputStream out = new FileOutputStream(target);
		FileChannel inChannel = in.getChannel();
		FileChannel outChannel = out.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(4096);
		
		while(inChannel.read(buffer) != -1){
			buffer.flip();
			outChannel.write(buffer);
			buffer.clear();
		}
	}
}
