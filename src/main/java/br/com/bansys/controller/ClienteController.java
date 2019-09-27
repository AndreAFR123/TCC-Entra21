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

import br.com.bansys.dao.ClienteDAO;
import br.com.bansys.model.Cliente;

@Path("clientes")
public class ClienteController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Cliente> listCliente() {
		try {
			ClienteDAO ClienteDAO = new ClienteDAO();
			return ClienteDAO.listar();
		} catch (Exception ex) {
			Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Cliente getCliente(@PathParam("id") int id) {
		try {
			ClienteDAO ClienteDAO = new ClienteDAO();
			return ClienteDAO.selecionar(id);
		} catch (Exception ex) {
			Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{num_conta}/")
	public Cliente getExtrato(@PathParam("num_conta") int num_conta) {
		try {
			ClienteDAO ClienteDAO = new ClienteDAO();
			return ClienteDAO.selecionar(num_conta);
		} catch (Exception ex) {
			Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{cpf_cliente}/")
	public Cliente getConsulta(@PathParam("cpf_cliente") int cpf_cliente) {
		try {
			ClienteDAO ClienteDAO = new ClienteDAO();
			return ClienteDAO.selecionar(cpf_cliente);
		} catch (Exception ex) {
			Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Cliente cliente) {
		try {
			ClienteDAO ClienteDAO = new ClienteDAO();
			ClienteDAO.inserir(cliente);

			return Response.status(Response.Status.CREATED).build();
		} catch (Exception ex) {
			Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Cliente cliente) {
		try {

			ClienteDAO ClienteDAO = new ClienteDAO();
			ClienteDAO.alterar(cliente);
			return Response.status(Response.Status.CREATED).build();
		} catch (Exception ex) {
			Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") int id) {
		try {
			ClienteDAO ClienteDAO = new ClienteDAO();
			ClienteDAO.excluir(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Path("{id}/")
	public Response concluir(@PathParam("id") int id) {
		try {
			ClienteDAO ClienteDAO = new ClienteDAO();

			Cliente c = ClienteDAO.selecionar(id);

			ClienteDAO.alterar(c);
			return Response.status(Response.Status.ACCEPTED).build();
		} catch (Exception ex) {
			Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}
