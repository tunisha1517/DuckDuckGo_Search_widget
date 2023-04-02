package duckDuckGoProject.pojoClasses;

/**
 * POJO class to hold JSON data from {@link https://api.duckduckgo.com/}
 *
 */
public class DataHolder {

	private String Heading;
	private String Abstract;
	private String AbstractSource;
	private String AbstractUrl;
	private String Answer;
	private String Image;
	private String Defination;
	private String DefinationSource;
	private String DefinationUrl;

	private Related_Topics[] RelatedTopics;
	private Results[] Results;

	public DataHolder() {
		super();
	}

	public DataHolder(String heading, String abstract1, String abstractSource, String abstractUrl, String answer,
			String image, String defination, String definationSource, String definationUrl,
			Related_Topics[] relatedTopics, duckDuckGoProject.pojoClasses.Results[] results) {
		super();
		Heading = heading;
		Abstract = abstract1;
		AbstractSource = abstractSource;
		AbstractUrl = abstractUrl;
		Answer = answer;
		Image = image;
		Defination = defination;
		DefinationSource = definationSource;
		DefinationUrl = definationUrl;
		RelatedTopics = relatedTopics;
		Results = results;
	}

	public String getHeading() {
		return Heading;
	}

	public void setHeading(String heading) {
		Heading = heading;
	}

	public String getAbstractSource() {
		return AbstractSource;
	}

	public void setAbstractSource(String abstractSource) {
		AbstractSource = abstractSource;
	}

	public String getAbstractUrl() {
		return AbstractUrl;
	}

	public void setAbstractUrl(String abstractUrl) {
		AbstractUrl = abstractUrl;
	}

	public String getDefinationSource() {
		return DefinationSource;
	}

	public void setDefinationSource(String definationSource) {
		DefinationSource = definationSource;
	}

	public String getDefinationUrl() {
		return DefinationUrl;
	}

	public void setDefinationUrl(String definationUrl) {
		DefinationUrl = definationUrl;
	}

	public String getAbstract() {
		return Abstract;
	}

	public void setAbstract(String abstract1) {
		Abstract = abstract1;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		if (answer.equals(""))
			Answer = "Empty";
		else
			Answer = answer;
	}

	public String getDefination() {
		return Defination;
	}

	public void setDefination(String defination) {
		Defination = defination;
	}

	public Related_Topics[] getRelatedTopics() {
		return RelatedTopics;
	}

	public void setRelatedTopics(Related_Topics[] relatedTopics) {
		RelatedTopics = relatedTopics;
	}

	public Results[] getResults() {
		return Results;
	}

	public void setResults(Results[] results) {
		Results = results;
	}

}
