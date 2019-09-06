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

import br.com.bansys.dao.AgenciaDAO;
import br.com.bansys.model.Agencia;

@Path("agencias")
public class AgenciaController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<Agencia> listAgencia() {
		try {
			AgenciaDAO AgenciaDAO = new AgenciaDAO();
			return AgenciaDAO.listar();
		} catch (Exception ex) {
			Logger.getLogger(AgenciaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Agencia getAgenciao(@PathParam("id") int id) {
		try {
			AgenciaDAO AgenciaDAO = new AgenciaDAO();
			return AgenciaDAO.selecionar(id);
		} catch (Exception ex) {
			Logger.getLogger(AgenciaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Agencia agencia) {
		try {
			AgenciaDAO AgenciaDAO = new AgenciaDAO();
			AgenciaDAO.inserir(agencia);
			return Response.status(Response.Status.CREATED).build();
		} catch (Exception ex) {
			Logger.getLogger(AgenciaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Agencia agencia) {
		try {
			

			AgenciaDAO AgenciaDAO = new AgenciaDAO();
			AgenciaDAO.alterar(agencia);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(AgenciaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") int id) {
		try {
			AgenciaDAO AgenciaDAO = new AgenciaDAO();
			AgenciaDAO.excluir(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(AgenciaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

}