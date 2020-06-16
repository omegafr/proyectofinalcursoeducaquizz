package proyectofinalquizz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metodos.metodos;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class eliminarpreguntas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField enunciado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			eliminarpreguntas dialog = new eliminarpreguntas();
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
	public eliminarpreguntas() {
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
		this.setTitle("Descartar Preguntas");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		{
			enunciado = new JTextField();
			enunciado.setBounds(62, 140, 312, 20);
			contentPanel.add(enunciado);
			enunciado.setColumns(10);
			
			enunciado.addKeyListener(new KeyAdapter() {
		         public void keyTyped(KeyEvent e) {
		           char c = e.getKeyChar();
		           if (!(Character.isDigit(c) ||
		              (c == KeyEvent.VK_BACK_SPACE) ||
		              (c == KeyEvent.VK_DELETE))) {
		                e.consume();
		              }
		         }
		       });
		}
		{
			JLabel lblNewLabel = new JLabel("Introduce Id de la pregunta a eliminar");
			lblNewLabel.setBounds(62, 64, 312, 14);
			contentPanel.add(lblNewLabel);
		}
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
						
						m.eliminarpregunta(Integer.parseInt(enunciado.getText()));
						
							
						
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
