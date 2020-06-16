package proyectofinalquizz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodos.metodos;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class Actualizador extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField respuesta1;
	private JTextField respuesta2;
	private JTextField respuesta3;
	private JTextField respuesta4;
	private JTextField correcta;
	private JTextField condicion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Actualizador dialog = new Actualizador();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Actualizador() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Respuesta1");
		lblNewLabel.setBounds(34, 36, 90, 14);
		contentPanel.add(lblNewLabel);
		
		respuesta1 = new JTextField();
		respuesta1.setBounds(153, 33, 233, 20);
		contentPanel.add(respuesta1);
		respuesta1.setColumns(10);
		
		respuesta2 = new JTextField();
		respuesta2.setColumns(10);
		respuesta2.setBounds(153, 66, 233, 20);
		contentPanel.add(respuesta2);
		
		respuesta3 = new JTextField();
		respuesta3.setColumns(10);
		respuesta3.setBounds(153, 97, 233, 20);
		contentPanel.add(respuesta3);
		
		respuesta4 = new JTextField();
		respuesta4.setColumns(10);
		respuesta4.setBounds(153, 128, 233, 20);
		contentPanel.add(respuesta4);
		
		correcta = new JTextField();
		correcta.setColumns(10);
		correcta.setBounds(153, 159, 233, 20);
		contentPanel.add(correcta);
		
		JLabel lblRespuesta = new JLabel("Respuesta2");
		lblRespuesta.setBounds(34, 69, 90, 14);
		contentPanel.add(lblRespuesta);
		
		JLabel lblRespuesta_1 = new JLabel("Respuesta3");
		lblRespuesta_1.setBounds(34, 98, 90, 14);
		contentPanel.add(lblRespuesta_1);
		
		JLabel lblRespuesta_2 = new JLabel("Respuesta4");
		lblRespuesta_2.setBounds(34, 131, 90, 14);
		contentPanel.add(lblRespuesta_2);
		
		JLabel lblCorrecta = new JLabel("Correcta");
		lblCorrecta.setBounds(34, 162, 90, 14);
		contentPanel.add(lblCorrecta);
		
		JLabel lblNewLabel_1 = new JLabel("Condicion");
		lblNewLabel_1.setBounds(34, 189, 72, 14);
		contentPanel.add(lblNewLabel_1);
		
		condicion = new JTextField();
		condicion.setBounds(153, 190, 233, 20);
		contentPanel.add(condicion);
		condicion.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						metodos m = new metodos();
						m.actualiza(respuesta1.getText(), respuesta2.getText(), respuesta3.getText(), respuesta4.getText(), correcta.getText(), condicion.getText());
						dispose();
						
					}
				});
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
