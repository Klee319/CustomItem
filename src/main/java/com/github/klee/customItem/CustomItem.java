package com.github.klee.customItem;


import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import static com.github.klee.customItem.registerItem.registerRecipesAll;


public final class CustomItem extends JavaPlugin {
    private static CustomItem instance;

    public static CustomItem getPlugin() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new ItemListener(), this);
        registerRecipesAll();
        getLogger().info("enabled");

    }

    @Override
    public void onDisable() {
        getLogger().info("disabled");
    }


}
