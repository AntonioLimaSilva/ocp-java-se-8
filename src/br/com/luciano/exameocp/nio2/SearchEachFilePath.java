package br.com.luciano.exameocp.nio2;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @author Luciano Lima
 *
 */
public class SearchEachFilePath {

	public static void main(String[] args) throws Exception {

		Path path = Paths.get("C:\\certificacao");
		
		DirectoryStream<Path> stream =  Files.newDirectoryStream(path,
				f -> f.startsWith("C:\\certificacao\\carro.java"));
		
		stream.forEach(System.out::println);
		
	}

}
