package mindustry.content.units;

import arc.graphics.Color;
import mindustry.type.UnitType;
import mindustry.gen.UnitWaterMove;
import mindustry.type.Weapon;
import mindustry.content.StatusEffects;
//import mindustry.entities.abilities.SpawnDeathAbility;
import mindustry.entities.bullet.BasicBulletType;

public class t2ship46e8a66000beaa5e90c4173c130fa56c357a6522aa3c7329932707077effa89f {
    public static UnitType createUnit() {
        return new UnitType("t2ship46e8a66000beaa5e90c4173c130fa56c357a6522aa3c7329932707077effa89f") {
            {
                accel = 0.4f;
                aimDst = 5;
                allowedInPayloads = true;
                allowLegStep = false;
                description = "T1 Ship";
                health = 300;
                speed = 1.15f;
                rotateSpeed = 1.8f;
                range = 21;
                flying = false;
                rotateMoveFirst = false;
                hitSize = 11;
                canDrown = false;
                hovering = false;
                naval = true;
                faceTarget = false;
                physics = true;
                bounded = true;
                outlineColor = Color.valueOf("575767ff");
                engineOffset = 5.5f;
                engineSize = 2.5f;
                immunities.add(StatusEffects.wet);

                constructor = UnitWaterMove::create;

                load();
            }
        };
    }
}