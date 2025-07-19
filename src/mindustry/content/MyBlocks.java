package mindustry.content;

import mindustry.world.blocks.units.UnitFactory;
import mindustry.content.MyTurrets; // <--- ИСПРАВЛЕННЫЙ ИМПОРТ: MyTurrets теперь в том же пакете

public class MyBlocks {
    public static UnitFactory factory;
    public static UnitFactory unitFabricator;

    public static void load() {
        // Инициализация фабрики кораблей
        // Путь к shipFactory и UnitFabricator предполагается правильным, исходя из вашего кода
        mindustry.content.blocks.units.shipFactory.load();
        factory = mindustry.content.blocks.units.shipFactory.factory;
        
        mindustry.content.blocks.units.UnitFabricator.load();
        unitFabricator = mindustry.content.blocks.units.UnitFabricator.tankFabricator;
        
        factory.load();
        unitFabricator.load();
        
        // Загрузка ваших кастомных турелей
        MyTurrets.load(); 
    }
}