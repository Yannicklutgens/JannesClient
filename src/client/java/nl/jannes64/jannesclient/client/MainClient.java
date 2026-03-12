package nl.jannes64.jannesclient.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.gui.screen.TitleScreen;
import nl.jannes64.jannesclient.client.gui.CustomTitleScreen;

public class MainClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
//        ClientTickEvents.END_CLIENT_TICK.register(client -> {
//            if(client.player == null) {
//                if (client.currentScreen instanceof TitleScreen) {
//                    client.setScreen(new CustomTitleScreen());
//                }
//            }
//        });
    }
}
