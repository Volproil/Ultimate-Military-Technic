package mindustry.content.units;

import arc.graphics.Color;
import arc.math.geom.Rect;
import mindustry.content.Fx;
import mindustry.content.StatusEffects; // Импорт StatusEffects
import mindustry.entities.bullet.ArtilleryBulletType; // Импорт ArtilleryBulletType
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.DrawPart.PartProgress;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.Env;

public class abrams {

    public static UnitType createabrams() {
        return new TankUnitType("abrams") {{
            // Основные параметры юнита
            description = "heavy tank";
            hitSize = 20f; // float
            omniMovement = false;
            health = 550f; // float
            armor = 12f; // float
            speed = 0.6f; // float
            rotateSpeed = 2f; // float
            range = 270f; // float

            treadFrames = 18; // int
            treadPullOffset = 8; // int
            outlineColor = Color.valueOf("2d2f39");

            treadRects = new Rect[]{
                new Rect(10, 8, 7, 8)
            };

            // Флаги окружающей среды
            // 17 = Env.terrestrial | Env.space | Env.underwater (1|16) = 17
            envEnabled = Env.terrestrial | Env.space | Env.underwater;
            envDisabled = Env.none; // 0 = Env.none

            // Конструктор сущности юнита
            constructor = UnitEntity::create;

            // Оружие 1: Главная пушка
            weapons.add(new Weapon("umt-java-abrams-weapon") {{
                x = 0f;
                y = 0.7f;
                rotateSpeed = 1.8f;
                shootY = 21f;
                targetAir = false;
                targetGround = true;
                mirror = false;
                rotate = true;
                layerOffset = 2f;
                ignoreRotation = true;

                reload = 90f;
                recoil = 0.5f;
                shootSound = Sounds.artillery;

                // Части оружия (ствол)
                parts.add(new RegionPart("-barrel") {{
                    under = false;
                    y = 19.3f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -2f, 0f)); // y: -2 из HJSON
                }});

                // Тип пули для главной пушки
                bullet = new ArtilleryBulletType(5f, 220) {{ // speed, damage
                    trailMult = 0.8f; // float
                    trailColor = Color.valueOf("ff7f14ff");
                    frontColor = Color.valueOf("ff9a00ff");
                    backColor = Color.valueOf("ffa621ff");
                    width = 8f; // float
                    height = 10f; // float
                    status = StatusEffects.blasted; // StatusEffect
                    hitSize = 0.4f; // float
                    shootEffect = Fx.shootBig2;
                    collides = false;
                    collidesTiles = true;
                    collidesAir = false;
                    splashDamageRadius = 20f; // float
                    splashDamage = 420f; // float
                    lifetime = 60f; // float
                }};
            }});

            // Оружие 2: Пулемет Браунинг
            weapons.add(new Weapon("umt-java-browning") {{
                x = 2.7f;
                y = 1.6f;
                rotateSpeed = 4f;
                mirror = false;
                rotate = true;
                layerOffset = 3f;
                ignoreRotation = false;

                reload = 15f;
                recoil = 1f;
                recoilTime = 30f; // float
                shootSound = Sounds.pew;
                ejectEffect = Fx.casing1;

                // Тип пули для пулемета
                bullet = new BasicBulletType(4f, 10) {{ // speed, damage
                    lifetime = 40f; // float
                }};
            }});
        }};
    }
}