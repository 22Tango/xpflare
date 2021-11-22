
package net.mcreator.xpflare;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

import net.minecraft.potion.PotionUtils;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.Blocks;

import net.mcreator.xpflare.potion.LongGhostwalkingPotion;
import net.mcreator.xpflare.potion.GhostwalkingPotion;

@XpflareModElements.ModElement.Tag
public class LongGostwalkingBrewBrewingRecipe extends XpflareModElements.ModElement {
	public LongGostwalkingBrewBrewingRecipe(XpflareModElements instance) {
		super(instance, 12);
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BrewingRecipeRegistry.addRecipe(new CustomBrewingRecipe());
	}
	public static class CustomBrewingRecipe implements IBrewingRecipe {
		@Override
		public boolean isInput(ItemStack input) {
			Item inputItem = input.getItem();
			return (inputItem == Items.POTION || inputItem == Items.SPLASH_POTION || inputItem == Items.LINGERING_POTION)
					&& PotionUtils.getPotionFromItem(input) == GhostwalkingPotion.potionType;
		}

		@Override
		public boolean isIngredient(ItemStack ingredient) {
			return ingredient.getItem() == Blocks.REDSTONE_WIRE.asItem();
		}

		@Override
		public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
			if (isInput(input) && isIngredient(ingredient)) {
				return PotionUtils.addPotionToItemStack(new ItemStack(input.getItem()), LongGhostwalkingPotion.potionType);
			}
			return ItemStack.EMPTY;
		}
	}
}
