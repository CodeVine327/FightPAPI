package io.github.codevine327.fightpapi;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class FightPAPI extends JavaPlugin {
    @Getter
    private static FightPAPI instance;

    @Getter
    private final Map<UUID, PlayerData> playerData = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        new PlaceholderHook().register();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
