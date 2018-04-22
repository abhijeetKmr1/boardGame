package GameBlackBox;

public class CoinMovementController {




    void CalculateMovement(int force, int angle){

    }



	public Coin collideWall(String strikerPosition, double strikerAngle, double velocity) {
		String[] s = strikerPosition.split(":");
		int x = Integer.parseInt(s[0]);
		int y = Integer.parseInt(s[1]);
		double x2 = 0, y2;
		y2 = (BoardDefination.BOARD_DIMENTION - x) * Math.tan(Math.toRadians(strikerAngle));
		if (strikerAngle < 90 && strikerAngle > 0) {
		    if (y2 < BoardDefination.BOARD_DIMENTION) {
		        x2 = BoardDefination.BOARD_DIMENTION;
		        strikerAngle = strikerAngle + 90;
		    } else if (y2 > BoardDefination.BOARD_DIMENTION) {
		        y2 = BoardDefination.BOARD_DIMENTION;
		        x2 = x + y2 / Math.tan(Math.toRadians(strikerAngle));
		        //change angel
		        strikerAngle = 360 - strikerAngle;
		    } else if (y2 == BoardDefination.BOARD_DIMENTION) {
		        System.out.println("in to the pocket");
		    }

		} else if (strikerAngle == 90) {
		    x2 = x;
		    y2 = BoardDefination.BOARD_DIMENTION;
		} else if (strikerAngle > 90 && strikerAngle < 180) {
		    if (y2 < BoardDefination.BOARD_DIMENTION) {
		        x2 = BoardDefination.BOARD_DIMENTION;
		        strikerAngle = 180 + strikerAngle;
		    } else if (y2 > BoardDefination.BOARD_DIMENTION) {
		        y2 = BoardDefination.BOARD_DIMENTION;
		        x2 = x - y2 / Math.tan(Math.toRadians(strikerAngle));
		        strikerAngle = 360 - strikerAngle;
		    } else if (y2 == BoardDefination.BOARD_DIMENTION) {
		        System.out.println("in to the pocket");
		    }
		} else if (strikerAngle > 180 && strikerAngle < 270) {
		    strikerAngle = strikerAngle - 180;
		    y2 = x * Math.tan(strikerAngle);
		    if (y2 > BoardDefination.BOARD_DIMENTION) {
		        y2 = BoardDefination.BOARD_DIMENTION;
		        x2 = x - y2 / Math.tan(Math.toRadians(strikerAngle));
		        strikerAngle = 180 + strikerAngle;
		    } else if (y2 < BoardDefination.BOARD_DIMENTION) {
		        x2 = 0;
		        strikerAngle = 360 - strikerAngle;
		    } else if (y2 == BoardDefination.BOARD_DIMENTION) {
		        System.out.println("in to the pocket");
		    }
		} else {
		    strikerAngle = strikerAngle - 270;
		    x2 = y * Math.tan(strikerAngle);
		    if (x2 > BoardDefination.BOARD_DIMENTION) {
		        x2 = BoardDefination.BOARD_DIMENTION;
		        y2 = x - y2 / Math.tan(Math.toRadians(strikerAngle));
		        strikerAngle = 270 - strikerAngle;
		    } else if (x2 < BoardDefination.BOARD_DIMENTION) {
		        y2 = 0;
		        strikerAngle = 90 - strikerAngle;
		    } else if (x2 == BoardDefination.BOARD_DIMENTION) {
		        System.out.println("in to the pocket");
		    }
		}
		x2 = (int) Math.ceil(x2);
		y2 = (int) Math.ceil(y2);
		String newPosition = "" + x2 + ":" + y2 + "";
		Coin coin = new Coin();
		coin.setPosition(newPosition);
		double dist = getDistance(strikerPosition, newPosition);
		coin.setAngleMovement((int) strikerAngle);
		coin.setVelocity((int) velocity);
		double distanceCanGo = getMaxDistance(velocity);
		if (distanceCanGo > dist) {
		    System.out.println(" update the coin position");

		} else {
		    System.out.println("its not colliding ");
		}

		return coin;
    	}

	private double getMaxDistance(double velocity) {
		double mu = 0.2;
		double g = 9.8;
		return velocity * velocity / 2 * mu * g;
	}

