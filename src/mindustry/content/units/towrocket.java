package mindustry.content.units;

import arc.graphics.Color;
import mindustry.ai.types.MissileAI;
import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.entities.bullet.BombBulletType;
import mindustry.entities.effect.WaveEffect;
import mindustry.gen.UnitEntity;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class towrocket {
    public static UnitType createtowrocket() {
        UnitType type = new UnitType("towrocket");
        
        // Основные параметры
        type.localizedName = "TOW Rocket";
        type.speed = 3f;
        type.health = 45f;
        type.hitSize = 10f;
        type.lifetime = 70f;
        type.controller = u -> new MissileAI();
        type.flying = true;
        type.targetAir = false;
        type.targetGround = true;
        
        // Визуальные параметры
        type.outlineColor = Color.valueOf("2d2f39");
        type.engineColor = Color.valueOf("ff770e");
        type.trailColor = Color.valueOf("ffb114");
        type.engineSize = 0.7f;
        type.engineOffset = 4f;
        
        // Настройки взрыва
        type.constructor = UnitEntity::create;
        type.deathExplosionEffect = Fx.dynamicExplosion;

        // Оружие с эффектом взрыва
        Weapon weapon = new Weapon();
        weapon.shootCone = 140f;
        weapon.mirror = false;
        weapon.shootOnDeath = true;
        weapon.x = 0f;
        weapon.y = 0f;

        BombBulletType bullet = new BombBulletType();
        bullet.splashDamageRadius = 40f;
        bullet.splashDamage = 100f;
        bullet.instantDisappear = true;
        bullet.killShooter = true;
        bullet.hittable = false;
        bullet.collidesAir = true;
        bullet.status = StatusEffects.melting;
        bullet.pierce = true;
        bullet.shootEffect = Fx.none;
        bullet.despawnEffect = Fx.dynamicExplosion;
        bullet.despawnHit = true;

        // Эффект при попадании
        WaveEffect hitEffect = new WaveEffect();
        hitEffect.lifetime = 25f;
        hitEffect.sizeFrom = 10f;
        hitEffect.sizeTo = 30f;
        hitEffect.strokeFrom = 3f;
        hitEffect.strokeTo = 0f;
        hitEffect.colorFrom = Color.valueOf("ffca14");
        hitEffect.colorTo = Color.valueOf("ff0010");
        
        bullet.hitEffect = hitEffect;
        weapon.bullet = bullet;
        type.weapons.add(weapon);

        return type;
    }
}