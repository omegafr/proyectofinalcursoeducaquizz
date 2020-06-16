package metodos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.jdi.connect.spi.Connection;

public class metodos {
	public static java.sql.Connection conexion = null;
	static String pregunta;
	static String respuesta;
	static String correcta;
	static String categoria;

	
	public static void conexion() {
		try {
			  Class.forName("org.postgresql.Driver").newInstance();
			  conexion =  DriverManager.getConnection(
			    "jdbc:postgresql://localhost:5432/quizz",
			    "postgres", "alumno");
			} catch (ClassNotFoundException cnfe) {
			  cnfe.printStackTrace();
			} catch (SQLException sqle) {
			  sqle.printStackTrace();
			} catch (InstantiationException ie) {
			  ie.printStackTrace();
			} catch (IllegalAccessException iae) {
			  iae.printStackTrace();
			}
		 
	
	}
	// metodo que saca el enunciado de la pregunta de la base de datos y además le asocia al un string dicho enunciado
	public static  String sacapregunta() {
		String sentenciaSql = "SELECT  pregunta FROM copia  ORDER BY random() LIMIT 1 ";
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		 
		try {
		  sentencia = conexion.prepareStatement(sentenciaSql);
		  resultado = sentencia.executeQuery();
		  while (resultado.next()) {
			  pregunta = resultado.getString(1);
		   
		    
		    
		    
		  }
		} catch (SQLException sqle) {
		  sqle.printStackTrace();
		} finally {
		  if (sentencia != null)
		    try {
		      sentencia.close();
		      resultado.close();
		    } catch (SQLException sqle) {
		      sqle.printStackTrace();
		    }
		}
		return pregunta;
		

		
	}
	// metodo que saca la primera opcion dependiendo del enunciado
	public static  String sacarespuesta1 (String respuesta) {
		String sentenciaSql2 = "SELECT  respuesta1 FROM copia where pregunta = ?";
		PreparedStatement sentencia = null;
		ResultSet resultado = null;
		 
		try {
			
		  sentencia = conexion.prepareStatement(sentenciaSql2);
		  sentencia.setString(1, pregunta);
		  resultado = sentencia.executeQuery();
		  while (resultado.next()) {
			 respuesta = resultado.getString(1);
		    
		    
		  }
		} catch (SQLException sqle) {
		  sqle.printStackTrace();
		} finally {
		  if (sentencia != null)
		    try {
		      sentencia.close();
		      resultado.close();
		    } catch (SQLException sqle) {
		      sqle.printStackTrace();
		    }
		}
		return respuesta;
		

		
	}
	
public static String sacarespuesta2(String respuesta2) {
	String sentenciaSql2 = "SELECT  respuesta2 FROM copia where pregunta = ?";
	PreparedStatement sentencia = null;
	ResultSet resultado = null;
	 
	try {
		
	  sentencia = conexion.prepareStatement(sentenciaSql2);
	  sentencia.setString(1, pregunta);
	  resultado = sentencia.executeQuery();
	  while (resultado.next()) {
		 respuesta2 = resultado.getString(1);
	    System.out.println(respuesta2);
	    
	  }
	} catch (SQLException sqle) {
	  sqle.printStackTrace();
	} finally {
	  if (sentencia != null)
	    try {
	      sentencia.close();
	      resultado.close();
	    } catch (SQLException sqle) {
	      sqle.printStackTrace();
	    }
	}
	return respuesta2;
	}

public static String sacarespuesta3(String respuesta3) {
	String sentenciaSql2 = "SELECT  respuesta3 FROM copia where pregunta = ?";
	PreparedStatement sentencia = null;
	ResultSet resultado = null;
	 
	try {
		
	  sentencia = conexion.prepareStatement(sentenciaSql2);
	  sentencia.setString(1, pregunta);
	  resultado = sentencia.executeQuery();
	  while (resultado.next()) {
		 respuesta3 = resultado.getString(1);
	    System.out.println(respuesta3);
	    
	  }
	} catch (SQLException sqle) {
	  sqle.printStackTrace();
	} finally {
	  if (sentencia != null)
	    try {
	      sentencia.close();
	      resultado.close();
	    } catch (SQLException sqle) {
	      sqle.printStackTrace();
	    }
	}
	return respuesta3;
	}

public static String sacarespuesta4(String respuesta4) {
	String sentenciaSql2 = "SELECT  respuesta4 FROM copia where pregunta = ?";
	PreparedStatement sentencia = null;
	ResultSet resultado = null;
	 
	try {
		
	  sentencia = conexion.prepareStatement(sentenciaSql2);
	  sentencia.setString(1, pregunta);
	  resultado = sentencia.executeQuery();
	  while (resultado.next()) {
		 respuesta4 = resultado.getString(1);
	    System.out.println(respuesta4);
	    
	  }
	} catch (SQLException sqle) {
	  sqle.printStackTrace();
	} finally {
	  if (sentencia != null)
	    try {
	      sentencia.close();
	      resultado.close();
	    } catch (SQLException sqle) {
	      sqle.printStackTrace();
	    }
	}
	return respuesta4;
	}


public static String correcta(String correcta) {
	String sentenciaSql2 = "SELECT  correcta FROM copia where pregunta = ?";
	PreparedStatement sentencia = null;
	ResultSet resultado = null;
	 
	try {
		
	  sentencia = conexion.prepareStatement(sentenciaSql2);
	  sentencia.setString(1, pregunta);
	  resultado = sentencia.executeQuery();
	  while (resultado.next()) {
		 correcta = resultado.getString(1);
	   
	    
	  }
	} catch (SQLException sqle) {
	  sqle.printStackTrace();
	} finally {
	  if (sentencia != null)
	    try {
	      sentencia.close();
	      resultado.close();
	    } catch (SQLException sqle) {
	      sqle.printStackTrace();
	    }
	}
	return correcta;
	
	
	
}

public static String categoria(String categoria) {
	String sentenciaSql2 = "SELECT  categoria FROM copia where pregunta = ?";
	PreparedStatement sentencia = null;
	ResultSet resultado = null;
	 
	try {
		
	  sentencia = conexion.prepareStatement(sentenciaSql2);
	  sentencia.setString(1, pregunta);
	  resultado = sentencia.executeQuery();
	  while (resultado.next()) {
		 categoria = resultado.getString(1);
	   
	    
	  }
	} catch (SQLException sqle) {
	  sqle.printStackTrace();
	} finally {
	  if (sentencia != null)
	    try {
	      sentencia.close();
	      resultado.close();
	    } catch (SQLException sqle) {
	      sqle.printStackTrace();
	    }
	}
	return categoria;
	
	
	
}

public static void insertarpreguntas(String pregunta, String respuesta1, String respuesta2, String respuesta3, String respuesta4, String categoria, String correcta) {
	String sentenciaSql = "INSERT INTO preguntas (pregunta, respuesta1, respuesta2, respuesta3, respuesta4, categoria, correcta) VALUES (?, ?, ?, ?, ?, ?, ?)";
	PreparedStatement sentencia = null;
	 
	try {
	  sentencia = conexion.prepareStatement(sentenciaSql);
	  sentencia.setString(1, pregunta);
	  sentencia.setString(2, respuesta1);
	  sentencia.setString(3, respuesta2);
	  sentencia.setString(4, respuesta3);
	  sentencia.setString(5, respuesta4);
	  sentencia.setString(6, categoria);
	  sentencia.setString(7, correcta);
	  sentencia.executeUpdate();
	} catch (SQLException sqle) {
	  sqle.printStackTrace();
	} finally {
	  if (sentencia != null)
	    try {
	      sentencia.close();
	    } catch (SQLException sqle) {
	      sqle.printStackTrace();
	    }
	}
}

public static void eliminarpregunta(int id) {
	
	String sentenciaSql = "DELETE FROM preguntas WHERE id = ?";
	PreparedStatement sentencia = null;
	 
	try {
	  sentencia = conexion.prepareStatement(sentenciaSql);
	  sentencia.setInt(1, id);
	  sentencia.executeUpdate();
	} catch (SQLException sqle) {
	  sqle.printStackTrace();
	} finally {
	  if (sentencia != null)
	    try {
	      sentencia.close();
	    } catch (SQLException sqle) {
	      sqle.printStackTrace();
	    }
	}
	
}

public void norep(String pregunta) {
	
	String sentenciaSql = "DELETE FROM copia WHERE pregunta = ?";
	PreparedStatement sentencia = null;
	 
	try {
	  sentencia = conexion.prepareStatement(sentenciaSql);
	  sentencia.setString(1, pregunta);
	  sentencia.executeUpdate();
	} catch (SQLException sqle) {
	  sqle.printStackTrace();
	} finally {
	  if (sentencia != null)
	    try {
	      sentencia.close();
	    } catch (SQLException sqle) {
	      sqle.printStackTrace();
	    }
	}
	
}
public static void copiar()  {
	try {
	PreparedStatement psvac = conexion.prepareStatement("delete from copia");
    psvac.execute();

    PreparedStatement psrellenar = conexion.prepareStatement("INSERT INTO copia SELECT * FROM preguntas");
    psrellenar.execute();
         
	}catch (SQLException ex) {
    Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
}
        

}
public static void importar(String url) throws SQLException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
	
