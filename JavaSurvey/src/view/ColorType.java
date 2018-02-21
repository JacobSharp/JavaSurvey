package view;

import java.awt.Color;

public enum ColorType {
	CYAN(Color.cyan), MAGENTA(Color.magenta), YELLOW(Color.yellow), RED(Color.red), GREEN(Color.green), BLUE(
			Color.blue), WHITE(Color.white); 

	private final Color color;

	private ColorType(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
}
