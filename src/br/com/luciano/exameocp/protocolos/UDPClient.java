package br.com.luciano.exameocp.protocolos;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 
 * @author Luciano Lima
 *
 */
public class UDPClient {

	public static void main(String[] args) throws Exception {
		
		try (DatagramSocket socket = new DatagramSocket()) {
		
			byte[] buffer = new String("Olá, seja bem vindo!").getBytes();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 1250);
			
			socket.send(packet);
			
			System.out.println("Cliente enviando o pacote para o servidor ");
		}

	}
}
