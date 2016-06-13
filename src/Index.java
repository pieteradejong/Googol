import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;

public class Index {
	private HashMap<String, Integer> index = new HashMap<String, Integer>();
	/*
	 * the index should:
	 * - be given a series of Documents
	 * - for each Document: 
	 * 	--- for each word, add a reference to the index for that word
	 * 
	 * 
	 * */
	private HashMap<String, Integer> reverseIndex;
	private int numDocs;
	private boolean built;
	
	public Index() {
		this.numDocs = 0;
		this.built = false;
	}
	
	public HashMap<String, Integer> createInvertedIndexForDocuments(ArrayList<Document> docs) {
//		HashMap<String, Integer> reverseIndex = new HashMap<String, Integer>(); 
		
		for (Document doc : docs) {
			ArrayList<String> words = doc.toBagOfWords();

			for (String word : words) {
				Integer count = reverseIndex.get(word);
				if (count == null) {
					reverseIndex.put(word, 1);
				}
				else {
					reverseIndex.put(word, count + 1);
				}
			}
		}
		Index.printMap(reverseIndex);
		return reverseIndex;
	}
	
	public List<Integer> getDocumentIDsForWord(String word) {
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
