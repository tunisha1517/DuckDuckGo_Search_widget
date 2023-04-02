package duckDuckGoProject.interfaces;

import duckDuckGoProject.pojoClasses.DataHolder;
import duckDuckGoProject.pojoClasses.SearchRequest;

/**
 * This interface specifies the DuckDuckGo search functionality that is to be
 * implemented.
 */
public interface DuckDuckGoSearcher {

	/**
	 * search the duckduckgo using an api and return the list of articles displayed
	 * once the articles are successfully retrieved the search query needs to be
	 * encrypted and stored in local sqlite db
	 * 
	 * @param request the search request
	 * @return list of data displayed
	 */
	public DataHolder Search(SearchRequest request);
}
