package mindustry.content;
import mindustry.type.UnitType;

public class MyUnits {
    public static UnitType M113;
    public static UnitType fpvdrone1;
    //public static UnitType t1ship;
    public static UnitType ATGMVehicle;
    public static UnitType towrocket;

    public static void load() {
        //t1ship = mindustry.content.units.t1ship.createUnit();
        M113 = mindustry.content.units.M113.createM113();
        fpvdrone1 = mindustry.content.units.fpvdrone1.createFPVKamikaze();
        ATGMVehicle = mindustry.content.units.ATGMVehicle.createATGMVehicle();
        //towrocket = mindustry.content.units.Towrocket.createTowrocket();
    }
}




