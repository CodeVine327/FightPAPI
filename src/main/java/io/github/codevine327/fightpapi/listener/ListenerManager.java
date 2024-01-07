package io.github.codevine327.fightpapi.listener;

import io.github.codevine327.fightpapi.FightPAPI;
import io.github.codevine327.fightpapi.listener.attack.MMOLibsListener;
import io.github.codevine327.fightpapi.listener.attack.VanillaListener;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.logging.Logger;

public class ListenerManager {
    public static void init() {
        FightPAPI plugin = FightPAPI.getInstance();
        Logger logger = plugin.getLogger();
        FileConfiguration config = plugin.getConfig();
        ConfigurationSection dataSource = config.getConfigurationSection("data-source");

        if (dataSource.getBoolean("vanilla", true)) {
            logger.info("原版伤害检测已启用。");
            Bukkit.getPluginManager().registerEvents(new VanillaListener(), plugin);
        }

        if (dataSource.getBoolean("mmolibs", false)) {
            Plugin mythicLib = Bukkit.getPluginManager().getPlugin("MythicLib");
            if (mythicLib == null) {
                logger.warning("未检测到 MythicLib(MMOLibs) 插件，已禁用该类型的伤害检测。");
            } else {
                logger.info("MMOLibs 伤害检测已启用。");
                Bukkit.getPluginManager().registerEvents(new MMOLibsListener(), plugin);
            }
        }
    }
}
