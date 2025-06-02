package mindustry.content.units;

import arc.graphics.Color;
import mindustry.type.UnitType;
import mindustry.type.unit.TankUnitType;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.Weapon;
import mindustry.ai.types.MissileAI;
import mindustry.content.Fx;
import mindustry.world.meta.Env;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.pattern.ShootSpread;

public class ATGMVehicle {
    public static UnitType createATGMVehicle() {
        return new TankUnitType("ATGM-Vehicle") {{
            description = "Light anti-tank vehicle";
            hitSize = 15f;
            omniMovement = false;
            health = 80;
            armor = 1f;
            speed = 1.3f;
            rotateSpeed = 2.6f;
            range = 23f;
            outlineColor = Color.valueOf("2d2f39");
            envEnabled = Env.terrestrial | Env.space;
            envDisabled = Env.underwater;

        constructor = UnitEntity::create;

            weapons.add(new Weapon("umt-java-ATGMVehicle-weapon") {{
                x = 0.0f;
                y = 0.0f;
                rotate = true;
                mirror = false;
                rotateSpeed = 7f;
                ignoreRotation = false;

                shoot = new ShootSpread();
                ((ShootSpread)shoot).spread = 2f;
                shoot.shots = 1;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.pew;

                reload = 13f;
                recoil = 1f;
                recoilTime = 30f;

               bullet = new MissileBulletType() {{
                    speed = 3f;
                    hitSize = 10f;
                  //  controller = u -> new MissileAI();
                    width = 7f;
                    splashDamageRadius = 40f;
                    splashDamage = 100f;
        
                      // Настройки текстуры снаряда
                      sprite = "umt-java-towrocket"; // Имя файла без расширения
                      width = 10f;          // Ширина спрайта
                      height = 10f;         // Высота спрайта
                      shrinkX = 0f;         // Не сжимать по X
                      shrinkY = 0f;         // Не сжимать по Y
              //        spin = 15f;           // Вращение снаряда
                    lifetime = 70f;
                    collides = false;
                    hittable = false;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    targetAir = false;
                targetGround = true;

    WaveEffect hitEffect = new WaveEffect();
        hitEffect.lifetime = 25f;
        hitEffect.sizeFrom = 10f;
        hitEffect.sizeTo = 30f;
        hitEffect.strokeFrom = 3f;
        hitEffect.strokeTo = 0f;
        hitEffect.colorFrom = Color.valueOf("ffca14");
        hitEffect.colorTo = Color.valueOf("ff0010");
        
        bullet.hitEffect = hitEffect;
                    homingPower = 0.1f;
                    weaveScale = 5f;
                    weaveMag = 2f;
                    homingRange = 50f;
                }};
            }});
        }};
    }
}
