package mindustry.content.units;

import arc.graphics.Color;
import arc.math.geom.Rect;
import mindustry.entities.part.DrawPart.PartProgress;
import mindustry.entities.part.RegionPart;
import mindustry.entities.pattern.ShootAlternate;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity; // Убедитесь, что этот импорт есть
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.TankUnitType;
import mindustry.world.meta.Env;

// Импорты, необходимые для определения MissileBulletType
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.effect.MultiEffect;
import mindustry.entities.effect.WaveEffect;


public class M270MLRS {

    public static UnitType createM270MLRS() {
        return new TankUnitType("m270mlrs") {{
            description = "excellent mobile multiple launch rocket system";
            omniMovement = false;
            hitSize = 17f;
            health = 500f;
            armor = 6f;
            speed = 1.0f;
            rotateSpeed = 2f;
            treadPullOffset = 4;
            treadRects = new Rect[]{
                new Rect(-40, 10, 20, 20f)
            };
            envEnabled = Env.terrestrial | Env.space;
            envDisabled = Env.underwater;
            outlineColor = Color.valueOf("2d2f39");
            constructor = UnitEntity::create; 

            weapons.add(new Weapon("umt-java-m270mlrs-weapon") {{
                x = 0f;
                y = -4.1f;
                rotateSpeed = 1.5f;
                shootX = 0f;
                shootY = 13f;
                targetAir = false;
                targetGround = true;
                mirror = false;
                rotate = true;
                layerOffset = 2f;
                reload = 2200f;
                shootSound = Sounds.shoot;

                shoot = new ShootAlternate() {{
                    shots = 2;
                    shotDelay = 50f;
                    spread = 10f;
                }};

                parts.add(new RegionPart("-l") {{
                    under = true;
                    y = 6f;
                    x = 5f;
                    moves.add(new RegionPart.PartMove(PartProgress.reload, 0f, 6.5f, 0f));
                }});
                parts.add(new RegionPart("-r") {{
                    under = true;
                    y = 6f;
                    x = -5f;
                    moves.add(new RegionPart.PartMove(PartProgress.reload, 0f, 6.5f, 0f));
                }});

                bullet = new MissileBulletType() {{
                    speed = 3.0f;
                    lifetime = 400f;
                    damage = 1000f;
                    splashDamage = 100f;
                    splashDamageRadius = 100f;

                    trailColor = Color.valueOf("ffb114");
                    trailLength = 21;
                    homingPower = 0.8f; // Как в ATGMVehicle
                    homingDelay = 15f; // Сохраняем из M270MLRS
                    weaveScale = 5f; // Как в ATGMVehicle
                    weaveMag = 2f; // Как в ATGMVehicle
                    homingRange = 80f; // Как в ATGMVehicle


                    // Эти свойства закомментированы для компиляции из-за постоянных ошибок "cannot find symbol".
                    // Если вы хотите использовать их, ВАМ НЕОБХОДИМО обновить ваш build.gradle,
                    // чтобы он соответствовал версии вашей игры Mindustry.
                    // loopSound = Sounds.none;
                    // engineColor = Color.valueOf("ff770e");
                    // engineSize = 2.8f;
                    // rotateSpeed = 0.60f;

                    sprite = "umt-java-m57rocket";
                    // Увеличиваем размер снаряда
                    width = 20f;          
                    height = 20f;         
                    hitSize = 20f;        
                    shrinkX = 0f;         
                    shrinkY = 0f;         
                    collidesAir = true;
                    collidesGround = true;
                    despawnHit = true;
                    shootEffect = Fx.none;

                    hitEffect = new MultiEffect(new WaveEffect() {{
                        lifetime = 35f;
                        sizeFrom = 20f;
                        sizeTo = 70f;
                        strokeFrom = 9f;
                        strokeTo = 0f;
                        colorFrom = Color.valueOf("ffca14");
                        colorTo = Color.valueOf("ff0010");
                    }});
                    
                    status = StatusEffects.burning;
                    pierce = true;
                }};
            }});
        }};
    }
}