package io.github.codevine327.fightpapi.listener;

import io.github.codevine327.fightpapi.FightPAPI;
import io.github.codevine327.fightpapi.PlayerData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinQuitListener implements Listener {
    @EventHandler(priority = EventPriority.LOW)
    private void onPlayerJoin(PlayerJoinEvent event) {
        FightPAPI.getInstance().getPlayerData().put(event.getPlayer().getUniqueId(), new PlayerData());
    }

    @EventHandler
    private void onPlayerQuit(PlayerQuitEvent event) {
        FightPAPI.getInstance().getPlayerData().remove(event.getPlayer().getUniqueId());
    }
}
