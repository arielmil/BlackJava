/***********************************************************************/

package model;

import java.util.HashMap;
import java.util.Map;

/***********************************************************************/

public class Tokens {
	public int value;
	public int quantity;
	private int total;
	
	private static int tokensValues[];
	
	public String color;
	
	public static String tokensNames[];
	
	private static Map <String, Integer> color_to_value = new HashMap <String, Integer>(6);
		
	
	static {
        tokensValues = new int[] {1, 5, 10, 20, 50, 100};
		tokensNames = new String[] {"Gray", "Purple", "Blue", "Red", "Green", "Black"};
		
		int i;
		for (i = 0; i < tokensValues.length; i++) {
			color_to_value.put(tokensNames[i], tokensValues[i]);
		}
	}
	
	public Tokens(String color, int quantity) {
		
		/*Checks if given color is a key of color_to_value*/
		if (color_to_value.containsKey(color)) {
			value = colorToValue(color);
			this.quantity = quantity;
			this.color = color;
			setTotal();
		}
		
		else {
			/*colocar execao*/
			return;
		}
	}
	
	public int getValue() {
		return value;
	}
	
	public int getQuantity() {
		return quantity;
	}
		
	public String getColor() {
		return color;
	}
	
	
	public int getTotal() {
		return total;
	}
	
	public void tokensAdd(Tokens tokens) {
		quantity = quantity + tokens.quantity;
		total = total + tokens.total;
	}
	
	public void tokensAdd() {
		quantity++;
		total = total + value;
	}
	
	public void setTotal() {
		int i;
		int total = 0;
		for (i = 0; i < quantity; i++) {
			total = total + value;
		}
		this.total = total;
	}
	
	public Tokens tokensSubtract(int quantity) {
		Tokens returned = new Tokens(color, quantity);
		
		returned.quantity = this.quantity - returned.quantity;
		setTotal();
		
		return returned;
	}
	
	public Tokens tokenSubtract() {
		quantity = quantity - 1;
		total = total - value;
		return new Tokens(color, 1);
	}
	
	public int colorToValue(String color) {
		/*checar retorno invalido desse metodo*/
		return color_to_value.get(color);
	}
	
	public static List convertValueToTokens(int value) {
        int blackTokens, purpleTokens, greenTokens, blueTokens, redTokens, grayTokens;
        blackTokens = purpleTokens = greenTokens = blueTokens = redTokens = grayTokens = 0;
        
        int i;
        
        int tokenQuantities[] = new int[] {grayTokens, redTokens, blueTokens, greenTokens, purpleTokens, blackTokens};
  
        List result = new List ();
        
        if (value % 100 > 0) {
            blackTokens += value/100;
            value -= blackTokens * 100;
        }

        if (value % 50 > 0) {
            greenTokens += value/50;
            value -= greenTokens * 50;
        }

        if (value % 20 > 0) {
            redTokens += value/20;
            value -= redTokens * 20;
        }

        if (value % 10 > 0) {
            blueTokens += value/10;
            value -= blueTokens * 10;
        }

        if (value % 5 > 0) {
            purpleTokens += value/5;
            value -= purpleTokens * 5;
        }

        if (value > 0) {
            grayTokens += value;
            value -= grayTokens;
        }

        for (i = 0; i < tokenQuantities.length; i++) {
        	result.insertL(new Tokens(tokensNames[i], tokenQuantities[i]));
        }
   
        return result;

    }
	
	public static int[] getTokensValues() {
		return tokensValues;
	}
	
	public static String[] getTokensNames() {
		return tokensNames;
	}
}