	System.out.println(url);
	Connection connect = null;
	try {
		Class.forName("org.postgresql.Driver").newInstance();
		  conexion =  DriverManager.getConnection(
		    "jdbc:postgresql://localhost:5432/quizz",
		    "postgres", "alumno");
		if (conexion != null) {
			System.out.println("Conectado");
		}
	} catch (SQLException ex) {
		System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
	}
	



	String sql = url;

	 PreparedStatement psvaciar =conexion.prepareStatement("DELETE from preguntas");
	 psvaciar.execute();

	BufferedReader br = null;
	String line = "";
	String csvSplitBy = ",";
	int currentLine = 0;

	try {
		br = new BufferedReader(new FileReader(sql));
		PreparedStatement prep = conexion.prepareStatement(
				"INSERT INTO preguntas (pregunta, respuesta1, respuesta2, respuesta3, respuesta4, categoria, correcta) VALUES (?, ?, ?, ?, ?, ?, ?)");

		while ((line = br.readLine()) != null) {
			if (currentLine >= 0) {
				String[] table = line.split(csvSplitBy);
				int tamanyo = table.length;
				int j = 0;
				for (int i = 0; i < tamanyo; i++) {
					j = i + 1;
					prep.setString(j, (table[i]));
				}
				prep.execute();
				for (int i = 0; i < tamanyo; i++) {
					j = i + 1;
					prep.setString(j, null);
				}
			}
			currentLine++;
		}
		
	} catch (FileNotFoundException ex) {
		Logger.getLogger(metodos.class.getName()).log(Level.SEVERE, null, ex);
	}
	conexion.close();
}

