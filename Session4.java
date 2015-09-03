
// EXERCISE 1

// I decided to simplify the task by not using trailing zeros, although
// if I have time I'll modify the original to configure to trailing zeros.

// If there is a way to make the function faster, I think I would create an
// array to keep track of the integers I already know are palindromes and configure
// the size of the array to whatever is appropriate for its usage.

public int bitPalindrome(int K){
  
  if(K <= 0) return 0;
  
   int tracker = 1;
   int num = 1;
   while(tracker != K){
     String s = Integer.toBinaryString(num);
     if(isPalindrome(s)) tracker++;
     num++;
   }
   return num;
}

// Note: I like using this method of determining palindrome strings because
// they save up time by spotting an irregularity without having to check
// the entire string. I could have just as easily split the string into its halves,
// reversed the second half and attempted to use an equality function supplied
// by java.

public boolean isPalindrome(String s){
  for(int i = 0; i <= s.length()/2; i++){
    if(s.charAt(0) == s.charAt(s.length()-1)) {
      s = s.substring(1,s.length()-1);
    }
    else return false;
  }
  return true;
}

// TEST CASES FOR EXERCISE 1:

public static void main(String[] args){
  
  System.out.println(bitPalindrome(15)); // should return 
  System.out.println(bitPalindrome(0)); 
  System.out.println(bitPalindrome(-4));
  System.out.println(bitPalindrome(15));
}
