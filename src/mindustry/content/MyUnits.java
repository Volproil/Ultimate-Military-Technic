package mindustry.content;

import mindustry.type.UnitType;

public class MyUnits {
    public static UnitType M113;

    public static void load() {
        M113 = mindustry.content.units.M113.createM113();
    }
}
