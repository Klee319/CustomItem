package com.github.klee.customitem;

import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import com.github.klee.customitem.ItemStackUtils;
import org.bukkit.inventory.ShapelessRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.github.klee.customitem.ItemStackUtils.getCustomTag;

public class RecipeUtils {
    private static final CustomItem plugin=CustomItem.getPlugin();

    public static ShapedRecipe CreateNormalBlock(ItemStack base,ItemStack result){
        String id = getCustomTag(result,"unique_id");
        NamespacedKey key= new NamespacedKey(plugin, Objects.requireNonNull(id));
        ShapedRecipe recipe=new ShapedRecipe(key,result);
        recipe.shape("AAA","AAA","AAA");
        recipe.setIngredient('A',base);
        return recipe;
    }

    public static ShapedRecipe fixedRecipe(ItemStack result,List<String> shapes, Map<Character,ItemStack> ingredient){
        String id = getCustomTag(result,"unique_id");
        NamespacedKey key= new NamespacedKey(plugin, Objects.requireNonNull(id));
        if(shapes!=null){
            ShapedRecipe recipe=new ShapedRecipe(key,result);
            recipe.shape(shapes.get(0),shapes.get(1),shapes.get(2));
            for(Character character : ingredient.keySet()){
                recipe.setIngredient(character,ingredient.get(character));
            }
            return recipe;
        }

    }

    public static ShapelessRecipe Recipe(ItemStack result,@Nullable List<String> shapes, Map<Character,ItemStack> ingredient){
        String id = getCustomTag(result,"unique_id");
        NamespacedKey key= new NamespacedKey(plugin, Objects.requireNonNull(id));

            ShapelessRecipe recipe = new ShapelessRecipe(key, result);
            for(Character character : ingredient.keySet()){
                int count=character-'0';
                recipe.addIngredient(count,ingredient.get(character));
            }
            return recipe;


    }

}
