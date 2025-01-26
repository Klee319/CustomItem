package com.github.klee.customItem;

import com.github.klee.customItem.additionalItem.CompressedBlock;
import org.bukkit.inventory.Recipe;

import java.util.List;

public class registerItem {

    private static void registerRecipes(List<Recipe> customRecipes){
        for(Recipe recipe : customRecipes){
            CustomItem.getPlugin().getServer().addRecipe(recipe);
        }
    }
    public static void registerRecipesAll(){
        registerRecipes(new CompressedBlock().recipes);
    }
}
