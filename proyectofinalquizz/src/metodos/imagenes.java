package metodos;

import javax.swing.ImageIcon;

import proyectofinalquizz.pregunta1;
// Clase que se encarga de coger las imagenes
public class imagenes {
	public static String categorias;
	metodos m = new metodos();
	// metodo que carga la imagen 
	public static void cargarimagen() {
		SO s = new SO();
		if (s.isWindows()) {
			if (metodos.categoria(categorias).equals("Informatica")) {
				pregunta1.categoria.setIcon(new ImageIcon(".\\imagenes\\informatica.jpg"));
			} else if (metodos.categoria(categorias).equals("ciencias")) {
				pregunta1.categoria.setIcon(new ImageIcon(".\\imagenes\\ciencias.jpg"));
			} else if (metodos.categoria(categorias).equals("matematicas")) {
				pregunta1.categoria.setIcon(new ImageIcon(".\\imagenes.\\matematicas.jpg"));
			} else if (metodos.categoria(categorias).equals("Historia")) {
				pregunta1.categoria.setIcon(new ImageIcon(".\\imagenes\\historia.jpg"));
			} else if (metodos.categoria(categorias).equals("deporte")) {
				pregunta1.categoria.setIcon(new ImageIcon(".\\imagenes\\deporte.jfif"));
			} else if (metodos.categoria(categorias).equals("ingles")) {
				pregunta1.categoria.setIcon(new ImageIcon(".\\imagenes.\\ingles.jfif"));
			} else if (metodos.categoria(categorias).equals("castellano")) {
				pregunta1.categoria.setIcon(new ImageIcon(".\\imagenes\\castellano.jfif"));
			}
		} else {
			if (metodos.categoria(categorias).equals("Informatica")) {
				pregunta1.categoria.setIcon(new ImageIcon(s.dir + "/imagenes/informatica.jpg"));
			} else if (metodos.categoria(categorias).equals("ciencias")) {
				pregunta1.categoria.setIcon(new ImageIcon(s.dir + "/imagenes/ciencias.jpg"));
			} else if (metodos.categoria(categorias).equals("matematicas")) {
				pregunta1.categoria.setIcon(new ImageIcon(s.dir + "/imagenes/matematicas.jpg"));
			} else if (metodos.categoria(categorias).equals("Historia")) {
				pregunta1.categoria.setIcon(new ImageIcon(s.dir + "imagenes/historia.jpg"));
			} else if (metodos.categoria(categorias).equals("deporte")) {
				pregunta1.categoria.setIcon(new ImageIcon(s.dir + "/imagenes/deporte.jfif"));
			} else if (metodos.categoria(categorias).equals("ingles")) {
				pregunta1.categoria.setIcon(new ImageIcon(s.dir + "/imagenes/ingles.jfif"));
			} else if (metodos.categoria(categorias).equals("castellano")) {
				pregunta1.categoria.setIcon(new ImageIcon(s.dir + "/imagenes/castellano.jfif"));

			}
	}
		}
	}

