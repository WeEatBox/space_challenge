import space_challenge.*;

import java.io.*;
import java.util.*;

public class Simulation{

    public ArrayList<Item> loadItems(String fileName) {
        ArrayList<Item> items = new ArrayList<>();
        try{
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] parts = line.split("=");
                Item item = new Item(parts[0], Integer.valueOf(parts[1]));
                items.add(item);
            }
        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }

        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items){
        ArrayList<Rocket> U1List = new ArrayList<>();
        
        while (!items.isEmpty()){
            U1 u1 = new U1(18000, 10000, 100);
            while (items.size()!=0 && u1.canCarry(items.get(0))){
                u1.carry(items.remove(0));
            }
            U1List.add(u1);
        }
        return U1List;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items){
        ArrayList<Rocket> U2List = new ArrayList<>();
        
        while (!items.isEmpty()){
            U2 u2 = new U2(29000, 18000, 120);
            while (items.size()!=0 && u2.canCarry(items.get(0))){
                u2.carry(items.remove(0));
            }
            U2List.add(u2);
        }
        return U2List;
    }

    public int runSimulation(ArrayList<Rocket> rockets){
        int budget = 0; 
        while (!rockets.isEmpty()){
            // load first time, if launch or land failed, load again
            do{
                budget += rockets.get(0).COST;
                // if launch OR land failed, need a new budget for rocket
            }while (!rockets.get(0).launch() || !rockets.get(0).land());
            // remove loaded rocket from list
            rockets.remove(0);
        }
        return budget;
    }

    public static void main(String[] args){
        int totalBudget = 0;
        Simulation simulation = new Simulation();
        
        ArrayList<Item> items = new ArrayList<>();
        items.addAll(simulation.loadItems("phase-1.txt"));
        items.addAll(simulation.loadItems("phase-2.txt"));

        ArrayList<Rocket> rockets = new ArrayList<>();
        rockets.addAll(simulation.loadU1(items));
        
        totalBudget += simulation.runSimulation(rockets); 
        System.out.println("U1 budget = " + totalBudget);



        int totalBudget2 = 0;
        Simulation simulation2 = new Simulation();
        
        ArrayList<Item> items2 = new ArrayList<>();
        items2.addAll(simulation2.loadItems("phase-1.txt"));
        items2.addAll(simulation2.loadItems("phase-2.txt"));

        ArrayList<Rocket> rockets2 = new ArrayList<>();
        rockets2.addAll(simulation2.loadU2(items2));
        
        totalBudget2 += simulation2.runSimulation(rockets2); 
        System.out.println("U2 budget = " + totalBudget2);
    }
}

