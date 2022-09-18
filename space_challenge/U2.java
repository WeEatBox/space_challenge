package space_challenge;

import java.util.Random;

public class U2 extends Rocket{

    //this.MAX_WEIGHT = 29000;
    //this.rocketWeight = 18000;
    //this.COST = 120;
    public U2(int MAX_WEIGHT, int rocketWeight, int COST){
        this.MAX_WEIGHT = MAX_WEIGHT;
        this.rocketWeight = rocketWeight;
        this.COST = COST;
    }

    public boolean launch(){
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;

        if (n > 4*((double)rocketWeight/MAX_WEIGHT))
            return true;
        else
            return false;
    }

    public boolean land(){
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;

        if (n > 8*((double)rocketWeight/MAX_WEIGHT))
            return true;
        else
            return false;
    }

}
