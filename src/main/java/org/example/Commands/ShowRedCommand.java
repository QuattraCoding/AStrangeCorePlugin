package org.example.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.MinecraftChat.Messages.BuiltMessages.RedMessage;
import org.jetbrains.annotations.NotNull;

public class ShowRedCommand extends Command {
    public ShowRedCommand() {
        super("ShowRed");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            RedMessage.sendAdd((Player) commandSender);
        }
        return true;
    }
}
