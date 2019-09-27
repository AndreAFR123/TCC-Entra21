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

import br.com.bansys.dao.ContaDAO;
import br.com.bansys.model.Conta;
;

@Path("contas")
public class ContaController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	
	public List<Conta> listConta() {
		try {
			ContaDAO ContaDAO = new ContaDAO();
			return ContaDAO.listar();
		} catch (Exception ex) {
			Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}/")
	public Conta getConta(@PathParam("id") int id) {
		try {
			ContaDAO ContaDAO = new ContaDAO();
			return ContaDAO.selecionar(id);
		} catch (Exception ex) {
			Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{num_conta}/")
	public Conta getConsulta(@PathParam("num_conta") int num_conta) {
		try {
			ContaDAO ContaDAO = new ContaDAO();
			return ContaDAO.selecionar(num_conta);
		} catch (Exception ex) {
			Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Conta conta) {
		try {
			ContaDAO ContaDAO = new ContaDAO();
			ContaDAO.inserir(conta);
			return Response.status(Response.Status.CREATED).build();
		} catch (Exception ex) {
			Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response update(Conta conta) {
		try {
			

			ContaDAO ContaDAO = new ContaDAO();
			ContaDAO.alterar(conta);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	@PUT
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Path("{id}/{saldo_conta}/{saldo}/{num}")
	   public Response Transferencia(@PathParam("id") int id, @PathParam("saldo_conta")double saldo_conta, @PathParam("saldo")double saldo, @PathParam("num")int num) {
	       try {
	           ContaDAO ContaDAO = new ContaDAO();
	           ContaDAO.Transferencia(saldo_conta, id, saldo, num);
	           return Response.status(Response.Status.OK).build();
	       } catch (Exception ex) {
	           Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
	           throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
	       }
	   }
	   @PUT
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Path("{id}/{saldo_conta}/{emprestimo_conta}")
	   public Response Emprestimo(@PathParam("id") int id, @PathParam("saldo_conta") double saldo_conta, @PathParam("emprestimo_conta") double emprestimo_conta) {
	       try {
	           ContaDAO ContaDAO = new ContaDAO();
	           ContaDAO.Emprestimo(saldo_conta,emprestimo_conta, id);
	           return Response.status(Response.Status.OK).build();
	       } catch (Exception ex) {
	           Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
	           throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
	       }
	   }
	   @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Path("saque/{id}/{saldo_conta}/")
	    public Response saque(@PathParam("saldo_conta") double saldo_conta, @PathParam("id") int id) {
	        try {
	            ContaDAO ContaDAO = new ContaDAO();
	            ContaDAO.Saque(saldo_conta, id);
	            return Response.status(Response.Status.OK).build();
	        } catch (Exception ex) {
	            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
	            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
	        }
	    }
	   @PUT
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Path("deposito/{id}/{saldo_conta}/")
	    public Response deposito(@PathParam("saldo_conta") double saldo_conta, @PathParam("id") int id) {
	        try {
	            ContaDAO ContaDAO = new ContaDAO();
	            ContaDAO.Deposito(saldo_conta, id);
	            return Response.status(Response.Status.OK).build();
	        } catch (Exception ex) {
	            Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
	            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
	        }
	    }
	
	
	@DELETE
	@Path("{id}/")
	public Response delete(@PathParam("id") int id) {
		try {
			ContaDAO ContaDAO = new ContaDAO();
			ContaDAO.excluir(id);
			return Response.status(Response.Status.OK).build();
		} catch (Exception ex) {
			Logger.getLogger(ContaController.class.getName()).log(Level.SEVERE, null, ex);
			throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	

}
