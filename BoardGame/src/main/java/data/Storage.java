package data;

import java.util.List;

public class Storage {
    private static String playerName;
    private static List boardPosition;

    public static String getPlayerName() {
        return playerName;
    }

    public static void setPlayerName(String playerName) {
        Storage.playerName = playerName;
    }

    public static List getBoardPosition() {
        return boardPosition;
    }

    public static void setBoardPosition(List boardPosition) {
        Storage.boardPosition = boardPosition;
    }
}
