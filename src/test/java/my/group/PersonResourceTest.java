package my.group;


import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import my.group.dto.PersonRequestDto;
import my.group.dto.PersonResposeDto;
import my.group.entity.Status;
import my.group.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;


import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonResourceTest {

    @InjectMock
    PersonService personService;

    @Test
    void getPersonByIdTest(){
        PersonResposeDto personResposeDto = new PersonResposeDto(
                1L,"pipo", LocalDate.of(1992,04,25)
                , Status.ALIVE,10,"pipo_ea@gmail.com"
        );
        BDDMockito.given(personService.getPersonById(1L)).willReturn(personResposeDto);

        given()
                .pathParam("id",1L)
                .when()
                .get("/api/v1/peoples/{id}",1L)
                .then()
                .statusCode(200)
                .body("name", is("pipo"))
                .body("email", is("pipo_ea@gmail.com"));
    }

    @Test
    void createPersonTest(){
        PersonRequestDto personRequestDto = new PersonRequestDto(
                "pipo", LocalDate.of(1992,04,25)
                , Status.ALIVE,10,"pipo_ea@gmail.com");

        given()
                .contentType("application/json")
                .body(personRequestDto)
                .when()
                .post("/api/v1/peoples")
                .then()
                .statusCode(201);
                 Mockito.verify(personService, Mockito.times(1))
                .createPerson(Mockito.any(PersonRequestDto.class));
    }

    @Test
    void deletePersonTest(){
        Long idAEliminar = 1L;

        given()
        .pathParam("id",idAEliminar)
                .when()
                .delete("/api/v1/peoples/{id}",idAEliminar)
                .then()
                .statusCode(200);
        Mockito.verify(personService, Mockito.times(1)).deletePerson(idAEliminar);
    }




}
