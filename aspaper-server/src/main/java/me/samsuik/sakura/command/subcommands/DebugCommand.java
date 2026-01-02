package me.samsuik.sakura.command.subcommands;

import me.samsuik.sakura.command.BaseSubCommand;
// import me.samsuik.sakura.redstone.RedstoneNetwork; // Disabled - requires patches
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public final class DebugCommand extends BaseSubCommand {
    public DebugCommand(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player player) || args.length == 0) {
            return;
        }

        ServerPlayer nmsPlayer = ((CraftPlayer) player).getHandle();
        if (args[0].equalsIgnoreCase("redstone-cache")) {
            this.showCachedWires(player, nmsPlayer.level());
        }
    }

    @Override
    public void tabComplete(List<String> list, String[] args) throws IllegalArgumentException {
        list.add("redstone-cache");
    }

    private void showCachedWires(Player player, Level level) {
        // TODO search some way to applie patches 0035
        /*
        Set<Location> locations = new HashSet<>();
        for (RedstoneNetwork network : level.redstoneWireCache.getNetworkCache().values()) {
            byte randomColour = (byte) ThreadLocalRandom.current().nextInt(16);
            DyeColor dyeColour = DyeColor.getByWoolData(randomColour);
            Material material = Material.matchMaterial(dyeColour.name() + "_WOOL");

            if (!network.isRegistered()) {
                continue;
            }

            for (BlockPos pos : network.getWirePositions()) {
                Location location = CraftLocation.toBukkit(pos, level);
                if (player.getLocation().distance(location) >= 64.0) {
                    continue;
                }
                player.sendBlockChange(location, material.createBlockData());
                locations.add(location);
            }
        }

        player.sendRichMessage("<red>Displaying %dx cached redstone wires".formatted(locations.size()));

        level.levelTickScheduler.delayedTask(() -> {
            for (Location loc : locations) {
                player.sendBlockChange(loc, loc.getBlock().getBlockData());
            }
        }, 1200);
        */
        player.sendMessage(net.kyori.adventure.text.Component.text("Redstone cache debugging requires patches to be applied", net.kyori.adventure.text.format.NamedTextColor.RED));
    }
}
