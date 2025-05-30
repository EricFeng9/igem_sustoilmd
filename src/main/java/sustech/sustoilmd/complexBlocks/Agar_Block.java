package sustech.sustoilmd.complexBlocks;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SlimeBlock;

public class Agar_Block extends SlimeBlock {
    public Agar_Block(Settings settings) {
        super(settings);
    }
    // 关键：设置渲染类型为透明
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL; // 必须返回 MODEL 才能应用透明渲染
    }
}
