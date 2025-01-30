package com.github.klee.customItem;

import com.google.common.base.Preconditions;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.jetbrains.annotations.NotNull;

import javax.naming.Name;
import java.util.*;

import static com.github.klee.customItem.ItemStackUtils.getCustomTag;

public class RecipeUtils extends RecipeChoice.ExactChoice  {
    private static final CustomItem plugin = CustomItem.getPlugin();

    //ブロックレシピを作成
    public static ShapedRecipe createBlockRecipe(ItemStack base, ItemStack result) {
        String id = getCustomTag(result, "unique_id");
        NamespacedKey key = new NamespacedKey(plugin, Objects.requireNonNull(id) + "_zip");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape("AAA", "AAA", "AAA");
        recipe.setIngredient('A', new RecipeChoice.ExactChoice(base));
        return recipe;
    }

    //ブロックの解凍レシピを作成
    public static ShapelessRecipe unZipBlockRecipe(ItemStack base, ItemStack result) {
        String id = getCustomTag(base, "unique_id");
        NamespacedKey key = new NamespacedKey(plugin, Objects.requireNonNull(id) + "_unzip");
        result.setAmount(9);
        ShapelessRecipe recipe = new ShapelessRecipe(key, result);
        recipe.addIngredient( new RecipeUtils.ExactChoice(base));
        return recipe;
    }

    //形のあるレシピを作成
    //引数はクラフト結果、形のリスト(3文字のstring*3)、置き換え対象の文字charと材料itemStackのマップ
    public static ShapedRecipe fixedRecipe(ItemStack result, List<String> shapes, Map<Character, ItemStack> ingredient) {
        String id = getCustomTag(result, "unique_id");
        NamespacedKey key = new NamespacedKey(plugin, Objects.requireNonNull(id));
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(shapes.get(0), shapes.get(1), shapes.get(2));
        for (Character character : ingredient.keySet()) {
            recipe.setIngredient(character, new RecipeUtils.ExactChoice(ingredient.get(character)));
        }
        return recipe;
    }

    //形のないレシピを作成
    //引数はクラフト結果、材料itemStackとその個数intのマップ
    public static ShapelessRecipe freeRecipe(ItemStack result, Map<ItemStack, Integer> ingredient) {
        String id = getCustomTag(result, "unique_id");
        NamespacedKey key = new NamespacedKey(plugin, Objects.requireNonNull(id));
        ShapelessRecipe recipe = new ShapelessRecipe(key, result);
        for (ItemStack item : ingredient.keySet()) {
            for(int i=0;i<ingredient.get(item);i++) {
                recipe.addIngredient(new RecipeUtils.ExactChoice(item));
            }
        }
        return recipe;
    }

}
