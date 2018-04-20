package GameBlackBox;

import model.Coin;

import java.util.ArrayList;
import java.util.List;

public class BoardInit {
    public List<Coin> initializeBoard(int coinCount){
        if(coinCount == 0){
            return new ArrayList<>();
        }else{
            Coin coin;
            List<Coin> board = new ArrayList<>();

            coin = new Coin();
            coin.setCoinId("coin1");
            coin.setPosition((BoardDefination.BOARD_DIMENTION/2)+":"+(BoardDefination.BOARD_DIMENTION/2));
            coin.setCoinType("red");

            board.add(coin);

            int innerCoinCount = coinCount > 6 ? 6 : coinCount;
            double angleBetweenCoins = 360 / innerCoinCount;

            while(innerCoinCount >= board.size()){

                double angleWithBase = angleBetweenCoins * (board.size() - 1);
                double base =  Math.ceil(Math.cos(Math.toRadians(angleWithBase ))*BoardDefination.COIN_RADIUS * 2);
                double height =  Math.ceil(Math.sin(Math.toRadians(angleWithBase))*BoardDefination.COIN_RADIUS * 2);

                coin = new Coin();
                coin.setCoinId("coin" + (board.size() + 1));
                coin.setPosition((BoardDefination.BOARD_DIMENTION/2 + base)+":"+(BoardDefination.BOARD_DIMENTION/2 + height));
                if (board.size()%2 == 0)
                    coin.setCoinType("black");
                else
                    coin.setCoinType("white");

                board.add(coin);
            }

           // int outerCoinCount = coinCount - innerCoinCount;
            double angleBetweenCoinsOuter = 30;

            while(coinCount > board.size()){
                double angleWithBase = angleBetweenCoinsOuter * (board.size() - 1);

                double base ;
                double height;

                if(angleWithBase % 60 == 0) {
                    base = Math.ceil(Math.cos(Math.toRadians(angleWithBase)) * BoardDefination.COIN_RADIUS * 4);
                    height = Math.ceil(Math.sin(Math.toRadians(angleWithBase)) * BoardDefination.COIN_RADIUS * 4);
                }else{
                    base = Math.ceil(Math.cos(Math.toRadians(angleWithBase)) * BoardDefination.COIN_RADIUS * Math.sqrt(12));
                    height = Math.ceil(Math.sin(Math.toRadians(angleWithBase)) * BoardDefination.COIN_RADIUS * Math.sqrt(12));
                }

                coin = new Coin();
                coin.setCoinId("coin" + (board.size() + 1));
                coin.setPosition((BoardDefination.BOARD_DIMENTION/2 + base)+":"+(BoardDefination.BOARD_DIMENTION/2 + height));
                if (board.size()%2 == 0)
                    coin.setCoinType("black");
                else
                    coin.setCoinType("white");

                board.add(coin);
            }


/*            coin = new Coin();
            coin.setCoinId("striker");
            coin.setPosition(BoardDefination.STRIKER_INIT_POSITIONS);
            coin.setCoinType("striker");

            board.add(coin);*/

            return board;
        }
    }
}
