
// Note: I am assuming that the words in TrivialDictionary are in alphabetical order
// and that they all start with a lower-case letter. 

private HashMap() map = new HashMap();

public boolean isInDictionary(String word){
  
  // set up a way to reduce the search range through using past results
  
  int min = 0;
  int max = -1;
  for(String key in map){
    int comp = word.compareTo(key.subString(0, word.length());
    if(comp == 0 || (comp > 0 && min < map.get(key))) min = map.get(key);
    else (comp < 0 && (max > map.get(key) || max == -1)) max = map.get(key);
  }
  
  String temp = trivialDictionary.WordAt(min);
  while(temp != null || temp != max){
    if(word.equals(temp)){
      map.put(temp, min);
      return true;
    }
    min++;
    temp = trivialDictionary.WordAt(min);
  }
  return false;
}
  
