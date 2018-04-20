package Services;

import GameBlackBox.BoardInit;
import data.Storage;
import model.Coin;
import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Path("/carrom")
@Produces("application/json")
@Consumes("application/json")
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
    public List<List<Coin>> StrikeHit(String strike) {
        List<List<Coin>> boards = new ArrayList<>();
        List<Coin> board = new ArrayList<>();

        Coin coin = new Coin();
        coin.setCoinId("striker");
        coin.setPosition("300:400");
        coin.setCoinType("blue");

        board.add(coin);
        boards.add(board);
        // board.put("Coordinates", (new CoinMovementController()).CalculateMovement(strikeJson.optDouble("force"),strikeJson.optDouble("angle"),strikeJson.optString("strikePos")));
        return boards;
    }
}
