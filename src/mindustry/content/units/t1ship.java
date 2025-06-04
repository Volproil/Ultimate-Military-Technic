package mindustry.content.units;

import arc.graphics.Color;
import mindustry.type.UnitType;
import mindustry.gen.UnitEntity;
import mindustry.type.Weapon;
import mindustry.world.meta.Env;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BasicBulletType;


//TODO Заставить нормально плавать.
public class t1ship {
    public static UnitType createUnit() {
        return new UnitType("t1ship") {
            {
                accel = 0.4f; // Slower acceleration
                aimDst = 5;
                allowedInPayloads = true;
                allowLegStep = false;
                description = "T1 Naval Ship"; // Localized description & details. May be null.
                health = 300; // Increased health for a naval unit
                speed = 5; // Slower speed for naval unit
                rotateSpeed = 1.8f; // Slower rotation for more realistic ship movement
                range = 35; // Increased range for naval combat
                flying = false; // Ships don't fly
                rotateMoveFirst = false; // Ships should rotate before moving
                hitSize = 11;

                // Naval unit properties
                canDrown = false; // Ships don't drown in water
                //lowAltitude = false; // Not a flying unit
                hovering = false; // Not hovering over water

                // Naval movement properties
                // drag = 0.1f; //More drag for water movement
                // homingDelay
                // playerControllable
                // drawnMinimap
                // wobble = true;

                // Water movement restrictions
                canDrown = false; // Ships don't drown in water
                naval = true;
                faceTarget = false;
                physics = true;

                // const u1=Vars.content.unit("risso"),u2=Vars.content.unit(68);if(u1&&u2)for(let k in u1)if(u1[k]!=u2[k])print("[#00FF00]"+k+" [#FFFF00]diff: [#0000FF]"+u1[k]+" [#FFFF00]vs [#FF00FF]"+u2[k]);else print(u1?"[#FF00FF]id68 [#FFFF00]missing [#00FF00]'"+k+"' [#FFFF00]but [#0000FF]risso [#FFFF00]has [#0000FF]"+u1[k]:"[#0000FF]risso [#FFFF00]missing [#00FF00]'"+k+"' [#FFFF00]but [#FF00FF]id68 [#FFFF00]has [#FF00FF]"+u2[k])



                
                // if(u1&&u2)for(let k in u1)if(u1[k]!=u2[k])print("[#00FF00]"+k+" [#FFFF00]diff: [#0000FF]"+u1[k]+" [#FFFF00]vs [#FF00FF]"+u2[k]);else print(u1?"[#FF00FF]id68 [#FFFF00]missing [#00FF00]'"+k+"' [#FFFF00]but [#0000FF]risso [#FFFF00]has [#0000FF]"+u1[k]:"[#0000FF]risso [#FFFF00]missing [#00FF00]'"+k+"' [#FFFF00]but [#FF00FF]id68 [#FFFF00]has [#FF00FF]"+u2[k])
                // for (const prop in Vars.content.unit("risso")) {prop}
                // Vars.content.unit("risso").
                // Vars.content.unit(68)
                //envRequired = 0;
                //envEnabled = 1; // Can only exist in water
                //envDisabled = Env.scorching; // Cannot exist on land
                bounded = true;

                // Visuals
                outlineColor = Color.valueOf("5e9ed6"); // Blue outline for water units
                engineOffset = 5.5f; // Engine position
                engineSize = 2.5f; // Engine size

                immunities.add(StatusEffects.wet);

                constructor = UnitEntity::create;

                weapons.add(new Weapon("umt-java-t1turret") {
                    {
                        x = 0;
                        y = -2;
                        rotate = true;
                        rotateSpeed = 6;
                        reload = 60;
                        // layerOffset = 1;
                        outlineColor = Color.valueOf("00000000");
                        recoil = 0;
                        recoilTime = 0;
                        omniMovement = false;
                        ignoreRotation = false;

                        bullet = new BasicBulletType() {
                            {
                                speed = 4; // Speed in units/tick.
                                damage = 15; // Direct damage dealt on hit.
                                lifetime = 60; // Lifetime in ticks.
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
                });
                load();
            }
        };
    }
}
