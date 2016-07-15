package com.zlkj.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) {
		Socket client = null;
		try {
			client = new Socket("localhost", 6789);
			Scanner sc = new Scanner(System.in);
			System.out.println("input: ");
			String msg = sc.nextLine();
			sc.close();
			PrintWriter pw = new PrintWriter(client.getOutputStream());
			pw.println(msg);
			pw.flush();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println(bufferedReader.readLine());
			client.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (client != null){
				try {
					client.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
