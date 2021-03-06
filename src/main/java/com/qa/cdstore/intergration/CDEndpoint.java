package com.qa.cdstore.intergration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.cdstore.business.CDService;

@Path("/cdstore")
public class CDEndpoint {

	@Inject
	private CDService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllCDs() { return service.getAllCDs(); }

	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public String getCD(@PathParam("id") Long id) { return service.getCD(id); }

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addCD(String cd) {
		return service.createCD(cd);
	}

    @Path("/json")
    @DELETE
    @Produces({ "application/json" })
    public String deleteAll() { return service.deleteAll(); }

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateCD(@PathParam("id") Long id, String cd) {
		return service.updateCD(id, cd);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteCD(@PathParam("id") Long id) {
		return service.deleteCD(id);
	}



}
