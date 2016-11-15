package asgn1Collection;

import java.util.ArrayList;

//THis is some free code for you to include (adapting as needed) for inclusion in the MovieListing.java 
//class that you have to create. It is copied from that class before it was deleted. 
public class Snippet {
	private String title;
	private String year;
	private ArrayList<String> keywords;


		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return this.title + ":" + this.year + ":" + "Active keywords:" + this.numKeywords();
		}
	
	
		private String numKeywords() {
			// TODO Auto-generated method stub
			return null;
		}


		/* (non-Javadoc)
		 * @see asgn1Collection.Listing#writeKeywords()
		 */
		public String writeKeywords() {
			String str=""; int index=0;
			for (String kw : this.keywords) {
				str += kw +":"; 
				index++;
				if ((index % 10)==0) {
					str += "\n";
				}
			}
			return str;
		}
		
}

