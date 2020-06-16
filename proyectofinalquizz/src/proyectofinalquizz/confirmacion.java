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

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class confirmacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	administrador a = new administrador();
	String contraseña = "profesor";
	metodos m = new metodos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			confirmacion dialog = new confirmacion();
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
	public confirmacion() {
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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		this.setTitle("Autorizacion");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(119, 197, 193, 20);
		contentPanel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("Introduzca la contrase\u00F1a del administrador");
		lblNewLabel.setBounds(106, 159, 233, 14);
		contentPanel.add(lblNewLabel);
		{
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBounds(106, 11, 220, 137);
			SO S = new SO();
			
			if(SO.isWindows()) {
			lblNewLabel_2.setIcon(new ImageIcon(".\\imagenes\\candado.png"));
			}else {
			lblNewLabel_2.setIcon(new ImageIcon(S.dir+"/imagenes/candado.png"));
				
			}
			
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(passwordField.getText().equals(contraseña)) {
							JOptionPane.showMessageDialog(null, "Contraseña correcta");
							a.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Contraseña Incorrecta por lo que no puedes acceder al modo administrador");
						}
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
