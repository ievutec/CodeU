
// My exercises are largely done assuming that the trivial bits like
// importing trivialDictionary as well as creating an instance of it
// are self-evident and not the point of the exercise.
// ie Don't worry, I know how to do these things, I just preferred
// to focus on the problem-solving.
// If this is an issue, I'm happy to change my exercises and make them look
// neater, but I tried to stick to time constraints.

// Note: I am assuming that the words in TrivialDictionary are in alphabetical order
// and that they all start with a lower-case letter. (I would ask if that's okay during the interview)

private HashMap() map = new HashMap();

public boolean isInDictionary(String word){
  
  // Set up a way to reduce the search range through using past results:
  // I use a method to shorten the range through which I search for the 
  // right word. If I have a word starting with the letters 'had' and I
  // already know from previous searches that 'ingenious' is at index N,
  // I know that the word will not be beyond index N etc.
  
  int min = 0;
  int max = -1; // since if map is empty, I don't want it to mess up my while loop below.
  for(String key in map){
    int compare = word.compareTo(key.subString(0, word.length());
    if(compare == 0 || (compare > 0 && min < map.get(key))) min = map.get(key);
    else (compare < 0 && (max > map.get(key) || max == -1)) max = map.get(key);
  }
  
  // Loop through the dictionary using my reduced range:
  
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
  
