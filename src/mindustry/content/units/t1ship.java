package mindustry.content.units;

import arc.Core;
import arc.graphics.Color;
import mindustry.type.UnitType;
import mindustry.type.unit.ErekirUnitType;
import mindustry.gen.UnitEntity;
import mindustry.type.Weapon;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.Vars;

public class t1ship {
    public static UnitType createUnit() {
        return new UnitType("t1ship") {{
            description = "t1 ship";
            health = 80;
            speed = 1.3f;
            rotateSpeed = 2.6f;
            constructor = UnitEntity::create;

            weapons.add(new Weapon("umt-java-t1turret") {{
                x = 0;
                y = 0;
                rotate = true;
                top = true;
                reload = 20f;
                layerOffset = 3;

                bullet = new BasicBulletType() {{
                    speed = 3f;
                    damage = 15f;
                    lifetime = 60f;
                    width = 7f;
                    height = 9f;
                    frontColor = Color.valueOf("ff9966");
                    backColor = Color.valueOf("ff6633");
                }};
            }});
            load();
        }};
    }
}
