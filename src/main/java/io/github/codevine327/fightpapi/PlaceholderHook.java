package io.github.codevine327.fightpapi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlaceholderHook extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "fight";
    }

    @Override
    public @NotNull String getAuthor() {
        return "TheLittle_Yang";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) {
            return "";
        }

        if (!FightPAPI.getInstance().getPlayerData().containsKey(player.getUniqueId())) {
            return "";
        }

        if (params.equalsIgnoreCase("last_attack_damage")) {
            return String.valueOf(FightPAPI.getInstance().getPlayerData().get(player.getUniqueId()).getLastAttackDamage());
        } else if (params.equalsIgnoreCase("last_1s_attack_damage")) {
            return String.valueOf(FightPAPI.getInstance().getPlayerData().get(player.getUniqueId()).getLastSecondAttackDamage());
        } else {
            return "";
        }

    }

    @Override
    public boolean persist() {
        return true;
    }
}
