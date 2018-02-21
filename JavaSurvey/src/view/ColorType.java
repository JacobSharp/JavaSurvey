package view;

import java.awt.Color;

public enum ColorType {
	Cyan(Color.cyan), Magenta(Color.magenta), Yellow(Color.yellow), Red(Color.red), Green(Color.green), Blue(
			Color.blue); 

	private final Color color;

	private ColorType(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
}
