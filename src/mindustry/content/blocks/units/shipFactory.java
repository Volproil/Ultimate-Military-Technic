package mindustry.content.blocks.units;

import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.blocks.units.UnitFactory;
import mindustry.content.Items;

public class shipFactory {
    public static UnitFactory factory;

    public static void load() {
        factory = new UnitFactory("ship-factory") {
            {
                requirements(Category.units, ItemStack.with(
                        Items.copper, 100,
                        Items.lead, 150,
                        Items.silicon, 80));

                size = 2;
                // Тень настраивается через спрайт блока
                researchCostMultiplier = 0.5f;

                hasShadow = false;
                plans.add(new UnitPlan(
                        mindustry.content.MyUnits.t1ship,
                        60f * 10, // 10 seconds to build
                        ItemStack.with(Items.copper, 30, Items.lead, 40)));

                consumePower(1f);
                consumeItems(new ItemStack(Items.copper, 5), new ItemStack(Items.lead, 8));

                // Research requirements are set via requirements() above
            }
        };
    }
}
