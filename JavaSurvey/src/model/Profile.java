package model;

import java.sql.Date;

public class Profile extends User {

	private int id;
	private String name;
	private Date geburtsdatum;
	private String profilBildLink;
	private int user_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getGeburtsdatum() {
		return geburtsdatum;
	}

	public void setGeburtsdatum(Date geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

	public String getProfilBildLink() {
		return profilBildLink;
	}

	public void setProfilBildLink(String profilBildLink) {
		this.profilBildLink = profilBildLink;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
