package mindustry.content.units;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.*;
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
            description = "Heavy tank";
            hitSize = 17f;
            health = 400f;
            armor = 8f;
            speed = 0.8f;
            rotateSpeed = 2f;
            range = 50f;
            treadPullOffset = 4;
            outlineColor = Color.valueOf("2d2f39");
            omniMovement = false;


            // Окружающая среда
            envEnabled = Env.terrestrial | Env.space;
            envDisabled = Env.underwater;



            constructor = UnitEntity::create;

            // Основное оружие
            weapons.add(new Weapon("umt-java-m2bradley-weapon") {{
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


                bullet = new BasicBulletType(3f, 40) {{
                    width = 7f;
                    height = 10f;
                    hitSize = 0.6f;
                    lifetime = 60f;
                    trailLength = 10;
                    trailWidth = 1.5f;
                    trailColor = Color.valueOf("ff7f14");
                    backColor = Color.valueOf("ffa621");
                    frontColor = Color.valueOf("ff9a00");
                    shootEffect = Fx.shootBig;


                    collides = true;
                    collidesTiles = true;
                    collidesAir = true;
                }};

                // Анимация ствола
                parts.add(new RegionPart("umt-java-m2bredley-weapon-barrel") {{
                    under = false;
                    y = 9.4f;
                    moves.add(new PartMove() {{
                        progress = PartProgress.recoil;
                        y = -1.5f;
                    }});
                }});
            }});
        }};
    }
}