package ie.gmit.java2;

import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;

public class URLParser implements Parsearator {

		//instance variables
		private List<String> urlContents = new ArrayList<String>();
		
        /* (non-Javadoc)
		 * @see ie.gmit.java2.Parsearator#parse(java.lang.String)
		 */
		
		public URLParser(){
			
		}
		
		public URLParser(String url){
			this.parse(url);
		}
		
        @Override
		public void parse(String url){
        	URL site = null;
        
	        try {
				site = new URL(url);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        BufferedReader br = null;
	        
	        try {
				br = new BufferedReader(new InputStreamReader(site.openStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        String s = "";
	        StringBuffer sb = new StringBuffer();
	        
	        try {
				while((s=br.readLine()) != null){
					sb.append(s + "\n");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        //jsoup
			Document doc = Jsoup.parse(sb.toString());
			String text = doc.body().text();
			//System.out.println(text);
			//String[] words = line.split("\\s+");
			//call add
			addItem(text);
        
        }//parse
                  
         private void addItem(String s){
        	 String[] words = s.split("\\s+");
        	 urlContents.addAll(Arrays.asList(words));
         }
         
         /* (non-Javadoc)
		 * @see ie.gmit.java2.Parsearator#getList()
		 */
        @Override
		public List<String> getList(){
        	 List<String> copyList = new ArrayList <String>();

        	 for(String string : urlContents)
        	 	copyList.add(string);
        	 
        	 return copyList;
        }
    	/////////////////////////////////////////////////////////////////////////////////////////////////////
    	//Search
    	/////////////////////////////////////////////////////////////////////////////////////////////////////
    	
//    	boolean contains(String s):returns true if s exists in the array.
    	@Override
    	public boolean contains(String s) {
    		boolean contains = false;
    		if (urlContents.contains(s))
    			contains = true;
    		return contains;
    	}
//    	int count():returns the total number of elements in the array.
    	@Override
    	public int count() {
    		int size = urlContents.size();
    		return size;
    	}
//    	int countOccurrences(String s):returns the number of occurrences of s in the array.
    	@Override
    	public int countOccurrences(String s) {
    		int occur = Collections.frequency(urlContents,s);
    		return occur;
    	}
//    	int getFirstIndex(String s):returns the index of the 1stoccurrence of s in the array.
    	@Override
    	public int getFirstIndex(String s) {
    		int index = urlContents.indexOf(s);
    		return index;
    	}
//    	int getLastIndex(String s):returns the index of the last occurrence of s in the array.
    	@Override
    	public int getLastIndex(String s) {
    		int index = urlContents.lastIndexOf(s);
    		return index;
    	}
//    	int[]  getAllIndices(String  s):return  an  array  of  the  indices  of  all  occurrences  of  s  in the array.
    	public int[] getAllIndices(String  s) {
    		
    		int cnt = 0;
    		
    		ArrayList<Integer> indices = new ArrayList<Integer>();
    		
    		for (String el : urlContents) {

    			if (s.equals(el)) {
    		        // found value at index i
    		    	indices.add(cnt);
    		    }
    			cnt++;
    		}

    		cnt=0;
    		int[] ind = new int[indices.size()];

    		for (int indices1 : indices) {
    	        ind[cnt] = indices1;
    	        cnt++;
    		}
    	    return ind;
    	}
//    	void delete(String s):deletes all occurrences of s from the array.
    	@Override
    	public void delete(String s) {
    		while(urlContents.remove(s));
    	}
//    	void delete(int index): deletes the string at a given index in the array.
    	@Override
    	public void delete(int index) {
    		urlContents.remove(index);
		}

		/////////////////////////////////////////////////////////////////////////////////////////////////////
		//Stats
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		@Override
		public void printArray(String inFile) {
			System.out.println("The contents of " + inFile + " are: ");

			for (String string : urlContents) {
				System.out.print(string);
			
				for (int i=0; i %5 == 4; i++)
					System.out.println();
			}
		}//printArray
		@Override
		public String mostCommon() {
			
			//instance variables
			String mostCommon="";
			
			Map<String, Integer> most = new HashMap<String, Integer>();
			
			
			//fill map
			for(String s: urlContents) {
			  Integer com = most.get(s);
			  
			  if(com == null)
				  com = new Integer(0);
			  
			  com++;
			
			  most.put(s,com);
			}
			  
			  Map.Entry<String,Integer> mc = null;
			  
			  //get most repeated
			  for(Map.Entry<String, Integer> e: most.entrySet()) {
			      if(mc == null || mc.getValue() <= e.getValue())
			    	  mc = e;
				      mostCommon = mc.getKey();
			  }
			
			return mostCommon;
		}//most
		
		@Override
		public void fourtyTwo(String inFile) {
			System.out.println("The answer to life, the universe and everything (according to " + inFile + ")is: " + urlContents.get(42));
		}
}