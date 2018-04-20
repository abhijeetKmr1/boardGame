package data;

import model.Coin;

import java.util.List;

public class Storage {
    private static String playerName;
    private static List<Coin> boardPosition;

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        Storage.playerName = playerName;
    }

    public static List<Coin> getBoardPosition() {
        return boardPosition;
    }

    public static void setBoardPosition(List<Coin> boardPosition) {
        Storage.boardPosition = boardPosition;
    }
}
