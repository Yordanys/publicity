package com.publicity.dao;

import static com.publicity.dao.AbstractDAO.timeoutError;
import com.publicity.domain.Cliente;
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
 * @version 1.0
 * Esta clase permite gestionar los datos de un cliente, hacia y desde la base de datos.
 */
public class ClienteDAO extends AbstractDAO {
    
    private static final String findAllSQL = "SELECT * FROM CLIENTE";
    private static final String findByIdSQL = "SELECT * FROM CLIENTE WHERE CLIENTE_ID = ?";
    private static final String saveSQL = "INSERT INTO CLIENTE (NOMBRES, APELLIDOS, CEDULA, EMPRESA, RIF, TELEFONO, PAGO) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String findLastIdSQL = "SELECT MAX(CLIENTE_ID) FROM CLIENTE";
    private static final String updateSQL = "UPDATE CLIENTE SET NOMBRES = ?, APELLIDOS = ?, CEDULA = ?, EMPRESA = ?, RIF = ?, TELEFONO = ?, PAGO = ? WHERE CLIENTE_ID = ?";
    private static final String deleteSQL = "DELETE FROM CLIENTE WHERE CLIENTE_ID = ?";
    
    public ClienteDAO() {
        super();
    }
    
    public ClienteDAO(Connection connection) {
        super(connection);
    }
    
    public List<Cliente> obtenerClientes() throws Exception {
        List<Cliente> clienteList = new ArrayList<>();
        PreparedStatement ps = null;  
        ResultSet resultSet = null;
        try {                        
            getConnecton();            
            
            ps = connection.prepareStatement(findAllSQL);    
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                clienteList.add(new Cliente(resultSet.getLong("CLIENTE_ID"), resultSet.getString("NOMBRES"), resultSet.getString("APELLIDOS"), resultSet.getString("CEDULA"),  
                                            resultSet.getString("EMPRESA"), resultSet.getString("RIF"), resultSet.getString("TELEFONO"), resultSet.getDouble("PAGO")));                
            }
            return clienteList;            
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
    
    public Cliente obtenerClientePorId(Long id) throws Exception {
        PreparedStatement ps = null;  
        ResultSet resultSet = null;
        try {                        
            getConnecton();            
            
            ps = connection.prepareStatement(findByIdSQL); 
            ps.setInt(1, id.intValue());
            resultSet = ps.executeQuery();
            
            Cliente cliente = null;            
            if (resultSet.next()) {
                cliente = new Cliente(resultSet.getLong("CLIENTE_ID"), resultSet.getString("NOMBRES"), resultSet.getString("APELLIDOS"), resultSet.getString("CEDULA"),  
                                      resultSet.getString("EMPRESA"), resultSet.getString("RIF"), resultSet.getString("TELEFONO"), resultSet.getDouble("PAGO"));                
            }
            return cliente;            
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
    
    public Cliente buscarCliente(Cliente cliente) throws Exception {
        PreparedStatement ps = null;  
        ResultSet resultSet = null;
        try {                        
            getConnecton();            
            
            StringBuilder sb = new StringBuilder("SELECT * FROM CLIENTE WHERE");
            if (cliente.getCedula() != null) {
                sb.append(" CEDULA = ? ");
                if (cliente.getRif() != null) 
                    sb.append(" OR RIF = ?");
            } else if (cliente.getRif() != null) 
                    sb.append("RIF = ?");
                        
            ps = connection.prepareStatement(sb.toString()); 
            
            int param = 1;
            if (cliente.getCedula() != null) {
                ps.setString(param++, cliente.getCedula()); 
            }
            if (cliente.getRif() != null) {
                ps.setString(param++, cliente.getRif());            
            }
            resultSet = ps.executeQuery();
            
            Cliente nuevoCliente = null;            
            if (resultSet.next()) {
                nuevoCliente = new Cliente(resultSet.getLong("CLIENTE_ID"), resultSet.getString("NOMBRES"), resultSet.getString("APELLIDOS"), resultSet.getString("CEDULA"),  
                                           resultSet.getString("EMPRESA"), resultSet.getString("RIF"), resultSet.getString("TELEFONO"), resultSet.getDouble("PAGO"));                
            }
            return nuevoCliente;            
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
  
    public Long guardarCliente(Cliente cliente) throws Exception {
        PreparedStatement ps = null;                
        try {                        
            getConnecton();
            
            ps = connection.prepareStatement(saveSQL);
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getCedula());
            ps.setString(4, cliente.getEmpresa());            
            ps.setString(5, cliente.getRif());
            ps.setString(6, cliente.getTelefono());           
            ps.setDouble(7, cliente.getPago());
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
      
    public void editarCliente(Cliente cliente) throws Exception {
        PreparedStatement ps = null;                
        try {                        
            getConnecton();
                        
            ps = connection.prepareStatement(updateSQL);
            ps.setString(1, cliente.getNombres());
            ps.setString(2, cliente.getApellidos());
            ps.setString(3, cliente.getCedula());
            ps.setString(4, cliente.getEmpresa());            
            ps.setString(5, cliente.getRif());
            ps.setString(6, cliente.getTelefono());           
            ps.setDouble(7, cliente.getPago());
            ps.setInt(8, cliente.getClienteId().intValue());
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

    public void eliminarCliente(Long id) throws Exception {
        eliminarLong(id, deleteSQL);
    }
    
}
