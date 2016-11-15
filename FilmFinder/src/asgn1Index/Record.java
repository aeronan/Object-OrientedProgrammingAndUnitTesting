package asgn1Index;

/**
 * hold title and (int) similarity data * 
 *
 */
public class Record extends AbstractRecord implements Comparable {
	
	/**
	 * Constructor for the Record class.
	 * @param title
	 * @param similarity
	 * @throws IndexException
	 */
    public Record(String title, int similarity) throws IndexException {
	    if(title==null||title.isEmpty()){
	        throw new IndexException("title should not be null or empty");
	    }
	    
	    if(similarity<0){
            throw new IndexException("similarity should not be negative");
        }
	    
		this.similarity = similarity;
		this.title = title;
	}

	/**
	 * compare two Record
	 */
	@Override
	public int compareTo(Object arg) {
		Record record=(Record)arg;
		if (this.similarity > record.getSimilarity()) {
			return 1;
		} else if (this.similarity < record.getSimilarity()) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * return the similarity 
	 */
	@Override
	public int getSimilarity() {
		return this.similarity;
	}

	/**
     * return the title 
     */
	@Override
	public String getTitle() {
		return this.title;
	}	

}
