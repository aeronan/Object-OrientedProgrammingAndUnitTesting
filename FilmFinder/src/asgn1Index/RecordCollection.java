package asgn1Index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collection class for the similarity records based on AbstractRecordCollection
 * @author 
 *
 */
public class RecordCollection extends AbstractRecordCollection {
	boolean isSorted;
	/**
	 * Constructor for the RecordCollection class. Initialises collection;
	 */
	public RecordCollection(){
		records=new ArrayList<Record>();	
	}	

	/**
	 * add a record to the collection
	 */
	@Override
	public void addRecord(Record record) throws IndexException {
		this.records.add(record);

	}

	/**
	 *  find the closest record in the collection (In practice, the top record once the collection is sorted)
	 */
	@Override
	public AbstractRecord findClosestRecord() throws IndexException {
		if(isSorted){
			return records.get(0);
		}else{
			throw new IndexException("The colelction is not sorted");
		}
		
	}

	/**
	 * Search method to find the n closest records in the collection (In practice, the top n records once the collection is sorted)
	 */
	@Override
	public List<Record> findClosestRecords(int n) throws IndexException {
		if(!isSorted || n > records.size() || n==0){
			throw new IndexException("The colelction is not sorted or n is not valid");
		}
		
		  List<Record> a = new ArrayList<Record>();
	      for (int i=0;i<n;i++) {
	          a.add(records.get(i)); 
	      }
		
		return a;
	}

	/**
	 * whether collection has been sorted
	 */
	@Override
	public boolean isSorted() {		
		return isSorted;
	}

	/**
	 *  sort the collection based on Record comparator
	 */
	@Override
	public void sortCollection() {	
		Collections.sort(records,Collections.reverseOrder());
		isSorted=true;
	}

}
