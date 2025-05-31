package mindustry.content;

import mindustry.world.blocks.units.UnitFactory;

public class MyBlocks {
    public static UnitFactory factory;
    public static UnitFactory unitFabricator;

    public static void load() {
        // Initialize the factory
        mindustry.content.blocks.units.shipFactory.load();
        factory = mindustry.content.blocks.units.shipFactory.factory;
        
        mindustry.content.blocks.units.UnitFabricator.load();
        unitFabricator = mindustry.content.blocks.units.UnitFabricator.tankFabricator;
        // Register the block with the game's content system
        factory.load();
        unitFabricator.load();
        // The block is automatically registered when created in the factory
        // No need for additional registration in Mindustry v7+
    }
}
