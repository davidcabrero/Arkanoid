//Autor: David Cabrero Jiménez
package codigo;

import acm.graphics.GImage;

public class Cursor extends GImage {

	GImage cursor; //imagen del cursor
	public Cursor(int posY,double width,double height,String cursor){
		super(cursor);
		setSize(width,height);
		setLocation(0,posY);
	}
	
	public void muevete(int anchoPantalla, int posX){
		if(posX+getWidth() < anchoPantalla){
			setLocation(posX, getY());
		}
	}

}
