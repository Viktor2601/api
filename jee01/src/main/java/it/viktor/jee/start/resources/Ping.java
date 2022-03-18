/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.jee.start.resources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tss
 */
@Path("ping")
public class Ping {

    /**
    @GET // TIPO DI RICHESTA HTTP
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "ok !!!! " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
    */

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{id}") // PARAMETRO
    public String ping1(@PathParam("id") String id) {
        return "ping eseguito" + " parametro -> " + id;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping2(@QueryParam("language") String language) {
        
        if (language == null){
            throw new BadRequestException("Parametro language mancante"); 
        }
        
        
        DateTimeFormatter df;

        switch (language) {
            case "it":
                df = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss", Locale.ITALY);
                return LocalDateTime.now().format(df);

            case "en":
                df = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
                return LocalDateTime.now().format(df);

            default:
                return "Formato non previsto";
        }

    }
}
