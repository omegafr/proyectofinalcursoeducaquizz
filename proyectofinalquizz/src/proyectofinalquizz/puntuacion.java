package proyectofinalquizz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodos.SO;
import metodos.metodos;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class puntuacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombre;
	private JTextField apellido;
	SO s = new SO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			puntuacion dialog = new puntuacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public puntuacion() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre");
			lblNewLabel.setBounds(23, 74, 81, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			nombre = new JTextField();
			nombre.setBounds(128, 71, 122, 20);
			contentPanel.add(nombre);
			nombre.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Apellido");
			lblNewLabel_1.setBounds(23, 157, 81, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			apellido = new JTextField();
			apellido.setBounds(128, 154, 122, 20);
			contentPanel.add(apellido);
			apellido.setColumns(10);
		}
		{
			JLabel foto = new JLabel("");
			foto.setBounds(274, 53, 150, 137);
			contentPanel.add(foto);
			if(s.isWindows()) {
				foto.setIcon(new ImageIcon(".\\imagenes\\perfil.jfif"));
			}else {
				foto.setIcon(new ImageIcon(s.dir+"./imagenes/perfil.jfif"));
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nombre.setText(null);
						apellido.setText(null);
						metodos m = new metodos();
						m.insertapuntuaciones(nombre.getText(), apellido.getText(), pregunta1.puntuacion);
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
