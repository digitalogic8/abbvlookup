package bumperdata;

import java.util.Date;

import com.google.gson.Gson;

public class Registration {

	private String id;
	private Abbreviation abbv;
	private User owner;
	private Date registered;
	private Date expiration;

	public Registration(Abbreviation abbv, User owner, Date registered,
			Date expiration) {
		super();
		this.abbv = abbv;
		this.owner = owner;
		this.registered = registered;
		this.expiration = expiration;
	}

	public Abbreviation getAbbv() {
		return abbv;
	}

	public void setAbbv(Abbreviation abbv) {
		this.abbv = abbv;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
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
