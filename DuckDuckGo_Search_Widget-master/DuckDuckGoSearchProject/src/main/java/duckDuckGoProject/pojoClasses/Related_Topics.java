package duckDuckGoProject.pojoClasses;

/**
 * POJO class to hold JSONArray data {@link RelatedTopics} 
 * from {@link https://api.duckduckgo.com/}
 *
 */
public class Related_Topics {
	
	private String FirstURL;
	private Icon Icon;
	private String Text;
	public Related_Topics() {
		super();
	}
	public Related_Topics(String firstURL, duckDuckGoProject.pojoClasses.Icon icon, String text) {
		super();
		FirstURL = firstURL;
		Icon = icon;
		Text = text;
	}
	
	public String getFirstURL() {
		return FirstURL;
	}
	public Icon getIcon() {
		return Icon;
	}
	public void setIcon(Icon icon) {
		Icon = icon;
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
