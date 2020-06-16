package metodos;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import javazoom.jlgui.basicplayer.BasicPlayer;
// clase que contiene los metodos de la musica
public class reproductor2 extends JFrame{
	public BasicPlayer player;
	
	public reproductor2(){
		player = new BasicPlayer();
	}
	// metodo que activa la musica
	public void Play() throws Exception {
		  player.play();
		}
		//metodo que abre el archivo que se le pasa
		public void AbrirFichero(String ruta) throws Exception {
			player.open(new File(ruta));
		}
		// metodo que pausa la musica
		public void Pausa() throws Exception {
		  player.pause();
		}
		// metodo que reanuda la musica
		public void Continuar() throws Exception {
		  player.resume();
		}
		// metodo que para definitivamente la musica hasta que se vuelva a reactivar
		public void Stop() throws Exception {
		  player.stop();
		}
		
		

}
