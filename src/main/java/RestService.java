import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("")
public class RestService {
    public RestService() {
    }

    @POST
    @Path("/action")
    @Consumes("application/json")
    @Produces("application/json")
    public String action(String request) {
        System.out.println(request);

        return request;
    }

}
