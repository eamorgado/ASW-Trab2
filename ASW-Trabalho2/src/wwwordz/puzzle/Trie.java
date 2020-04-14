package wwwordz.puzzle;

import java.util.HashMap;
import java.util.Iterator;

import wwwordz.shared.Configs;

public class Trie {
	private Node root = new Node();
	
	private class Node extends HashMap<Character,Node>{
		private static final long serialVersionUID = 1L;
		private boolean isWord = false;
		
		Node(){
			isWord = false;
			String s = new Configs().getAlphabet();
			
			for(int i = 0; i < s.length(); i++)
				
		}
		
	}
	
	public class NodeIterator extends Object implements Iterator<String>, Runnable{

		private String nextWord;
		private boolean terminated;
		private Thread thread;
		
		NodeIterator(){
			
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	private static class Search extends Object{
		private static final long serialVersionUID = 1L;
		private Node node;
		
		/** 
		 * Creates a search starting in given node
		 */
		Search(){
			
		}
		
		/**
		 * Creates a clone of the given search with the same fields
		 */
		Search(Search search){
			this.node = search.node;
		}
		
		/**
		 * Method to check if we can continue the search with the current letter
		 * @param letter
		 * @return
		 */
		boolean continueWith(char letter) {
			
		}
		
		/**
		 * Method to check if characters searched so far correspond to a word
		 * -> dict search
		 * @return
		 */
		boolean isWord() {
			
		}
	}
	
	String getRandomLargeWord() {
		
	}
	
	Iterator<String> iterator(){
		
	}
	
	void put(String word) {
		
	}
	
	Search startSearch() {
		
	}
}
