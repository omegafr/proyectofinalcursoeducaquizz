package proyectofinalquizz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import metodos.SO;
import metodos.imagenes;
import metodos.metodos;
//import metodos.reproductor2;

import metodos.reproductor2;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Interfaz extends JFrame {

	private JPanel contentPane;
	
	String respuesta = null;
	pregunta1 p = new pregunta1();
	administrador a = new administrador();
	String contraseña = "profesor";
	metodos m = new metodos();
	SO s = new SO();
	imagenes im = new imagenes();
	File fichero = new File("/sonido/correcto.wav");
	static reproductor2 r2= new reproductor2();
	
	static int i = 1;
	
	
  

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws HelpSetException 
	 * @throws MalformedURLException 
	 */
	public Interfaz() throws HelpSetException, MalformedURLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 395);
		this.setTitle(" Ventana Principal ");
		JMenuBar menuBar = new JMenuBar(); 
		setJMenuBar(menuBar);
		
		JMenu mnAyuda = new JMenu("Menu");
		menuBar.add(mnAyuda);
		
		JMenuItem item3 = new JMenuItem("Modo Administrador");
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmacion c = new confirmacion();
				c.setVisible(true);
			}
		});
		mnAyuda.add(item3);
		
		JMenuItem item2 = new JMenuItem("Nuevo Juego");
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					r2.Stop();
					if(s.isWindows()) {
						r2.AbrirFichero(".\\sonido\\Música alegre de fondo para tus videos sin Copyright.mp3");
					}else {
						r2.AbrirFichero(s.dir+"/sonido/Música alegre de fondo para tus videos sin Copyright.mp3");	
					}
					r2.Play();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}

				i = 1;
				m.copiar();
				p.setVisible(true);
				pregunta1.progreso.setText("Pregunta" + i++);
				pregunta1.textField.setText(metodos.sacapregunta());
				pregunta1.boton1.setText(metodos.sacarespuesta1(respuesta));
				pregunta1.boton2.setText(metodos.sacarespuesta2(respuesta));
				pregunta1.boton3.setText(metodos.sacarespuesta3(respuesta));
				pregunta1.boton4.setText(metodos.sacarespuesta4(respuesta));
				im.cargarimagen();
				pregunta1.puntuacion = 0;
				
			}
		
		});
		mnAyuda.add(item2);
		
		JMenu mnArchivo = new JMenu("archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem item1 = new JMenuItem("ayuda");
		mnArchivo.add(item1);
		
		JMenu mnNewMenu = new JMenu("Musica");
		menuBar.add(mnNewMenu);
		
		JMenuItem insertar = new JMenuItem("Insertar M\u00FAsica");
		insertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					r2.Stop();
					String ruta = "";
					JFileChooser fc=new JFileChooser();
					 
					//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
					int seleccion=fc.showOpenDialog(getContentPane());
					 
					//Si el usuario, pincha en aceptar
					if(seleccion==JFileChooser.APPROVE_OPTION){
					 
					    //Seleccionamos el fichero
						 ruta = fc.getSelectedFile().getAbsolutePath();
						
					}
					
					 r2.AbrirFichero(ruta);
					 r2.Play();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnNewMenu.add(insertar);
		
		JMenuItem pausar = new JMenuItem("Pausar M\u00FAsica");
		pausar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					r2.Pausa();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(pausar);
		
		JMenuItem reanudar = new JMenuItem("Reanudar ");
		reanudar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					r2.Continuar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(reanudar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton empezar = new JButton("Nuevo Juego");
		empezar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(s.isWindows()) {
						r2.AbrirFichero(".\\sonido\\Música alegre de fondo para tus videos sin Copyright.mp3");
					}else {
						r2.AbrirFichero(s.dir+"/sonido/Música alegre de fondo para tus videos sin Copyright.mp3");	
					}
					r2.Play();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				i = 1;
				m.copiar();
				p.setVisible(true);
				pregunta1.progreso.setText("Pregunta" + i++);
				pregunta1.textField.setText(metodos.sacapregunta());
				pregunta1.boton1.setText(metodos.sacarespuesta1(respuesta));
				pregunta1.boton2.setText(metodos.sacarespuesta2(respuesta));
				pregunta1.boton3.setText(metodos.sacarespuesta3(respuesta));
				pregunta1.boton4.setText(metodos.sacarespuesta4(respuesta));
				im.cargarimagen();
			}
			
		});
		empezar.setBounds(137, 213, 173, 23);
		contentPane.add(empezar);
		
		JButton btnNewButton = new JButton("Ayuda");
		btnNewButton.setBounds(137, 247, 173, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		if(s.isWindows()) {
			lblNewLabel_1.setIcon(new ImageIcon(".\\imagenes\\indice.jfif"));
		}else {
			lblNewLabel_1.setIcon(new ImageIcon(s.dir+"./imagenes/indice.jfif"));
		}
		
		lblNewLabel_1.setBounds(87, 11, 309, 173);
		contentPane.add(lblNewLabel_1);
	
		
		JButton administrador = new JButton("modo administrador");
		administrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmacion c = new confirmacion();
				c.setVisible(true);
				}
		});
		administrador.setBounds(137, 281, 173, 23);
		contentPane.add(administrador);
		File fichero = new File(".\\help\\help_set.hs");
		URL hsURL = fichero.toURI().toURL();

		HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
		HelpBroker hb = helpset.createHelpBroker();

		// Pone ayuda a item de menu al pulsarlo y a F1 en ventana
		// principal y secundaria.
		hb.enableHelpOnButton(btnNewButton, "aplicacion", helpset);
		hb.enableHelpOnButton(item1, "aplicacion", helpset);
		hb.enableHelpKey(getRootPane(), "Modo Usuario", helpset);
		hb.enableHelpKey(administrador , "Modo Administrador", helpset);

	}
}
