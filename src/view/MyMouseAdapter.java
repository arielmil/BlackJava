package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseAdapter extends MouseAdapter {
	MyMouseListener source;
	
	public MyMouseAdapter(MyMouseListener source) {
		super();
		this.source = source;
	}
	
	public void mouseClicked(MouseEvent e) {
		source.setClickedPoint(e.getPoint());
	}
}
