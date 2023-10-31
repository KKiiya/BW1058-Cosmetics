package me.defender.cosmetics.api.category.bedbreakeffects;

import com.andrei1058.bedwars.api.events.player.PlayerBedBreakEvent;
import me.defender.cosmetics.api.BwcAPI;
import me.defender.cosmetics.api.enums.CosmeticsType;
import me.defender.cosmetics.api.enums.FieldsType;
import me.defender.cosmetics.api.enums.RarityType;
import me.defender.cosmetics.api.event.BedBreakEffectExecuteEvent;
import me.defender.cosmetics.api.util.StartupUtils;
import me.defender.cosmetics.api.util.DebugUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static me.defender.cosmetics.api.util.Utility.plugin;

public class BedDestroyHandler1058 implements Listener{
	
	@EventHandler
	public void onBedBreak1058(PlayerBedBreakEvent e) {
		String selected = new BwcAPI().getSelectedCosmetic(e.getPlayer(), CosmeticsType.BedBreakEffects);
		BedBreakEffectExecuteEvent event = new BedBreakEffectExecuteEvent(e.getPlayer());
		Bukkit.getServer().getPluginManager().callEvent(event);

		if(event.isCancelled()) return;
		boolean isBedDestroysEnabled = plugin().getConfig().getBoolean("bed-break-effects.enabled");
		if (!isBedDestroysEnabled) return;

		DebugUtil.addMessage("Executing " + selected + " Bed Break Effect for " + e.getPlayer().getDisplayName());
		Player p = e.getPlayer();
		Location loc = e.getVictimTeam().getBed();

		for(BedDestroy bedDestroy : StartupUtils.bedDestroyList){
			if(selected.equals(bedDestroy.getIdentifier())){
				if(bedDestroy.getField(FieldsType.RARITY, p) != RarityType.NONE) {
					bedDestroy.execute1058(p, loc, e.getVictimTeam());
				}
			}
		}
	}
}