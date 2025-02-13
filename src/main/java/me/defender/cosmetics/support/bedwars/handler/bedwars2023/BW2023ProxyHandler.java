package me.defender.cosmetics.support.bedwars.handler.bedwars2023;

import com.tomkeuper.bedwars.proxy.BedWarsProxy;
import com.tomkeuper.bedwars.proxy.api.BedWars;
import java.io.File;
import me.defender.cosmetics.Cosmetics;
import me.defender.cosmetics.api.handler.*;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class BW2023ProxyHandler implements IHandler {
    @Override
    public void register() {
        // What should be here?
    }

    @Override
    public String getAddonPath() {
        return BedWarsProxy.getPlugin().getDataFolder().getPath() + File.separator + "Addons" + File.separator + Cosmetics.getInstance().getDescription().getName();
    }

    @Override
    public ILanguage getLanguageUtil() {
        BedWars.LanguageUtil languageUtil = BedWarsProxy.getAPI().getLanguageUtil();
        return new ILanguage() {
            @Override
            public String getMessage(Player player, String path) {
                return languageUtil.getMsg(player, path);
            }

            @Override
            public List<String> getMessageList(Player player, String path) {
                return languageUtil.getList(player, path);
            }

            @Override
            public void saveIfNotExists(String path, Object data) {
                languageUtil.saveIfNotExists(path, data);
            }
        };
    }

    @Override
    public ISetupSession getSetupSession(UUID playerUUID) {
        return null;
    }

    @Override
    public IScoreboardUtil getScoreboardUtil() {
        return null;
    }

    @Override
    public IArenaUtil getArenaUtil() {
        return null;
    }
}
