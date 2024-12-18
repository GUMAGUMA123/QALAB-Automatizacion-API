package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class PetStore {

    private static String URL_BASE="https://petstore.swagger.io/v2/";
    private static String PARAM = "store/order";

    public void crearOrdenMascota(String id, String petid, int cantidad) {
        SerenityRest
                .given()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                "  \"id\": \""+id+"\",\n" +
                "  \"petId\": \""+petid+"\",\n" +
                "  \"quantity\": \""+cantidad+"\",\n" +
                "  \"shipDate\": \"2024-12-17T20:27:28.759Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}")
                .log().all()
                .post(PARAM)
                .then()
                .log().all();
    }


    public void consultarOrdenMascota(String id) {
        SerenityRest
                .given()
                .baseUri(URL_BASE)
                .relaxedHTTPSValidation()
                .log().all()
                .get(PARAM + "/" +id)
                .then()
                .log().all();
    }

    public void validarCodigoRespuesta(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    public void validarType(String statusOrder) {
        restAssuredThat(response -> response.body("'status'", equalTo(statusOrder)));
        System.out.println("status: " + SerenityRest.lastResponse().body().path("status").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

}
