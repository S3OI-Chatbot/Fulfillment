import com.google.gson.Gson;
import database.FilmCommunicator;
import models.Film;
import models.requests.QueryResult;
import models.requests.Request;
import models.responses.Response;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.text.DecimalFormat;

@Path("")
public class RestService {
    public RestService() {
    }

    @POST
    @Path("/")
    @Consumes("application/json")
    @Produces("application/json")
    public String action(String request) {
        //System.out.println(request);

        Gson gson = new Gson();
        Request r = gson.fromJson(request, Request.class);

        Film film = FilmCommunicator.getInstance().readByName(r.getQueryResult().getParameters().getFilms().toLowerCase());

        if (film == null) {
            return gson.toJson(new Response("Helaas heb ik niks over de film '" + r.getQueryResult().getParameters().getFilms() + "' kunnen vinden."));
        }


        switch (r.getQueryResult().getIntent().getDisplayName()) {
            case "age limit replier" :
                return gson.toJson(new Response("De leeftijdscategorie voor " + film.getName() + " is " + film.getAgeLimit() + "+"));
            case "Cost replier":
                return gson.toJson(new Response("De kosten voor " + film.getName() + " zijn " + new DecimalFormat("€##.##").format(film.getPrice()) + " euro"));
            case "Duration replier":
                return gson.toJson(new Response(film.getName() + " duurt " + film.getDuration().getHours() + " uur en " + film.getDuration().getMinutes() + " minuten"));
        }



        return null;

    }

}
