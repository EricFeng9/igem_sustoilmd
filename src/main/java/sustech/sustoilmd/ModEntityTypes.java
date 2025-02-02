package sustech.sustoilmd;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sustech.sustoilmd.complexBlocks.Bio_Fridge_Entity;

public class ModEntityTypes {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of("tutorial", path), blockEntityType);
    }

    public static final BlockEntityType<Bio_Fridge_Entity> Bio_Fridge = register(
            "bio_fridge",
            // 对于 1.21.2 及以上的版本，
            // 请将 `BlockEntityType.Builder` 替换为 `FabricBlockEntityTypeBuilder`。
            BlockEntityType.Builder.create(Bio_Fridge_Entity::new, ModBlocks.Bio_Fridge).build()
    );


    public static void initialize() {
    }
}
