package sustech.sustoilmd;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import sustech.sustoilmd.complexBlocks.Bio_Fridge_ScreenHandler;
import sustech.sustoilmd.gui.Bio_Fridge_Screen;
import sustech.sustoilmd.complexBlocks.Bio_Fridge_ScreenHandler;

public class SustoilMDClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ScreenRegistry.register(
				ModScreenHandlers.BIO_FRIDGE_SCREEN_HANDLER,
                Bio_Fridge_Screen::new
		);

		// 注册油流体渲染
		FluidRenderHandlerRegistry.INSTANCE.register(
				ModFluids.STILL_OIL,
				ModFluids.FLOWING_OIL,
				new SimpleFluidRenderHandler(
						new Identifier(SustoilMD.MOD_ID+":block/still_oil"),
						new Identifier(SustoilMD.MOD_ID+":block/flowing_oil"),
						0xFFFFFF // RGB颜色（深灰色）
				)
		);

		// 将粘液块绑定到半透明渲染层（根据需求选择 TRANSLUCENT 或 CUTOUT）
		BlockRenderLayerMap.INSTANCE.putBlock(
				ModBlocks.Agar_Block_Yellow,
				RenderLayer.getTranslucent()
		);
	}
}

