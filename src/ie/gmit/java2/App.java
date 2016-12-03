package ie.gmit.java2;

import java.util.ArrayList;
import java.util.List;

//Shane Daniels - G00332592
//Text Analyser - store text from given file or URL

import java.util.Scanner;

public class App {
	
	//variables
	public static int option=0, fileOrUrl=0, search=0;
	
	//scanner
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("---- Text Analyser ----");
		
		menuOne();
		
		sc.close();

	}//main
			
	public static void menuOne(){
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
	
	public static void menuTwo(){
		String inFile = "";
		//While 
		while(fileOrUrl != 3){
			System.out.println("\n1) File\n2) URL\n3) Back");
			fileOrUrl = sc.nextInt();
			
			switch (fileOrUrl) {
			case 1:
				System.out.println("--- File ---");
	
				//Prompt for file name
				System.out.print("Please enter name of file:");
				inFile = sc.next();
				
				Parsearator fp = new FileParser(inFile);
				System.out.println("File Parsed!");
				
				//test
				////////////////////
//				String search = "book";
//				System.out.println("Book contains " + search + "? " + fp.contains(search));
//				System.out.println("The size of the Array is: " + fp.count());
				////////////////////
				break;
				
			case 2:
				System.out.println("--- URL ---");
				System.out.print("Please enter name of file:");
				inFile = sc.next();
				
				//testing
				Parsearator url = new URLParser();
				url.parse(inFile);
				
				 List<String> urlList = new ArrayList <String>();
				 urlList = url.getList();
				 
				 for (String string : urlList) {
					System.out.println(string);
				}
			
//				//test
//				////////////////////
//				String searchURL = "a";
//				System.out.println("contains " + searchURL + "? " + up.contains(searchURL));
//				System.out.println("The size of the Array is: " + up.count());
//				////////////////////
				break;
			}//switch
		}//while
	}//menuTwo
	
	public static void menueThree(){
		//While 
		while(search != 4){
			System.out.println("\n1) Contains\n2) Search\n3) search\n4) Back");
			search = sc.nextInt();
				
			switch (search) {
				case 1:
					System.out.println("---- Contains(String) ----");
					System.out.print("Enter String: ");
					
					break;
				case 2:
					System.out.println("---- Count() ----");
					break;
				case 3:
					System.out.println("---- Count(String) ----");
					break;
				case 4:
					System.out.println("---- Get First Index(String) ----");
					break;
				case 4:
					System.out.println("---- Get Last Index(String) ----");
					break;
				case 4:
					System.out.println("---- Get All Indices ----");
					break;
				case 4:
					System.out.println("---- Delete(String) ----");
					break;
				case 4:
					System.out.println("---- Delete(int) ----");
					break;
				case 4:
					System.out.println("---- Back ----");
					break;
			}//switch
		}//while
	}//menueThree
	
}//App
