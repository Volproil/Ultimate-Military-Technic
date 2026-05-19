package mindustry.content;
import mindustry.content.blocks.units.UnitReconstructors;
public class ModContent {
    public static void load() {
        MyUnits.load();
        MyBlocks.load();
        UnitReconstructors.addUpgrades();
    }
}
