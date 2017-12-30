package br.com.luciano.exameocp.protocolos;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 
 * @author Luciano Lima
 *
 */
public class TCPClient1 {
	
	private static final String HOST = "localhost";
	private static final short PORTA = 1200;
	
	public static void main(String[] args) throws Exception {
		
		try (Socket socket = new Socket(HOST, PORTA)) {
		
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(1);
		
		InputStream inputStream = socket.getInputStream();
		int valor = inputStream.read();
		
		System.out.println(valor);
		
		}
		
	}

}
