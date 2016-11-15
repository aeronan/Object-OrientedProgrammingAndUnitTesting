package asgn1Tests;

import java.util.BitSet;

import org.junit.Assert;
import org.junit.Test;

import asgn1Collection.ListingException;
import asgn1Collection.MovieListing;
import junit.framework.TestCase;

public class MovieListingTests extends TestCase {

    @Test
    public void testMovieListing() {
        MovieListing movieList = null;
        try {
            movieList = new MovieListing("A Star Is Born", 1937);
            Assert.assertEquals("A Star Is Born", movieList.getTitle());
            Assert.assertEquals(1937, movieList.getYear());
        } catch (ListingException e) {            
            e.printStackTrace();
        }
        Assert.assertNotNull(movieList);
    }

    /**
     * test MovieListing with exception
     */
    @Test
    public void testMovieListingWithException1() {
        try {
            MovieListing movieList = new MovieListing(null, 1937);
            Assert.fail();
        } catch (ListingException ex) {

        }
    }

    /**
     * test MovieListing with exception
     */
    @Test
    public void testMovieListingWithException2() {
        try {
            MovieListing movieList = new MovieListing("", 1937);
            Assert.fail();
        } catch (ListingException ex) {

        }
    }

    /**
     * test MovieListing with exception
     */
    @Test
    public void testMovieListingWithException3() {
        try {
            MovieListing movieList = new MovieListing("Test", -1);
            Assert.fail();
        } catch (ListingException ex) {

        }
    }

 /**
  * test add keyword
  */
    @Test
    public void testAddKeyword() {
        try {
            MovieListing movieList = new MovieListing("Test", 1937);
            movieList.addKeyword("test");
            Assert.assertTrue(movieList.getKeywords().contains("test"));
            Assert.assertFalse(movieList.getKeywords().contains("test1"));
            Assert.assertEquals(1, movieList.numKeywords());
            movieList.addKeyword("test2");
            Assert.assertEquals(2, movieList.numKeywords());
        } catch (ListingException ex) {
        }
    }
    
    /**
     * test add an empty string as keyword which causes an exception 
     */
    @Test
    public void testAddKeywordWithException1() {
        try {
            MovieListing movieList = new MovieListing("Test", 1937);
            movieList.addKeyword("");
            Assert.fail();
        } catch (ListingException ex) {
        }

    }
    
    /**
     * test add null as keyword which causes an exception 
     */
    @Test
    public void testAddKeywordWithException2() {
        try {
            MovieListing movieList = new MovieListing("Test", 1937);
            movieList.addKeyword(null);
            Assert.fail();
        } catch (ListingException ex) {
        }

    }

    @Test
    public void testFindSimilarity() {
        try {
            MovieListing movieList = new MovieListing("Test", 1937);
            BitSet bs=new BitSet();
            bs.set(0);
            bs.set(1);
            bs.set(5);
            movieList.setKeyVector(bs);
            
            
            MovieListing movieList1 = new MovieListing("Test", 1937);
            BitSet bs1=new BitSet();
            bs1.set(0);
            bs1.set(1);
            bs1.set(5);
            movieList1.setKeyVector(bs1);
            
            Assert.assertEquals(3,movieList.findSimilarity(movieList1));
         
        } catch (ListingException ex) {
        }
    }
    
    
    @Test
    public void testFindSimilarityWithException1() {
        try {
            MovieListing movieList = new MovieListing("Test", 1937);
            MovieListing movieList1 = new MovieListing("Test", 1937);
            BitSet bs1=new BitSet();
            bs1.set(0);
            bs1.set(1);
            bs1.set(5);
            movieList1.setKeyVector(bs1);            
            movieList.findSimilarity(movieList1);
            Assert.fail();
        } catch (ListingException ex) {
        }
    }
    
    /**
     * test Find Similarity WithException  
     */
    @Test
    public void testFindSimilarityWithException2() {
        try {            
            MovieListing movieList1 = new MovieListing("Test", 1937);
            BitSet bs1=new BitSet();
            bs1.set(0);
            bs1.set(1);
            bs1.set(5);
            movieList1.setKeyVector(bs1);            
            movieList1.findSimilarity(null);
            Assert.fail();
        } catch (ListingException ex) {
        }
    }

    @Test
    public void testSetKeyVector() {
        try {
            MovieListing movieList = new MovieListing("Test", 1937);
            BitSet bs=new BitSet();
            bs.set(0);
            bs.set(1);
            movieList.setKeyVector(bs);
            Assert.assertEquals(bs,movieList.getKeyVector());
         
        } catch (ListingException ex) {
        }
    }

    @Test
    public void testWriteKeyVectorWithException() {
        try {
            MovieListing movieList = new MovieListing("Test", 1937);
            movieList.writeKeyVector();
            Assert.fail();   
         
        } catch (ListingException ex) {
        }
    }
    
    @Test
    public void testWriteKeyVector() {
        try {
            MovieListing movieList = new MovieListing("Test", 1937);
            BitSet bs=new BitSet();
            bs.set(0);
            bs.set(1);
            bs.set(3);
            movieList.setKeyVector(bs);
            Assert.assertEquals("1101",movieList.writeKeyVector());
         
        } catch (ListingException ex) {
        }
    }

    /**
     * test write keywords
     */
    @Test
    public void testWriteKeywords() {
        try {
            MovieListing movieList = new MovieListing("Test", 1937);
            movieList.addKeyword("Star");
            movieList.addKeyword("Jack Chen");
            movieList.addKeyword("Batman");
            Assert.assertEquals("Star,Jack Chen,Batman",movieList.writeKeywords());
        } catch (ListingException ex) {
        }
    }  
}
