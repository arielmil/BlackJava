/***********************************************************************/

package model;
import java.util.Map;
import java.util.HashMap;

/***********************************************************************/

class Tokens {
	
	private int value;
	private String color;
	private static Map <String, Integer> color_to_value = new HashMap <String, Integer>(6);
	/*private img;*/
	
	static {
        int token_values[] = new int[] {1, 5, 10, 20, 50, 100};
		String token_names[] = new String[] {"Gray", "Red", "Blue", "Green", "Purple", "Black"};
		
		int i;
		for (i = 0; i < token_values.length; i++) {
			color_to_value.put(token_names[i], token_values[i]);
		}
	}
	
	/***************************************************************************
	*  Method: Constructor - Token : Initializes the Token Oi Ariel
	*  ****/
	
	public Token(String color)	{
		value = color_to_value.get(color);
		this.color = color;
	}
	/* End Method: Constructor - Token */
	/*
	***************************************************************************
	*  Method: int getValue : Returns the value of the Token
	*  ****/
	
	public int getValue() {
		return value;
	}
	/* End Method: int getValue */
	/*
	***************************************************************************
	*  Method: String getColor : Returns a String with the color of the Token
	*  ****/
	public String getColor() {
		return color;
	}
	/* End Method: String getColor */
	/*
	****************************************************************************
	 * 
	 * To be implemented...
	 * 
	 * Method: void render: Render the image of the Token on the Screen.
	 *  ****/
	/*void render() {
	
	
	}*/
	/* End Method: void render */
}