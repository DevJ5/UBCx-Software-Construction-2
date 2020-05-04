package model;

import java.util.ArrayList;
import java.util.List;

public class Room extends Option {

    private List<Monster> monsters;
    private List<Treasure> treasures;
    private List<Room> rooms;
    private List<Option> options;

    private int id;
    private String optionMessage;

    public Room(int id) {
        optionMessage = "Enter Room " + id + ".";
        this.id = id;
        monsters = new ArrayList<>();
        treasures = new ArrayList<>();
        rooms = new ArrayList<>();
        options = new ArrayList<>();

    }

    //EFFECTS: prints a message representing this possible next choice
    public void printOptionMessage() {
        System.out.println(optionMessage);
    }

    //EFFECTS: prints all possible next choices
    public void printOutcome() {
        System.out.println("You are now in Room " + id + ".\n");
        System.out.println("You have the following options: ");

        int counter = 1;
        for (Option option : options) {
            System.out.print("\tOption " + counter + ": ");
            option.printOptionMessage();
            counter++;
        }
//        for (Monster m: monsters) {
//            System.out.print("\tOption " + counter + ": ");
//            m.printOptionMessage();
//            counter++;
//        }
//
//        for (Treasure t: treasures) {
//            System.out.print("\tOption " + counter + ": ");
//            t.printOptionMessage();
//            counter++;
//        }
//
//        for (Room r: rooms) {
//            System.out.print("\tOption " + counter + ": ");
//            r.printOptionMessage();
//            counter++;
//        }
    }

    //MODIFIES: this
    //EFFECTS: adds m to next possible monsters
    public void addOption(Option o) {
        options.add(o);
    }
//    public void addMonster(Monster m) {
//        monsters.add(m);
//    }
//
//    //MODIFIES: this
//    //EFFECTS: adds t to next possible treasures
//    public void addTreasure(Treasure t) {
//        treasures.add(t);
//    }
//
//    //MODIFIES: this
//    //EFFECTS: adds r to next possible rooms
//    public void addRoom(Room r) {
//        rooms.add(r);
//    }

    //getters for gameplay
    public Monster getMonster(int i) {
        return monsters.get(i);
    }

    public Treasure getTreasure(int i) {
        return treasures.get(i);
    }

    public Option getOption(int i) {
        return options.get(i);
    }

    public Room getRoom(int i) {
        return rooms.get(i);
    }

    public int getMonsterRange() {
        return monsters.size();
    }

    public int getTreasureRange() {
        return treasures.size();
    }

    public int getRoomRange() {
        return rooms.size();
    }

}
