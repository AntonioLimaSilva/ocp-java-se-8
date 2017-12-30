package br.com.luciano.exameocp.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Aplicacao {

	public static void main(String[] args) throws Exception {

		//serializer();
		unserializer();
	}
	
	private static void serializer() throws Exception {
		Usuario usuario = new Usuario();
		usuario.setId(1);
		usuario.setNome("lima");
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuario.bin1"))) {
			oos.writeObject(usuario);
		}
		
	}

	private static void unserializer() throws Exception {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuario.bin1"))) {
			Usuario usuario  = (Usuario) ois.readObject();
			
			System.out.println("Usuario deserializado: " + usuario);
		}
	}
}
