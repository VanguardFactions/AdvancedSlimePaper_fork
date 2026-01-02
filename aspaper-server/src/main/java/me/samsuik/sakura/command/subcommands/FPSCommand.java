package me.samsuik.sakura.command.subcommands;

import me.samsuik.sakura.command.BaseSubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jspecify.annotations.NullMarked;

import java.util.List;

@NullMarked
public final class FPSCommand extends BaseSubCommand {

    public FPSCommand(String name) {
        super(name);
        this.description = "Shows FPS information";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player player)) {
            return;
        }

        // TODO: fps monitoring requires patches
        player.sendMessage(net.kyori.adventure.text.Component.text(
            "FPS monitoring requires patches to be applied",
            net.kyori.adventure.text.format.NamedTextColor.RED
        ));
    }

    @Override
    public void tabComplete(List<String> list, String[] args) throws IllegalArgumentException {}
}

