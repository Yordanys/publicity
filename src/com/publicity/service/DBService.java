package com.publicity.service;

import com.publicity.dao.ClienteDAO;
import com.publicity.dao.HorarioDAO;
import com.publicity.dao.PublicidadDAO;
import com.publicity.domain.Cliente;
import com.publicity.domain.Horario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Yordanys Pupo
 * @version 1.0
 * Esta clase gestiona la lógica del negocio de las publicidades.
 */
public class DBService {
    
    private HorarioDAO horarioDAO;
    private PublicidadDAO publicidadDAO;
    private ClienteDAO clienteDAO;
    
    private SimpleDateFormat format = new SimpleDateFormat("HH:mm");

    public DBService() {
        horarioDAO = new HorarioDAO();
        publicidadDAO = new PublicidadDAO();
        clienteDAO = new ClienteDAO();
    }
    
    public List<Horario> obtenerHorarios() throws Exception {
        return horarioDAO.obtenerHorarios();
    }
    
    public Horario obtenerHorarioPorId(Long id) throws Exception {
        return horarioDAO.obtenerHorarioPorId(id);
    }
    
    public Long adicionarHorario(Horario horario) throws Exception {        
        List<Horario> horarios = obtenerHorarios();
        try {
            Date horaInicial = format.parse(horario.getHoraInicio());
            Date horaFinal = format.parse(horario.getHoraFin());
            if (horaInicial.compareTo(horaFinal) >= 0)
                throw new Exception("Horario incorrecto: La hora inicial debe ser antes de la hora fin.");
            Date horaInicialDB, horaFinalDB;
            for (Horario horarioDB : horarios) {
                horaInicialDB = format.parse(horarioDB.getHoraInicio());
                horaFinalDB = format.parse(horarioDB.getHoraFin());
                if (((horaInicial.compareTo(horaInicialDB) >= 0 && horaInicial.compareTo(horaFinalDB) < 0) || (horaFinal.compareTo(horaInicialDB) > 0 && horaFinal.compareTo(horaFinalDB) <= 0) ||
                     (horaInicial.compareTo(horaInicialDB) < 0 && horaFinal.compareTo(horaFinal) > 0)) && horario.getSession() == horarioDB.getSession()) {
                    throw new Exception("Horario incorrecto: Existen intercepciones entre horarios.");
                }                
            }
            return horarioDAO.guardarHorario(horario);        
        } catch(Exception e) {
            throw e;
        }        
    }
    
    public void editarHorario(Horario horario) throws Exception {
        horarioDAO.editarHorario(horario);
    }
        
    public List<Cliente> obtenerClientes() throws Exception {
        return clienteDAO.obtenerClientes();
    }
    
    public Cliente obtenerClientePorId(Long id) throws Exception {
        return clienteDAO.obtenerClientePorId(id);
    }
    
    public Cliente buscarCliente(Cliente buscarCliente) throws Exception {
        return clienteDAO.buscarCliente(buscarCliente);
    }
    
    public Long adicionarCliente(Cliente nuevoCliente) throws Exception {
        Cliente cliente = clienteDAO.buscarCliente(nuevoCliente);
        if (cliente != null) {
            if (nuevoCliente.getCedula().equals(cliente.getCedula()))
                throw new Exception("El cliente: " + cliente.getNombres() + " " + cliente.getApellidos() + ", ya ha sido registrado con esa Cédula.");
            if (nuevoCliente.getRif().equals(cliente.getRif()))
                throw new Exception("El cliente: " + cliente.getNombres() + " " + cliente.getApellidos() + ", ya ha sido con ese RIF.");    
        }            
        return clienteDAO.guardarCliente(nuevoCliente);
    }
    
    public void editarCliente(Cliente clienteEditado) throws Exception {
        Cliente cliente = clienteDAO.buscarCliente(clienteEditado);
        if (cliente != null && clienteEditado.getClienteId() != cliente.getClienteId()) {
            if (clienteEditado.getCedula().equals(cliente.getCedula()))
                throw new Exception("El cliente: " + cliente.getNombres() + " " + cliente.getApellidos() + ", ya ha sido con esa Cédula.");
            if (clienteEditado.getRif().equals(cliente.getRif()))
                throw new Exception("El cliente: " + cliente.getNombres() + " " + cliente.getApellidos() + ", ya ha sido con ese RIF.");    
        }
        clienteDAO.editarCliente(clienteEditado);
    }
    
    public void eliminarCliente(Long id) throws Exception {
        clienteDAO.eliminarCliente(id);
    }
    
}
