package zektha.brush;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class Brush extends JavaPlugin implements Listener{
    private Commands commands = new Commands();

    @Override
    public void onEnable() {
        getLogger().info("BRUSH loaded");
        this.getServer().getPluginManager().registerEvents(new BrushItem(), this);
        this.getServer().getPluginManager().registerEvents(new BrushPlace(), this);
        getCommand(commands.cmd1).setExecutor(commands);
        getCommand(commands.cmd2).setExecutor(commands);
        getCommand(commands.cmd3).setExecutor(commands);
        loadConfig();
    }
    @Override
    public void onDisable() {
        getLogger().info("BRUSH stopped");
    }
    public void loadConfig(){
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
