package com.github.klee.customItem.additionalItem;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.github.klee.customItem.ItemStackUtils.*;
import static com.github.klee.customItem.RecipeUtils.createBlockRecipe;
import static com.github.klee.customItem.RecipeUtils.unZipBlockRecipe;


public class CompressedBlock {

    public ItemStack compressedRedStoneBlock= createNewItem(Material.STICK, "compressed_redstone_block", "&b圧縮レッドストーンブロック", 1);
    public ItemStack compressedRedStoneBlockX9= createNewItem(Material.REDSTONE_BLOCK, "compressed_redstone_block_x9", "&e9倍圧縮レッドストーンブロック", 2);
    public ItemStack compressedLapisLazuliBlock = createNewItem(Material.LAPIS_BLOCK, "compressed_lapis_lazuli_block", "&b圧縮ラピスラズリブロック", 3);
    public ItemStack compressedLapisLazuliBlockX9= createNewItem(Material.LAPIS_BLOCK, "compressed_lapis_lazuli_block_x9", "&e9倍圧縮ラピスラズリブロック", 4);
    public ItemStack compressedEmeraldBlock= createNewItem(Material.EMERALD_BLOCK, "compressed_emerald_block", "&b圧縮エメラルドブロック", 5);
    public ItemStack compressedEmeraldBlockX9= createNewItem(Material.EMERALD_BLOCK, "compressed_emerald_block_x9", "&e9倍圧縮エメラルドブロック", 6);
    public ItemStack compressedDiamondBlock= createNewItem(Material.DIAMOND_BLOCK, "compressed_diamond_block", "&b圧縮ダイヤモンドブロック", 7);
    public ItemStack compressedDiamondBlockX9= createNewItem(Material.DIAMOND_BLOCK, "compressed_diamond_block_x9", "&e9倍圧縮ダイヤモンドブロック", 7);
    public ItemStack compressedIronBlock= createNewItem(Material.IRON_BLOCK, "compressed_iron_block", "&b圧縮鉄ブロック", 8);
    public ItemStack compressedIronBlockX9= createNewItem(Material.IRON_BLOCK, "compressed_iron_block_x9", "&e 9倍圧縮鉄ブロック", 9);
    public ItemStack compressedGoldBlock= createNewItem(Material.GOLD_BLOCK, "compressed_gold_block", "&b圧縮金ブロック", 10);
    public ItemStack compressedGoldBlockX9= createNewItem(Material.GOLD_BLOCK, "compressed_gold_block_x9", "&e9倍圧縮金ブロック", 11);
    public ItemStack compressedCoalBlock= createNewItem(Material.COAL_BLOCK, "compressed_coal_block", "&b圧縮石炭ブロック", 12);
    public ItemStack compressedCoalBlockX9= createNewItem(Material.COAL_BLOCK, "compressed_coal_block_x9", "&e9倍圧縮石炭ブロック", 13);
    public ItemStack compressedCopperBlock = createNewItem(Material.COPPER_BLOCK, "compressed_copper_block", "&b圧縮銅ブロック", 14);
    public ItemStack compressedCopperBlockX9 = createNewItem(Material.COPPER_BLOCK, "compressed_copper_block_x9", "&e9倍圧縮銅ブロック", 15);
    public List<List<ItemStack>> Blocks = Arrays.asList(
            Arrays.asList(ItemStack.of(Material.REDSTONE_BLOCK),compressedRedStoneBlock,compressedRedStoneBlockX9),
           Arrays.asList(ItemStack.of(Material.LAPIS_BLOCK),compressedLapisLazuliBlock,compressedLapisLazuliBlockX9),
            Arrays.asList(ItemStack.of(Material.EMERALD_BLOCK),compressedEmeraldBlock,compressedEmeraldBlockX9),
           Arrays.asList(ItemStack.of(Material.DIAMOND_BLOCK),compressedDiamondBlock,compressedDiamondBlockX9),
            Arrays.asList(ItemStack.of(Material.IRON_BLOCK),compressedIronBlock,compressedIronBlockX9),
          Arrays.asList(ItemStack.of(Material.GOLD_BLOCK),compressedGoldBlock,compressedGoldBlockX9),
            Arrays.asList(ItemStack.of(Material.COAL_BLOCK),compressedCoalBlock,compressedCoalBlockX9),
           Arrays.asList(ItemStack.of(Material.COPPER_BLOCK),compressedCopperBlock,compressedCopperBlockX9)
    );
    public  List<Recipe> recipes;
    public CompressedBlock() {
        this.recipes = new ArrayList<>();
        for (List<ItemStack> block : Blocks) {
            for(ItemStack item : block){
                setCustomTag(item, "placed", "false");
                addAura(item);
            }
            for(int i=1;i<block.size();i++) {
                recipes.add(createBlockRecipe(block.get(i-1), block.get(i)));
                recipes.add(unZipBlockRecipe(block.get(i), block.get(i-1)));
            }
        }
    }






}
