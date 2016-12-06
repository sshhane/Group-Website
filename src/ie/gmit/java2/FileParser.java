package ie.gmit.java2;

import java.io.*;
import java.util.*;

public class FileParser implements Parsearator {
	//instance variables
	private List<String> fileContents = new ArrayList<String>();
	private File file = null;
	
	//Constructors
	public FileParser(){
		//this(file);
	}
	
	//Constructor with file name input
	public FileParser(String fileName){
		this.file = new File(fileName);
		this.parse(fileName);
	}
	
	//Constructor with file input
	public FileParser(File file){
		this.file = file;
	}
	
	/* (non-Javadoc)
	 * @see ie.gmit.java2.Parsearator#parse(java.lang.String)
	 */
	@Override
//	public List<String> parse(String fileName)
	public void parse(String fileName){
		//read file in
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//output to list
		String line = "";
		try {
			while((line = br.readLine()) != null){
				//split the line on white spaces. 's' is space, '+' is 1 or more
				String[] words = line.split("\\s+");
				
				//convert array into a collection
				fileContents.addAll(Arrays.asList(words));
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		return this.fileContents;
	}//end of Parse

	private void addItem(String s){
   	 String[] words = s.split("\\s+");
   	 fileContents.addAll(Arrays.asList(words));
    }
    
   @Override
	public List<String> getList(){
   	 List<String> copyList = new ArrayList <String>();

   	 for(String string : fileContents)
   	 	copyList.add(string);
   	 
   	 return copyList;
   }
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//Search
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	
//	boolean contains(String s):returns true if s exists in the array.
	@Override
	public boolean contains(String s) {
		boolean contains = false;
		if (fileContents.contains(s))
			contains = true;
		return contains;
	}
//	int count():returns the total number of elements in the array.
	@Override
	public int count() {
		int size = fileContents.size();
		return size;
	}
//	int countOccurrences(String s):returns the number of occurrences of s in the array.
	@Override
	public int countOccurrences(String s) {
		int occur = Collections.frequency(fileContents,s);
		return occur;
	}
//	int getFirstIndex(String s):returns the index of the 1stoccurrence of s in the array.
	@Override
	public int getFirstIndex(String s) {
		int index = fileContents.indexOf(s);
		return index;
	}
//	int getLastIndex(String s):returns the index of the last occurrence of s in the array.
	@Override
	public int getLastIndex(String s) {
		int index = fileContents.lastIndexOf(s);
		return index;
	}
//	int[]  getAllIndices(String  s):return  an  array  of  the  indices  of  all  occurrences  of  s  in the array.
	public int[] getAllIndices(String  s) {
		
		int cnt = 0;
		
		ArrayList<Integer> indices = new ArrayList<Integer>();
		
		for (String el : fileContents) {

			if (s.equals(el)) {
		        // found value at index i
		    	indices.add(cnt);
		    }
			cnt++;
		}

		cnt=0;
		int[] ind = new int[indices.size()];

		for (int i : indices) {
	        ind[cnt] = i;
	        cnt++;
		}
	    return ind;
	}
//	void delete(String s):deletes all occurrences of s from the array.
	@Override
	public void delete(String s) {
		while(fileContents.remove(s));
	}
//	void delete(int index): deletes the string at a given index in the array.
	@Override
	public void delete(int index) {
		fileContents.remove(index);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	//Stats
	/////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void printArray(String inFile) {
		System.out.println("The contents of " + inFile + " are: ");

		for (String string : fileContents) {
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
		for(String s: fileContents) {
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
		System.out.println("The answer to life, the universe and everything (according to " + inFile + ") is: " + fileContents.get(42));
	}
}

