package model;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends Survey {

	private List<String> antwort;

	public Quiz() {
		this.antwort = new ArrayList<>();
	}

	public List<String> getAntwort() {
		return antwort;
	}

	public void addAntwort(String antwort) {
		this.antwort.add(antwort);
	}

}
