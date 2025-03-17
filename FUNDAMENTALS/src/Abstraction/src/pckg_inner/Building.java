package pckg_inner;

public class Building {
    private String street;
    private int number;
    private int numberOfFloors;
    private BuildingFloor[] floors;
    private static final int MAXFLOORS = 20;


    public Building(String street, int number){
        this.number = number;
        this.street = street;
        buildBuilding();
        numberOfFloors = 0;
    }

    public Building(String street, int number, int numberOfFloors){
        this(street, number);
        this.numberOfFloors = numberOfFloors;
        buildBuilding();
    }

    public void provideBuildingInfo(){
        System.out.println("Street: " + street);
        System.out.println("Number: " + number);
        System.out.println(getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()));
        for(BuildingFloor floor:floors){
            floor.getFloorInfo();
        }

    }

    class BuildingFloor {

        public void getFloorInfo(){
            System.out.println(getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()));
            System.out.println("This is some building floor info...");
        }
    }

    public void getSomeFloorInfo(){
        BuildingFloor buildingFloor = new BuildingFloor();
        buildingFloor.getFloorInfo();
    }

    private void buildBuilding(){
        floors = new BuildingFloor[numberOfFloors];
        for(int k = 0; k<numberOfFloors; k++){
            floors[k] = new BuildingFloor();
        }
    }
    public void specialLocalBuildingFeature(){
        class BuildingCompanyService{
            String name;
            String registeredIn;

            BuildingCompanyService(String name, String registeredIn){
                this.name = name;
                this.registeredIn = registeredIn;
            }
            void performSomeServiceOnBuilding(){
                System.out.println("Performing maintenance on: " + street);
            }
        }
        BuildingCompanyService buildingCompanyService = new BuildingCompanyService("SV", "-CRO");
        buildingCompanyService.performSomeServiceOnBuilding();
    }
}
