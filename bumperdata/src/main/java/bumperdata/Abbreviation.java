package bumperdata;

import com.google.gson.Gson;

public class Abbreviation {

	private String id;
	private String abbvr;
	private String expandadedData;
	private String url;
	private String image;
	private String data;

	public Abbreviation(String abbvr, String expandadedData, String url,
			String image, String data) {
		super();
		this.abbvr = abbvr;
		this.expandadedData = expandadedData;
		this.url = url;
		this.image = image;
		this.data = data;
	}

	public String getAbbvr() {
		return abbvr;
	}

	public void setAbbvr(String abbvr) {
		this.abbvr = abbvr;
	}

	public String getExpandadedData() {
		return expandadedData;
	}

	public void setExpandadedData(String expandadedData) {
		this.expandadedData = expandadedData;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		String json = gson.toJson(this);
		return json;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
