package io.github.codevine327.fightpapi.bossbar;

import io.github.codevine327.fightpapi.FightPAPI;
import io.github.codevine327.fightpapi.PlayerData;
import me.clip.placeholderapi.PlaceholderAPI;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class BarUpdateTask extends BukkitRunnable {
    String title;

    public BarUpdateTask() {
        String unprocessedTitle = FightPAPI.getInstance().getConfig().getString("boss-bar.title", "次伤：%ad% 秒伤：%dps%");
        LegacyComponentSerializer serializer = LegacyComponentSerializer.legacySection();
        title = serializer.serialize(MiniMessage.miniMessage().deserialize(unprocessedTitle));
    }

    @Override
    public void run() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            PlayerData playerData = FightPAPI.getInstance().getPlayerData().get(player.getUniqueId());
            playerData.getBossBar().setTitle(PlaceholderAPI.setPlaceholders(player, title));
        });
    }
}
