package codigo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.IOException;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;

public class Marcador extends GRect{
	
	GImage logo = new GImage("imagenes/logo.png");
	GLabel texto2 = new GLabel("");
	GLabel texto = new GLabel("");
	int puntuacion = 0;
	GLabel titulo = new GLabel("");

	public Marcador(double width, double height) {
		super(width, height); //puntuación
		setFilled(true);
		setFillColor(Color.BLACK);
		texto2.setLabel("Puntos: ");
		texto.setLabel("0");
		texto2.setColor(Color.WHITE);
		texto.setColor(Color.WHITE);
		texto2.setFont(new Font("Arial", Font.BOLD, 18));
		texto.setFont(new Font("Arial", Font.BOLD, 18));
	}
	
	public void incrementaMarcador(int puntos){
		//suma el nº de puntos que se indica en la variable de puntos
		//a la puntuación actual
		puntuacion = puntuacion + puntos; //puntuación += puntos;
		texto.setLabel("" + puntuacion);
	}
	
	public void addMarcador(Arkanoid arkanoid){
		arkanoid.add(this, arkanoid.getWidth() - 100, 20);
		arkanoid.add(texto, arkanoid.getWidth() - 100, 120); //puntos
		arkanoid.add(logo, arkanoid.getWidth() - 250, 10); //Logo Arkanoid en el menú
		arkanoid.add(texto2, arkanoid.getWidth() - 180, 120);
	}

}
