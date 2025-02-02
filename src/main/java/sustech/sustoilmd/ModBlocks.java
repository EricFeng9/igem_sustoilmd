package sustech.sustoilmd;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import sustech.sustoilmd.complexBlocks.Bio_Fridge;
import sustech.sustoilmd.complexBlocks.OccupiedBlock;

public class ModBlocks {
    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        Identifier id = new Identifier(SustoilMD.MOD_ID, name);

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }
        return Registry.register(Registries.BLOCK, id, block);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.CUSTOM_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.CONDENSED_DIRT.asItem());
            itemGroup.add(ModBlocks.Bio_Fridge);

        });
    }

    public static final Block CONDENSED_DIRT = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE)),
            "condensed_dirt",
            true
    );
    public static final Block Bio_Fridge = register(
            new Bio_Fridge(AbstractBlock.Settings.copy(Blocks.STONE)),
            "bio_fridge",
            true
            );
    public static final Block OCCUPIED_BLOCK = register(
            new OccupiedBlock(AbstractBlock.Settings.copy(Blocks.AIR)),
            "occupied_block",
            false
            );

}
