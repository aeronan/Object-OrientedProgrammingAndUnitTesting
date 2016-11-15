/**
 *  test for record collection
 */
package asgn1Tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import asgn1Index.IndexException;
import asgn1Index.Record;
import asgn1Index.RecordCollection;

/**
 * @author 
 *
 */
public class RecordCollectionTest {

    /**
     * Test method for {@link asgn1Index.RecordCollection#addRecord(asgn1Index.Record)}.
     */
    @Test
    public void testAddRecord() {        
        try {
            RecordCollection recordCollection = new RecordCollection();
            Record record=new Record("test",1);            
            recordCollection.addRecord(record);
            recordCollection.sortCollection();
            Assert.assertEquals(recordCollection.findClosestRecord(),record);
            
        } catch (IndexException e) {          
            e.printStackTrace();
        } 
    }

    /**
     * Test method for {@link asgn1Index.RecordCollection#findClosestRecord()}.
     */
    @Test
    public void testFindClosestRecords() {
        
        try {
            RecordCollection recordCollection = new RecordCollection();
            Record record=new Record("test",1);            
            recordCollection.addRecord(record);
            
            Record record2=new Record("test",2);            
            recordCollection.addRecord(record2);
            
            recordCollection.sortCollection();
            
            Assert.assertEquals(recordCollection.findClosestRecords(2).get(0),record2);
            Assert.assertEquals(recordCollection.findClosestRecords(2).get(1),record);           
            
            
        } catch (IndexException e) {          
            e.printStackTrace();
        } 
        
    }

    /**
     * Test method for {@link asgn1Index.RecordCollection#findClosestRecords(int)}.
     */
    @Test
    public void testFindClosestRecordWithException() {
        try {
            RecordCollection recordCollection = new RecordCollection();
            Record record=new Record("test",1);            
            recordCollection.addRecord(record);           
            recordCollection.findClosestRecord();
            Assert.fail();
            
        } catch (IndexException e) {          
            e.printStackTrace();
        } 
    }

    /**
     * Test method for {@link asgn1Index.RecordCollection#isSorted()}.
     */
    @Test
    public void testIsSorted() {
        try {
            RecordCollection recordCollection = new RecordCollection();
            Record record=new Record("test",1);            
            recordCollection.addRecord(record);           
            Assert.assertFalse(recordCollection.isSorted());
            recordCollection.sortCollection();
            Assert.assertTrue(recordCollection.isSorted());
            
        } catch (IndexException e) {          
            e.printStackTrace();
        } 
    }

    /**
     * Test method for {@link asgn1Index.RecordCollection#sortCollection()}.
     */
    @Test
    public void testSortCollection() {
        try {
            RecordCollection recordCollection = new RecordCollection();
            Record record=new Record("test",1);            
            recordCollection.addRecord(record);
            
            Record record2=new Record("test",4);            
            recordCollection.addRecord(record2);            
            recordCollection.sortCollection();            
            Assert.assertEquals(recordCollection.findClosestRecord(),record2);                       
            
            
        } catch (IndexException e) {          
            e.printStackTrace();
        } 
    }
}
