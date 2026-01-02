package me.samsuik.sakura.command.subcommands;

import me.samsuik.sakura.command.BaseSubCommand;
import net.minecraft.server.MinecraftServer;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.CraftServer;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public final class TPSCommand extends BaseSubCommand {

    public TPSCommand(String name) {
        super(name);
        this.description = "Displays the current ticks per second";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        MinecraftServer server = ((CraftServer) sender.getServer()).getServer();
        double[] recentTps = server.recentTps;
        sender.sendMessage(net.kyori.adventure.text.Component.text(
            String.format("TPS from last 1m, 5m, 15m: %.2f, %.2f, %.2f",
                recentTps[0], recentTps[1], recentTps[2]),
            net.kyori.adventure.text.format.NamedTextColor.GREEN
        ));
        sender.sendMessage(net.kyori.adventure.text.Component.text(
            "Detailed TPS graphs require patches to be applied",
            net.kyori.adventure.text.format.NamedTextColor.YELLOW
        ));
    }

    @Override
    public void tabComplete(List<String> list, String[] args) throws IllegalArgumentException {}
}

