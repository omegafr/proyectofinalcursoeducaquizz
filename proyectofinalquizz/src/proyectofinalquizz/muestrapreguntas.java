package proyectofinalquizz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;

public class muestrapreguntas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static String [] columnas = {"preguntas", "respuesta1", "respuesta2", "respuesta3","respuesta4","categoria","correcta","id",}; 
	static Object[][] datos = {
            {"vacío","vacío","vacío","vacío","vacío","vacío","vacío","vacío"}
     };
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					muestrapreguntas frame = new muestrapreguntas();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public muestrapreguntas() {
		dispose();
		setBounds(100, 100, 907, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("Listado de las preguntas");
		
	      JScrollPane scrollPane = new JScrollPane();
	      scrollPane.setBounds(0, 40, 871, 281);
	      contentPane.add(scrollPane);
	      
	      table = new JTable();
	      scrollPane.setViewportView(table);
	      table.setModel(new DefaultTableModel(
	      	new Object[][] {
	      		{"Pregunta", "respuesta1", "respuesta2", "respuesta3", "respuesta4", "categoria", "correcta", "id"}
	      	},
	      	new String[] {
	      		"Pregunta", "respuesta1", "respuesta2", "respuesta3", "respuesta4", "categoria", "correcta", "id"
	      	}
	      ));
	      TableColumnModel columna = table.getColumnModel();
	      columna.getColumn(0).setPreferredWidth(1500);
			columna.getColumn(1).setPreferredWidth(500);
			columna.getColumn(2).setPreferredWidth(550);
			columna.getColumn(3).setPreferredWidth(600);
			columna.getColumn(4).setPreferredWidth(600);
			columna.getColumn(5).setPreferredWidth(500);
			columna.getColumn(6).setPreferredWidth(500);
			columna.getColumn(7).setPreferredWidth(500);
		      
	      
	      
	         
	      table.setRowHeight(25);
		
		JButton cerrar = new JButton("Cerrar");
		cerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cerrar.setBounds(722, 373, 89, 23);
		contentPane.add(cerrar);
	}
	
	public DefaultTableModel getmodel(){
        return (DefaultTableModel)  table.getModel();
        
    }
}
