import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class Index {
	private HashMap<String, ArrayList<Document>> reverseIndex = new HashMap<String, ArrayList<Document>>();
	private int numDocs;
	private boolean built;
	
	public Index() {
		this.numDocs = 0;
		this.built = false;
	}
	
	public HashMap<String, ArrayList<Document>> createInvertedIndexForDocuments(ArrayList<Document> docs) {
		for (Document doc : docs) {
			ArrayList<String> words = doc.toBagOfWords();
			for (String word : words) {
				if (!reverseIndex.containsKey(word)) {
					reverseIndex.put(word, new ArrayList<Document>(Arrays.asList(doc)));
				}
				else {
					ArrayList<Document> documents = reverseIndex.get(word);
					documents.add(doc);
				}
			}
		}
		Index.printMap(reverseIndex);
		return reverseIndex;
	}
	
	public ArrayList<Document> getDocumentIDsForWord(String word) {
		return reverseIndex.get(word);
	}
	
	
	//temp helper method just meant to print reverse index 
	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	
	

}