	private double getDistance(String strikerPosition, String newPosition) {
		String pos[] = (strikerPosition.split(":"));
		int x1 = Integer.parseInt(pos[0]);
		System.out.println("x1=" + x1);
		int y1 = Integer.parseInt(pos[1]);
		String pos2[] = (newPosition.split(":"));
		System.out.println("x2 as string" + pos2[0]);
		float x2 = Float.parseFloat(pos2[0]);
		System.out.println("x2=" + x2);
		float y2 = Float.parseFloat(pos2[1]);
		return Math.sqrt(Math.pow(x2 - x1, 2) + (Math.pow(y2 - y1, 2) * 1.0));
	}




	private Coin getCollidingCoin(String strikerPosition, double strikerAngle) {
		int strikerRadius = 10;
		int coinRadius = 8;
		List<Coin> coinList = new ArrayList<>();
		String[] StrikerCoodinates = strikerPosition.split(":");
		double striker_x = Double.parseDouble(StrikerCoodinates[0]);
		double striker_y = Double.parseDouble(StrikerCoodinates[1]);

		double coeff = (double) ((strikerRadius + coinRadius) / Math.toRadians(strikerAngle));

		double c1 = striker_y - Math.tan(Math.toRadians(strikerAngle)) * (striker_x - coeff);
		double c2 = striker_y - Math.tan(Math.toRadians(strikerAngle)) * (striker_x + coeff);

		Coin nearestCoin = null;
		double nearestDistance = 0;
		List<Coin> board = Storage.getBoardPosition();
		for (Coin coin : board) {
		    int x = Integer.parseInt(coin.getPosition().split(":")[0]);
		    int y = Integer.parseInt(coin.getPosition().split(":")[1]);

		    double c = (double) (y - Math.tan(Math.toRadians(strikerAngle)) * x);

		    if (c1 > c && c > c2) {
		        double dist = Math.sqrt(Math.pow(striker_x - x, 2) + (Math.pow(striker_y - y, 2) * 1.0));
		        if(nearestCoin == null){
		            nearestDistance = dist;
		            nearestCoin = coin;
		        }
		        else if(dist < nearestDistance){
		            nearestDistance = dist;
		            nearestCoin = coin;
		        }
		    }
		}

        	return nearestCoin;
    	}


	public String getPositionofCollision(float angle,Coin coin,Coin striker){

		String[] coordinates = striker.getPosition().split(":");
		
		double x_striker = Double.parseDouble(coordinates[0]);
		double y_striker = Double.parseDouble(coordinates[1]);

		int strikerRadius = BoardDefination.STRIKER_RADIUS;
		int coinRadius =BoardDefination.COIN_RADIUS;

		String[] coin_coordinates = striker.getPosition().split(":");

		double x_coin = Double.parseDouble(coin_coordinates[0]);
		double y_coin = Double.parseDouble(coin_coordinates[1]);
		
		int combinedRadius = strikerRadius+coinRadius;
		/**
		 * equation of line passing through center of striker along given direction
		 * y= tan(theta)x+y0-x0*tan(theta)
		 *
		 */
		double k1 = Math.pow(combinedRadius,2)- Math.pow(x_coin,2)-Math.pow(y_coin,2);
		double k2 = k1 - Math.pow(y_striker, 2) - (2 * y_striker * y_coin);

		double k3 = k2 + (2 * x_striker * y_striker * Math.tan(Math.toRadians(angle))) + (2 * x_striker * y_coin * Math.tan(Math.toRadians(angle)));

		double k4 = k3 - Math.pow(x_striker, 2) * Math.pow(Math.tan(Math.toRadians(angle)) , 2);
		System.out.println("k4="+k4);

		double a = 1 + Math.pow(Math.tan(Math.toRadians(angle)), 2);
		double b = (-2 * x_striker * Math.pow(Math.tan(Math.toRadians(angle)), 2)) + ( 2 * y_striker * Math.tan(Math.toRadians(angle))) -(2 * x_coin) + (2 * Math.tan(Math.toRadians(angle)) * y_coin);
		double c = (-1) * k4;
		double D=Math.abs(Math.pow(b, 2) - 4*a*c);
		System.out.println("a="+a+"b="+b+"c="+c+"d= "+D);
		if(D>0) {
		    D=Math.sqrt(D);
		    double x_stricker1 = (-b + D) / (2 * a);
		    double x_stricker2 = (-b - D) / (2 * a);
		    double y_stricker1 = x_striker + Math.tan(Math.toRadians(angle)) * (x_stricker1 - x_striker);
		    double y_stricker2 = x_striker + Math.tan(Math.toRadians(angle)) * (x_stricker2 - x_striker);

		    if(x_stricker1>0 && y_stricker1>0){
		        return x_stricker1+":"+y_stricker1;
		    }
		}
		    
		return null;
	}
}


