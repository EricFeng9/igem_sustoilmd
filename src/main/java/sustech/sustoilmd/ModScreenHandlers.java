package sustech.sustoilmd;


import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sustech.sustoilmd.complexBlocks.Autoclave_Entity;
import sustech.sustoilmd.complexBlocks.Autoclave_ScreenHandler;
import sustech.sustoilmd.complexBlocks.Bio_Fridge_Entity;
import sustech.sustoilmd.complexBlocks.Bio_Fridge_ScreenHandler;

/**
 * 这里统一管理和注册 ScreenHandler
 */
public class ModScreenHandlers {
    public static final ScreenHandlerType<Bio_Fridge_ScreenHandler> BIO_FRIDGE_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerExtended(
                    new Identifier(SustoilMD.MOD_ID, "bio_fridge_screen_handler"),
                    (syncId, playerInventory, buf) -> {
                        // 从 PacketByteBuf 中读取方块坐标
                        BlockPos pos = buf.readBlockPos();
                        // 获取客户端世界中指定坐标的 BlockEntity
                        World world = playerInventory.player.getWorld();
                        BlockEntity blockEntity = world.getBlockEntity(pos);

                        // 如果对应的方块确实是 BioFridgeBlockEntity，就用它的 inventory
                        if (blockEntity instanceof Bio_Fridge_Entity fridgeEntity) {
                            return new Bio_Fridge_ScreenHandler(syncId, playerInventory, fridgeEntity);
                        }

                        // 如果没找到，返回一个备用的 SimpleInventory 9格
                        return new Bio_Fridge_ScreenHandler(syncId, playerInventory, new SimpleInventory(9));
                    }
            );
    public static final ScreenHandlerType<Autoclave_ScreenHandler> AUTOCLAVE_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerExtended(
                    new Identifier(SustoilMD.MOD_ID, "autoclave"),
                    (syncId, playerInventory, buf) ->
                            new Autoclave_ScreenHandler(
                                    syncId,
                                    playerInventory,
                                    (Autoclave_Entity) playerInventory.player.getWorld().getBlockEntity(buf.readBlockPos())
                            )
            );

    public static void registerAll() {
    }
}
