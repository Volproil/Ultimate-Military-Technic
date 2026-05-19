package mindustry.content;
import mindustry.content.units.M163VADS;
import mindustry.content.units.T28;
import mindustry.type.UnitType;

public class MyUnits {
    public static UnitType M113;
    public static UnitType fpvdrone1;
    public static UnitType t1ship;
    public static UnitType ATGMVehicle;
    public static UnitType towrocket;
    public static UnitType MIM72;
    public static UnitType M163VADS;
    public static UnitType m2bradley;
    public static UnitType abrams;
    public static UnitType M247SergeantYork;
    public static UnitType T28;
    public static UnitType Gepard;
    public static UnitType Ratte;
    public static UnitType M270MLRS;

    public static void load() {
        t1ship = mindustry.content.units.t1ship.createUnit();
        M113 = mindustry.content.units.M113.createM113();
        fpvdrone1 = mindustry.content.units.fpvdrone1.createFPVKamikaze();
        ATGMVehicle = mindustry.content.units.ATGMVehicle.createATGMVehicle();
        towrocket = mindustry.content.units.towrocket.createtowrocket();
        MIM72 = mindustry.content.units.MIM72.createMIM72();
        M163VADS = mindustry.content.units.M163VADS.createM163VADS();
        m2bradley = mindustry.content.units.M2Bradley.createM2Bradley();
        abrams = mindustry.content.units.abrams.createabrams();
        M247SergeantYork = mindustry.content.units.M247SergeantYork.createM247SergeantYork();
        T28 = mindustry.content.units.T28.createT28();
        Gepard = mindustry.content.units.Gepard.createGepard();
        Ratte  = mindustry.content.units.Ratte.createRatte();
        M270MLRS = mindustry.content.units.M270MLRS.createM270MLRS();
    }
}




