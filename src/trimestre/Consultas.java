package trimestre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {
	
		public void registrar(String r_usuario, String r_password, String r_correo) { 
			Conexion conexion = new Conexion();
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			
			try {		
				cn = conexion.conectar();
				PreparedStatement stm2 = cn.prepareStatement("INSERT INTO registro (Nombre_Usuario,Password,correo) VALUES (?,?,?)");
				stm2.setString(1 , r_usuario);
				stm2.setString(2 , r_password);
				stm2.setString(3 , r_correo);
				stm2.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				try {
					
					if (rs!= null) {
						rs.close();
					}
					
					if (stm != null) {
						stm.close();
					}
					
					if (cn != null) {
						cn.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		
		
		}
		
		public boolean logeo(String r_usuario, String r_password) { 
			Conexion conexion = new Conexion();
			Connection cn = null;
			Statement stm = null;
			ResultSet rs = null;
			PreparedStatement pst =  null;
			boolean correcto = false;
			
			try {
				cn = conexion.conectar();
				stm = cn.createStatement();
				pst = cn.prepareStatement("SELECT * FROM registro where Nombre_Usuario=? AND Password=?");
				pst.setString(1, r_usuario);
				pst.setString(2, r_password);
				rs = pst.executeQuery();
				
				while (rs.next()) {
					String Nombre_Usuario = rs.getString(1);
					String Password = rs.getString(2);
							
					System.out.println(Nombre_Usuario + " - " + Password + " - ");
					if(Nombre_Usuario.equals(r_usuario) && Password.equals(r_password)) {
						correcto=true;
						break;
					}
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				try {
					if (rs!= null) {
						rs.close();
					}
					
					if (stm != null) {
						stm.close();
					}
					
					if (cn != null) {
						cn.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return correcto;
	}
		
		public void borrar(String nomb_usu) {
	          Conexion conexion = new Conexion();
	            Connection cn = null;
	            Statement stm = null;
	            ResultSet rs = null;
	            PreparedStatement pst =  null;
	        try {
	            cn = conexion.conectar();
	            PreparedStatement stm2 = cn.prepareStatement("DELETE FROM registro WHERE Nombre_usuario = ?");
	            stm2.setString(1 , nomb_usu);


	            stm2.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();

	        } finally {
	            try {
	                if (rs!= null) {
	                    rs.close();
	                }

	                if (stm != null) {
	                    stm.close();
	                }

	                if (cn != null) {
	                    cn.close();
	                }
	            } catch (Exception e2) {
	                e2.printStackTrace();
	            }
	        }


	    }
}