package server.controllers;

import com.google.gson.Gson;
import server.model.Account;
import server.repository.AccountRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Contains the endpoints for account operations.
 */

@Path("/accounts")
public class AccountController {

    private AccountRepository accountRepository;

    public AccountController()
    {
        this.accountRepository = new AccountRepository();
    }


    /**
     * Gets all customers from the database
     * @return Response to the client.
     */
    @GET
    public Response getAccounts(){
        // Get a list of users
        ArrayList<Account> accounts = accountRepository.getAccountsForCustomer();
        String out = new Gson().toJson(accounts);

        // Return the users with the status code 200
        return Response.status(200).type(MediaType.APPLICATION_JSON).entity(out).build();
    }

    /**
     * Creates a customer from a JSON encoded representation of a customer object.
     * @return A response indicating if the creation went well.
     */
    @POST
    public Response createAccount(String account) {

        Account account1 = new Gson().fromJson(account, Account.class);

        accountRepository.createAccount(account1);

        return Response
                .status(200)
                .type("application/json")
                .entity("{\"userCreated\":\"true\"}")
                .build();
    }

    /**
     * Updates a customer from a JSON String representing a full JSON object.
     * Matches the customer based on the primary key.
     * @return A JSON Object with e
     */
    @PUT
    public Response withdraw(String account) {

        Account account1 = new Gson().fromJson(account, Account.class);

        accountRepository.withdraw(account1);

        return Response
                .status(200)
                .type("application/json")
                .entity("{\"userUpdated\":\"true\"}")
                .build();

    }
    @GET
    @Path("{id}")
    public Response getAccount(@PathParam("id") int id){
        Account account = accountRepository.getAccount(id);
        String output = new Gson().toJson(account);
        System.out.println(output);

        return Response
                .status(200)
                .type("application/json")
                .entity(output)
                .build();
    }
}




//Todo: Add the needed account endpoints here.

