import java.io.*;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {
        String code = getFileContent(args[0]);
        System.out.println("Now running the following Brainfuck program:\n\n" + code);
        BrainfuckRunner.run(code);
    }

    static String getFileContent(String path) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF8"))) {
            StringBuilder result = new StringBuilder();
			int lineNumber = 0;
			String line;
			while ((line = br.readLine()) != null) {
				lineNumber++;
				result.append(line);
			}
			return result.toString();
		} catch (IOException e) {
			e.printStackTrace();;
		}
        return "";
    }
}
