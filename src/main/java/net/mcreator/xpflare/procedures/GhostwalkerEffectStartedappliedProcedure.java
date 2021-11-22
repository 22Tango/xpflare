package net.mcreator.xpflare.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.xpflare.XpflareMod;

import java.util.Map;

public class GhostwalkerEffectStartedappliedProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				XpflareMod.LOGGER.warn("Failed to load dependency entity for procedure GhostwalkerEffectStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Ghostwalker, unseen by the flare"), (true));
		}
	}
}
