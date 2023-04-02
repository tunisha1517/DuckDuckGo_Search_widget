package duckDuckGoProject.pojoClasses;

/**
 * POJO class to hold JSONArray data {@link Results} 
 * from {@link https://api.duckduckgo.com/}
 *
 */
public class Results {

	private String FirstURL;
	private String Text;

	public Results() {
		super();
	}

	public Results(String firstURL, String text) {
		super();
		FirstURL = firstURL;
		Text = text;
	}

	public String getFirstURL() {
		return FirstURL;
	}

	public void setFirstURL(String firstURL) {
		FirstURL = firstURL;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

}
