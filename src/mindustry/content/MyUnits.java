package mindustrymod.content;

import mindustry.type.UnitType;
import mindustrymod.content.units.M113;

public class MyUnits {
    public static UnitType M113;

    public static void load() {
        M113 = M113.create();
    }
}
