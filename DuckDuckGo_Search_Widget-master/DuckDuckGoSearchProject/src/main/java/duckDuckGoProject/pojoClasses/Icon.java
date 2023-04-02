package duckDuckGoProject.pojoClasses;

public class Icon {
	private String Height;

	private String Width;

	private String URL;

	public Icon() {
		super();
	}

	public Icon(String height, String width, String uRL) {
		super();
		Height = height;
		Width = width;
		URL = uRL;
	}

	public String getHeight() {
		return Height;
	}

	public void setHeight(String Height) {
		this.Height = Height;
	}

	public String getWidth() {
		return Width;
	}

	public void setWidth(String Width) {
		this.Width = Width;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}
}
