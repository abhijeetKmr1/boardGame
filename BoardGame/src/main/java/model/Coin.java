package model;

public class Coin {
    String coinType;
    String coinId;
    String position;
    int angleMovement;
    int velocity;

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }

    public String getCoinId() {
        return coinId;
    }

    public void setCoinId(String coinId) {
        this.coinId = coinId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAngleMovement() {
        return angleMovement;
    }

    public void setAngleMovement(int angleMovement) {
        this.angleMovement = angleMovement;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}
