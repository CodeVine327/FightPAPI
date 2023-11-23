package io.github.codevine327.fightpapi;

import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.longs.LongIntImmutablePair;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class PlayerData {
    @Getter
    @Setter
    private int lastAttackDamage;
    private final List<Pair<Long, Integer>> attackDamage = new ArrayList<>();

    public int getLastSecondAttackDamage() {
        Long now = System.currentTimeMillis();
        attackDamage.removeIf(pair -> now - pair.left() > 1000);
        return attackDamage.stream().mapToInt(Pair::second).sum();
    }

    public void addAttackData(int damage) {
        lastAttackDamage = damage;
        attackDamage.add(new LongIntImmutablePair(System.currentTimeMillis(), damage));
    }
}
