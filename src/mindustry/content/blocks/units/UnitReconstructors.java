package mindustry.content.blocks.units;

import mindustry.content.Blocks;
import mindustry.content.MyUnits;
import mindustry.world.blocks.units.Reconstructor;

public class UnitReconstructors {

    public static void addUpgrades() {
        Reconstructor additive       = (Reconstructor) Blocks.additiveReconstructor;
        Reconstructor multiplicative = (Reconstructor) Blocks.multiplicativeReconstructor;
        Reconstructor exponential    = (Reconstructor) Blocks.exponentialReconstructor;
        Reconstructor tetrative      = (Reconstructor) Blocks.tetrativeReconstructor;

        additive.addUpgrade(MyUnits.M113, MyUnits.m2bradley);
        additive.addUpgrade(MyUnits.M163VADS, MyUnits.M247SergeantYork);
        additive.addUpgrade(MyUnits.ATGMVehicle, MyUnits.MIM72);

        multiplicative.addUpgrade(MyUnits.MIM72, MyUnits.M270MLRS);
        multiplicative.addUpgrade(MyUnits.m2bradley, MyUnits.abrams);
        multiplicative.addUpgrade(MyUnits.M247SergeantYork, MyUnits.Gepard);


        exponential.addUpgrade(MyUnits.abrams, MyUnits.T28);


        tetrative.addUpgrade(MyUnits.T28, MyUnits.Ratte);




    }
}
