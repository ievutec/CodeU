public class Palindrome{
    
    // EXERCISE 1
    
    // I decided to simplify the task by not using trailing zeros, although
    // if I have time I'll modify the original to configure to trailing zeros.
    
    // If there is a way to make the function faster, I think I would create an
    // array to keep track of the integers I already know are palindromes and configure
    // the size of the array to whatever is appropriate for its usage.
    
    public static int bitPalindrome(int K){
	
	if(K <= 0) return 0;
	if(K == 1) return 1;
	
	int tracker = 1;
	int num = 1;
	while(tracker != K){
	    num++;
	    String s = Integer.toBinaryString(num);
	    if(isPalindrome(s)) tracker++;
	}
	return num;
    }
    
    // Note: I like using this method of determining palindrome strings because
    // they save up time by spotting an irregularity without having to check
    // the entire string. I could have just as easily split the string into its halves,
    // reversed the second half and attempted to use an equality function supplied
    // by java.
    
    public static boolean isPalindrome(String s){
	
	while(!s.isEmpty()){
	    if(s.length() == 1) return true;
	    char first = s.charAt(0);
	    char last = s.charAt(s.length() - 1);
	    if(first == last){
		s = s.substring(1,s.length()-1);
	    } 
	    else return false;
	}
	return true;
	
    }
    
    // TEST CASES FOR EXERCISE 1:
    
    public static void main(String[] args){
	
	System.out.println(bitPalindrome(16)); // should return 73
	System.out.println(bitPalindrome(0)); // should return 0
	System.out.println(bitPalindrome(-4)); // should return 0
	System.out.println(bitPalindrome(1)); // should return 1
	System.out.println(bitPalindrome(2)); // should return 3
	
    }
}
