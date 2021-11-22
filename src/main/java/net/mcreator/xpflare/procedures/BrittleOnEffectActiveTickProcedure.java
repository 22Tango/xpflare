package net.mcreator.xpflare.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.xpflare.potion.BrittlePotionEffect;
import net.mcreator.xpflare.XpflareMod;

import java.util.Random;
import java.util.Map;

public class BrittleOnEffectActiveTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				XpflareMod.LOGGER.warn("Failed to load dependency entity for procedure BrittleOnEffectActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0) > 0)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).addExperienceLevel(-((int) 1));
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(BrittlePotionEffect.potion);
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("The Flare is satiated."), (true));
			}
		} else {
			{
				ItemStack _ist = ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0))
						: ItemStack.EMPTY);
				if (_ist.attemptDamageItem((int) 5, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			{
				ItemStack _ist = ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1))
						: ItemStack.EMPTY);
				if (_ist.attemptDamageItem((int) 5, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			{
				ItemStack _ist = ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2))
						: ItemStack.EMPTY);
				if (_ist.attemptDamageItem((int) 5, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			{
				ItemStack _ist = ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
						: ItemStack.EMPTY);
				if (_ist.attemptDamageItem((int) 5, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			{
				ItemStack _ist = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
				if (_ist.attemptDamageItem((int) 10, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
	}
}
