import java.io.*;
import java.util.HashSet;


public class LookUp{

    public static HashSet<String> dictionary = new HashSet<String>();

    private static void initDict() throws IOException{
	BufferedReader reader = new BufferedReader(new FileReader("enable1.txt"));
	while(reader.ready()){
	    String word = reader.readLine();
	    dictionary.add(word);
	}
	reader.close();
    }
    
    public static String correct(String input){

	if(input.length() == 1 || input.length() == 2) return input;
       
        for(int i = 1; i < input.length()-1; i++){
	    String first = input.substring(0,i);
	    if(dictionary.contains(first)){
		String second = input.substring(i);
		if(dictionary.contains(second)) return "Did you mean \"" + first + " " + second + "\" ?";
	    }
	}

	return "You make no sense whatsoever when it comes to english, sorry";
    }

    public static void main(String[] args){

	try{
	    initDict();
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
	System.out.println(correct("giantelephant"));
	System.out.println(correct("thesun"));
	System.out.println(correct("a"));
    }
}
