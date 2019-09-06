package br.com.bansys.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.bansys.dao.AgenciaClienteDAO;
import br.com.bansys.model.AgenciaCliente;

@Path("agenciaclientes")
public class AgenciaClienteController {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<AgenciaCliente> listAgencia() {
		try {
			AgenciaClienteDAO AgenciaClienteDAO = new AgenciaClienteDAO();
			return AgenciaClienteDAO.listar();
		} catch (Exception ex) {
			Logger.getLogger(AgenciaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public AgenciaCliente getAgenciao(@PathParam("id") int id) {
		try {
			AgenciaClienteDAO AgenciaClienteDAO = new AgenciaClienteDAO();
			return AgenciaClienteDAO.selecionar(id);
		} catch (Exception ex) {
			Logger.getLogger(AgenciaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(AgenciaCliente agencia_cliente) {
		try {
			AgenciaClienteDAO AgenciaClienteDAO = new AgenciaClienteDAO();
			AgenciaClienteDAO.inserir(agencia_cliente);
			return Response.status(Response.Status.CREATED).build();
		} catch (Exception ex) {
			Logger.getLogger(AgenciaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}/{cd}/")
	public Response update(AgenciaCliente agencia_cliente, @PathParam("id") int id, @PathParam("cd") int cd) {
		try {
			AgenciaClienteDAO AgenciaClienteDAO = new AgenciaClienteDAO();
			AgenciaClienteDAO.alterar(agencia_cliente, id, cd);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(AgenciaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{id}/{cd}/")
	public Response delete(@PathParam("id") int id, @PathParam("cd") int cd){
		try {
			AgenciaClienteDAO AgenciaClienteDAO = new AgenciaClienteDAO();
			AgenciaClienteDAO.excluir(id, cd);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(AgenciaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

}
