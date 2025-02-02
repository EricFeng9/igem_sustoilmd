package sustech.sustoilmd;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
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
	}
}

