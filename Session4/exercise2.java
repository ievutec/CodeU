public class Palindrome2{
    
    public static String longestPalindrome(String s){

	int index = -1;
	int length = 0;

	for(int i = 0; i < s.length(); i++){
	    
	    int end = s.lastIndexOf(s.charAt(i));
	    String test = s.substring(i,end+1);
	    while(end != -1 && end != i){
		if(isPalindrome(test) && test.length() > length){
		    length = test.length();
		    index = i;
		    break;
		}
		else{
		    test = s.substring(0,end);
		    end = test.lastIndexOf(s.charAt(i));
		    test = s.substring(i,end+1);
		}
	    }
	}

	if(index == -1) return "There are no palindromes in the string.";

	return "The longest palindrome starts at index " + index + " and has a length of " + length;

    }


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
	
	System.out.println(longestPalindrome(test1));
	System.out.println(longestPalindrome(test2));
	System.out.println(longestPalindrome(test3));
	System.out.println(longestPalindrome(test4));


    }
}
