package br.com.luciano.exameocp.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Properties;

/**
 * 
 * @author Luciano Lima
 *
 */
public class TesteInputStream {

	public static void main(String[] args) throws Exception {
		
		Arrays.asList(args).forEach(System.out::println);

		Properties props = new Properties();	
		try (InputStream in = new FileInputStream("file.txt")) {
			props.load(in);		
		}
		
		System.out.println(props.getProperty("host"));
		
		props.setProperty("ID", "1000");
		try (OutputStream out = new FileOutputStream("file1.txt")) {
			props.store(out, "Esse file foi gerado automaticamente");
		}
	}

}
