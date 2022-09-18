package space_challenge;

public class Rocket implements SpaceShip{
    public int rocketWeight;
    public int MAX_WEIGHT;
    public int COST;

    public boolean launch(){
        return true;
    }

    public boolean land(){
        return true;
    }

    public boolean canCarry(Item item){
        return (rocketWeight+item.weight<=MAX_WEIGHT) ? true : false;
    }

    public void carry(Item item){
        rocketWeight += item.weight;
    }
}
