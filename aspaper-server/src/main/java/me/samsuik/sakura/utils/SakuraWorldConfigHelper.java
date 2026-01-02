package me.samsuik.sakura.utils;

import net.minecraft.server.level.ServerLevel;
import me.samsuik.sakura.configuration.WorldConfiguration;

/**
 * Helper class to provide Sakura configuration access to ServerLevel
 */
public class SakuraWorldConfigHelper {

    private static final java.util.Map<ServerLevel, WorldConfiguration> CONFIGS = new java.util.WeakHashMap<>();

    public static WorldConfiguration getSakuraConfig(ServerLevel level) {
        // TODO: proper configuration requires patches
        return CONFIGS.computeIfAbsent(level, l -> {
            try {
                java.lang.reflect.Constructor<WorldConfiguration> constructor =
                    WorldConfiguration.class.getDeclaredConstructor(net.minecraft.resources.ResourceLocation.class);
                constructor.setAccessible(true);
                return constructor.newInstance(l.dimension().location());
            } catch (Exception e) {
                throw new RuntimeException("WorldConfiguration requires patches or proper initialization", e);
            }
        });
    }

    public static void setSakuraConfig(ServerLevel level, WorldConfiguration config) {
        CONFIGS.put(level, config);
    }

    public static void clearConfig(ServerLevel level) {
        CONFIGS.remove(level);
    }
}

