import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.StringBuilder;

public class Document {
	private Integer ID;
	private String header;
	private String body;
	private String punctuation = ".,;:'\"[]{}-=_+<>?/";
	private List<String> commonWords = Arrays.asList("the", "and");
	
	public Document() {
	}
	
	public Document(String path) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
			this.header = lines.get(0);
			StringBuilder body = new StringBuilder();
			
			for (int i = 2; i < lines.size(); i++) {
				body.append(lines.get(i) + "\n");
			}
			this.body = body.toString();
		}
		catch (IOException ex) {
			System.out.println(ex.toString());
			System.out.println("Could not find file " + path);
		}
	}
	
	public String getHeader() {
		return this.header;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public Integer getID() {
		return this.ID;
	}
	
	public ArrayList<String> toBagOfWords() {
		
		ArrayList<String> bagOfWords = new ArrayList<String>();
		
		ArrayList<String> headerBagOfWords = new ArrayList<String>(Arrays.asList(this.header.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+")));
		ArrayList<String> bodyBagOfWords = new ArrayList<String>(Arrays.asList(this.body.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+")));
		
		bagOfWords.addAll(headerBagOfWords);
		bagOfWords.addAll(bodyBagOfWords);
		
		return bagOfWords;
	}
	
//	private static String readFile(String path, Charset encoding) throws IOException {
//		byte[] encoded = Files.readAllBytes(Paths.get(path));
//		return new String(encoded, encoding);
//	}
}
