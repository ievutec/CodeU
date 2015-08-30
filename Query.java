public class Query {
    private Integer timestamp;
    private String words;
    private Integer tracker; 
    
    public Query(String words) {
        this.words = words;
        tracker = 0;
    }
     
    public boolean hasNext() {
        if (tracker == words.length()) return false;
        while (words.charAt(tracker) == ' ') {
            tracker++;
            if (tracker == words.length()) return false;
        }
        return true;
    }
    
    public String next() {
        int prev = tracker;
        while (tracker < words.length() && words.charAt(position) != ' ') tracker++;
        return words.substring(prev, tracker);
    }
    
    public Integer getTimestamp() {
    return this.timestamp;
    }
}
