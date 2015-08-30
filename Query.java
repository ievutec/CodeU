public class Query {
    private Integer timestamp;
    private String words;
    private Integer position; 
    
    public Query(String words) {
        this.words = words;
        position = 0;
    }
    
    public Integer getTimestamp() {
        return this.timestamp;
    }
     
    public boolean hasNext() {
        if (position == words.length()) return false;
        while (words.charAt(position) == ' ') {
            position++;
            if (position == words.length()) return false;
        }
        return true;
    }
    
    public String next() {
        int oldPosition = position;
        while (position < words.length() && words.charAt(position) != ' ') position++;
        return words.substring(oldPosition, position);
    }
}
