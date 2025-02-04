package sustech.sustoilmd;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sustech.sustoilmd.complexBlocks.Bio_Fridge;

public class SustoilMD implements ModInitializer {
    public static final String MOD_ID = "sustoilmd";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            LOGGER.info("UseBlockCallback triggered");
            ItemStack heldItem = player.getStackInHand(hand);
            if (heldItem.getItem() == ModItems.EXPLANATORY_LIQUID_BP || heldItem.getItem() == ModItems.EXPLANATORY_LIQUID_B) {
                LOGGER.info("Player is holding EXPLANATORY_LIQUID_BP");
                BlockPos blockPos = hitResult.getBlockPos();
                BlockState blockState = world.getBlockState(blockPos);

                if (blockState.getBlock() == ModBlocks.POLLUTION_BLOCK) {
                    LOGGER.info("Pollution block detected, replacing with grass block");
                    world.setBlockState(blockPos, Blocks.GRASS_BLOCK.getDefaultState());
                    LOGGER.info("Block replaced at position: " + blockPos);

                    if (!player.isCreative()) {
                        heldItem.decrement(1);
                    }

                    return ActionResult.SUCCESS;
                }
            }

            return ActionResult.PASS;
        });

        ModBlocks.initialize();
        ModItems.initialize();
        ModItemGroups.initialize();
        Bio_Fridge.initialize();
        ModEntityTypes.initialize();
        ModFluids.initialize();
        ModScreenHandlers.registerAll();

        LOGGER.info("Hello Fabric world!");
    }
}