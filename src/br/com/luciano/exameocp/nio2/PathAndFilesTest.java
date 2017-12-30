package br.com.luciano.exameocp.nio2;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 
 * @author Luciano Lima
 *
 */
public class PathAndFilesTest {

	public static void main(String[] args) throws Exception {
		
		Path path1 = Paths.get("C:\\Users\\lucli\\workspace\\exame-ocp");
		Path path2 = Paths.get("file.txt");
//		
//		//Faz a junção entre dois paths
		Path path3 = path1.resolve(path2);
//		System.out.println(path3);
//		
//		//Path path4 = Files.createDirectories(Paths.get("C:\\Users\\lucli\\workspace\\exame-ocp\\temp"));
//		Path path4 = Paths.get("C:\\Users\\lucli\\workspace\\exame-ocp\\temp");
//		Files.move(path3, path4,  StandardCopyOption.REPLACE_EXISTING);
//		
		File file = path1.toFile();
		boolean existe = file.exists();
		
		System.out.println(existe);
		System.out.println(path3.getFileName());
		System.out.println(path3.getRoot());
		System.out.println(path3.getName(2));
		System.out.println(path3.getFileSystem().getPath(path3.toString(), "ok"));
		System.out.println(FileSystems.getDefault().getPath(System.getProperty("user.home"), "teste"));
		
		System.out.println(Paths.get("/home").resolve("user/docs"));
	}

}
