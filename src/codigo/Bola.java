package codigo;

import java.awt.Color;

import acm.graphics.GObject;
import acm.graphics.GOval;

public class Bola extends GOval{
	int dx = 1; //velocidad en el eje x
	int dy = 1; //velocidad en el eje y

	public Bola(double width, double height) {
		super(width, height);
	}
	
	public Bola(double width, double height, Color c) {
		super(width, height);
		setFillColor(c);
		setFilled(true);
	}
	
	public void muevete(Arkanoid ark){
		//rebote con el techo
		if (getY() < 10){
			dy = dy * -1;
		}
		//Si la pelota da contra el suelo
		if (getY() > ark.getHeight()){
			//TODO 
		}
		
		//rebote con la pared dcha e izqda
		if (getX()+getWidth() > ark.ANCHO_PANTALLA - 30 || getX() < 10){
			dx = dx * -1;
		}
		
		//chequeo la esquina superior izquierda de la bola
		if (chequeaColision(getX(), getY(), ark)){
			if (chequeaColision(getX() + getWidth(), getY(), ark)){
				if (chequeaColision(getX(), getY()+getHeight(), ark)){
					if (chequeaColision(getX()+getWidth(), getY()+getHeight(), ark)){
						
					}
				}
			}
			
		}
		
		//mueve la bola en la dirección correcta
		move(dx,dy);
	}
	
	private boolean chequeaColision(double posx, double posy, Arkanoid ark){
		boolean noHaChocado = true;
		GObject auxiliar;
		
		auxiliar = ark.getElementAt(posx, posy);
		
		if (auxiliar == ark.miCursor){ //Si entra aquí es que choca con el cursor
			dy = dy * -1;
			noHaChocado = false;
		}else if (auxiliar == null){//si vale null es que no había nada ahí
			
		}else if (auxiliar instanceof Ladrillo){ //si es un ladrillo
			if (auxiliar.getX() + getWidth() >= posx || auxiliar.getX() <= posx){
				dx = dx * -1;
			}
			if (auxiliar.getY() + getHeight() >= posy || auxiliar.getY() <= posy){
				dy = dy * -1;
			}
			

			//si la y de la pelota es menor que la y del cursor
			ark.miMarcador.incrementaMarcador(1);
			ark.remove(auxiliar); //Borro el ladrillo
			
			noHaChocado = false;
		}
		
		return noHaChocado;
	}

	private void println(String string) {
		// TODO Auto-generated method stub
		
	}
}
