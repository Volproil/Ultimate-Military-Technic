package mindustry.content;

import arc.graphics.Color;
import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids; // Добавлен импорт Liquids
import mindustry.gen.Sounds;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.ArtilleryBulletType; // Добавлен импорт ArtilleryBulletType для осколков
import mindustry.entities.bullet.MissileBulletType; // Добавлен импорт MissileBulletType для основной ракеты
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
// import mindustry.type.StatusEffects; // ЗАКОММЕНТИРОВАНО: проблема "cannot find symbol"
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.meta.BuildVisibility;
import mindustry.graphics.Pal;
import static mindustry.type.ItemStack.with;


public class MyTurrets {
    public static ItemTurret antiTank;
    public static ItemTurret artillery;

    public static void load() {
        // Определение турели AntiTank
        antiTank = new ItemTurret("antitank"){{
            this.description = "A powerful anti-tank turret.";
            this.health = 2500;
            this.size = 3;

            // this.recoilAmount = 5f; // ЗАКОММЕНТИРОВАНО: проблема "cannot find symbol"
            // this.shots = 1;
            // this.burst = 3;
            // this.burstSpacing = 15f;

            this.reload = 120f;
            this.range = 300f;
            this.ammoUseEffect = Fx.casing3;
            this.shootSound = Sounds.explosionbig;
            this.targetAir = false;
            this.inaccuracy = 1f;
            this.rotateSpeed = 0.8f;
            this.coolantMultiplier = 0.7f;

            // Типы боеприпасов
            this.ammo(
                Items.graphite, new BasicBulletType(){{
                    this.damage = 158f;
                    this.speed = 5.0f;
                    this.lifetime = 70f;
                    this.width = 12f;
                    this.height = 12f;
                    this.shootEffect = Fx.shootBig;
                    this.smokeEffect = Fx.shootBigSmoke;
                    this.splashDamageRadius = 80f;
                    this.splashDamage = 158f;
                    this.collidesGround = true;
                    this.hitEffect = new WaveEffect(){{
                        this.sizeFrom = 0;
                        this.sizeTo = 40;
                        this.lifetime = 60f;
                    }};
                    this.despawnEffect = new WaveEffect(){{
                        this.sizeFrom = 0;
                        this.sizeTo = 100;
                        this.lifetime = 180f;
                    }};
                }},
                Items.thorium, new BasicBulletType(){{
                    this.damage = 300f;
                    this.speed = 4.5f;
                    this.lifetime = 80f;
                    this.width = 14f;
                    this.height = 14f;
                    this.shootEffect = Fx.shootBig;
                    this.smokeEffect = Fx.shootBigSmoke;
                    this.splashDamageRadius = 100f;
                    this.splashDamage = 250f;
                    this.collidesGround = true;
                    this.hitEffect = new WaveEffect(){{
                        this.sizeFrom = 0;
                        this.sizeTo = 60;
                        this.lifetime = 120f;
                    }};
                    this.despawnEffect = new WaveEffect(){{
                        this.sizeFrom = 70;
                        this.sizeTo = 150;
                        this.lifetime = 240f;
                    }};
                }}
            );

            // Требования к ресурсам
            this.requirements(Category.turret, BuildVisibility.shown, with(Items.titanium, 100, Items.lead, 80, Items.silicon, 50));
            this.category = Category.turret;
            // this.research = Blocks.sniper; // ЗАКОММЕНТИРОВАНО: поле research
        }};

        // Определение турели Artillery
        artillery = new ItemTurret("artillery"){{
            this.description = "excellent powerful artillery with a large radius but slow";
            this.health = 4500;
            this.size = 4;
            // this.recoilAmount = 5f; // ЗАКОММЕНТИРОВАНО: проблема "cannot find symbol"
            this.reload = 1080f;
            this.range = 1500f;
            this.ammoUseEffect = Fx.casing3;
            this.shootSound = Sounds.explosionbig;
            this.targetAir = false;
            this.inaccuracy = 5.0f;
            this.rotateSpeed = 0.1f;
            this.coolantMultiplier = 0.7f;

            // Расход жидкости
            this.consumeLiquid(Liquids.water, 1.5f);

            // Требования к ресурсам
            this.requirements(Category.turret, BuildVisibility.shown, with(Items.thorium, 390, Items.silicon, 630));
            this.category = Category.turret;
            // this.research = Blocks.mortar; // ЗАКОММЕНТИРОВАНО: проблема "cannot find symbol"

            // Типы боеприпасов
            this.ammo(
                Items.thorium, new MissileBulletType(){{
                    this.speed = 3.0f;
                    this.lifetime = 400f;
                    this.damage = 1000f;
                    this.splashDamage = 100f;
                    this.splashDamageRadius = 100f;

                    this.trailColor = Color.valueOf("ffb114");
                    this.trailLength = 21;
                    this.homingPower = 2.0f;
                    this.homingDelay = 15f;
                    this.weaveScale = 5f;
                    this.weaveMag = 2f;
                    this.homingRange = 80f;

                    this.sprite = "umt-java-m57rocket";
                    this.width = 20f;
                    this.height = 20f;
                    this.hitSize = 20f;
                    this.shrinkX = 0f;
                    this.shrinkY = 0f;
                    this.collidesAir = true;
                    this.collidesGround = true;
                    this.despawnHit = true;
                    this.shootEffect = Fx.none;

                    this.fragBullets = 10;
                    this.fragBullet = new ArtilleryBulletType(){{
                        this.width = 5f;
                        this.height = 5f;
                        this.damage = 15f;
                        this.speed = 3.0f;
                        this.lifetime = 20f;
                        this.splashDamageRadius = 10f;
                        this.splashDamage = 10f;
                        // this.status = StatusEffects.burning; // ЗАКОММЕНТИРОВАНО: проблема "cannot find symbol"
                    }};
                }},
                Items.blastCompound, new MissileBulletType(){{
                    this.speed = 3.0f;
                    this.lifetime = 400f;
                    this.damage = 1000f;
                    this.splashDamage = 100f;
                    this.splashDamageRadius = 100f;

                    this.trailColor = Color.valueOf("ff770e");
                    this.trailLength = 21;
                    this.homingPower = 2.0f;
                    this.homingDelay = 15f;
                    this.weaveScale = 5f;
                    this.weaveMag = 2f;
                    this.homingRange = 80f;

                    this.sprite = "umt-java-m57rocket";
                    this.width = 20f;
                    this.height = 20f;
                    this.hitSize = 20f;
                    this.shrinkX = 0f;
                    this.shrinkY = 0f;
                    this.collidesAir = true;
                    this.collidesGround = true;
                    this.despawnHit = true;
                    this.shootEffect = Fx.none;

                    this.fragBullets = 10;
                    this.fragBullet = new ArtilleryBulletType(){{
                        this.width = 5f;
                        this.height = 5f;
                        this.damage = 15f;
                        this.speed = 3.0f;
                        this.lifetime = 20f;
                        this.splashDamageRadius = 10f;
                        this.splashDamage = 10f;
                        // this.status = StatusEffects.burning; // ЗАКОММЕНТИРОВАНО: проблема "cannot find symbol"
                    }};
                }}
            );
        }};
    }
}