package duckDuckGoProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import duckDuckGoProject.interfaces.DuckDuckGoSearcher;
import duckDuckGoProject.pojoClasses.DataHolder;
import duckDuckGoProject.pojoClasses.SearchRequest;

public class ConnectToDuckDuckGoServer implements DuckDuckGoSearcher {

	private HttpClient client;

	protected ConnectToDuckDuckGoServer() {
		client = HttpClients.createDefault();
	}

	public DataHolder Search(SearchRequest request) {

		String queryRequest = request.getSearchQuery();
		HttpGet get = new HttpGet("https://api.duckduckgo.com/?q=" + queryRequest + "&format=json");
		InputStream dataStream = null;
		try {
			HttpResponse jsonResponse = client.execute(get);
			dataStream = jsonResponse.getEntity().getContent();
		} catch (ClientProtocolException e) {
			System.out.println("Some Error occured");
		} catch (IOException e) {
			System.out.println("Some Error occured");
		}

		BufferedReader readJson = new BufferedReader(new InputStreamReader(dataStream));
		Gson gsonObject = new Gson();
		DataHolder dataHolder = null;
		try {

			// Received json file assigned to the object of DataHolder
			dataHolder = gsonObject.fromJson(readJson, DataHolder.class);

		} catch (JsonSyntaxException e1) {
			System.out.println("Sorry... search not found");
			e1.getLocalizedMessage();

		} catch (JsonIOException e1) {
			System.out.println("Error processing request");
			e1.getLocalizedMessage();
		}

		// calculate search time in epoch millis format
		long searchedTime = java.time.Instant.now().toEpochMilli();

		try {

			// finally update the search request and the search time to sqlite database
			new UpdateSqliteDatabase().updateDB(queryRequest, searchedTime);

		} catch (NoSuchAlgorithmException e) {
			e.getLocalizedMessage();
		}

		return dataHolder;
	}

}
