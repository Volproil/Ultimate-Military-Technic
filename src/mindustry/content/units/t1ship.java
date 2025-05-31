package mindustry.content.units;

import arc.graphics.Color;
import mindustry.type.UnitType;
import mindustry.gen.UnitEntity;
import mindustry.type.Weapon;
import mindustry.entities.bullet.BasicBulletType;
public class t1ship {
    public static UnitType createUnit() {
        return new UnitType("t1ship") {{
            description = "T1 Naval Ship"; //Localized description & details. May be null.
            health = 300;             //Increased health for a naval unit
            speed = 1.0f;            //Slower speed for naval unit
            rotateSpeed = 1.8f;      //Slower rotation for more realistic ship movement
            range = 35;              //Increased range for naval combat
            flying = false;          //Ships don't fly
            rotateMoveFirst = true;  //Ships should rotate before moving
            
            // Naval unit properties
            canDrown = false;        //Ships don't drown in water
            lowAltitude = false;     //Not a flying unit
            allowLegStep = false;    //No leg stepping animation
            hovering = false;        //Not hovering over water
            
            // Naval movement properties
            drag = 0.1f;              //More drag for water movement
            accel = 0.05f;            //Slower acceleration
            
            // Water movement restrictions
            canDrown = false;         //Ships don't drown in water
            naval = true;
            
            // Make it a naval unit
            //envRequired = Env.underwater;          //2 = water only (Env.water)
            //envDisabled = Env.terrestrial;          //1 = land (Env.terrestrial)
            
            // Visuals
            outlineColor = Color.valueOf("5e9ed6"); //Blue outline for water units
            engineOffset = 5.5f;     //Engine position
            engineSize = 2.5f;       //Engine size

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
