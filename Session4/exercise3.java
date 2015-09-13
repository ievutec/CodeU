    // I considered a number of options for this one, first in my mind being generating
    // the next ugly number by multiplying together 2, 3 and 5, but that proved too complicated
    // and I considered that this is an exercise to be done in an interview in a short
    // period of time. 
    
    public static int findUgly(int K){
	
	if(K <= 0) return -1;

	int tracker = 1;
	int num = 1;
	
	while(tracker < K){
	    if(isUgly(num)) tracker++;
	    num++;
	}
	return num;
    }

    public static boolean isUgly(int n){
	
	if(n == 1) return true;
	
	if(n%2 == 0) return isUgly(n/2);
	if(n%3 == 0) return isUgly(n/3);
	if(n%5 == 0) return isUgly(n/5);

	return false;
    }

    public static void main(String[] args){
    	
    	int start = System.nanoTime();
	
	System.out.println(findUgly(3)); // returns 3
	System.out.println(findUgly(9)); // returns 10
	System.out.println(findUgly(1)); // returns 1
	System.out.println(findUgly(14)); // returns 19
	System.out.println(findUgly(0)); // returns -1
	System.out.println(findUgly(1600)); // returns 1382400001
	
	// The time to find the 1600th number is humongous and the last 
	// result I got printed "Time taken: 25168656000".
	// I believe the algorithm simplifies down to O(nlogn) (?)
	// so it's not terrible, but it does require some processing.
	
	System.out.println("Time taken: " + System.nanoTime() - start);
    }
}
