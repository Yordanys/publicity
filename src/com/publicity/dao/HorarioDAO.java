package com.publicity.dao;

import static com.publicity.dao.AbstractDAO.timeoutError;
import com.publicity.domain.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yordanys Pupo
 * @version 1.0
 * Esta clase permite obtener los datos de un ticket.
 */
public class HorarioDAO extends AbstractDAO {
    
    private static final String findAllSQL = "SELECT * FROM HORARIO";
    private static final String findByIdSQL = "SELECT * FROM HORARIO WHERE HORARIO_ID = ?";
    private static final String saveSQL = "INSERT INTO HORARIO (HORA_INICIO, HORA_FIN, SESSION, ACTIVO) VALUES (?, ?, ?, ?)";
    private static final String findLastIdSQL = "SELECT MAX(HORARIO_ID) FROM HORARIO";
    private static final String updateSQL = "UPDATE HORARIO SET HORA_INICIO = ?, HORA_FIN = ?, SESSION = ?, ACTIVO = ? WHERE HORARIO_ID = ?";
    private static final String deleteSQL = "DELETE FROM HORARIO WHERE HORARIO_ID = ?";
        
    public HorarioDAO() {
        super();
    }
    
    public HorarioDAO(Connection connection) {
        super(connection);
    }
    
    public List<Horario> obtenerHorarios() throws Exception {
        List<Horario> horarioList = new ArrayList<>();
        PreparedStatement ps = null;  
        ResultSet resultSet = null;
        try {                        
            getConnecton();            
            
            ps = connection.prepareStatement(findAllSQL);    
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                horarioList.add(new Horario(resultSet.getLong("HORARIO_ID"), resultSet.getString("HORA_INICIO"), resultSet.getString("HORA_FIN"), SESSION.values()[resultSet.getInt("SESSION")], resultSet.getBoolean("ACTIVO")));                
            }
            return horarioList;            
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
    
    public Horario obtenerHorarioPorId(Long id) throws Exception {
        PreparedStatement ps = null;  
        ResultSet resultSet = null;
        try {                        
            getConnecton();            
            
            ps = connection.prepareStatement(findByIdSQL); 
            ps.setInt(1, id.intValue());
            resultSet = ps.executeQuery();
            
            Horario horario = null;            
            if (resultSet.next()) {
                horario = new Horario(resultSet.getLong("HORARIO_ID"), resultSet.getString("HORA_INICIO"), resultSet.getString("HORA_FIN"), SESSION.values()[resultSet.getInt("SESSION")], resultSet.getBoolean("ACTIVO"));                
            }
            return horario;            
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
    
    public Long guardarHorario(Horario horario) throws Exception {
        PreparedStatement ps = null;                
        try {                        
            getConnecton();
                        
            ps = connection.prepareStatement(saveSQL);
            ps.setString(1, horario.getHoraInicio());
            ps.setString(2, horario.getHoraFin());
            ps.setInt(3, horario.getSession().ordinal());
            ps.setBoolean(4, horario.isActivo());
            ps.execute();   
            return obtenerIdGenerado(findLastIdSQL);                      
        } catch (SQLTimeoutException sqltoe) {            
            revertirTransaccion();
            throw new Exception(timeoutError, new Throwable(sqltoe.getMessage()));
        } catch (SQLException sqle) {            
            revertirTransaccion();
            throw new Exception(sqlError, new Throwable(sqle.getMessage()));        
        } finally {            
            closeStatement(ps);
            closeConnection();
        }        
    }
    
    public void editarHorario(Horario horario) throws Exception {
        PreparedStatement ps = null;                
        try {                        
            getConnecton();
                        
            ps = connection.prepareStatement(updateSQL);
            ps.setString(1, horario.getHoraInicio());
            ps.setString(2, horario.getHoraFin());
            ps.setInt(3, horario.getSession().ordinal());
            ps.setBoolean(4, horario.isActivo());
            ps.setInt(5, horario.getHorarioId().intValue());
            ps.execute(); 
            
        } catch (SQLTimeoutException sqltoe) {            
            revertirTransaccion();
            throw new Exception(timeoutError, new Throwable(sqltoe.getMessage()));
        } catch (SQLException sqle) {            
            revertirTransaccion();
            throw new Exception(sqlError, new Throwable(sqle.getMessage()));        
        } finally {            
            closeStatement(ps);
            closeConnection();
        }  
    }

    public void eliminarHorario(Long id) throws Exception {
        eliminarLong(id, deleteSQL);
    }
    
}
