package com.nttdata.glue;

import com.nttdata.steps.PetStore;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetStoreStepDef {
    @Steps
    PetStore storeActions;

    //Step definition creacion de orden de mascota
    @When("creo la orden de la mascota con id {string}, petId {string} y cantidad {int}")
    public void creoLaOrdenDeLaMascotaConIdPetIdYCantidadCantidad(String id, String petid , int cantidad) {
        storeActions.crearOrdenMascota(id,petid,cantidad);
    }
    @Then("el servicio responde con un código de estado {int}")
    public void elServicioRespondeConUnCódigoDeEstadoStatusCode(int statusCode) {
        storeActions.validarCodigoRespuesta(statusCode);
    }
    @And("el estado de orden es {string}")
    public void elEstadoDeOrdenEs(String statusOrder) {
        storeActions.validarType(statusOrder);
    }


    //Step definition consulta de orden de mascota
    @Given("que existe una orden con id {string}")
    public void queExisteUnaOrdenConId(String id) {
    }

    @When("hago la consulta de la orden con id {string}")
    public void hagoLaConsultaDeLaOrdenConId(String id) {
        storeActions.consultarOrdenMascota(id);
    }


}
