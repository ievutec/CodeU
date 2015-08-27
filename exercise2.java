

Integer hasMajority(ArrayList<Integer> list){
  
  if(list.isEmpty()) return null;
  if(list.size() == 1) return list.get(0);
  
  // I can use various sorting algorithms I write myself to sort the list,
  // such as mergesort or selectionsort, but since those are things I can 
  // explain to the interviewer, I focused on my own solution to the problem 
  // instead, using Collections.sort() to do the dirty work.
  
  Collections.sort(list); 
  int lim = list.size()/2;
  while(!list.isEmpty()){
    int number = lastIndexOf(list.get(0)) + 1;
    if(number > lim) return list.get(0);
    list.subList(0, number).clear();
  }
  return null;
  
  // And the given test cases + some of my own I used to test the algorithm:
  
  public static void main(String[] args){
		
		ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(5, 3, 9, 4, 3, 3, 8, 3, 3));
		ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(5, 3, 9, 4, 3, 3, 8, 3));
		ArrayList<Integer> l3 = new ArrayList<Integer>(Arrays.asList(1));
		ArrayList<Integer> l4 = new ArrayList<Integer>(Arrays.asList(-5, 3, 9, 4, 3, -3, 8, 3));
		
		System.out.println(hasMajority(l1)); // 3
		System.out.println(hasMajority(l2)); // null
		System.out.println(hasMajority(l3)); // 1
		System.out.println(hasMajority(l4)); // null
		
	}
}
