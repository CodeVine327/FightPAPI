package io.github.codevine327.fightpapi.listener.attack;

import io.github.codevine327.fightpapi.FightPAPI;
import io.lumine.mythic.lib.api.event.PlayerAttackEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.UUID;

public class MMOLibsListener implements Listener {
    @EventHandler
    private void onPlayerAttackEntity(PlayerAttackEvent event) {
        UUID uuid = event.getAttacker().getPlayer().getUniqueId();
        FightPAPI.getInstance().getPlayerData().get(uuid).addAttackData((int) event.getDamage().getDamage());
    }
}
