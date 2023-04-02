package duckDuckGoProject.pojoClasses;

/**
 * this class handles search requests to get and set request for the particular
 * object created for this class
 */
public class SearchRequest {
	private String searchQuery;

	/**
	 * returns the search request recieved of that object
	 * 
	 * @return search query of type String
	 */
	public String getSearchQuery() {
		return searchQuery;
	}

	/**
	 * Receives search request and assign it to the object
	 * 
	 * @param searchQuery of type String
	 */
	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

}
