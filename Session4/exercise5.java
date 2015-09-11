import java.io.*;
import java.util.HashSet;

// NOTE: for the purposes of testing the exercise, I used a text file I found online
// containing all the words in the english dictionary called "enable1.txt" which
// I got from https://code.google.com/p/dotnetperls-controls/downloads/detail?name=enable1.txt
// The words in the file are each on a separate line and could easily be read into a hashset.
// I feel a Hashset is one of the best options for this sort of function, since memory is not
// considered an issue (according to the exercise) and yet the contains function runs largely at
// constant O(1) speed.

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
