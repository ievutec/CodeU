import java.util.Arrays;

public class Change{
    

    // I am assuming that the coin denominations have to be positive, non-zero
    // integers. I am also assuming that N cannot equal 0, else there would
    // be nothing to make change of. These cases return -1.

    public static int makeChange(int N, int[] coins){
	
	Arrays.sort(coins);
	if(N < 0 || coins[0] <= 0) return 0;
	
	int counter = 0;
	
	for(int i : coins){

	    if(N-i == 0){
		return 1;
	    }
	    else counter += makeChange(N-i, coins);
	    coins = Arrays.copyOfRange(coins, 1, coins.length);
	}

	return counter;

    }

    public static void main(String[] args){
	
	int[] test1 = {2,3,5};
	int[] test2 = {1,2,3,5};
	int[] test3 = {2,3,5};
	
	System.out.println(makeChange(10, test1));
	System.out.println(makeChange(1, test2));
	System.out.println(makeChange(8, test3));

    }

}
