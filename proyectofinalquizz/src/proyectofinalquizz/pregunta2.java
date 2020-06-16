package proyectofinalquizz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodos.metodos;

import javax.swing.JTextField;

public class pregunta2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField pregunta;
	static String respuesta;
	metodos m = new metodos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			pregunta2 dialog = new pregunta2();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public pregunta2() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		pregunta = new JTextField();
		pregunta.setBounds(22, 56, 390, 45);
		contentPanel.add(pregunta);
		pregunta.setColumns(10);
		m.conexion();
		pregunta.setText(m.sacapregunta());
		JButton boton1 = new JButton("New button");
		boton1.setBounds(22, 166, 89, 23);
		contentPanel.add(boton1);
		
		
		JButton boton2 = new JButton("New button");
		boton2.setBounds(121, 166, 89, 23);
		contentPanel.add(boton2);
		
		JButton boton3 = new JButton("New button");
		boton3.setBounds(229, 166, 89, 23);
		contentPanel.add(boton3);
		
		JButton boton4 = new JButton("New button");
		boton4.setBounds(335, 166, 89, 23);
		contentPanel.add(boton4);
		
		boton1.setText(m.sacarespuesta1(respuesta));
		boton2.setText(m.sacarespuesta2(respuesta));
		boton3.setText(m.sacarespuesta3(respuesta));
		boton4.setText(m.sacarespuesta4(respuesta));
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
