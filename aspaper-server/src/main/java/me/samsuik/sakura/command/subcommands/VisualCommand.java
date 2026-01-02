package me.samsuik.sakura.command.subcommands;

import me.samsuik.sakura.command.BaseSubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public final class VisualCommand extends BaseSubCommand {

    public VisualCommand(String name) {
        super(name);
        this.description = "Opens the visibility GUI";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player player)) {
            return;
        }

        player.sendMessage(net.kyori.adventure.text.Component.text(
            "Visibility GUI requires patches to be applied",
            net.kyori.adventure.text.format.NamedTextColor.RED
        ));
        player.sendMessage(net.kyori.adventure.text.Component.text(
            "This feature allows hiding TNT, falling blocks, explosions, etc.",
            net.kyori.adventure.text.format.NamedTextColor.YELLOW
        ));
    }

    @Override
    public void tabComplete(List<String> list, String[] args) throws IllegalArgumentException {}
}

