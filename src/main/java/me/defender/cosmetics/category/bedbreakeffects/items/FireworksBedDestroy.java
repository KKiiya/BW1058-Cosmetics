package me.defender.cosmetics.category.bedbreakeffects.items;

import com.andrei1058.bedwars.api.arena.team.ITeam;
import com.cryptomorin.xseries.XMaterial;
import me.defender.cosmetics.api.cosmetics.RarityType;
import me.defender.cosmetics.api.cosmetics.category.BedDestroy;
import me.defender.cosmetics.category.victorydance.util.UsefulUtilsVD;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

/**
 * Bed destroy effect.
 * Spawn a rocket to celebrate your bed break!
 */
public class FireworksBedDestroy extends BedDestroy {
    /** {@inheritDoc} */
    @Override
    public ItemStack getItem() {
        return XMaterial.FIREWORK_ROCKET.parseItem();
    }
    /** {@inheritDoc} */
    @Override
    public String base64() {
        return null;
    }
    /** {@inheritDoc} */
    @Override
    public String getIdentifier() {
        return "fireworks";
    }
    /** {@inheritDoc} */
    @Override
    public String getDisplayName() {
        return "Fireworks";
    }
    /** {@inheritDoc} */
    @Override
    public List<String> getLore() {
        return Arrays.asList("&7Spawns a rocket to celebrate", "&7your bed break!");
    }
    /** {@inheritDoc} */
    @Override
    public int getPrice() {
        return 5000;
    }
    /** {@inheritDoc} */
    @Override
    public RarityType getRarity() {
        return RarityType.COMMON;
    }
    /** {@inheritDoc} */
    @Override
    public void execute1058(Player player, Location bedLocation, ITeam victimTeam) {
        UsefulUtilsVD.spawnFireWorks(player, 1, Color.RED, Color.GREEN, bedLocation, false);
    }

    @Override
    public void execute2023(Player player, Location bedLocation, com.tomkeuper.bedwars.api.arena.team.ITeam victimTeam) {
        UsefulUtilsVD.spawnFireWorks(player, 1, Color.RED, Color.GREEN, bedLocation, false);
    }
}
