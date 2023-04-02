package duckDuckGoProject;

import java.util.Scanner;

import duckDuckGoProject.pojoClasses.DataHolder;
import duckDuckGoProject.pojoClasses.Related_Topics;
import duckDuckGoProject.pojoClasses.SearchRequest;

public class MainClass {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Search text : "); 
		String searchRequestQuery = sc.next().trim();
		sc.close();
		
		SearchRequest query = new SearchRequest();
		query.setSearchQuery(searchRequestQuery);
		ConnectToDuckDuckGoServer connect = new ConnectToDuckDuckGoServer();
		DataHolder holder = connect.Search(query);
		/*System.out.println("Abstract: " + holder.getAbstract());
		
		 * System.out.println("Source :" +holder.getAbstractSource());
		 * System.out.println("URL:" + holder.getAbstractUrl());
		 * System.out.println(holder.getAbstract()); Related_Topics[] relatedTopics =
		 * holder.getRelatedTopics();
		 * 
		 * for (int i = 0; i < relatedTopics.length; i++) {
		 * System.out.println(relatedTopics[i].getFirstURL());
		 * 
		 * }
		 */

	}

}
