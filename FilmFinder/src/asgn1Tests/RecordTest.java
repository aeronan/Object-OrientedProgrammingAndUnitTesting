/**
 * unit test for Record
 */
package asgn1Tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import asgn1Index.IndexException;
import asgn1Index.Record;

/**
 *  test class for Record
 *
 */
public class RecordTest {
    /**
     * Test method for {@link asgn1Index.Record#Record(java.lang.String, int)}.
     */
    @Test
    public void testRecord() {
        try{
            
         Record record=new Record("test",1);
         Assert.assertEquals(1,record.getSimilarity());
         Assert.assertEquals("test",record.getTitle());
         
        }catch(IndexException ex){
        }
    }
    
    /**
     * Test method for {@link asgn1Index.Record#Record(java.lang.String, int)}.
     */
    @Test
    public void testRecordWithException1() {
        try{
            
            Record record=new Record("",1);
            Assert.fail();
           }catch(IndexException ex){
           }
    }
    
    /**
     * Test method for {@link asgn1Index.Record#Record(java.lang.String, int)}.
     */
    @Test
    public void testRecordWithException2() {
        try{
            
            Record record=new Record(null,1);
            Assert.fail();
           }catch(IndexException ex){
           }
    }

    
    /**
     * Test method for {@link asgn1Index.Record#Record(java.lang.String, int)}.
     */
    @Test
    public void testRecordWithException3() {
        try{
            
            Record record=new Record("Test",-1);
            Assert.fail();
           }catch(IndexException ex){
           }
    }

    /**
     * Test method for {@link asgn1Index.Record#compareTo(java.lang.Object)}.
     */
    @Test
    public void testCompareTo() {
        try{
            
            Record record=new Record("test",1);
            Record record1=new Record("test",2);
            Assert.assertTrue(record.compareTo(record1)<0);
           }catch(IndexException ex){
           }
        
    }
}
