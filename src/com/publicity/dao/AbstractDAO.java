package com.publicity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;

/**
 *
 * @author Yordanys
 */
public abstract class AbstractDAO {
    
    protected Connection connection = null;        
    private static String USER = "";
    private static String PASSWORD = "";
    private static String ACCESS_FILE_PATH = System.getProperty("user.dir") + "\\publicidad.mdb";
    private static String URL = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + ACCESS_FILE_PATH;    
    private static String DRIVER_NAME = "sun.jdbc.odbc.JdbcOdbcDriver";
    
    protected static final String timeoutError = "No se ha podido acceder al disco. La operación no se pudo completar.";
    protected static final String sqlError = "Ha ocurrido un error procesando datos. La operación no se pudo completar.";
    
    public AbstractDAO() {
        
    }
    
    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public static void setConnection(String user, String password, String accessFilePath, String driverName) {
        AbstractDAO.USER = user;
        AbstractDAO.PASSWORD = password;
        AbstractDAO.ACCESS_FILE_PATH = accessFilePath;
        AbstractDAO.DRIVER_NAME = driverName;
    }
    
    public void getConnecton() throws Exception {
        try {                    
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException ex) {
            throw new Exception("El driver especificado para la conexión no se ha encontrado.");
        } catch (SQLException ex) {
            throw new Exception("Imposible conectar al servidor de datos.\nPor favor, consulte los siguientes parametros de conexión:");
        }        
    }
    
    public void closeConnection() throws Exception {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new Exception("Imposible cerrar la conexión al servidor de datos.");
            }
        }
    }
    
    protected void closeStatement(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                System.err.println("La sentencia no se pudo cerrar.");
            }
        }
    }
    
    protected void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.err.println("El resultado no se pudo cerrar.");
            }
        }
    }
    
    protected void revertirTransaccion() {
        try {                
            connection.rollback();
        } catch (SQLException ex) {
            System.err.println("La transacción no se pudo revertir.");
        }
    }
    
    protected Long obtenerIdGenerado(String findLastIdSQL) throws Exception {        
        PreparedStatement ps = null;  
        ResultSet resultSet = null;
        try {                        
            getConnecton();            
            
            ps = connection.prepareStatement(findLastIdSQL);    
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                return resultSet.getLong(1); 
            }            
        } catch (SQLTimeoutException sqltoe) {            
            throw new Exception(timeoutError, new Throwable(sqltoe.getMessage()));
        } catch (SQLException sqle) {            
            throw new Exception(sqlError, new Throwable(sqle.getMessage()));        
        } finally {            
            closeResultSet(resultSet);
            closeStatement(ps);
            closeConnection();
        }
        return null;
    }
    
    public void eliminarLong(Long id, String deleteSQL) throws Exception {
        PreparedStatement ps = null;                
        try {                        
            getConnecton();
            
            ps = connection.prepareStatement(deleteSQL); 
            ps.setInt(1, id.intValue());
            ps.executeUpdate();
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
    
}
