package br.com.luciano.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class TestReadLine {

	public static void main(String[] args) throws IOException {
		
//		try (Stream<String> stream = Files.lines(Paths.get("C:/file/Manual.pdf"),  StandardCharsets.ISO_8859_1)) {
//		    stream
//		        .filter(line -> line.contains("Simone"))
//		        .map(String::trim)
//		        .forEach(System.out::println);
//		}
		
		Path path = Paths.get("C:/file/Manual.pdf");
	    try(Stream<String> filteredLines = Files.lines(path, StandardCharsets.ISO_8859_1)
	                                    .onClose(() -> System.out.println("File closed"))
	                                    .filter(s -> s.contains("Liduína"))){
	        Optional<String> hasPassword = filteredLines.findFirst();
	        if(hasPassword.isPresent()){
	            System.out.println(hasPassword.get());
	        }
	    }
	    
	    

	}

}
