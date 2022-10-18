package dev.lumberisland.helpers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Method;

public class CraftBukkitHelper {

    public static String getVersion(){
        return Bukkit.getServer().getClass().getPackage().getName().substring(23);
    }

    public static Class<?> getClass(String path){
        return ReflectionHelper.getClass("org.bukkit.craftbukkit." + getVersion() + "." + path);
    }

    private static Class<?> CraftPlayerClass = getClass("entity.CraftPlayer");
    private static Method CraftPlayer_getHandle = ReflectionHelper.getMethod(CraftPlayerClass, "getHandle");

    public static Object getCraftPlayer(Player player){
        return CraftPlayerClass.cast(player);
    }

}
