/***********************************************************************/

package model;

/***********************************************************************/

class Token {
	
	private int value;
	private String color;
	/*private img;*/
	
	/***************************************************************************
	*  Method: Constructor - Token : Initializes the Token
	*  ****/
	
	Token(int value, String color)	{
		this.value = value;
		this.color = color;
	}
	/* End Method: Constructor - Token */
	/*
	***************************************************************************
	*  Method: int getValue : Returns the value of the Token
	*  ****/
	
	int getValue() {
		return value;
	}
	/* End Method: int getValue */
	/*
	***************************************************************************
	*  Method: String getColor : Returns a String with the color of the Token
	*  ****/
	String getColor() {
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