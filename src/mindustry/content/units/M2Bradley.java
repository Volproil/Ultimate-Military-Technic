package mindustry.content.units; // Пакет соответствует пути файла из ошибки компиляции

import arc.graphics.Color;
import arc.math.geom.Rect;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.part.*;
import mindustry.entities.part.DrawPart.PartProgress;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.gen.TankUnit;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.Env;

public class M2Bradley {

    public static UnitType createM2Bradley() {
        return new TankUnitType("M2Bradley") {{
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

            treadRects = new Rect[]{
            new Rect(-33f, -55f, 18f, 115f),
            new Rect( 31f, -55f, 18f, 115f)
            };

            envEnabled = Env.terrestrial | Env.space;
            envDisabled = Env.underwater;

             constructor = TankUnit::create;

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


                bullet = new BasicBulletType(3f, 40) {{
                    width = 7f;
                    height = 10f;
                    hitSize = 0.6f;
                    lifetime = 60f;

                    trailColor = Color.valueOf("ff7f14ff");
                    backColor = Color.valueOf("ffa621ff");
                    frontColor = Color.valueOf("ff9a00ff");
                    shootEffect = Fx.shootBig;

                    collides = true;
                    collidesTiles = true;
                    collidesAir = true;
                }};


                parts.add(new RegionPart("-barrel") {{
                    under = true;
                    y = 9.4f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -1.5f, 0f));
                }});
            }});
        }};
    }
}
