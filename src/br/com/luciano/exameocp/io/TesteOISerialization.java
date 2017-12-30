package br.com.luciano.exameocp.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Luciano Lima
 * 
 * Existe alguns cuidados para serializar alguma informação, a classe obrigatóriamente deve implementar a interface Serializable, que é apenas
 * uma interface de marcação, e outras classes que são atributos da classe principal devem ser serializadas também
 *
 */
public class TesteOISerialization {

	public static void main(String[] args) throws Exception {

		Endereco endereco = new Endereco(100, "Padre Ovaldo Chaves", 1099);
		Cliente cliente = new Cliente(1001, "Francisco das chahas", endereco);
		
		/**
		 * A classe ObjectOutputStream é responsável por serializar as informações em arquivo de saída
		 */
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dados.bin"))) {
			oos.writeObject(cliente);
		}
		
		/**
		 * A classe ObjectInputStream é responsável por deserializar as informações em um arquivo de entrada
		 */
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dados.bin"))) {
			Cliente clienteDeserializado = (Cliente) ois.readObject();
			System.out.println(clienteDeserializado);
		}		
		
		System.out.println(cliente);
		System.out.println(endereco);
	}

}
