package space_challenge;

public interface SpaceShip{
    
    boolean launch();

    boolean land();

    boolean canCarry(Item item);

    void carry(Item item);
}
