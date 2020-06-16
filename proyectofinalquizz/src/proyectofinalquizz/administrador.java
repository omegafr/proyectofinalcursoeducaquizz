package proyectofinalquizz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import metodos.SO;
import metodos.metodos;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class administrador extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			administrador dialog = new administrador();
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
	public administrador() {
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
		this.setTitle("Ventana del administrador");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("A\u00F1adir pregunta");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					añadirpreguntas ap = new añadirpreguntas();
					ap.setVisible(true);
				}
			});
			btnNewButton.setBounds(21, 160, 166, 23);
			contentPanel.add(btnNewButton);
		}
		{
			JButton btnNewButton_1 = new JButton("Eliminar pregunta");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					eliminarpreguntas ep = new eliminarpreguntas();
					ep.setVisible(true);
				}
			});
			btnNewButton_1.setBounds(21, 194, 166, 23);
			contentPanel.add(btnNewButton_1);
		}
		
		JButton mostrar = new JButton("Mostrar preguntas");
		mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				muestrapreguntas mp = new muestrapreguntas();
				metodos m = new metodos();
				m.conexion();
				String sentenciaSql2 = "SELECT  *  from preguntas";
				PreparedStatement sentencia = null;
				ResultSet resultado = null;
				
				
				 try {
					 sentencia = m.conexion.prepareStatement(sentenciaSql2);
					  
					  resultado = sentencia.executeQuery();
					while (resultado.next())
					 {
					    // Se crea un array que será una de las filas de la tabla.
					    Object [] fila = new Object[8]; // Hay tres columnas en la tabla

					    // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
					   
					       fila[0] = resultado.getString(1);
					       fila[1] = resultado.getString(2); 
					       fila[2] = resultado.getString(3); 
					       fila[3] = resultado.getString(4); 
					       fila[4] = resultado.getString(5); 
					       fila[5] = resultado.getString(6); 
					       fila[6] = resultado.getString(7); 
					       fila[7] = resultado.getString(8); 
					       // El primer indice en rs es el 1, no el cero, por eso se suma 1.

					    // Se añade al modelo la fila completa.
					    mp.getmodel().addRow(fila);  
					
}
					
					mp.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		mostrar.setBounds(21, 126, 166, 23);
		contentPanel.add(mostrar);
		SO S = new SO();
		JLabel lblNewLabel = new JLabel("");
		if(SO.isWindows()) {
		lblNewLabel.setIcon(new ImageIcon(".\\imagenes\\llave.jfif"));
		}else {
			lblNewLabel.setIcon(new ImageIcon(S.dir+"/imagenes/llave.jfif"));
			
		}
		
		lblNewLabel.setBounds(197, 57, 227, 160);
		contentPanel.add(lblNewLabel);
		
		JButton CSV = new JButton("Cargar preguntas");
		CSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ruta = "";
				try {
					JFileChooser fc=new JFileChooser();
					 
					//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
					int seleccion=fc.showOpenDialog(getContentPane());
					 
					//Si el usuario, pincha en aceptar
					if(seleccion==JFileChooser.APPROVE_OPTION){
					 
					    //Seleccionamos el fichero
						 ruta = fc.getSelectedFile().getAbsolutePath();
						 metodos.importar(ruta);
					}
					
				} catch (SQLException | IOException ex ) {
					// TODO Auto-generated catch block
					 Logger.getLogger(administrador.class.getName()).log(Level.SEVERE, null, ex);

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		CSV.setBounds(21, 92, 166, 23);
		contentPanel.add(CSV);
		
		JButton actualizador = new JButton("Actualizar preguntas");
		actualizador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actualizador a = new Actualizador();
				a.setVisible(true);
			}
		});
		actualizador.setBounds(21, 58, 166, 23);
		contentPanel.add(actualizador);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
