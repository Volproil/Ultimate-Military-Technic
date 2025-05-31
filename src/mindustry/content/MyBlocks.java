package mindustry.content;

import mindustry.world.blocks.units.UnitFactory;

public class MyBlocks {
    public static UnitFactory factory;

    public static void load() {
        // Initialize the factory
        mindustry.content.blocks.units.shipFactory.load();
        factory = mindustry.content.blocks.units.shipFactory.factory;
        
        tankFabricator = new UnitFabricator("tank-fabricator");
        // Register the block with the game's content system
        factory.load();
        tankFabricator.load();
        // The block is automatically registered when created in the factory
        // No need for additional registration in Mindustry v7+
    }
}
