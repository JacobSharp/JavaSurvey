package view;

import java.awt.Color;

public enum ColorType {
	
	CYAN(Color.cyan), MAGENTA(Color.magenta), YELLOW(Color.yellow), RED(Color.red), GREEN(Color.green), BLUE(
			Color.blue), WHITE(Color.white);
	
	// Default color is set to WHITE
	public static final ColorType DEFAULT_COLORTYPE = ColorType.WHITE;

	private final Color color;

	private ColorType(Color color) {
		this.color = color;
	}

	/**
	 * Gets the Color of a ColorType object. 
	 * E.g. usable to set a Swing component background color from a ColorType object.
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Converts a Color object to a ColorType.
	 */
	public static ColorType convertColorToColorType(Color color) {
		ColorType javaColor = null;
		for(ColorType jc: ColorType.values()) {
		    if(jc.getColor().equals(color)) {
		    		javaColor = jc;
		    }
		}
		if(javaColor == null) {
		    System.err.println("Color " + color + " was not found inside the possible values of ColorType!");
		    return DEFAULT_COLORTYPE;
		}
		return javaColor;
	}
	
	/**
	 * Converts a String object to a ColorType. 
	 * E.g. usable to convert a color name from a DB to a ColorType object.
	 */
	public static ColorType convertStringToColorType(String colorRgb) {
		if (colorRgb == null) {
			return DEFAULT_COLORTYPE;
		} else {
			try {
				return ColorType.convertColorToColorType(new Color(Integer.parseInt(colorRgb)));
			} catch (IllegalArgumentException ex) {
				System.err.println("ColorType " + colorRgb + " was not found!");
				return DEFAULT_COLORTYPE;
			}
		}
	}

	public static String convertColorToString(Color color) {
		if (color == null) {
			return Integer.toString(Color.WHITE.getRGB());
		}
		return Integer.toString(color.getRGB());
	}
	
}