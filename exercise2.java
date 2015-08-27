

Integer hasMajority(ArrayList<Integer> list){
  
  if(list.isEmpty()) return null;
  if(list.size() == 1) return list.get(0);
  
  Collections.sort(list);
  int lim = list.size()/2;
  while(!list.isEmpty()){
    int number = lastIndexOf(list.get(0)) + 1;
    if(number > lim) return list.get(0);
    list.subList(0, number).clear();
  }
  return null;
}
