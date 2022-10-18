package dev.lumberisland.core;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.java.annotation.plugin.Description;
import org.bukkit.plugin.java.annotation.plugin.Plugin;
import org.bukkit.plugin.java.annotation.plugin.author.Author;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Plugin(name = "LumberSystem-TREE", version = "1.0.32")
@Author("Saidora")
@Description("""
        System who create custom mechanics for trees.
        He make server more harder to play.
        Player must put much effort to game.

        Plugin is texted in programing language: Kotlin""")
public class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    private final ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(2);

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }

    @Override
    public void onEnable() {
        instance = this;
    }
}
