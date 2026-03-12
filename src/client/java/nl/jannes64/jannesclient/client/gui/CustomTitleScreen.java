package nl.jannes64.jannesclient.client.gui;

import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import nl.jannes64.jannesclient.client.COLOR;
import nl.jannes64.jannesclient.client.Reference;

public class CustomTitleScreen extends Screen {

    private static final Identifier LOGO =
            Identifier.of(Reference.MOD_ID, "textures/gui/logo.png");


    public CustomTitleScreen() {
        super(Text.literal("Custom Title"));
    }

    @Override
    protected void init() {

        int centerX = this.width / 2;
        int centerY = this.height / 4 + 48;

        // Singleplayer
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Singleplayer"),
                button -> client.setScreen(new SelectWorldScreen(this))
        ).dimensions(centerX - 100, centerY, 200, 20).build());

        // Multiplayer
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Multiplayer"),
                button -> client.setScreen(new MultiplayerScreen(this))
        ).dimensions(centerX - 100, centerY + 24, 200, 20).build());

        // Options
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Options"),
                button -> client.setScreen(new OptionsScreen(this, client.options))
        ).dimensions(centerX - 100, centerY + 48, 98, 20).build());

        // Quit
        this.addDrawableChild(ButtonWidget.builder(
                Text.literal("Quit"),
                button -> client.scheduleStop()
        ).dimensions(centerX + 2, centerY + 48, 98, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        context.fillGradient(0,0,width, height, COLOR.BG_LIGHT,COLOR.BG_DARK );
        super.render(context, mouseX, mouseY, delta);

        context.drawTexture(
                RenderPipelines.GUI_TEXTURED,
                LOGO,
                width / 2 - 30,
                40,
                0,
                0,
                60,
                60,
                60,
                60
        );

        context.drawCenteredTextWithShadow(
                this.textRenderer,
                "My Custom Menu",
                this.width / 2,
                20,
                0xFFFFFF
        );
    }
}
