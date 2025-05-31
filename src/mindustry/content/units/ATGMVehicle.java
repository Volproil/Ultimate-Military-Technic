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

                bullet = new BasicBulletType(3f, 0f) {{
                    width = 7f;
                    height = 9f;
                    lifetime = 0f;
                    collides = false;
                    hittable = false;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;

                    despawnUnit = mindustry.content.MyUnits.M113;
                    despawnUnitChance = 1.0f;
                    despawnUnitCount = 1;
                    despawnUnitRadius = 0.1f;
                }};
            }});
        }};
    }
}
