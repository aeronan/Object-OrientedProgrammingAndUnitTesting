package asgn1Collection;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class to handle an individual movie, implementing the Listing interface 
 *
 */
public class MovieListing implements Listing {

	private String title;
	private int year;
	private Set<String> keywords;
	private BitSet keyVector;

	/**
	 * Constructor for the MovieList class keyVector has meaning only w.r.t. a
	 * full asgn1Collection lexicon, and so requires keywords from across the
	 * collection for initialisation.
	 * 
	 * @param title
	 *            - String containing movie title
	 * @param year
	 *            - int containing year in which the movie was made
	 * @throws ListingException
	 */
	public MovieListing(String title, int year) throws ListingException {
		if (title == null || title.isEmpty() || year <= 0) {
			throw new ListingException("Missing Keyword");
		}

		this.title = title;
		this.year = year;
		this.keywords = new TreeSet<String>();
	}

	/**
	 * add a valid keyword to the list
	 * @throws ListingException 
	 */
	public void addKeyword(String keyword) throws ListingException {
		if(keyword==null || keyword.isEmpty()){
			throw new ListingException("Invalid Keyword");
		}
		this.keywords.add(keyword);
	}

	/**
	 * get title of the movie list
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * find the number of keywords common to this and the Listing l based on the keyVector representations for each listing
	 */
	@Override
	public int findSimilarity(Listing listing) throws ListingException {
		int similarity=0;
		if(this.keyVector==null || listing==null){
			throw new ListingException("Invalid Keyword");
		}
		
		for (int i = this.keyVector.nextSetBit(0); i >= 0; i = this.keyVector.nextSetBit(i+1)) {
			if(this.keyVector.get(i)&&listing.getKeyVector().get(i)){
				similarity++;
			}
		}
		return similarity;
	}

	/**
	 * get key vector
	 */
	@Override
	public BitSet getKeyVector() throws ListingException {
		return keyVector;
	}

	/**
	 * get year
	 */
	@Override
	public int getYear() {
		return year;
	}

	/**
	 * get number of keywords
	 */
	@Override
	public int numKeywords() {
		return this.keywords.size();
	}

	/**
	 * set key vector
	 */
	@Override
	public void setKeyVector(BitSet bs) {
		this.keyVector = bs;
	}

	/**
	 * Simple method to accumulate keyVector for printing 
	 */
	@Override
	public String writeKeyVector() throws ListingException {
	    if(keyVector==null){
	        throw new ListingException("keyVector should not be null");
	    }
	    
	    StringBuilder builder=new StringBuilder();	    
	    for(int i=0;i<keyVector.length();i++){
	        if(keyVector.get(i)){
	        builder.append("1"); 
	        }else{
	            builder.append("0");
	        }
	    }	    	    
		return builder.toString();
	}

	/**
	 * Simple method to accumulate keywords for printing
	 */
	@Override
	public String writeKeywords(){    
	    
	    Object r[]= reverse(keywords.toArray());	    
	    if (r.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i;
        for(i=0;i<r.length;i++){
            sb.append((String)r[i]);
            if(i<r.length-1){
                sb.append(",");               
                }
        }
        return sb.toString();
	}
	
	private static Object[] reverse(Object[] arr) {
        List< Object > list = Arrays.asList(arr);
        Collections.reverse(list);
        return list.toArray();
    }

	/**
	 * Getter to provide access to the Listing keywords
	 */
	@Override
	public Set<String> getKeywords() {
		return this.keywords;
	}

}
