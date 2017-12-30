package br.com.luciano.exameocp.protocolos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author Luciano Lima
 *
 */
public class TCPServer {
	
	public static void main(String[] args) throws Exception {
		
		try (ServerSocket clientSocket = new ServerSocket(8080)) {
			Socket socket = clientSocket.accept();
			System.out.println("======== Conexão estabelecida ==========");
			
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
			
			DataInputStream dataInput = new DataInputStream(input);
			int valor = dataInput.readInt();
			System.out.println("Valor que chegou.... " + valor);
			valor++;
			
			DataOutputStream dataOutput = new DataOutputStream(output);
			dataOutput.writeInt(valor);
		
		}
	}

}
