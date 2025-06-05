package mindustry.content.units;

import arc.graphics.Color;
import arc.math.geom.Rect;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.abilities.ForceFieldAbility;
import mindustry.entities.part.RegionPart; // RegionPart все еще используется, поэтому этот импорт нужен
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.Env;

public class Gepard {

    public static UnitType createGepard() {
        return new TankUnitType("Gepard") {{
            // Основные параметры юнита
            description = "Powerful anti-aircraft tank with dual autocannons.";
            hitSize = 24f;
            omniMovement = false;
            health = 450f;
            armor = 10f;
            speed = 0.9f;
            targetAir = true;
            targetGround = false;
            rotateSpeed = 2.0f;
            range = 27f;
            treadPullOffset = 4;
            outlineColor = Color.valueOf("2d2f39");
            // layerOffset = -1f; // Удалено по вашему запросу

            treadRects = new Rect[]{
                new Rect(-10, 8, 6, 2.5f),
                new Rect(10, 8, 6, 2.5f)
            };

            envEnabled = Env.terrestrial | Env.space;
            envDisabled = Env.underwater;

            constructor = UnitEntity::create;

            // Оружие 1: Gepard-weapon (сдвоенные автопушки)
            weapons.add(new Weapon("umt-java-gepard-weapon") {{
                x = 0f;
                y = 0f;
                rotateSpeed = 2.5f;
                shootX = -10f;
                shootY = 17f;
                targetAir = true;
                targetGround = false;
                mirror = true;
                rotate = true;
                layerOffset = 2f;
                ignoreRotation = true;
                // shots = 100; // Удалено по вашему запросу
                // shootEffect = Fx.shootSmall; // Удалено по вашему запросу
                // followRotation = true; // Удалено по вашему запросу
                // rotateShooting = true; // Удалено по вашему запросу

                reload = 4f;
                recoil = 0.2f;
                shootSound = Sounds.shoot;

                parts.add(new RegionPart("-barrelL") {{
                    under = true;
                    x = -10f;
                    y = 8f;
                    // moves.add(new PartMove(PartProgress.recoil, 0f, -1.5f, 0f)); // Удалено по вашему запросу
                }});
                parts.add(new RegionPart("-barrelR") {{
                    under = true;
                    x = 10f;
                    y = 8f;
                    // moves.add(new PartMove(PartProgress.recoil, 0f, -1.5f, 0f)); // Удалено по вашему запросу
                }});

                bullet = new FlakBulletType() {{
                    damage = 25f;
                    speed = 8f;
                    lifetime = 30f;
                }};
            }});

            // Оружие 2: Browning (пулемет)
            weapons.add(new Weapon("umt-java-browning") {{
                x = 2.7f;
                y = 1.6f;
                rotateSpeed = 4f;
                mirror = false;
                rotate = true;
                layerOffset = 3f;
                ignoreRotation = false;
                // followRotation = true; // Удалено по вашему запросу
                // rotateShooting = false; // Удалено по вашему запросу
                // shootEffect = Fx.shootSmall; // Удалено по вашему запросу

                reload = 15f;
                recoil = 1f;
                recoilTime = 30f;
                shootSound = Sounds.pew;
                ejectEffect = Fx.casing1;

                bullet = new BasicBulletType(4f, 10) {{
                    lifetime = 40f;
                }};
            }});

            // Способности юнита - ИСПРАВЛЕНО
            // Используем конструктор с 4 float аргументами и устанавливаем цвет в блоке инициализатора.
            abilities.add(new ForceFieldAbility(
                30.0f,    // radius
                1.5f,     // regen
                60.0f,    // cooldown
                100.0f    // max
            ) {{
            }});
        }};
    }
}