
// I've attempted the timestamps instead of <NEWQUERY> for the exercise.

public class QueryStream {
    private List<Query> queryStream;
    private Iterator<Query> streamIterator;
    private Query current;
    
    public QueryStream(List<Query> queryStream) {
        this.queryStream = queryStream;
        streamIterator = this.queryStream.iterator();
        if (this.streamIterator.hasNext()) {
            System.out.println(0);
            current= streamIterator.next();
        }
    }
    
    public boolean hasNext() {
        while (!(current.hasNext())) {
            if (!(streamIterator.hasNext())) {
                return false;
            }
            Query prev = current;
            current = streamIterator.next();
            System.out.println(current.getTimestamp() - prev.getTimestamp());
        }
        return true;
    }
    
    public String next() throws IllegalStateException {
        if (this.hasNext()) {
            return current.next();
        } else {
            throw new IllegalStateException("The QueryStream is empty.");
        }
    }
}
