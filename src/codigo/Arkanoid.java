//Autor: David Cabrero Jiménez
package codigo;
 
import java.awt.Color;
import java.awt.event.MouseEvent;
 
import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;
 
public class Arkanoid extends GraphicsProgram{
 
	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	static final int ANCHO_PANTALLA = 520;
 
	Bola bola1 = new Bola(10,10, Color.BLUE);
	//declaro el cursor del juego
	Cursor miCursor= new Cursor(400, 60, 12,"imagenes/cursor.png");
	//imágenes
	GImage youWin = new GImage("imagenes/win.png");
	GImage intro = new GImage("imagenes/intropic.png");
	GImage fondo = new GImage("imagenes/arkanoidback.png");
	GImage fondoMarcador = new GImage("imagenes/menu.jpg",300, 600);
	GImage gameOver = new GImage("imagenes/over.jpg");
	Marcador miMarcador = new Marcador(20, 40);
 
	public void init(){
		//intro
		intro.setSize(ANCHO_PANTALLA + 240, 500);
		add(intro);
		waitForClick(); //click para empezar
		remove(intro);
		add(fondoMarcador, ANCHO_PANTALLA - 30,0);
		add(fondo);
		addMouseListeners();
		add(bola1, 50, 100);
		add(miCursor);
		setSize(ANCHO_PANTALLA + 300,500);
	}
 
	public void run(){
		creaPiramide();
		miMarcador.addMarcador(this);//marcador.
 
		while (true){
			bola1.muevete(this); //paso el objeto arkanoid que se está ejecutando.
			pause(2);
			//miCursor.muevete(ANCHO_PANTALLA - 30, (int) bola1.getX()); //Añadir para juego automático.
 
			if (bola1.getY() > miCursor.getY()){ //Si la pelota cae al suelo, pierdes
				add(gameOver);
				waitForClick(); //Click para volver a empezar
				removeAll();
				init();
				run();
			}
			if(miMarcador.puntuacion == 91){ //Has roto todo los ladrillos, Has ganado!
				add(youWin);
				waitForClick(); //Click para volver a empezar
				removeAll(); //Eliminar todo
				miMarcador.puntuacion = 0; //Restart puntuación
				init(); //Volver a empezar
				run();
			}
	}
	}
 
	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(ANCHO_PANTALLA - 30, evento.getX());
	}
 
	private void creaPiramide(){ //pirámide de ladrillos
		int numeroLadrillos = 13;
		int desplazamiento_inicial_X = 20;
		int desplazamiento_inicial_Y = 15;
 
		for (int j=0; j<numeroLadrillos; j++){
			for (int i=j; i<numeroLadrillos; i++){
				Ladrillo miLadrillo = new Ladrillo("imagenes/ladrillo.png"); //Ladrillo
				add(miLadrillo, ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X, //pos X
						ALTO_LADRILLO*j + desplazamiento_inicial_Y);
			}
		}
	}
}
