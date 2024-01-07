package io.github.codevine327.fightpapi.listener.attack;

import io.github.codevine327.fightpapi.FightPAPI;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class VanillaListener implements Listener {
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
