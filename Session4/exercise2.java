
// EXERCISE 2

// I reused my isPalindrome() function from exercise 1 and I've not modified this to
// accept natural language Palindromes, although that's not too difficultto do. I would simply 
// filter the input string of any characters that aren't letters and make it case insensitive
// if the need arose.

public class Palindrome2{
    
    public static String longestPalindrome(String s){

	int index = -1;
	int length = 0;

	for(int i = 0; i < s.length(); i++){
		
		// The function goes through possible palindromes by using substrings of the input
		// string, moving up the indexes and taking note of the longest palindrome found so 
		// far in variables index and length.
		// I reduce the amount of work by only checking substrings both beginning and ending with
		// the same character, so as to not go through every single possible substring in a 
		// very long input.
	    
	    int end = s.lastIndexOf(s.charAt(i));
	    String test = s.substring(i,end+1);
	    while(end != -1 && end != i){
		if(isPalindrome(test) && test.length() > length){
		    length = test.length();
		    index = i;
		    break; // if a palindrome is found, there is no reason to keep looking at shorter substrings/palindromes
		    	   // starting from this index
		}
		else{
		    test = s.substring(0,end); //removes the last character in the investigated string
		    end = test.lastIndexOf(s.charAt(i)); // finds the next longest substring with the same starting/ending character
		    test = s.substring(i,end+1); // produces a new possible palindrome to investigate.
		}
	    }
	}

	if(index == -1) return "There are no palindromes in the string.";

	return "The longest palindrome starts at index " + index + " and has a length of " + length;

    }
	//reused the isPalindrome() recursive function from exercise 1
    public static boolean isPalindrome(String s){
	
        if(s.isEmpty() || s.length() == 1) return true;
	
	char first = s.charAt(0);
	char last = s.charAt(s.length() - 1);
	if(first == last){
	    return isPalindrome(s.substring(1,s.length()-1));
	} 
	else return false;
	
    }

    public static void main(String[] args){

	String test1 = "12111122221212121";
	String test2 = "ababrakadabraaaababab";
	String test3 = "m";
	String test4 = "90!lalalalalal!09";
	
	System.out.println(longestPalindrome(test1)); // original test case. Returns "The longest palindrome starts at index 9 and has a length of 7"
	System.out.println(longestPalindrome(test2)); // Returns "The longest palindrome starts at index 15 and has a length of 5"
	System.out.println(longestPalindrome(test3)); // Returns "There are no palindromes in the string."
	System.out.println(longestPalindrome(test4)); // Returns "The longest palindrome starts at index 0 and has a length of 17"


    }
}
