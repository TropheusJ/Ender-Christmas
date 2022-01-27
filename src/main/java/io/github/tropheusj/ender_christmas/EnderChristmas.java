package io.github.tropheusj.ender_christmas;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;

public class EnderChristmas implements ClientModInitializer {
	public static final ResourceLocation CHRISTMAS_ENDER_CHEST_LOCATION = new ResourceLocation("ender_christmas", "ender_christmas");
	public static final Material CHRISTMAS_ENDER_CHEST_MATERIAL = new Material(
			InventoryMenu.BLOCK_ATLAS, EnderChristmas.CHRISTMAS_ENDER_CHEST_LOCATION
	);

	@Override
	public void onInitializeClient() {
		ClientSpriteRegistryCallback.event(InventoryMenu.BLOCK_ATLAS).register((atlasTexture, registry) ->
				registry.register(CHRISTMAS_ENDER_CHEST_LOCATION)
		);
	}
}
