package io.github.codevine327.fightpapi;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        FightPAPI.getInstance().getPlayerData().put(event.getPlayer().getUniqueId(), new PlayerData());
    }

    @EventHandler
    private void onPlayerQuit(PlayerQuitEvent event) {
        FightPAPI.getInstance().getPlayerData().remove(event.getPlayer().getUniqueId());
    }

    @EventHandler
    private void onPlayerAttackEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player player) {
            FightPAPI.getInstance().getPlayerData().get(player.getUniqueId()).addAttackData((int) event.getFinalDamage());
            return;
        }

        if (event.getDamager() instanceof Projectile projectile &&
                projectile.getShooter() instanceof Player player) {
            FightPAPI.getInstance().getPlayerData().get(player.getUniqueId()).addAttackData((int) event.getFinalDamage());
        }
    }
}
