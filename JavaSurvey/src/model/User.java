package model;

public class User {

	private int id;
	private String username;
	private String password;
	private int spielpunkte;
	private int lookAndFeel;
	
	public int getLookAndFeel() {
		return lookAndFeel;
	}

	public void setLookAndFeel(int lookAndFeel) {
		this.lookAndFeel = lookAndFeel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSpielpunkte() {
		return spielpunkte;
	}

	public void setSpielpunkte(int spielpunkte) {
		this.spielpunkte = spielpunkte;
	}
}