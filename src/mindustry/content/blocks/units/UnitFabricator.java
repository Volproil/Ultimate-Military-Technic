package mindustry.content.blocks.units;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.content.Items;

public class MyBlocks {
    public static UnitFactory tankFabricator;

    public static void load() {
        tankFabricator = new UnitFactory("tank-fabricator") {{
            // Базовые параметры
            localizedName = "Armored Vehicle Factory";
            description = "Produces military vehicles and drones";
            health = 1800;
            size = 3;
            itemCapacity = 350;

            // Потребление энергии
            consumePower(3f);

            // План 1: FPV Kamikaze Drone
            plans.add(new UnitPlan(
                MyUnits.fpvdrone1,
                1500,
                ItemStack.with(
                    Items.copper, 80,
                    Items.silicon, 60,
                    Items.graphite, 30
                )
            ));

            // План 2: ATGM Vehicle
            plans.add(new UnitPlan(
                MyUnits.ATGMVehicle,
                2400,
                ItemStack.with(
                    Items.copper, 120,
                    Items.silicon, 100,
                    Items.titanium, 60
                )
            ));

            // План 3: M113 APC
            plans.add(new UnitPlan(
                MyUnits.M113,
                2100,
                ItemStack.with(
                    Items.lead, 150,
                    Items.copper, 100,
                    Items.silicon, 70
                )
            ));

            // Ресурсы для постройки фабрики
            requirements(Category.units, ItemStack.with(
                Items.titanium, 200,
                Items.silicon, 180,
                Items.lead, 250
            ));
        }};

        // Загрузка фабрики
        tankFabricator.load();
    }
}
