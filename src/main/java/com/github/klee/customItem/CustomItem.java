package com.github.klee.customItem;


import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import static com.github.klee.customItem.registerItem.registerRecipesAll;
import static com.github.klee.customItem.registerItem.unregisterRecipesAll;

//バージョンの違うクライアント（s:1.21<=>c:1.20.4 forge）でログインした後,クリエインベントリを開くと手持ちアイテムのNBTが壊れるので注意

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
        unregisterRecipesAll();
        getLogger().info("disabled");
    }


}
