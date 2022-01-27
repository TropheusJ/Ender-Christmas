package io.github.tropheusj.ender_christmas.mixin;

import io.github.tropheusj.ender_christmas.EnderChristmas;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.Sheets;

import net.minecraft.client.resources.model.Material;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static io.github.tropheusj.ender_christmas.EnderChristmas.CHRISTMAS_ENDER_CHEST_MATERIAL;

@Environment(EnvType.CLIENT)
@Mixin(Sheets.class)
public abstract class SheetsMixin {
	@Shadow
	@Final
	public static Material ENDER_CHEST_LOCATION;

	@Inject(cancellable = true, at = @At("RETURN"), method = "chooseMaterial(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/world/level/block/state/properties/ChestType;Z)Lnet/minecraft/client/resources/model/Material;")
	private static void enderChristmas$chooseMaterial(BlockEntity blockEntity, ChestType chestType, boolean holiday, CallbackInfoReturnable<Material> cir) {
		Material material = cir.getReturnValue();
		if (material == ENDER_CHEST_LOCATION && holiday) {
			cir.setReturnValue(CHRISTMAS_ENDER_CHEST_MATERIAL);
		}
	}
}
