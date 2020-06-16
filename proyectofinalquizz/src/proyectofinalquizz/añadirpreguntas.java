package proyectofinalquizz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodos.metodos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class añadirpreguntas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField respuesta1;
	private JTextField respuesta2;
	private JTextField respuesta3;
	private JTextField respuesta4;
	private JTextField categoria;
	private JTextField correcta;
	private JTextField pregunta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			añadirpreguntas dialog = new añadirpreguntas();
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
	public añadirpreguntas() {
		addWindowListener(new WindowAdapter() {
			   public void windowClosing(WindowEvent e) {
			   
			     try {
			    	 dispose();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			   }
			 });
		setBounds(100, 100, 493, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel Pregunta = new JLabel("Pregunta");
		Pregunta.setBounds(24, 8, 70, 14);
		contentPanel.add(Pregunta);
		
		respuesta1 = new JTextField();
		respuesta1.setBounds(193, 40, 259, 20);
		contentPanel.add(respuesta1);
		respuesta1.setColumns(10);
		
		respuesta2 = new JTextField();
		respuesta2.setColumns(10);
		respuesta2.setBounds(193, 81, 259, 20);
		contentPanel.add(respuesta2);
		
		respuesta3 = new JTextField();
		respuesta3.setColumns(10);
		respuesta3.setBounds(193, 124, 259, 20);
		contentPanel.add(respuesta3);
		
		respuesta4 = new JTextField();
		respuesta4.setColumns(10);
		respuesta4.setBounds(193, 166, 259, 20);
		contentPanel.add(respuesta4);
		
		categoria = new JTextField();
		categoria.setColumns(10);
		categoria.setBounds(193, 208, 259, 20);
		contentPanel.add(categoria);
		
		correcta = new JTextField();
		correcta.setBounds(193, 245, 259, 20);
		contentPanel.add(correcta);
		correcta.setColumns(10);
		
		pregunta = new JTextField();
		pregunta.setColumns(10);
		pregunta.setBounds(193, 8, 259, 20);
		contentPanel.add(pregunta);
		
		JLabel lblNewLabel = new JLabel("Respuesta1");
		lblNewLabel.setBounds(24, 43, 70, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblRespuesta = new JLabel("Respuesta2");
		lblRespuesta.setBounds(24, 87, 70, 14);
		contentPanel.add(lblRespuesta);
		
		JLabel lblRespuesta_1 = new JLabel("Respuesta3");
		lblRespuesta_1.setBounds(24, 130, 70, 14);
		contentPanel.add(lblRespuesta_1);
		
		JLabel lblNewLabel_3 = new JLabel("Respuesta4");
		lblNewLabel_3.setBounds(24, 172, 70, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(24, 214, 70, 14);
		contentPanel.add(lblCategoria);
		
		JLabel lblCorrecta = new JLabel("Correcta");
		lblCorrecta.setBounds(24, 251, 70, 14);
		contentPanel.add(lblCorrecta);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						metodos m = new metodos();
						m.conexion();
						m.insertarpreguntas(pregunta.getText(), respuesta1.getText(), respuesta2.getText(), respuesta3.getText(), respuesta4.getText(), categoria.getText(), correcta.getText());
						JOptionPane.showMessageDialog(null, " Se ha insertado con exito la pregunta");
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
