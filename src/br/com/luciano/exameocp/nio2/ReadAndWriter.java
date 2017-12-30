package br.com.luciano.exameocp.nio2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 
 * @author Luciano Lima
 *
 */
public class ReadAndWriter {

	public static void main(String[] args) throws Exception {

		Path path1 = Paths.get("C:\\certificacao\\carro.java");
		Path path2 = Paths.get("C:\\certificacao\\laco");
		
		byte [] bytes = Files.readAllBytes(path1);
		
		Files.write(path2, bytes, StandardOpenOption.CREATE);
	}
}
