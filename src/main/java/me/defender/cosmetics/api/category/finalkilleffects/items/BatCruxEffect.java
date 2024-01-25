package me.defender.cosmetics.api.category.finalkilleffects.items;

import com.cryptomorin.xseries.XMaterial;
import com.hakan.core.HCore;
import com.hakan.core.particle.Particle;
import com.hakan.core.particle.type.ParticleType;
import com.hakan.core.utils.ColorUtil;
import me.defender.cosmetics.api.category.finalkilleffects.FinalKillEffect;
import me.defender.cosmetics.api.enums.RarityType;
import me.defender.cosmetics.api.util.Utility;
import org.bukkit.Location;
import org.bukkit.entity.Bat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.defender.cosmetics.api.util.Utility.plugin;

public class BatCruxEffect extends FinalKillEffect {
    @Override
    public ItemStack getItem() {
        return XMaterial.BAT_SPAWN_EGG.parseItem();
    }

    @Override
    public String base64() {
        return null;
    }

    @Override
    public String getIdentifier() {
        return "batcrux";
    }

    @Override
    public String getDisplayName() {
        return "Batcrux";
    }

    @Override
    public List<String> getLore() {
        return Arrays.asList("&7Spawns many bats at", "&7location of victim!");
    }

    @Override
    public int getPrice() {
        return 5000;
    }

    @Override
    public RarityType getRarity() {
        return RarityType.COMMON;
    }

    @Override
    public void execute(Player killer, Player victim, Location location, boolean onlyVictim) {

        List<Bat> bats = new ArrayList<>();

        for (int i = 0; i < 4; i++){
            Bat bat = (Bat) location.getWorld().spawnEntity(location, EntityType.BAT);
            bat.setVelocity(bat.getLocation().getDirection().multiply(0.7).setY(2));
            bat.setCustomNameVisible(true);
            int number = i + 1;
            if (onlyVictim) {
                bat.setCustomName(ColorUtil.colored("&7Deperino's horcrux #" + number));
            } else {
                bat.setCustomName(ColorUtil.colored("&7" + victim.getName() + "'s horcrux #" + number));
            }
            bats.add(bat);
        }

        if (onlyVictim) {
            for (Bat bat : bats) {
                Utility.entityForPlayerOnly(bat, victim);
            }
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                if (!bats.isEmpty()) {
                    for (Bat bat : bats) {
                        Location batLocation = bat.getLocation().clone();
                        Particle particle = new Particle(ParticleType.SMOKE_LARGE, 1, new Vector(0,0,0));
                        HCore.playParticle(victim, batLocation, particle);
                    }
                }
            }
        }.runTaskTimer(plugin(), 0L, 5L);

        long delay = (onlyVictim ? 80L : 200L);

        new BukkitRunnable(){
            @Override
            public void run() {
                for (Bat bat : bats) {
                    bat.remove();
                }
                bats.clear();
            }
        }.runTaskLater(plugin(), delay);
    }
}