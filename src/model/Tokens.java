/***********************************************************************/

package model;

import java.util.HashMap;
import java.util.Map;

/***********************************************************************/

public class Tokens {
	private int value;
	private int quantity;
	private String color;
	private int total;
	
	private static Map <String, Integer> color_to_value = new HashMap <String, Integer>(6);
	/*private img*/
	
	
	static {
        int token_values[] = new int[] {1, 5, 10, 20, 50, 100};
		String token_names[] = new String[] {"Gray", "Red", "Blue", "Green", "Purple", "Black"};
		
		int i;
		for (i = 0; i < token_values.length; i++) {
			color_to_value.put(token_names[i], token_values[i]);
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
		
		this.quantity = this.quantity - quantity;
		setTotal();
		
		return returned;
	}
	
	/*ver se tem necessidade de retornar um objeto tokens nos metodos de subtract*/
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
        
        String token_names[] = new String[] {"Gray", "Red", "Blue", "Green", "Purple", "Black"};
        int token_quantities[] = new int[] {grayTokens, redTokens, blueTokens, greenTokens, purpleTokens, blackTokens};
  
        List result = new List ();
        
        if (value % 100 > 0) {
            blackTokens += value/100;
            value -= blackTokens * 100;
        }

        else if (value % 50 > 0) {
            purpleTokens += value/50;
            value -= purpleTokens * 50;
        }

        else if (value % 25 > 0) {
            greenTokens += value/25;
            value -= greenTokens * 25;
        }

        else if (value % 10 > 0) {
            blueTokens += value/10;
            value -= blueTokens * 10;
        }

        else if (value % 5 > 0) {
            redTokens += value/5;
            value -= redTokens * 5;
        }

        else if (value > 0) {
            grayTokens += value;
            value -= grayTokens;
        }

        for (i = 0; i < token_quantities.length; i++) {
        	result.insertL(new Tokens(token_names[i], token_quantities[i]));
        }
   
        return result;

    }
	
	/*void render() {
	
	
	}*/
}