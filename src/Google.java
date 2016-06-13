
import java.util.HashMap;

public class Google {
	public static void main(String[] args) {
		Document doc = new Document("document1.txt");
		System.out.println("Found document:\n" + doc.getHeader() + "\n\n" + doc.getBody());
		
		Index index = new Index();
		index.createInvertedIndexForDocument(doc);
	}
}
