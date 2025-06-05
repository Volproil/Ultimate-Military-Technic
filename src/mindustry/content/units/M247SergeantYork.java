package mindustry.content.units;

import arc.graphics.Color;
import arc.math.geom.Rect;
import mindustry.content.Fx;
import mindustry.entities.bullet.FlakBulletType; // Импорт FlakBulletType

import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.Env;

public class M247SergeantYork {

    public static UnitType createM247SergeantYork() {
        return new TankUnitType("M247SergeantYork") {{
            // Основные параметры юнита
            description = "Powerful anti-aircraft tank with dual autocannons.";
            hitSize = 17f;
            omniMovement = false;
            health = 350f;
            armor = 10f;
            speed = 0.9f;
            targetAir = true; // Юнит нацеливается на воздух
            targetGround = false; // Юнит не нацеливается на землю
            rotateSpeed = 2.0f;
            range = 17f; // Дальность действия юнита
            treadPullOffset = 4;
            outlineColor = Color.valueOf("2d2f39");

            treadRects = new Rect[]{
                new Rect(-40, 8, 1.5f, 2.5f) // x, y, width, height (float)
            };

            // Флаги окружающей среды: 14 = Env.terrestrial | Env.space
            envEnabled = Env.terrestrial | Env.space;
            // Флаги окружающей среды: 2 = Env.underwater
            envDisabled = Env.underwater;

            // Конструктор сущности юнита
            constructor = UnitEntity::create;

            // Оружие: M247-weapon (сдвоенные автопушки)
            weapons.add(new Weapon("umt-java-M247-weapon") {{
                x = 0f;
                y = 0f;
                rotateSpeed = 2.5f;
                shootY = 17f;
                targetAir = true; // Оружие нацеливается на воздух
                targetGround = false; // Оружие не нацеливается на землю
                mirror = true; // Включаем зеркальное отображение
                rotate = true;
                layerOffset = 2f;
                ignoreRotation = true;

                reload = 8f;
                recoil = 0.2f;
                shootSound = Sounds.shoot;

                // Части оружия (два ствола)
                parts.add(new RegionPart("-barrel") {{
                    under = true;
                    x = -2f; // Левый ствол
                    y = 9.4f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -1.5f, 0f));
                }});
                parts.add(new RegionPart("-barrel") {{
                    under = true;
                    x = 2f; // Правый ствол
                    y = 9.4f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -1.5f, 0f));
                }});

                // Тип пули для автопушек
                bullet = new FlakBulletType() {{
                    damage = 25f;
                    speed = 8f;
                    lifetime = 20f;
                    // Дополнительные свойства FlakBulletType, если требуются:
                    // splashDamage = 0f;
                    // splashDamageRadius = 0f;
                    // hitEffect = Fx.flakExplosion;
                    // despawnEffect = Fx.flakExplosion;
                }};
            }});
        }};
    }
}