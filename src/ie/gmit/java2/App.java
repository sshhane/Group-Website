package ie.gmit.java2;

import java.util.ArrayList;
import java.util.List;

//Shane Daniels - G00332592
//Text Analyser - store text from given file or URL

import java.util.Scanner;

public class App {
	
	//variables
	
	private int option=0, fileOrUrl=0, search=0;
	private boolean isFileIsUrl;
	private Parsearator parse = null;
	private List<String> list = new ArrayList<String>();
	
	//scanner
	public static Scanner sc = new Scanner(System.in);
	
	public App(){
		menuOne();
	}
			
	public void menuOne(){
		//While 
		while(option != 4){
			System.out.println("\n1) Parse a File or URL\n2) Search\n3) Print Stats\n4) Exit");
			option = sc.nextInt();
			
		switch (option) {
			case 1:
				System.out.println("---- File or URL ----");
				menuTwo();
				break;
				
			case 2:
				System.out.println("---- Search ----");
				menueThree();
				break;
				
			case 3:
				System.out.println("---- Print Stats ----");
				break;
				
			case 4:
				System.out.println("---- Exited ----");
				break;
				
			}//switch
		
		}//while

	}//menueOne
	
	public void menuTwo(){
		String inFile = "";
		//While 
		while(fileOrUrl != 3){
			System.out.println("\n1) File\n2) URL\n3) Back");
			fileOrUrl = sc.nextInt();
			
			switch (fileOrUrl) {
			case 1:
				//set fileUrlBool to true for file
				isFileIsUrl = true;
				
				System.out.println("--- File ---");
				//Prompt for file name
				System.out.print("Please enter name of file:");
				inFile = sc.next();
				
				parse = new FileParser(inFile);
				System.out.println("File Parsed!");				
				return;
				
			case 2:
				//set fileUrlBool to false for URL
				isFileIsUrl = false;
				//Prompt for URL
				System.out.println("--- URL ---");
				System.out.print("Please enter URL:");
				inFile = sc.next();
				
				parse = new URLParser(inFile);
				System.out.println("URL Parsed!");
			
				return;
			}//switch
		}//while
	}//menuTwo
	
	public void menueThree(){
		//local variables
		String s;
		int index;
		
		//While 
		while(search != 9){
			System.out.println("\n1) Contains\n2) Count\n3) Count Occurrances\n4) First Index\n5) Last Index\n6) All Indices\n7) Delete String\n8) Delete int\n9) Back");
			search = sc.nextInt();
				
			switch (search) {
				case 1:
					System.out.println("---- Contains(String) ----");
					System.out.print("Enter String: ");
					s = sc.next();
					
					if (parse.contains(s))
						System.out.println("The array contains string '" + s +"'.");
					else
						System.out.println("The array does not comtain string '" + s +"'.");				
					break;
				case 2:
					System.out.println("---- Count() ----");
					System.out.println("The count is: " + parse.count());
					break;
				case 3:
					System.out.println("---- Count Occurrences(String) ----");
					System.out.print("Enter String: ");
					s = sc.next();
					System.out.println("String '" + s + "' occurs " + parse.countOccurrences(s) + " time(s).");
					break;
				case 4:
					System.out.println("---- Get First Index(String) ----");
					System.out.print("Enter String: ");
					s = sc.next();
					System.out.println("First occurrance of String '" + s + "' is " + parse.getFirstIndex(s));					
					break;
				case 5:
					System.out.println("---- Get Last Index(String) ----");
					System.out.print("Enter String: ");
					s = sc.next();
					System.out.println("Last occurrance of String '" + s + "' is " + parse.getLastIndex(s));	
					break;
				case 6:	
					System.out.println("---- Get All Indices ----");
					System.out.print("Enter String: ");
					s = sc.next();
					int[] indices = parse.getAllIndices(s);
					System.out.print("All indices of String '" + s + "' are: ");
					for (int i = 0; i < indices.length; i++)
						System.out.print(indices[i] + ", ");
					System.out.println();
					break;
				case 7:
					System.out.println("---- Delete(String) ----");
					System.out.print("Enter String: ");
					s = sc.next();
					parse.delete(s);
					System.out.println("All occurrances of String '" + s + "' have been removed");	
					break;
				case 8:
					System.out.println("---- Delete(int) ----");
					System.out.print("Enter Index: ");
					index = sc.nextInt();
					parse.delete(index);
					System.out.println("All occurrances of String at " + index + " have been removed");	
					break;
				case 9:
					System.out.println("---- Back ----");
					break;
			}//switch
		}//while
	}//menueThree
	
}//App
