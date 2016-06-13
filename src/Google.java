
import java.util.HashMap;
import java.util.ArrayList;

public class Google {
	public static void main(String[] args) {
		ArrayList<Document> documents = new ArrayList<Document>();
		
		documents.add(new Document("document1.txt"));
		documents.add(new Document("document2.txt"));
		documents.add(new Document("document3.txt"));
		documents.add(new Document("document4.txt"));
		documents.add(new Document("document5.txt"));
		
		Index index = new Index();
		index.createInvertedIndexForDocuments(documents);
	}
}
