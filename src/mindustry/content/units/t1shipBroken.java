package mindustry.content.units;

import arc.graphics.Color;
import mindustry.type.UnitType;
import mindustry.gen.UnitWaterMove;
import mindustry.type.Weapon;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;

//TODO Улучшить вид снарядов.
//TODO Забалансировать.
public class t1shipBroken {
    public static UnitType createUnit() {
        return new UnitType("t1shipBroken") {
            {
                accel = 0.4f;
                aimDst = 5;
                description = "Can be repaired.";
                health = 3000;
                speed = 0f;
                rotateSpeed = 1.8f;
                flying = false;
                rotateMoveFirst = false;
                hitSize = 11;
                canDrown = false;
                hovering = false;
                naval = true;
                faceTarget = false;
                physics = true;
                bounded = true;
                outlineColor = Color.valueOf("00000000");
                engineOffset = 5.5f;
                engineSize = 2.5f;
                immunities.add(StatusEffects.wet);

                constructor = UnitWaterMove::create;

                /* weapons.add(new Weapon("umt-java-t1turret") {
                    {
                        x = 0;
                        y = -2;
                        rotate = true;
                        rotateSpeed = 6;
                        reload = 60;
                        outlineColor = Color.valueOf("00000000");
                        recoil = 0;
                        recoilTime = 0;
                        omniMovement = false;
                        ignoreRotation = false;

                        bullet = new BasicBulletType() {
                            {
                                speed = 4;
                                damage = 15;
                                lifetime = 60;
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
                            }
                        };
                    }
                }); */
                load();
            }
        };
    }
}