public static void actualiza(String respuesta1, String respuesta2, String respuesta3, String respuesta4, String correctas, String vcorrecta) {
	String sentenciaSql = "UPDATE preguntas SET respuesta1 ="+respuesta1+", respuesta2="+respuesta2+", respuesta3="+respuesta3+", respuesta4="+ respuesta4+ ", correcta="+correctas+ "WHERE correcta = ?";
	PreparedStatement sentencia = null;
	 
	try {
	  sentencia = conexion.prepareStatement(sentenciaSql);
	  sentencia.setString(1,vcorrecta);
	  
	  sentencia.executeUpdate();
	} catch (SQLException sqle) {
	  sqle.printStackTrace();
	} finally {
	  if (sentencia != null)
	    try {
	      sentencia.close();
	    } catch (SQLException sqle) {
	      sqle.printStackTrace();
	    }
	}
}

public static void insertapuntuaciones(String nombre, String apellido, int puntuacion) {
	String sentenciaSql = "INSERT INTO datos (nombre, apellidos, puntuacion) VALUES (?, ?, ?)";
	PreparedStatement sentencia = null;
	 
	try {
	  sentencia = conexion.prepareStatement(sentenciaSql);
	  sentencia.setString(1, nombre);
	  sentencia.setString(2, apellido);
	  sentencia.setInt(3, puntuacion);
	  sentencia.executeUpdate();
	 
	} catch (SQLException sqle) {
	  sqle.printStackTrace();
	} finally {
	  if (sentencia != null)
	    try {
	      sentencia.close();
	    } catch (SQLException sqle) {
	      sqle.printStackTrace();
	    }
	}
	
	
}

	
	
	
	public static void main(String[] args) {
		String hola = null;
		String adios = null;
		conexion();
		System.out.println(" se ha conectado a la base de datos");
		sacapregunta();
		sacarespuesta1(hola);
		sacarespuesta2(hola);
		sacarespuesta3(hola);
		sacarespuesta4(hola);
		correcta(hola);
	}

}
