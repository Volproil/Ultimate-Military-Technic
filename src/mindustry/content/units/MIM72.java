package mindustry.content.units;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.WaveEffect;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.Env;

public class MIM72 {
    public static UnitType createMIM72() {
        return new TankUnitType("MIM72") {{
            description = "Heavy anti-air/anti-tank missile carrier";
            hitSize = 24f;
            health = 400f;
            armor = 8f;
            speed = 0.8f;
            rotateSpeed = 1.3f;
            range = 70f;
            treadPullOffset = 4;
            outlineColor = Color.valueOf("2d2f39");
            omniMovement = false;

            envEnabled = Env.terrestrial | Env.space;
            envDisabled = Env.underwater;

            constructor = UnitEntity::create;

            // Визуальный эффект взрыва
            WaveEffect hitEffect = new WaveEffect() {{
                lifetime = 25f;
                sizeFrom = 10f;
                sizeTo = 30f;
                strokeFrom = 3f;
                strokeTo = 0f;
                colorFrom = Color.valueOf("ffca14");
                colorTo = Color.valueOf("ff0010");
            }};

            // Общий тип ракеты
            MissileBulletType missile = new MissileBulletType() {{
                speed = 3f;
                lifetime = 70f;
                damage = 70f;
                hitSize = 10f;
                width = 10f;
                height = 10f;
                homingPower = 0.8f;
                homingRange = 80f;
                weaveScale = 5f;
                weaveMag = 2f;
                collides = true;
                collidesTiles = true;
                collidesAir = false;
                collidesGround = true;
                splashDamageRadius = 40f;
                splashDamage = 100f;
                sprite = "umt-java-towrocket"; // Убедись, что спрайт есть
                shootEffect = Fx.shootSmall;
                smokeEffect = Fx.shootSmallSmoke;
                targetAir = false;
                targetGround = true;
                this.hitEffect = hitEffect;
            }};

            // Четыре одинаковых орудия в разных позициях
            float[][] positions = {
                {-4f, 0f},
                { 4f, 0f},
                {-4f, -4f},
                { 4f, -4f}
            };

            for (float[] pos : positions) {
                weapons.add(new Weapon("umt-java-ATGMVehicle-weapon") {{
                    x = pos[0];
                    y = pos[1];
                    rotate = true;
                    mirror = false;
                    rotateSpeed = 2.5f;
                    ignoreRotation = true;
                    reload = 310f;
                    recoil = 1.7f;
                    shootSound = Sounds.missileSmall;
                    layerOffset = 1f;
                    bullet = missile;
                }});
            }

        }};
    }
}
