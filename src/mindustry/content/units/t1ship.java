package mindustry.content.units;

import arc.graphics.Color;
import mindustry.type.UnitType;
import mindustry.gen.UnitWaterMove;
import mindustry.type.Weapon;
import mindustry.content.StatusEffects;
//import mindustry.entities.abilities.SpawnDeathAbility;
import mindustry.entities.bullet.BasicBulletType;

//TODO Улучшить вид снарядов.
//TODO Забалансировать.
public class t1ship {
    public static UnitType createUnit() {
        return new UnitType("t1ship") {
            {
                accel = 0.4f;
                aimDst = 5;
                allowedInPayloads = true;
                allowLegStep = false;
                description = "T1 Ship";
                health = 300;
                speed = 1.15f;
                rotateSpeed = 1.8f;
                range = 21;
                flying = false;
                rotateMoveFirst = false;
                hitSize = 11;
                canDrown = false;
                hovering = false;
                naval = true;
                faceTarget = false;
                physics = true;
                bounded = true;
                outlineColor = Color.valueOf("575767ff");
                engineOffset = 5.5f;
                engineSize = 2.5f;
                immunities.add(StatusEffects.wet);

                constructor = UnitWaterMove::create;

                weapons.add(new Weapon("umt-java-t1turret") {
                    {
                        x = 0;
                        y = -6;
                        rotate = true;
                        rotateSpeed = 4;
                        reload = 180;
                        outlineColor = Color.valueOf("575767ff");
                        recoil = 2;
                        recoilTime = 30;
                        omniMovement = false;
                        ignoreRotation = false;

                        bullet = new BasicBulletType() {
                            {
                                speed = 4;
                                damage = 22;
                                lifetime = 55;
                                width = 24;
                                height = 24;
                                lightRadius = 22;
                                lightOpacity = 0.5f;
                                lightColor = Color.white;
                                frontColor = Color.white;
                                backColor = Color.red;
                                homingPower = 0.5f;
                                homingRange = 100;
                            }
                        };
                    }
                });
                load();
            }
        };
    }
}
