package com.github.klee.customItem;

import com.github.klee.customItem.additionalItem.CompressedBlock;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class registerItem {
    private static final Set<NamespacedKey> registeredRecipes = new HashSet<>();
    private static void registerRecipes(List<Recipe> customRecipes){
        for(Recipe recipe : customRecipes){
            CustomItem.getPlugin().getServer().addRecipe(recipe);
            if(recipe instanceof Keyed){
                registeredRecipes.add(((Keyed)recipe).getKey());
            }
            else {
                CustomItem.getPlugin().getLogger().warning("Failed to register recipe: " + recipe);
            }
        }
    }
    public static void registerRecipesAll(){
        registerRecipes(new CompressedBlock().recipes);
    }

    public static void unregisterRecipesAll(){
        for(NamespacedKey key : registeredRecipes){
            CustomItem.getPlugin().getServer().removeRecipe(key);
        }
        registeredRecipes.clear();
    }
}
