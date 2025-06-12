package mindustry.content;

import arc.graphics.Color;
import mindustry.content.Blocks;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.gen.Sounds;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.effect.WaveEffect;
import mindustry.type.Category;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.meta.BuildVisibility;
import mindustry.world.draw.DrawTurret;
import static mindustry.type.ItemStack.with;


public class MyTurrets {
    public static ItemTurret antiTank;

    public static void load() {
        antiTank = new ItemTurret("antitank"){{
            description = "A powerful anti-tank turret.";
            health = 2500;
            size = 3;
            // УДАЛЕНО/ЗАКОММЕНТИРОВАНО: recoilAmount, shots, burst, burstSpacing
            // Если они вызовут проблемы, мы вернемся к ним индивидуально.

            reload = 120f;
            range = 300f;
            ammoUseEffect = Fx.casing3;
            shootSound = Sounds.explosionbig;
            targetAir = false;
            inaccuracy = 1f;
            rotateSpeed = 0.8f;
            coolantMultiplier = 0.7f;

            drawer = new DrawTurret(); 

            // Типы боеприпасов
            ammo(
                Items.graphite, new BasicBulletType(){{
                    damage = 158f;
                    speed = 5.0f;
                    lifetime = 70f;
                    width = 12f;
                    height = 12f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                    splashDamageRadius = 80f;
                    splashDamage = 158f;
                    hitEffect = new WaveEffect(){{
                        size = 40; 
                        lifetime = 60f;
                        // color = new Color(0.5f, 0.5f, 0.5f, 1f); // УДАЛЕНО/ЗАКОММЕНТИРОВАНО
                    }};
                }},
                Items.thorium, new BasicBulletType(){{
                    damage = 300f;
                    speed = 4.5f;
                    lifetime = 80f;
                    width = 14f;
                    height = 14f;
                    shootEffect = Fx.shootBig;
                    smokeEffect = Fx.shootBigSmoke;
                    splashDamageRadius = 100f;
                    splashDamage = 250f;
                    hitEffect = new WaveEffect(){{
                        size = 60; 
                        lifetime = 120f;
                        // color = new Color(0.7f, 0.4f, 0.1f, 0.8f); // УДАЛЕНО/ЗАКОММЕНТИРОВАНО
                    }};
                }}
            );

            // Требования к ресурсам
            requirements(Category.turret, BuildVisibility.shown, with(Items.titanium, 100, Items.lead, 80, Items.silicon, 50));
            category = Category.turret;
            // research = Blocks.sniper; // УДАЛЕНО/ЗАКОММЕНТИРОВАНО
        }};
    }
}