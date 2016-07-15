package com.zlkj.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static final int ECHO_SERVER_PORT = 6789;
	
	public static void main(String[] args) {
		try (ServerSocket server = new ServerSocket(ECHO_SERVER_PORT)){
			System.out.println("server start...");
			while (true){
				Socket client = server.accept();
				new Thread(new ClientHandler(client)).start();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static class ClientHandler implements  Runnable{
		private Socket client;
		
		public ClientHandler(Socket _client) {
			this.client = _client;
		}
		public void run() {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))){
				PrintWriter pw = new PrintWriter(client.getOutputStream());
				String mString = br.readLine();
				System.out.println("rev:" + client.getInetAddress()+" send " + mString);
				pw.println(mString);
				pw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
