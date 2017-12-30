package br.com.luciano.exameocp.protocolos;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Luciano Lima
 *
 */
public class TCPServer1 {

	public static void main(String[] args) throws IOException {

		try (ServerSocket server = new ServerSocket(1200)) {
			Socket accept = server.accept();
			
			InputStream inputStream = accept.getInputStream();
			int valor = inputStream.read();
			valor++;
			
			OutputStream outputStream = accept.getOutputStream();
			outputStream.write(valor);
		}
	}

}
