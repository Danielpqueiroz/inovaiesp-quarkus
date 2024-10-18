package br.edu.iesp.resource;

import br.edu.iesp.entity.Festa;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/festas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Festa Resource", description = "CRUD operações para festa")

public class FestaResource {

    @GET
    @Operation(summary = "Lista as festas do Inova", description = "Retorna lista de festas")
    public List<Festa> listar(){
        return Festa.listAll();
    }

    @POST
    @Transactional
    @Operation(summary = "Cria uma festas do Inova", description = "Retorna lista persistida")
    public Festa criar(Festa festa){
        festa.persist();
        return  festa;
    }

}
