package mindustry.content.units;

import arc.graphics.Color;
import mindustry.type.UnitType;
import mindustry.gen.UnitEntity;
import mindustry.type.Weapon;
import mindustry.entities.bullet.BasicBulletType;

public class t1ship {
    public static UnitType createUnit() {
        return new UnitType("t1ship") {{
            description = "t1 ship"; //Localized description & details. May be null.
            health = 80;             //Unit health
            speed = 1.5f;            //Unit speed
            rotateSpeed = 2.6f;      //Unit rotation speed
            range = 23;             //Unit fire range
            flying = false;          //If true, the unit can fly
            rotateMoveFirst = true;  //If true, the unit can rotate before moving

            constructor = UnitEntity::create;

            weapons.add(new Weapon("umt-java-t1turret") {{
                x = 0;
                y = -2;
                rotate = true;
                rotateSpeed = 6;
                reload = 60;
                //layerOffset = 1;
                outlineColor = Color.valueOf("00000000");
                recoil = 0;
                recoilTime = 0;
                omniMovement = false;
                ignoreRotation = false;
                


                bullet = new BasicBulletType() {{
                    speed = 4;     //Speed in units/tick.
                    damage = 15;   //Direct damage dealt on hit.
                    lifetime = 60; //Lifetime in ticks.
                    width = 12;
                    height = 12;
                    lightRadius = 22;
                    lightOpacity = 0.5f;
                    lightColor = Color.white;
                    frontColor = Color.white;
                    backColor = Color.red;
                    trailColor = Color.red;
                    trailLength = 10;
                    trailWidth = 2;
                    homingPower = 0.5f;
                    homingRange = 100;
                }};
            }});
            load();
        }};
    }
}
