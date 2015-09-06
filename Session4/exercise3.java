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
	
	System.out.println(findUgly(3));
	System.out.println(findUgly(9));
	System.out.println(findUgly(1));
	System.out.println(findUgly(14));
	System.out.println(findUgly(0));
	System.out.println(findUgly(1500));
    }
}
