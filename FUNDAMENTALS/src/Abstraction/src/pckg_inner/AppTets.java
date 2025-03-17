package pckg_inner;

public class AppTets {

    public static void main(String[] args) {
        Building building = new Building("Sezam", 23, 3);
        building.provideBuildingInfo();
        Building.BuildingFloor floor = building.new BuildingFloor();
        floor.getFloorInfo();
        building.getSomeFloorInfo();
    }
}
