package mindustry.content;

import arc.graphics.Color; // Может быть не нужен, если цвета эффектов не используются
import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.gen.Sounds;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.meta.BuildVisibility;
import static mindustry.type.ItemStack.with;


public class MyTurrets {
    public static ItemTurret antiTank;

    public static void load() {
        antiTank = new ItemTurret("antitank"){{
            this.description = "A powerful anti-tank turret.";
            this.health = 2500;
            this.size = 3; // ИСПРАВЛЕНО: Установлен размер 3x3, как в HJSON

            // УДАЛЕНЫ поля, которые вызывали ошибку "cannot find symbol"
            // this.recoilAmount = 5f;
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
                    this.collidesGround = true; // Добавлено для наземных целей
                    this.hitEffect = new WaveEffect(){{
                        this.sizeFrom = 0; // ИСПРАВЛЕНО: используем sizeFrom
                        this.sizeTo = 40;  // ИСПРАВЛЕНО: используем sizeTo
                        this.lifetime = 60f;
                        // this.color = new Color(0.5f, 0.5f, 0.5f, 1f); // УДАЛЕНО: поле color
                    }};
                    // Добавляем fogEffect (аналог despawnEffect в Java)
                    this.despawnEffect = new WaveEffect(){{
                        this.sizeFrom = 0;
                        this.sizeTo = 100;
                        this.lifetime = 180f;
                        // this.color = new Color(0.3f, 0.3f, 0.3f, 0.7f); // УДАЛЕНО: поле color
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
                    this.collidesGround = true; // Добавлено для наземных целей
                    this.hitEffect = new WaveEffect(){{
                        this.sizeFrom = 0; // ИСПРАВЛЕНО: используем sizeFrom
                        this.sizeTo = 60;  // ИСПРАВЛЕНО: используем sizeTo
                        this.lifetime = 120f;
                        // this.color = new Color(0.7f, 0.4f, 0.1f, 0.8f); // УДАЛЕНО: поле color
                    }};
                    // Добавляем fogEffect (аналог despawnEffect в Java)
                    this.despawnEffect = new WaveEffect(){{
                        this.sizeFrom = 70;
                        this.sizeTo = 150;
                        this.lifetime = 240f;
                        // this.color = new Color(0.3f, 0.3f, 0.3f, 0.7f); // УДАЛЕНО: поле color
                    }};
                }}
            );

            // Требования к ресурсам
            this.requirements(Category.turret, BuildVisibility.shown, with(Items.titanium, 100, Items.lead, 80, Items.silicon, 50));
            this.category = Category.turret;
            // this.research = Blocks.sniper; // УДАЛЕНО: поле research
        }};
    }
}