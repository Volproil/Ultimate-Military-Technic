package mindustry.content.units;

import arc.graphics.Color;
import mindustry.type.UnitType;
import mindustry.gen.UnitEntity;
import mindustry.type.Weapon;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.StatusFieldAbility;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.effect.WaveEffect;

public class fpvdrone1 {
    public static UnitType createFPVKamikaze() {
        return new UnitType("fpv-kamikaze") {{
            localizedName = "FPV Drone Kamikadze";
            speed = 7f;
            health = 40;
            hitSize = 1f;
            flying = true;
            omniMovement = false;
            outlineColor = Color.valueOf("2d2f39");
            constructor = UnitEntity::create;

            abilities.add(
                new StatusFieldAbility(StatusEffects.none, 1, 1, 1){ // effect, duration, reload, range
                    /* WaveEffect() {
                        followParent = true;
                        rotWithParent = true;
                        useRotation = false;
                        mirror = true;
                        baseRotation = -45f;
                        lifetime = 16f;
                        length = 0f;
                        spin = 1f;
                        region = "military-techic-mod-fpvdrone1-motor-blade";
                        layerOffset = 1f;
                        sizeFrom = 4f;
                        sizeTo = 4f;
                    } */
                });

            weapons.add(new Weapon() {{
                shootCone = 140f;
                mirror = false;
                shootOnDeath = true;
                x = 0f;
                y = 0f;
                //despawnOnHit = true;

                bullet = new BombBulletType() {{
                    splashDamageRadius = 50f;
                    splashDamage = 300f;
                    instantDisappear = true;
                    killShooter = true;
                    hittable = false;
                    collidesAir = true;
                    status = StatusEffects.melting;
                    pierce = true;
                    shootEffect = Fx.none;

                    hitEffect = new WaveEffect() {{
                        lifetime = 35f;
                        sizeFrom = 20f;
                        sizeTo = 50f;
                        strokeFrom = 9f;
                        strokeTo = 3f;
                        colorFrom = Color.valueOf("ffca14");
                        colorTo = Color.valueOf("ff0010");
                    }};
                }};
            }});
        }};
    }
}
