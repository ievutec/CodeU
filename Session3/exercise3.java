
public class Largest{
  
  private Integer[] array;
  private int sorted;
  
  public Largest(Integer[] array) throws IllegalArgumentException{
    if(array.length == 0) throw new IllegalArgumentException("The array is empty.");
    this.array = array;
    sorted = 0;
    this.sort();
  }
  
  public Integer nthLargest(int n) throws IllegalArgumentException{
    if(n < 1 || n >= array.length) throw new IllegalArgumentException("The input is out of bounds.");
    if(n < sorted) return array[n-1];
    else{
      for(int i = sorted; i < n; i++) this.sort();
      return array[n-1];
    }
    
  }
  
  private void sort(){
    int max = array[sorted+1];
    int temp = 0;
    for (int i = sorted; i < array.length; i++){
      if(array[i] >= max) {
        temp = i
      }
    }
    int num = array[sorted + 1];
    array[sorted + 1] = array[temp];
    array[temp] = num;
  }
}
