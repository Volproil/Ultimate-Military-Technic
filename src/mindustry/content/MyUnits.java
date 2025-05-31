package mindustry.content;
import mindustry.type.UnitType;

public class MyUnits {
    public static UnitType M113;
    public static UnitType fpvKamikaze;
    public static UnitType t1ship;

    public static void load() {
        t1ship = mindustry.content.units.t1ship.createUnit();
        M113 = mindustry.content.units.M113.createM113();
        fpvKamikaze = FPVDrone1.createFPVKamikaze();
    }
}
