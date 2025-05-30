package mindustry.mod;

import arc.util.Log;

public class Main extends Mod {
    public Main(){
        Log.info("Mod45 Air Force mod initialized!");
    }
    
    @Override
    public void loadContent(){
        
        // Log that the battleship was loaded
        Log.info("Loaded battleship unit");
        
        // The unit is already registered in AirForceUnits.load()
        // No need to register it again here
    }
}
