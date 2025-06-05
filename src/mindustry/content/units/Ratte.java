package mindustry.content.units;

import arc.graphics.Color;
import arc.math.geom.Rect;
import mindustry.content.Fx;
import mindustry.content.UnitTypes;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.FlakBulletType;
import mindustry.entities.abilities.UnitSpawnAbility;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WaveEffect;
import mindustry.entities.part.RegionPart;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.Env;

public class Ratte {

    public static UnitType createRatte() {
        return new TankUnitType("Ratte") {{
            // Основные параметры юнита
            description = "Heavily armed super-heavy tank.";
            hitSize = 40f;
            omniMovement = false;
            health = 9000f;
            armor = 20f;
            speed = 0.6f;
            targetAir = false; // Последнее значение из HJSON
            targetGround = true; // Последнее значение из HJSON
            rotateSpeed = 2.0f;
            range = 200f;
            treadPullOffset = 4;
            outlineColor = Color.valueOf("2d2f39");
            // layerOffset = -1f; // Удалено по запросу пользователя

            treadRects = new Rect[]{
                new Rect(70, 100, 10, 20f)
            };

            envEnabled = Env.terrestrial | Env.space; // 14
            envDisabled = Env.underwater; // 2

            constructor = UnitEntity::create;

            // Оружие 1: ratte-weapon (главная башня)
            weapons.add(new Weapon("umt-java-ratte-weapon") {{
                x = 0f;
                y = 10f;
                rotateSpeed = 2.5f;
                shootX = 4f;
                shootY = 30f;
                targetAir = true; // Последнее значение из HJSON
                targetGround = false; // Последнее значение из HJSON
                mirror = true;
                rotate = true;
                layerOffset = 2f;
                ignoreRotation = true;
                // shots = 100; // Удалено по запросу пользователя
                // shootEffect = Fx.shootBig; // Удалено по запросу пользователя
                // followRotation = true; // Удалено по запросу пользователя
                // rotateShooting = true; // Удалено по запросу пользователя

                reload = 80f;
                recoil = 0.1f;
                shootSound = Sounds.shootBig;

                // Эффект попадания (hitEffect) - УДАЛЕНО для устранения ошибки компиляции
                /*
                this.hitEffect = new MultiEffect(new WaveEffect() {{
                    lifetime = 40f;
                    sizeFrom = 80f;
                    sizeTo = 30f;
                    strokeFrom = 3f;
                    strokeTo = 0f;
                    colorFrom = Color.valueOf("ffca14");
                    colorTo = Color.valueOf("ff0010"); // Исправлено с ffo010 на ff0010
                }});
                */

                // Части оружия (два ствола)
                parts.add(new RegionPart("-barrel") {{
                    under = true;
                    x = -4f;
                    y = 20f;
                    // moves.add(new PartMove(PartProgress.recoil, 0f, -1.5f, 0f)); // Удалено по запросу пользователя
                }});
                parts.add(new RegionPart("-barrel") {{
                    under = true;
                    x = 4f;
                    y = 20f;
                    // moves.add(new PartMove(PartProgress.recoil, 0f, -1.5f, 0f)); // Удалено по запросу пользователя
                }});

                // Тип пули
                bullet = new BasicBulletType() {{
                    trailColor = Color.valueOf("ff7f14ff");
                    frontColor = Color.valueOf("ff9a00ff");
                    backColor = Color.valueOf("ffa621ff");
                    width = 10f; // Последнее значение из HJSON
                    height = 14f; // Последнее значение из HJSON
                    hitSize = 0.8f;
                    shootEffect = Fx.shootBig;
                    damage = 600f;
                    splashDamageRadius = 100f;
                    splashDamage = 350f;
                    speed = 8f;
                    lifetime = 30f;
                }};
            }});

            // Оружие 2: ratte_anti_air-weapon (левая ПВО)
            weapons.add(new Weapon("umt-java-ratte_anti_air-weapon") {{
                x = -22f;
                y = -32f;
                shootX = 0f;
                shootY = 20f;
                rotate = true;
                mirror = true;
                targetAir = true; // Последнее значение из HJSON
                targetGround = false; // Последнее значение из HJSON
                rotateSpeed = 3.0f;
                reload = 15f;
                recoil = 0.1f;
                shootSound = Sounds.shoot;
                // shootEffect = Fx.shootSmall; // Удалено по запросу пользователя

                parts.add(new RegionPart("-barrel") {{
                    under = true;
                    x = 0f;
                    y = 10f;
                    // moves.add(new PartMove(PartProgress.recoil, 0f, -1.5f, 0f)); // Удалено по запросу пользователя
                }});

                bullet = new FlakBulletType() {{
                    damage = 45f;
                    width = 6f;
                    height = 6f;
                    speed = 10f;
                    lifetime = 25f;
                }};
            }});

            // Оружие 3: ratte_anti_air-weapon (правая ПВО)
            weapons.add(new Weapon("umt-java-ratte_anti_air-weapon") {{
                x = 22f;
                y = -32f;
                shootX = 0f;
                shootY = 20f;
                mirror = true;
                rotate = true;
                targetAir = true; // Последнее значение из HJSON
                targetGround = false; // Последнее значение из HJSON
                rotateSpeed = 3.0f;
                reload = 15f;
                recoil = 0.1f;
                shootSound = Sounds.shoot;
                // shootEffect = Fx.shootSmall; // Удалено по запросу пользователя

                parts.add(new RegionPart("-barrel") {{
                    under = true;
                    x = 0f;
                    y = 10f;
                    // moves.add(new PartMove(PartProgress.recoil, 0f, -1.5f, 0f)); // Удалено по запросу пользователя
                }});

                bullet = new FlakBulletType() {{
                    damage = 45f;
                    width = 6f;
                    height = 6f;
                    speed = 10f;
                    lifetime = 25f;
                }};
            }});

            // Оружие 4: browning (левый пулемет)
            weapons.add(new Weapon("umt-java-browning") {{
                x = -18f;
                y = -10f;
                rotate = true;
                targetAir = false;
                targetGround = true;
                rotateSpeed = 3.0f;
                reload = 15f;
                recoil = 0.05f;
                shootSound = Sounds.pew;
                // shootEffect = Fx.shootSmall; // Удалено по запросу пользователя

                bullet = new BasicBulletType() {{
                    damage = 12f;
                    width = 4f;
                    height = 6f;
                    speed = 11f; // Значение из первого "browning" в HJSON
                    lifetime = 18f;
                }};
            }});

            // Оружие 5: browning (правый пулемет)
            weapons.add(new Weapon("umt-java-browning") {{
                x = 18f;
                y = -10f;
                rotate = true;
                targetAir = false;
                targetGround = true;
                rotateSpeed = 3.0f;
                reload = 15f;
                recoil = 0.05f;
                shootSound = Sounds.pew;
                // shootEffect = Fx.shootSmall; // Удалено по запросу пользователя

                bullet = new BasicBulletType() {{
                    damage = 12f;
                    width = 4f;
                    height = 6f;
                    speed = 6f; // Последнее значение из HJSON
                    lifetime = 18f;
                }};
            }});

            // Способности юнита
            abilities.add(new UnitSpawnAbility(UnitTypes.flare, 1000f, 0f, -45f)); // Добавлен 0f для spawnX
        }};
    }
}