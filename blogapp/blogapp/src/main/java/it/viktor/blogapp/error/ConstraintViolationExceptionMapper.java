/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.viktor.blogapp.error;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException>{

    @Override
    public Response toResponse(ConstraintViolationException ex) {
        Response.ResponseBuilder rb = Response.status(Response.Status.BAD_REQUEST);
        ex.getConstraintViolations()
                .forEach(v -> rb.header("cased-by-" + v.getPropertyPath().toString(), v.getMessage()));
        return rb.build();
    }
    
}