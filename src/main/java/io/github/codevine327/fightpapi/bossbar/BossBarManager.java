package io.github.codevine327.fightpapi.bossbar;

import io.github.codevine327.fightpapi.FightPAPI;
import io.github.codevine327.fightpapi.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.logging.Logger;

public class BossBarManager implements Listener {
    public static void init() {
        FightPAPI plugin = FightPAPI.getInstance();
        Logger logger = plugin.getLogger();
        FileConfiguration config = plugin.getConfig();

        if (config.getBoolean("boss-bar.enable", false)) {
            logger.info("BossBar 已启用。");
            Bukkit.getPluginManager().registerEvents(new BossBarManager(), plugin);
            new BarUpdateTask().runTaskTimer(plugin, 1L, 1L);
        } else {
            logger.info("BossBar 已禁用。");
        }
    }

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        FightPAPI plugin = FightPAPI.getInstance();
        PlayerData playerData = plugin.getPlayerData().get(event.getPlayer().getUniqueId());
        BossBar bossBar = Bukkit.createBossBar("", BarColor.PURPLE, BarStyle.SOLID);
        playerData.setBossBar(bossBar);
        bossBar.addPlayer(event.getPlayer());
        bossBar.setVisible(true);
    }
}
