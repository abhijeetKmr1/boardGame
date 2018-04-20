package Services;

import GameBlackBox.BoardInit;
import data.Storage;
import model.Coin;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/carrom")
public class BoardServicesImpl {
    @GET
    @Path("/initializeBoard/{coinCount}/{playName}")
    public List<Coin> initializeBoard(@PathParam("coinCount") int coinCount, @PathParam("playName") String playerName) {
        Storage.setPlayerName(playerName);
        Storage.setBoardPosition((new BoardInit()).initializeBoard(coinCount));
        return Storage.getBoardPosition();
    }

    @POST
    @Path("/strike_hit")
    public String StrikeHit(String strike) {
        return null;
    }
}
