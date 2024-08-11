package filemanager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileManager {
	public String readFileText(String filePath) {
			StringBuilder content = new StringBuilder();

			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
					String line;
					while ((line = br.readLine()) != null) {
							content.append(line).append("\n");  // Adicionar linha por linha, com quebra de linha
					}
			} catch (IOException e) {
					e.printStackTrace(); 
			}

			return content.toString();
	}
}