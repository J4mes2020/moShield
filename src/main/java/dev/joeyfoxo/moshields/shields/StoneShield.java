package dev.joeyfoxo.moshields.shields;

import dev.joeyfoxo.moshields.MoShields;
import dev.joeyfoxo.moshields.manager.ShieldType;
import dev.joeyfoxo.moshields.shields.features.Features;
import dev.joeyfoxo.moshields.util.UtilClass;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class StoneShield extends Shield {

    NamespacedKey key;

    public static int maxDurability = 200;

    public StoneShield(ItemStack itemStack, Component title, NamespacedKey key) {
        super(itemStack, title, maxDurability);
        this.key = key;
        createRecipe();
    }

    void createRecipe() {

        ShapedRecipe recipe = new ShapedRecipe(key, createShieldItem());
        recipe.shape("SIS", "SSS", " S ");
        recipe.setIngredient('S', new RecipeChoice.MaterialChoice(
                Material.STONE,
                Material.COBBLESTONE,
                Material.BLACKSTONE,
                Material.SMOOTH_STONE));

        recipe.setIngredient('I', Material.IRON_INGOT);
        Bukkit.addRecipe(recipe);
    }


    @Override
    void modifyMeta(ItemMeta meta) {
        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        UtilClass.setCustomModelID(meta, key, getShieldType());

    }

    @Override
    void shieldAbilities() {

        Features.addReflectionShield(getShieldType());

    }

    @Override
    public ShieldType getShieldType() {
        return ShieldType.STONE;
    }
}
