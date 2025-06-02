package mindustry.content.units;

import mindustry.ai.types.MissileAI; // Для контроллера
import mindustry.content.StatusEffects; // Для эффектов
import arc.graphics.Color;
import mindustry.type.UnitType;
import mindustry.gen.UnitEntity;
import mindustry.type.Weapon;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.abilities.StatusFieldAbility;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.effect.WaveEffect;

public class towrocket {
    public static UnitType createtowrocket() {
        return new UnitType("towrocket") {{
            localizedName = "towrocket for units";
            speed = 3f;
            health = 45;
            hitSize = 1f;
            controller = u -> new MissileAI();
            flying = true;
            omniMovement = false;
            outlineColor = Color.valueOf("2d2f39");
            constructor = UnitEntity::create;

            weapons.add(new Weapon() {{
                shootCone = 140f;
                mirror = false;
                shootOnDeath = true;
                x = 0f;
                y = 0f;
                //despawnOnHit = true;

                bullet = new BombBulletType() {{
                    splashDamageRadius = 40f;
                    splashDamage = 100f;
                    instantDisappear = true;
                    killShooter = true;
                    hittable = false;
                    collidesAir = true;
                    status = StatusEffects.melting;
                    pierce = true;
                    shootEffect = Fx.none;

                    hitEffect = new WaveEffect() {{
                        lifetime = 25f;
                        sizeFrom = 10f;
                        sizeTo = 30f;
                        strokeFrom = 3f;
                        strokeTo = 0f;
                        colorFrom = Color.valueOf("ffca14");
                        colorTo = Color.valueOf("ff0010");
                    }};
                }};
            }});
        }};
    }
}
