package Model;

import java.util.List;

public class Building {

    String buildingName;
    List<Floor> floorList;

    public Building(String buildingName, List<Floor> floorList) {
        this.buildingName = buildingName;
        this.floorList = floorList;
    }
}
