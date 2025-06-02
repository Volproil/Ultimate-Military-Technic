package mindustry.content.units;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.Env;

public class M163VADS {
    public static UnitType createM163VADS() {
        return new TankUnitType("M163-VADS") {{
            description = "Excellent air defense.";
            hitSize = 15f;
            health = 100f;
            armor = 8f;
            speed = 1.3f;
            rotateSpeed = 2.6f;
            range = 13f;
            treadPullOffset = 3;
            outlineColor = Color.valueOf("2d2f39");
            omniMovement = false;

            envEnabled = Env.terrestrial | Env.space;
            envDisabled = Env.underwater;

            constructor = UnitEntity::create;

            // Общий тип пули (Flak)
            FlakBulletType flak = new FlakBulletType() {{
                damage = 5f;
                speed = 10f;
                lifetime = 13f;
                knockback = 0f;
            }};

            float[][] gunPositions = {
                {-4f, 2.7f},
                { 4f, 2.7f}
            };

            for (float[] pos : gunPositions) {
                weapons.add(new Weapon("umt-java-M163-VADS-weapon") {{
                    x = pos[0];
                    y = pos[1];
                    rotate = true;
                    mirror = false;
                    rotateSpeed = 10f;
                    ignoreRotation = false;

                    reload = 8f;
                    recoil = 1f;
                    recoilTime = 30f;

                    shootSound = Sounds.pew;
                    ejectEffect = Fx.casing1;

                    bullet = flak;

                    targetAir = true;
                    targetGround = false;
                }});
            }
        }};
    }
}
