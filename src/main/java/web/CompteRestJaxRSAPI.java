package web;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import entities.Compte;
import repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {
    @Autowired
    private CompteRepository compteRepository;


    @Path("/compte")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compte> CompteList(){
        return compteRepository.findAll();
    }


    @Path("/compte/{ID}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Compte getcp(@PathParam(value = "ID") Long Id ){
        return compteRepository.findById(Id).get();
    }


    @Path("/compte")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Compte creer(Compte compte ){
        return compteRepository.save(compte);
    }


    @Path("/compte/{ID}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Compte compteUpdate(Compte compte ,@PathParam(value = "ID") Long Id )
    {
        compte.setId(Id);
        return compteRepository.save(compte);

    }


    @Path("/compte/{ID}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void supprimer(@PathParam(value = "ID") Long Id ){
        compteRepository.deleteById(Id);
    }



}