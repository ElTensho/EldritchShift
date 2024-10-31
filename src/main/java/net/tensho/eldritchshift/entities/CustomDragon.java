package net.tensho.eldritchshift.entities;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.piglin.AbstractPiglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.level.Level;

public class CustomDragon extends Piglin {
    private boolean isHumanoid = false;

    public void setHumanoid(boolean humanoid) {
        this.isHumanoid = humanoid;
    }

    public boolean isHumanoid(){
        return this.isHumanoid;
    }
    public CustomDragon(EntityType<? extends AbstractPiglin> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
}
