package main.model;

public class Room {

    int rid;
    int buildingid;
    String room;
    int capacity;
    String center;
    String building;

    public Room(){}

    public Room(int rid, int buildingid, String room, int capacity) {
        this.rid = rid;
        this.buildingid = buildingid;
        this.room = room;
        this.capacity = capacity;
    }

    public Room(int rid, int buildingid, String room, int capacity, String center, String building) {
        this.rid = rid;
        this.buildingid = buildingid;
        this.room = room;
        this.capacity = capacity;
        this.center = center;
        this.building = building;
    }

    public Room(String building, String room, int capacity) {
        this.building = building;
        this.room = room;
        this.capacity = capacity;
    }

    public Room(int buildingid, String room, int capacity) {
        this.buildingid = buildingid;
        this.room = room;
        this.capacity = capacity;
    }



    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(int buildingid) {
        this.buildingid = buildingid;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
