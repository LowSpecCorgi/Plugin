package me.discordgoat.BM.items;

import me.discordgoat.BM.Main.Main;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;

import java.util.*;

public class RecipeBuilder {
    public boolean shaped;
    public List<String> shape;
    public List<String> ingredients;
    public List<IngredientMapEntry> ingredientMap;

    public Recipe build(NamespacedKey key, ItemStack result) {
        if (shaped) {
            ShapedRecipe recipe = new ShapedRecipe(key, result);
            recipe.shape(shape.get(0), shape.get(1), shape.get(2));
            for (IngredientMapEntry entry : ingredientMap)
                recipe.setIngredient(entry.symbol.charAt(0), Material.getMaterial(entry.item));
            return recipe;
        }
        else {
            ShapelessRecipe recipe = new ShapelessRecipe(key, result);
            for (String s : ingredients)
                recipe.addIngredient(Material.getMaterial(s));
            return recipe;
        }
    }
}
