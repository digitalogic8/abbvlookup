package bumperdata;

import java.util.Date;

import com.google.gson.Gson;

public class Payment {

	private String id;
	private String whatFor;
	private String howmuch;
	private Date when;

	public Payment(String whatFor, String howmuch, Date when) {
		super();
		this.whatFor = whatFor;
		this.howmuch = howmuch;
		this.when = when;
	}

	public String getWhatFor() {
		return whatFor;
	}

	public void setWhatFor(String whatFor) {
		this.whatFor = whatFor;
	}

	public String getHowmuch() {
		return howmuch;
	}

	public void setHowmuch(String howmuch) {
		this.howmuch = howmuch;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
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
