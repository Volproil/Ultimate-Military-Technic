package mindustry.content.units;

import arc.graphics.Color;
import arc.math.geom.Rect;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.FlakBulletType;
// import mindustry.entities.Effect; // Этот импорт теперь не нужен для hitEffect
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.Env;

public class T28 {

    public static UnitType createT28() {
        return new TankUnitType("T28") {{
            // Основные параметры юнита
            description = "heavy tank";
            hitSize = 30f;
            targetAir = false;
            targetGround = true;
            omniMovement = true;
            circleTarget = false;
            health = 7000f;
            armor = 17f;
            speed = 0.5f;
            rotateSpeed = 1.3f;
            range = 400f;
            treadPullOffset = 4;
            outlineColor = Color.valueOf("2d2f39");


            treadRects = new Rect[]{
                new Rect(50f, 100f, 10f, 20f)
            };

            envEnabled = Env.terrestrial | Env.space;
            envDisabled = Env.underwater;

            constructor = UnitEntity::create;

            // Оружие 1: Главная пушка T28
            weapons.add(new Weapon("umt-java-T28-weapon") {{
                x = 0f;
                y = 37f;
                rotateSpeed = 0f;
                shootY = 17f;
                targetAir = false;
                targetGround = true;
                mirror = false;
                rotate = false;
                layerOffset = 2f;
                ignoreRotation = false;
                reload = 120f;
                recoil = 0.2f;
                shootSound = Sounds.shoot;
                shootCone = 360f;

                // Тип пули для главной пушки
                bullet = new BasicBulletType(4f, 400) {{
     
                    trailColor = Color.valueOf("ff7f14ff");
                    frontColor = Color.valueOf("ff9a00ff");
                    backColor = Color.valueOf("ffa621ff");
                    width = 9f;
                    height = 18f;
                    hitSize = 0.8f;
                    shootEffect = Fx.shootBig;
                    splashDamageRadius = 100f;
                    splashDamage = 350f;
                    collides = true;
                    collidesTiles = true;
                    collidesAir = true;
                    lifetime = 90f;

                    // Эффект попадания - ИСПРАВЛЕНО
                    hitEffect = new WaveEffect() {{ // Прямое присвоение WaveEffect
                        lifetime = 40f;
                        sizeFrom = 80f;
                        sizeTo = 30f;
                        strokeFrom = 3f;
                        strokeTo = 0f;
                        colorFrom = Color.valueOf("ffca14");
                        colorTo = Color.valueOf("ff0010");
                    }};
                }};
            }});

            // Оружие 2: Автопушка M163-VADS
            weapons.add(new Weapon("umt-java-M163-VADS-weapon") {{
                x = 4.0f;
                y = 2.7f;
                rotateSpeed = 10f;
                mirror = false;
                rotate = true;
                layerOffset = 3f;
                ignoreRotation = false;
  
                reload = 8f;
                recoil = 1f;
                recoilTime = 30f;
                shootSound = Sounds.pew;
                ejectEffect = Fx.casing1;
                targetAir = true;
                targetGround = false;

                // Тип пули для автопушки
                bullet = new FlakBulletType() {{
                    damage = 5f;
                    speed = 10f;
                    lifetime = 13f;
                }};
            }});
        }};
    }
}