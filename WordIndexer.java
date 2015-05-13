import java.util.ArrayList;
import java.util.HashMap;

//Write a constructor that takes in a list of sentences. Then write a method that takes in a word and returns all the sentences that contain that word.
//Sentence are in format where words are separated by spaces Example: "aaa bbb ccc ddd"

public class WordIndexer {

	private HashMap<String, ArrayList<String>> wordMap;
	
	public WordIndexer(ArrayList<String> sentences){
		//Create a HashMap of key words with value all the sentences that contain that word
		wordMap = new HashMap<String, ArrayList<String>>();
		
		for(int i = 0; i < sentences.size(); i++){
			String[] words = sentences.get(i).split(" ");
			for(int j = 0; j < words.length; j++){
				if(!wordMap.containsKey(words[j])){
					ArrayList<String> sentenceList = new ArrayList<String>();
					sentenceList.add(sentences.get(i));
					wordMap.put(words[j], sentenceList);
				}else{//word is already in the map
					//only add the sentence to the wordMap list if it isn't already there
					if(!wordMap.get(words[j]).contains(sentences.get(i))){
						wordMap.get(words[j]).add(sentences.get(i));
					}
				}
			}
		}
	}
	
	public ArrayList<String> getSentences(String word){
		//check the map for the word and return the list associated with it
		return wordMap.get(word);
	}
	
	public static void main(String [ ] args){
		
		ArrayList<String> sentences = new ArrayList<String>();
		sentences.add("aaa bbb ccc ddd");
		sentences.add("aaa ccc");
		sentences.add("bbb eee");
		sentences.add("fff ddd");
		WordIndexer wordIndexer = new WordIndexer(sentences);
		
		ArrayList<String> returnedSentences = wordIndexer.getSentences("ddd");
		
		for(int i = 0; i < returnedSentences.size(); i++){
			System.out.println(returnedSentences.get(i));
		}
		
	}
}
