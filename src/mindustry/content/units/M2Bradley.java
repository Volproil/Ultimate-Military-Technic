package mindustry.content.units; // Пакет соответствует пути файла из ошибки компиляции

import arc.graphics.Color;
import arc.math.geom.Rect;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.*; // Изменено для включения PartMove и PartProgress
import mindustry.entities.part.DrawPart.PartProgress;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.Env;

public class M2Bradley {

    public static UnitType createM2Bradley() {
        return new TankUnitType("M2Bradley") {{
            // Основные параметры
            description = "heavy tank";
            hitSize = 17f;
            health = 400f;
            armor = 8f;
            speed = 0.8f;
            rotateSpeed = 2f;
            range = 50f;
            treadPullOffset = 4;
            outlineColor = Color.valueOf("2d2f39");
            omniMovement = false;
            // layerOffset = -1f; // Удалено, так как вызывает ошибку "cannot find symbol"

            // Протекторные прямоугольники
            treadRects = new Rect[]{
                new Rect(3, 7, 1, 2)
            };

            // Окружающая среда
            // Исправлено на envEnabled, так как это правильное имя поля в UnitType
            envEnabled = Env.terrestrial | Env.space;
            envDisabled = Env.underwater;

            // Конструктор сущности юнита
             constructor = UnitEntity::create;

            // Основное оружие
            weapons.add(new Weapon("umt-java-m2bredley-weapon") {{
                x = 0f;
                y = 0f;
                shootY = 17f;
                rotate = true;
                mirror = false;
                rotateSpeed = 2.5f;
                reload = 20f;
                recoil = 0.2f;
                shootSound = Sounds.shoot;
                layerOffset = 2f;
                targetAir = true;
                targetGround = true;
                ignoreRotation = true;
                // followRotation = false;
                // rotateShooting = false;

                bullet = new BasicBulletType(3f, 40) {{
                    width = 7f;
                    height = 10f;
                    hitSize = 0.6f;
                    lifetime = 60f;
                    // trailMult = 0.8f; // Удалено, так как вызывает ошибку "cannot find symbol"
                    trailColor = Color.valueOf("ff7f14ff");
                    backColor = Color.valueOf("ffa621ff");
                    frontColor = Color.valueOf("ff9a00ff");
                    shootEffect = Fx.shootBig;

                    collides = true;
                    collidesTiles = true;
                    collidesAir = true;
                }};

                // Анимация ствола
                parts.add(new RegionPart("-barrel") {{
                    under = true;
                    y = 9.4f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -1.5f, 0f));
                }});
            }});
        }};
    }
}