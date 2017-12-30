package br.com.luciano.exameocp.protocolos;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 
 * @author Luciano Lima
 *
 */
public class UDPServer {
	public static void main(String[] args) throws Exception {

		try (DatagramSocket socket = new DatagramSocket(1250)) {
			
			byte[] buffer = new byte[1024];			
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			
			//Esse método é bloqueante
			socket.receive(packet);
			
			byte[] clientData = packet.getData();
			String clientDataStr = new String(clientData, 0, packet.getLength());
			
			System.out.println("Servidor recebendo dos dados: " + clientDataStr);
		}
		
	}
}
