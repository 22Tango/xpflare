package net.mcreator.xpflare.procedures;

import net.mcreator.xpflare.XpflareMod;

import java.util.Map;

public class BrittleActiveTickConditionProcedure {
	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("amplifier") == null) {
			if (!dependencies.containsKey("amplifier"))
				XpflareMod.LOGGER.warn("Failed to load dependency amplifier for procedure BrittleActiveTickCondition!");
			return false;
		}
		if (dependencies.get("duration") == null) {
			if (!dependencies.containsKey("duration"))
				XpflareMod.LOGGER.warn("Failed to load dependency duration for procedure BrittleActiveTickCondition!");
			return false;
		}
		double amplifier = dependencies.get("amplifier") instanceof Integer
				? (int) dependencies.get("amplifier")
				: (double) dependencies.get("amplifier");
		double duration = dependencies.get("duration") instanceof Integer
				? (int) dependencies.get("duration")
				: (double) dependencies.get("duration");
		double baseRate = 0;
		double rateWithAmplifier = 0;
		baseRate = (double) 50;
		rateWithAmplifier = (double) (baseRate / Math.pow(2, (amplifier)));
		if ((Math.floor(rateWithAmplifier) > 0)) {
			return (((duration) % Math.floor(rateWithAmplifier)) == 0);
		}
		return (true);
	}
}
