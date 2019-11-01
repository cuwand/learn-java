package com.dwbook.phonebook.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import com.dwbook.phonebook.representations.*;
import com.dwbook.phonebook.dao.*;
import java.net.*;
import org.skife.jdbi.v2.DBI;
import io.dropwizard.jdbi.DBIFactory;
import java.util.Set;
import javax.validation.ConstraintViolation;
import java.util.*;
import javax.validation.Validator;
import javax.ws.rs.core.Response.Status;

@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {
    // code...
    private final ContactDAO contactDao;
    private final Validator validator;
    public ContactResource(DBI jdbi, Validator validator) {
        contactDao = jdbi.onDemand(ContactDAO.class);
        this.validator = validator;
    }

    @GET
    @Path("/{id}")
    public Response getContact(@PathParam("id") int id) {
        // retrieve information about the contact with the provided id
        // ...
        Contact contact = contactDao.getContactById(id);
        System.out.println(contact);
        return Response
            .ok(contact)
            .build();
    }

    @POST
    public Response createContact(
        Contact contact) throws URISyntaxException {
        // store the new contact
        // Validate the contact's data
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
        // Are there any constraint violations?
        if (violations.size() > 0) {
            // Validation errors occurred
            ArrayList<String> validationMessages = new ArrayList<String>();

            for (ConstraintViolation<Contact> violation : violations) {
               validationMessages.add(violation.getPropertyPath().toString() + ":" + 
                                      violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST)
                           .entity(validationMessages)
                           .build();
        }

        // OK, no validation errors
        int newContactId = contactDao.createContact(contact.getFirstName(),
                                                    contact.getLastName(), 
                                                    contact.getPhone());
        return Response.created(new URI(String.valueOf(newContactId))).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteContact(@PathParam("id") int id) {
        // delete the contact with the provided id
        contactDao.deleteContact(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateContact(
        @PathParam("id") int id,
        Contact contact) {
        // update the contact with the provided ID
        // Validate the contact's data
        Set<ConstraintViolation<Contact>> violations = validator.validate(contact);
        // Are there any constraint violations?
        if (violations.size() > 0) {
            // Validation errors occurred
            ArrayList<String> validationMessages = new ArrayList<String>();

            for (ConstraintViolation<Contact> violation : violations) {
               validationMessages.add(violation.getPropertyPath().toString() + ":" + 
                                      violation.getMessage());
            }
            return Response.status(Status.BAD_REQUEST)
                           .entity(validationMessages)
                           .build();
        }
        contactDao.updateContact(id, contact.getFirstName(), 
                                 contact.getLastName(), contact.getPhone());
        return Response
            .ok(new Contact(id, contact.getFirstName(), contact.getLastName(), contact.getPhone()))
            .build();
    }
}
