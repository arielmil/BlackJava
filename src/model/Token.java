package model;

class Token {
	private int value;
	private String color;
	/*private img;*/
	
	Token(int value, String color)	{
		this.value = value;
		this.color = color;
	}
	
	int getValue() {
		return value;
	}
	
	String getColor() {
		return color;
	}
	
	/*void render() {
		
	}*/
}
