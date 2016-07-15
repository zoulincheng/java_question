package com.zlkj.echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;

public class EchoServerNIO {
	private static final int ECHO_SERVER_PORT = 6789;
	private static final int ECHO_SERVER_TIMEOUT  = 5000;
	private static final int BUFFER_SIZE = 1024;
	
	private static ServerSocketChannel serverSocketChannel = null;
	private static Selector selector = null;
	private static ByteBuffer buffer = null;
	
	public static void main(String[] args) {
		init();
		listen();
	}
	
	private static void init(){
		try {
			serverSocketChannel = ServerSocketChannel.open();
			buffer = ByteBuffer.allocate(BUFFER_SIZE);
			serverSocketChannel.socket().bind(new InetSocketAddress(ECHO_SERVER_PORT));
			serverSocketChannel.configureBlocking(false);
			selector = Selector.open();
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	
	private static void listen(){
		while(true){
			try {
				if (selector.select(ECHO_SERVER_TIMEOUT) != 0){
					Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
					while (iterator.hasNext()) {
						SelectionKey key = iterator.next();
						iterator.remove();
						handleKey(key);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void handleKey(SelectionKey key) throws IOException{
		SocketChannel channel = null;
		
		if (key.isAcceptable()){
			ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
			channel = serverChannel.accept();
			channel.configureBlocking(false);
			channel.register(selector, SelectionKey.OP_READ);
		} else if (key.isReadable()){
			channel = (SocketChannel) key.channel();
			buffer.clear();
			if (channel.read(buffer) > 0){
				buffer.flip();
				
			}
		}
	}
}
