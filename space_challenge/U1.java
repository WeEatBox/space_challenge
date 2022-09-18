package space_challenge;

import java.util.Random;

public class U1 extends Rocket{

   // MAX_WEIGHT = 18000;
   // this.rocketWeight = 10000;
   // this.COST = 100;
    public U1(int MAX_WEIGHT, int rocketWeight, int COST){
        this.MAX_WEIGHT = MAX_WEIGHT;
        this.rocketWeight = rocketWeight;
        this.COST = COST;
    }

    public boolean launch(){
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;

        if (n > 5*((double)rocketWeight/MAX_WEIGHT))
            return true;
        else
            return false;
    }

    public boolean land(){
        Random rand = new Random();
        int n = rand.nextInt(100) + 1;

        if (n > 1*((double)rocketWeight/MAX_WEIGHT))
            return true;
        else
            return false;
    }

}
