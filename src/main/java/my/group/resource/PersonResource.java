package my.group.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import my.group.dto.PersonRequestDto;
import my.group.dto.PersonResposeDto;
import my.group.service.PersonService;

import java.util.List;


/**
 * REST resource for managing people.
 * 
 * Provides CRUD operations for Person entities through HTTP endpoints.
 * All requests and responses are in JSON format.
 * 
 * @author my.group
 */
@Path("/api/v1/peoples")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private final PersonService personService;

    @Inject
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Path("/{id}")
    public Response getPersonById(@PathParam("id")Long id) {
        var person = personService.getPersonById(id);
        return Response.ok(person).build();
    }

    @POST
    public Response createPerson(PersonRequestDto personDto) {
        personService.createPerson(personDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePersonById(@PathParam("id")Long id) {
        personService.deletePerson(id);
        return Response.ok().build();
    }

    @GET
    public List<PersonResposeDto> getAll() {
        // Quarkus asume Response.ok() si devuelves la lista directamente
        return personService.getPeople();
    }

    @PATCH
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PersonRequestDto dto) {
        personService.updatePerson(id, dto);
        return Response.ok().build();
    }


}
