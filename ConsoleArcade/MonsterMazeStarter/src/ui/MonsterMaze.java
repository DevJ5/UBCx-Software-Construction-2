package ui;

import model.Monster;
import model.Room;
import model.Treasure;

public class MonsterMaze {

    public static void main(String[] args) throws InterruptedException {
        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Room r3 = new Room(3);
        Room r4 = new Room(4);
        Room r5 = new Room(5);
        Room r6 = new Room(6);

        Monster m1 = new Monster();
        Monster m2 = new Monster();
        Monster m3 = new Monster();

        Treasure t1 = new Treasure(100);

        m3.setTreasure(t1);

        r1.addOption(r2);
        r1.addOption(r4);
        r1.addOption(m1);

        r2.addOption(r3);
        r2.addOption(r6);

        r3.addOption(m3);

        r4.addOption(r5);

        r5.addOption(m2);

        r6.addOption(t1);

        Game g = new Game(r1);
    }



}
