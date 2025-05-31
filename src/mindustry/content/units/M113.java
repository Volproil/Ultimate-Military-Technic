package mindustry.content.units;

import arc.graphics.Color;
import mindustry.type.UnitType;
import mindustry.type.unit.TankUnitType;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.type.Weapon;
import mindustry.content.Fx;
import mindustry.world.meta.Env;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.pattern.ShootSpread;

public class M113 {
    public static UnitType createM113() {
        return new TankUnitType("m113") {{
            description = "light tank";
            hitSize = 11f;
            omniMovement = false;
            health = 80;
            armor = 3f;
            speed = 1.3f;
            rotateSpeed = 2.6f;
            range = 23f;
            outlineColor = Color.valueOf("2d2f39");
            envEnabled = Env.terrestrial | Env.space;
            envDisabled = Env.underwater;
            
            // Tank configuration
            speed = 1.3f;
            rotateSpeed = 2.6f;
            health = 80f;
            armor = 3f;
            hitSize = 11f;
            flying = false;
            omniMovement = false;
            rotateMoveFirst = true;

            constructor = UnitEntity::create;

            weapons.add(new Weapon("umt-java-browning") {{
                x = 2.7f;
                y = 2.7f;
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

                bullet = new BasicBulletType() {{
                    width = 7f;
                    height = 9f;
                    lifetime = 60f;
                    speed = 3f;
                    damage = 23f;
                    hitSize = 4f;
                    knockback = 0.5f;
                    frontColor = Color.valueOf("ffc665");
                    backColor = Color.valueOf("ff9632");
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                }};
            }});
        }};
    }
}
