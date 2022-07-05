package org.rokol;

import Service.GreetingService;

import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/hello")
public class GreetingResource {

    @Inject
    GreetingService greetingService;

    private static final List<String> myList = new ArrayList<>();

    static {
        myList.add("Yep 1");
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return myList.toString();
    }


    @GET
    @Path("/hi")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return greetingService.sayHello();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String postMan(@QueryParam("text") String text){
        myList.add(text);
        return text;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String putMan(@PathParam("id") Integer index, String text){
        myList.remove((int)index);
        myList.add(index, text);
        return text;
    }

    @DELETE
    @Path("/{id}")
    public String deleteMan(@PathParam("id") Integer index, String text){
        myList.remove((int) index);
        return text;
    }
}