package com.github.klee.customItem;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemStackUtils {

    private static final CustomItem plugin = CustomItem.getPlugin();

    public static @Nullable String getCustomTag(ItemStack item, @NotNull String key) {
        if (item == null || Material.AIR.equals(item.getType()))
            return null;
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer tag = meta.getPersistentDataContainer();
        NamespacedKey nameKey = new NamespacedKey(plugin, key);
        return tag.get(nameKey, PersistentDataType.STRING);
    }

    public static void setCustomTag(ItemStack item, @NotNull String key, @NotNull String value) {
        if (item == null || Material.AIR.equals(item.getType()))
            return;
        ItemMeta meta = item.getItemMeta();
        NamespacedKey nameKey = new NamespacedKey(plugin, key);
        PersistentDataContainer tag = meta.getPersistentDataContainer();
        tag.set(nameKey, PersistentDataType.STRING, value);
        item.setItemMeta(meta);
    }

    public static ItemStack createNewItem(Material material, String name_id, String name, boolean aura) {
        ItemStack item = new ItemStack(material);
        setCustomTag(item, "unique_id", name_id);
        Component component = LegacyComponentSerializer.legacyAmpersand().deserialize(name);
        ItemMeta meta= item.getItemMeta();
        meta.displayName(component);
        item.setItemMeta(meta);
        if (aura) {
            item.addUnsafeEnchantment(Enchantment.UNBREAKING, 1);
            item.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        return item;
    }

    public static ItemStack resetDisplay(ItemStack item, @Nullable String Title, String... Lore) {
        if (item == null || Material.AIR.equals(item.getType()))
            return null;
        ItemMeta meta = item.getItemMeta();
        List<Component> ComponentList = new ArrayList<>();
        if (!Objects.equals(Title, null)) {
            Component component = LegacyComponentSerializer.legacyAmpersand().deserialize(Title);
            meta.displayName(component);
        }
        for (String sentence : Lore) {
            ComponentList.add(LegacyComponentSerializer.legacyAmpersand().deserialize(sentence));
        }
        meta.lore(ComponentList);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack addLore(ItemStack item, @NotNull String... Lore) {
        ItemMeta meta = item.getItemMeta();
        List<Component> ComponentList = meta.lore();

        if (ComponentList == null) {
            ComponentList = new ArrayList<>();
        }

        for (String sentence : Lore) {
            ComponentList.add(LegacyComponentSerializer.legacyAmpersand().deserialize(sentence));
        }

        meta.lore(ComponentList);
        item.setItemMeta(meta);
        return item;
    }

}
