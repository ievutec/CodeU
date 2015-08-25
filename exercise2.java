

Integer hasMajority(ArrayList<Integer> list){
  list.sort();
  int lim = list.size()/2;
  while(!list.isEmpty()){
    int number = lastIndexOf(list.get(0)) + 1;
    if(number > lim) return list.get(0);
    list.subList(0, number).clear();
  }
  return null;
}
