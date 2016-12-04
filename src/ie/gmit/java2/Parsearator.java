package ie.gmit.java2;

import java.util.List;

public interface Parsearator {

	//parse url to file
	void parse(String url);//parse

	List<String> getList();

	boolean contains(String s);

	int count();

	int getFirstIndex(String s);

	int getLastIndex(String s);

	void delete(String s);

	int countOccurrences(String s);

	void delete(int index);

	int[] getAllIndices(String s);
		
}