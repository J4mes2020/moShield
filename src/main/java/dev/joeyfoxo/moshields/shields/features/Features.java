package dev.joeyfoxo.moshields.shields.features;

import dev.joeyfoxo.moshields.manager.ShieldType;

import java.util.HashSet;
import java.util.Set;

public record Features() {

    private static final Set<ShieldType> sinkableShields = new HashSet<>();
    private static final Set<ShieldType> reflectionShields = new HashSet<>();

    public static Set<ShieldType> getSinkableShields() {
        return sinkableShields;
    }
    public static Set<ShieldType> getReflectionShields() {
        return reflectionShields;
    }

    public static void addSinkableShield(ShieldType shieldType) {
        sinkableShields.add(shieldType);
    }

    public static void addReflectionShield(ShieldType shieldType) {
        reflectionShields.add(shieldType);
    }
}
