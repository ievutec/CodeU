public class QueryStream {
    private List<Query> queryStream;
    private Iterator<Query> streamIterator;
    private Query currentQuery;
    
    public QueryStream(List<Query> queryStream) {
        this.queryStream = queryStream;
        streamIterator = this.queryStream.iterator();
        if (this.streamIterator.hasNext()) {
            System.out.println(0);  // first timestamp
            currentQuery = streamIterator.next();
        }
    }
    
    public boolean hasNext() {
        while (!(currentQuery.hasNext())) {     // find next query which has words
            if (!(streamIterator.hasNext())) {
                return false;
            }
            Query oldQuery = currentQuery;
            currentQuery = streamIterator.next();
            System.out.println(currentQuery.getTimestamp() - oldQuery.getTimestamp());
        }
        return true;
    }
    
    public String next() throws IllegalStateException {
        if (this.hasNext()) {
            return currentQuery.next();
        } else {
            throw new IllegalStateException("Error, all elements of query stream were already printed.");
        }
    }
}
