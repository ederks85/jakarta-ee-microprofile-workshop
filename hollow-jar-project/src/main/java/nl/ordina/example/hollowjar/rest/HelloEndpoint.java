package nl.ordina.example.hollowjar.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloEndpoint {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response greeting() {
		return Response.ok("Hello from Payara Micro").build();
	}
}
