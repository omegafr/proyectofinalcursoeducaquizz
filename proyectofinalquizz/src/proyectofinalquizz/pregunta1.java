package proyectofinalquizz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodos.SO;
import metodos.imagenes;
import metodos.metodos;

import metodos.reproductor2;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.Timer;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class pregunta1 extends JDialog {
	metodos m = new metodos();
	private final JPanel contentPanel = new JPanel();
	String pregunta = null;
	puntuacion pu = new puntuacion();
	public static int puntuacion = 0;
	static String respuesta = null;
	static String respuesta2 = null;
	static String respuesta3 = null;
	static String respuesta4 = null;
	static String categorias = null;
	imagenes im = new imagenes();
	SO s = new SO();
	File fichero = new File("/sonido/correcto.wav");
	static JTextField textField;
	static JButton boton1;
	static JButton boton2;
	static JButton boton3;
	static JButton boton4;
	public static JLabel categoria;
	static JLabel progreso;
	Random rnd = new Random();
	reproductor2 r2 = new reproductor2();
	int preguntas = 15;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			pregunta1 dialog = new pregunta1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocationRelativeTo(null);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public pregunta1() {
		//Metodo para cerrar la ventana
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {

				try {
					dispose();
					Interfaz.r2.Stop();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setBounds(100, 100, 651, 382);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		ArrayList<Color> colors = new ArrayList<>();

		colors.add(Color.RED);
		colors.add(Color.BLUE);
		colors.add(Color.GREEN);
		colors.add(Color.YELLOW);
		colors.add(Color.BLACK);
		colors.add(Color.ORANGE);

		this.setTitle("Preguntas");

		boton1 = new JButton("New button");

		boton1.setBounds(10, 252, 128, 52);
		contentPanel.add(boton1);

		boton2 = new JButton("New button");
		boton2.setBounds(159, 252, 128, 52);
		contentPanel.add(boton2);

		boton3 = new JButton("New button");
		boton3.setBounds(314, 252, 145, 52);
		contentPanel.add(boton3);

		boton4 = new JButton("New button");
		boton4.setBounds(480, 252, 145, 52);
		contentPanel.add(boton4);

		textField = new JTextField();
		textField.setBounds(10, 149, 568, 46);
		contentPanel.add(textField);
		textField.setColumns(10);
		m.conexion();

		textField.setEditable(false);

		categoria = new JLabel("");
		categoria.setBounds(152, 11, 426, 127);
		contentPanel.add(categoria);

		progreso = new JLabel("New label");
		progreso.setFont(new Font("Tahoma", Font.BOLD, 20));
		progreso.setBounds(10, 11, 120, 23);
		contentPanel.add(progreso);
		// this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		boton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.conexion();

				if (preguntas > 0) {
					if (metodos.sacarespuesta1(respuesta).contains(m.correcta(respuesta))) {
						if (SO.isWindows()) {
							ReproducirSonido(".\\sonido\\correcto.wav");

						} else {
							ReproducirSonido(s.dir + "/sonido/correcto.wav");
						}
						// Se carga con un fichero wav

						m.norep(textField.getText());
						Color randomColor = colors.get(rnd.nextInt(colors.size()));
						contentPanel.setBackground(randomColor);
						JOptionPane.showMessageDialog(null, "Respuesta correcta");
						// p2.setVisible(true);

						progreso.setText("Pregunta" + Interfaz.i++);

						textField.setText(metodos.sacapregunta());
						boton1.setText(metodos.sacarespuesta1(respuesta));
						boton2.setText(metodos.sacarespuesta2(respuesta2));
						boton3.setText(metodos.sacarespuesta3(respuesta3));
						boton4.setText(metodos.sacarespuesta4(respuesta4));
						im.cargarimagen();

						preguntas--;
						puntuacion = puntuacion + 2000;

					} else {
						try {
							Interfaz.r2.Stop();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (SO.isWindows()) {

							ReproducirSonido(".\\sonido\\derrota.wav");

						} else {
							ReproducirSonido(s.dir + "/sonido/derrota.wav");
						}
						JOptionPane.showMessageDialog(null,
								"Mala Suerte La respuesta Correcta era " + m.correcta(respuesta));

						pu.setVisible(true);
						dispose();
					}
				} else {
					if (SO.isWindows()) {
						ReproducirSonido(".\\sonido\\victoria.wav");

					} else {
						ReproducirSonido(s.dir + "/sonido/victoria.wav");
					}
					JOptionPane.showMessageDialog(null, "Ha ganado");
					pu.setVisible(true);
					dispose();
				}
			}
		});

		boton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.conexion();

				if (preguntas > 0) {
					if (metodos.sacarespuesta2(respuesta2).contains(m.correcta(respuesta))) {

						if (SO.isWindows()) {
							ReproducirSonido(".\\sonido\\correcto.wav");

						} else {
							ReproducirSonido(s.dir + "/sonido/correcto.wav");
						}
						m.norep(textField.getText());
						Color randomColor = colors.get(rnd.nextInt(colors.size()));
						contentPanel.setBackground(randomColor);
						JOptionPane.showMessageDialog(null, "Respuesta correcta");
						// p2.setVisible(true);

						progreso.setText("Pregunta" + Interfaz.i++);

						textField.setText(metodos.sacapregunta());
						boton1.setText(metodos.sacarespuesta1(respuesta));
						boton2.setText(metodos.sacarespuesta2(respuesta2));
						boton3.setText(metodos.sacarespuesta3(respuesta3));
						boton4.setText(metodos.sacarespuesta4(respuesta4));
						im.cargarimagen();
						preguntas--;
						puntuacion = puntuacion + 2000;

					} else {
						try {
							Interfaz.r2.Stop();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (SO.isWindows()) {
							ReproducirSonido(".\\sonido\\derrota.wav");

						} else {
							ReproducirSonido(s.dir + "/sonido/derrota.wav");
						}
						JOptionPane.showMessageDialog(null,
								"Mala Suerte La respuesta Correcta era " + m.correcta(respuesta));

						pu.setVisible(true);
						dispose();
					}
				} else {
					if (SO.isWindows()) {
						ReproducirSonido(".\\sonido\\victoria.wav");

					} else {
						ReproducirSonido(s.dir + "/sonido/victoria.wav");
					}
					JOptionPane.showMessageDialog(null, "Ha ganado");
					pu.setVisible(true);
					dispose();
				}
			}
		});

		boton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.conexion();

				if (preguntas > 0) {
					if (metodos.sacarespuesta3(respuesta3).contains(m.correcta(respuesta))) {

						if (SO.isWindows()) {
							ReproducirSonido(".\\sonido\\correcto.wav");

						} else {
							ReproducirSonido(s.dir + "/sonido/correcto.wav");
						}
						m.norep(textField.getText());
						Color randomColor = colors.get(rnd.nextInt(colors.size()));
						contentPanel.setBackground(randomColor);
						JOptionPane.showMessageDialog(null, "Respuesta correcta");

						progreso.setText("Pregunta" + Interfaz.i++);
						textField.setText(metodos.sacapregunta());
						boton1.setText(metodos.sacarespuesta1(respuesta));
						boton2.setText(metodos.sacarespuesta2(respuesta2));
						boton3.setText(metodos.sacarespuesta3(respuesta3));
						boton4.setText(metodos.sacarespuesta4(respuesta4));
						im.cargarimagen();
						preguntas--;
						puntuacion = puntuacion + 2000;

					} else {
						try {
							Interfaz.r2.Stop();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (SO.isWindows()) {
							ReproducirSonido(".\\sonido\\derrota.wav");

						} else {
							ReproducirSonido(s.dir + "/sonido/derrota.wav");
						}
						JOptionPane.showMessageDialog(null,
								"Mala Suerte La respuesta Correcta era " + m.correcta(respuesta));

						pu.setVisible(true);
						dispose();
					}
				} else {
					if (SO.isWindows()) {
						ReproducirSonido(".\\sonido\\victoria.wav");

					} else {
						ReproducirSonido(s.dir + "/sonido/victoria.wav");
					}
					JOptionPane.showMessageDialog(null, "Ha ganado");
					pu.setVisible(true);
					dispose();
				}
			}
		});

		boton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.conexion();

				if (preguntas > 0) {
					if (metodos.sacarespuesta4(respuesta4).contains(m.correcta(respuesta))) {

						if (SO.isWindows()) {
							ReproducirSonido(".\\sonido\\correcto.wav");

						} else {
							ReproducirSonido(s.dir + "/sonido/correcto.wav");
						}

						m.norep(textField.getText());
						Color randomColor = colors.get(rnd.nextInt(colors.size()));
						contentPanel.setBackground(randomColor);
						JOptionPane.showMessageDialog(null, "Respuesta correcta");

						progreso.setText("Pregunta" + Interfaz.i++);
						textField.setText(metodos.sacapregunta());
						boton1.setText(metodos.sacarespuesta1(respuesta));
						boton2.setText(metodos.sacarespuesta2(respuesta2));
						boton3.setText(metodos.sacarespuesta3(respuesta3));
						boton4.setText(metodos.sacarespuesta4(respuesta4));
						im.cargarimagen();
						preguntas--;
						puntuacion = puntuacion + 2000;

					} else {
						try {
							Interfaz.r2.Stop();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (SO.isWindows()) {
							ReproducirSonido(".\\sonido\\derrota.wav");

						} else {
							ReproducirSonido(s.dir + "/sonido/derrota.wav");
						}
						JOptionPane.showMessageDialog(null,
								"Mala Suerte La respuesta Correcta era " + m.correcta(respuesta));

						pu.setVisible(true);

						dispose();
					}
				} else {
					if (SO.isWindows()) {
						ReproducirSonido(".\\sonido\\victoria.wav");

					} else {
						ReproducirSonido(s.dir + "/sonido/victoria.wav");
					}
					JOptionPane.showMessageDialog(null, "Ha ganado");
					pu.setVisible(true);
					dispose();
				}
			}
		});

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
	}

	public void ReproducirSonido(String nombreSonido) {// metodo para reroducir sonido
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			System.out.println("Error al reproducir el sonido.");
		}
	}
}
	

