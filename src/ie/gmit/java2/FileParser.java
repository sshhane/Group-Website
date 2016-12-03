package ie.gmit.java2;

import java.io.*;
import java.util.*;

public class FileParser implements Parsearator {
	//instance variables
	private List<String> fileContents = new ArrayList<String>();
	private File file = null;
	
	//Constructors
	//Default constructor which takes the 'this' keyword to call
	//The constructor
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

		
	//future shane=====================fix this, update to be like urlparser
	private void addItem(String s){
   	 String[] words = s.split("\\s+");
   	 fileContents.addAll(Arrays.asList(words));
    }
    
    /* (non-Javadoc)
	 * @see ie.gmit.java2.Parsearator#getList()
	 */
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
//	@Override
	public boolean contains(String s) {
		boolean contains = false;
		if (fileContents.contains(s))
			contains = true;
		return contains;
	}
//	int count():returns the total number of elements in the array.
//	@Override
	public int count() {
		int size = fileContents.size();
		return size;
	}
//	int countOccurrences(String s):returns the number of occurrences of s in the array.
//	@Override
	public int countOccurrences(String s) {
		int occur = Collections.frequency(fileContents,s);
		return occur;
	}
//	int getFirstIndex(String s):returns the index of the 1stoccurrence of s in the array.
//	@Override

	public int getFirstIndex(String s) {
		int index = fileContents.indexOf(s);
		return index;
	}
//	int getLastIndex(String s):returns the index of the last occurrence of s in the array.
//	@Override

	public int getLastIndex(String s) {
		int index = fileContents.indexOf(s);
		return index;
	}
//	int[]  getAllIndices(String  s):return  an  array  of  the  indices  of  all  occurrences  of  s  in the array.
//	void delete(String s):deletes all occurrences of s from the array.
//	@Override
	public void delete(String s) {
		while(fileContents.remove(s));
	}
//	void delete(int index): deletes the string at a given index in the array.
//	@Override

//	public void delete(int index) {
//		while(fileContents.remove(index));
//	}
	
}

