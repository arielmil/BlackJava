// Ariel Mileguir
// Pedro Gabriel 

package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class ImageLoader {
	//colocar no source path
	static String base_path = "graphics/Images/";
	
	static Image load(String name) {
		String img_path = base_path + name;
		Image img = null;
		
		try {
			img = ImageIO.read(new File(img_path));
		}
		
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		return img;
	}
}
