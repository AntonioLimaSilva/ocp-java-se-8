package br.com.luciano.exameocp.protocolos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 
 * @author Luciano Lima
 *
 */
public class TCPClient {

	public static void main(String[] args) throws Exception {

		try (Socket socket = new Socket("localhost", 8080)) {
		
			System.out.println("==== Solicitando conexão ====");
			
			OutputStream outputStream = socket.getOutputStream();
			InputStream inputStream = socket.getInputStream();
			
			DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
			DataInputStream dataInputStream = new DataInputStream(inputStream);
			
			dataOutputStream.writeInt(5);
			int valorIncrementado = dataInputStream.readInt();
			
			System.out.println("Valor retornado..."  + valorIncrementado);
		
		}		
	}

}
