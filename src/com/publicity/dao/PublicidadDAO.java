package com.publicity.dao;

import static com.publicity.dao.AbstractDAO.timeoutError;
import com.publicity.domain.Cliente;
import com.publicity.domain.Horario;
import com.publicity.domain.Publicidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yordanys
 */
public class PublicidadDAO extends AbstractDAO {

    private static final String findAllSQL = "SELECT * FROM CLIENTE";
    private static final String findByIdSQL = "SELECT * FROM CLIENTE WHERE CLIENTE_ID = ?";
    private static final String saveSQL = "INSERT INTO CLIENTE (NOMBRES, APELLIDOS, TIPO_CEDULA, CEDULA, EMPRESA, TIPO_RIF, RIF, TELEFONO, PAGO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String findLastIdSQL = "SELECT MAX(CLIENTE_ID) FROM CLIENTE";
    private static final String updateSQL = "UPDATE CLIENTE SET NOMBRES = ?, APELLIDOS = ?, TIPO_CEDULA = ?, CEDULA = ?, EMPRESA = ?, TIPO_RIF = ?, RIF = ?, TELEFONO = ?, PAGO = ? WHERE CLIENTE_ID = ?";
    private static final String deleteSQL = "DELETE FROM CLIENTE WHERE CLIENTE_ID = ?";
    
    public PublicidadDAO() {
        super();
    }
    
    public PublicidadDAO(Connection connection) {
        super(connection);
    }
    
    public List<Publicidad> obtenerPublicidades() throws Exception {
        List<Publicidad> publicidadList = new ArrayList<>();
        PreparedStatement ps = null;  
        ResultSet resultSet = null;
        try {                        
            getConnecton();            
            
            ps = connection.prepareStatement(findAllSQL);    
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                publicidadList.add(new Publicidad(resultSet.getLong("PUBLICIDAD_ID"), resultSet.getString("NOMBRE"), resultSet.getDate("FECHA_INICIO"), resultSet.getDate("FECHA_FIN"), resultSet.getInt("PRIORIDAD"), resultSet.getInt("COLOR"), resultSet.getLong("CLIENTE_ID"));                
            }
            return publicidadList;            
        } catch (SQLTimeoutException sqltoe) {            
            throw new Exception(timeoutError, new Throwable(sqltoe.getMessage()));
        } catch (SQLException sqle) {            
            throw new Exception(sqlError, new Throwable(sqle.getMessage()));        
        } finally {                        
            closeResultSet(resultSet);
            closeStatement(ps);
            closeConnection();
        }
    }
 
    public boolean guardarHorario(Horario horario) throws Exception {
        PreparedStatement ps = null;                
        try {                        
            getConnecton();
            
            final String SQL = "INSERT INTO HORARIO (HORA_INICIO, HORA_FIN, SESSION) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(SQL);
//            ps.setDate(1, horario.getHoraInicio());
        //    ps.setDate(2, horario.getHoraFin());
            ps.setInt(3, horario.getSession().ordinal());
            ps.execute();              
            return true;           
        } catch (SQLTimeoutException sqltoe) {            
            revertirTransaccion();
            throw new Exception("No se ha recibido respuesta del servidor de datos. Los tickets no se pudieron guardar.", new Throwable(sqltoe.getMessage()));
        } catch (SQLException sqle) {            
            revertirTransaccion();
            throw new Exception("Ha ocurrido un error en el servidor de datos. Los tickets no se pudieron guardar.", new Throwable(sqle.getMessage()));        
        } finally {            
            closeStatement(ps);
            closeConnection();
        }        
    }
    
    public boolean editarHorario(Horario horario) throws Exception {
        PreparedStatement ps = null;                
        try {                        
            getConnecton();
            
            final String SQL = "UPDATE HORARIO SET HORA_INICIO = ?, HORA_FIN = ?, SESSION = ? WHERE HORARIO_ID = ?";
            ps = connection.prepareStatement(SQL);
//            ps.setDate(1, horario.getHoraInicio());
  //          ps.setDate(2, horario.getHoraFin());
            ps.setInt(3, horario.getSession().ordinal());
            ps.setLong(4, horario.getHorarioId());
            ps.execute();              
            return true;           
        } catch (SQLTimeoutException sqltoe) {            
            revertirTransaccion();
            throw new Exception("No se ha recibido respuesta del servidor de datos. Los tickets no se pudieron guardar.", new Throwable(sqltoe.getMessage()));
        } catch (SQLException sqle) {            
            revertirTransaccion();
            throw new Exception("Ha ocurrido un error en el servidor de datos. Los tickets no se pudieron guardar.", new Throwable(sqle.getMessage()));        
        } finally {            
            closeStatement(ps);
            closeConnection();
        }  
    }

    public boolean eliminarHorario(Long id) throws Exception {
        PreparedStatement ps = null;                
        try {                        
            getConnecton();
            
            final String SQL = "DELETE HORARIO WHERE HORARIO_COD = ?";
            ps = connection.prepareStatement(SQL); 
            ps.setLong(1, id);
            ps.execute();              
            return true;           
        } catch (SQLTimeoutException sqltoe) {            
            revertirTransaccion();
            throw new Exception("No se ha recibido respuesta del servidor de datos. Los tickets no se pudieron guardar.", new Throwable(sqltoe.getMessage()));
        } catch (SQLException sqle) {            
            revertirTransaccion();
            throw new Exception("Ha ocurrido un error en el servidor de datos. Los tickets no se pudieron guardar.", new Throwable(sqle.getMessage()));        
        } finally {            
            closeStatement(ps);
            closeConnection();
        }
    }

}
