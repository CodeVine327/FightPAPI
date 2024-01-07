package io.github.codevine327.fightpapi;

import io.github.codevine327.fightpapi.bossbar.BossBarManager;
import io.github.codevine327.fightpapi.listener.ListenerManager;
import io.github.codevine327.fightpapi.listener.PlayerJoinQuitListener;
import lombok.Getter;
import org.bukkit.Bukkit;
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
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new PlayerJoinQuitListener(), this);
        ListenerManager.init();
        BossBarManager.init();
        new PlaceholderHook().register();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
