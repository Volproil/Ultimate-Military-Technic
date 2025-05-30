package mindustrymod.content.units;

import arc.graphics.Color;
import mindustry.type.UnitType;
import mindustry.type.unit.TankUnitType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Fx;
import mindustry.gen.Sounds;
import mindustry.entities.part.Tread;
import mindustry.type.Weapon;
import mindustry.type.env.Env;

public class M113 {
    public static UnitType create() {
        return new TankUnitType("M113") {{
            description = "light tank";
            hitSize = 11f;
            omniMovement = false;
            health = 80;
            armor = 3f;
            speed = 1.3f;
            rotateSpeed = 2.6f;
            range = 23f;
            treadPullOffset = 3f;
            outlineColor = Color.valueOf("2d2f39");
            layerOffset = -1f;

            envEnabled = Env.terrestrial | Env.space;
            envDisabled = Env.deep;

            treadRects = new Tread.TreadRect[]{
                new Tread.TreadRect(-35f, 7f, 1f, 2f)
            };

            weapons.add(new Weapon("browning") {{
                x = 2.7f;
                y = 2.7f;
                rotate = true;
                mirror = false;
                rotateSpeed = 7f;
                layerOffset = 3f;
                ignoreRotation = false;
                followRotation = true;
                rotateShooting = false;

                shootEffect = Fx.shootSmall;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.pew;

                reload = 13f;
                recoil = 1f;
                recoilTime = 30f;

                bullet = new BasicBulletType(7f, 23) {{
                    lifetime = 23f;
                }};
            }});
        }};
    }
}
