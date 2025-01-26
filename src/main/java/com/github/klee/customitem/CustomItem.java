package com.github.klee.customitem;


import org.bukkit.plugin.java.JavaPlugin;


public final class CustomItem extends JavaPlugin {
    private static CustomItem instance;
    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new ItemListener(),this);
        addAllRecipe();

    }

    @Override
    public void onDisable() {
        getLogger().info("disabled");
    }

    public static CustomItem getPlugin(){
        return  instance;
    }

    public static void addAllRecipe{

    }
}
