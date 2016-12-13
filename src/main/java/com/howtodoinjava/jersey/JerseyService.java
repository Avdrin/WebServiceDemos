package com.howtodoinjava.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/messages")

public class JerseyService
{
    @GET
    public String getMsg()
    {
         return "Hello World !! 234 - Jersey 2";
    }
}
