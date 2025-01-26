package com.github.klee.customItem;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.Objects;

import static com.github.klee.customItem.ItemStackUtils.getCustomTag;

public class ItemListener implements Listener {
    private static final CustomItem plugin = CustomItem.getPlugin();

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        if(Objects.equals(getCustomTag(event.getItemInHand(), "placed"), "false")){
            event.setCancelled(true);
        }
    }

}
