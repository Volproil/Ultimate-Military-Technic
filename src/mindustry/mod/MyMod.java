package mindustrymod;

import mindustry.mod.*;

public class MyMod extends Mod {
    public MyMod() {
        System.out.println("MyMod loaded!");
    }

    @Override
    public void loadContent() {
        mindustrymod.content.ModContent.load();
    }
}
