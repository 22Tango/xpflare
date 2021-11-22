package net.mcreator.xpflare.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.xpflare.potion.GhostwalkerPotionEffect;
import net.mcreator.xpflare.potion.BrittlePotionEffect;
import net.mcreator.xpflare.XpflareModVariables;
import net.mcreator.xpflare.XpflareMod;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

public class XpflareclockstepProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onWorldTick(TickEvent.WorldTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				IWorld world = event.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("world", world);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				XpflareMod.LOGGER.warn("Failed to load dependency world for procedure Xpflareclockstep!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if ((XpflareModVariables.xpflareclock >= 2400)) {
			{
				List<? extends PlayerEntity> _players = new ArrayList<>(world.getPlayers());
				for (Entity entityiterator : _players) {
					if ((!(new Object() {
						boolean check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
								for (EffectInstance effect : effects) {
									if (effect.getPotion() == GhostwalkerPotionEffect.potion)
										return true;
								}
							}
							return false;
						}
					}.check(entityiterator)))) {
						if ((((entityiterator instanceof PlayerEntity) ? ((PlayerEntity) entityiterator).experienceLevel : 0) >= 1)) {
							if (entityiterator instanceof PlayerEntity)
								((PlayerEntity) entityiterator).addExperienceLevel(-((int) 1));
							if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
								((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("The Flare is Satiated"), (false));
							}
						} else {
							if ((new Object() {
								boolean check(Entity _entity) {
									if (_entity instanceof LivingEntity) {
										Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
										for (EffectInstance effect : effects) {
											if (effect.getPotion() == BrittlePotionEffect.potion)
												return true;
										}
									}
									return false;
								}
							}.check(entityiterator))) {
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 2400, (int) 2));
								if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
									((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("The Wither Comes!"), (true));
								}
							} else {
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator)
											.addPotionEffect(new EffectInstance(BrittlePotionEffect.potion, (int) 2400, (int) 1));
								if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
									((PlayerEntity) entityiterator)
											.sendStatusMessage(new StringTextComponent("The Blight! Tools and Armor are Cumbling!"), (true));
								}
							}
						}
					}
				}
			}
			XpflareModVariables.xpflareclock = (double) 0;
		} else {
			XpflareModVariables.xpflareclock = (double) (XpflareModVariables.xpflareclock + 1);
		}
	}
}
