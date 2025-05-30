package mindustry.mod;

import mindustry.content.ModContent;

public class Main extends Mod {
    public Main() {
        System.out.println("MyMod loaded!");
    }

    @Override
    public void loadContent() {
        ModContent.load();
    }
}
