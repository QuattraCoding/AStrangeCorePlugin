package org.example.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.Messages.BuiltMessages.GreenMessage;
import org.example.Messages.BuiltMessages.RedMessage;
import org.jetbrains.annotations.NotNull;

public class ShowGreenCommand extends Command {
    public ShowGreenCommand() {
        super("showGreen");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player){
            GreenMessage.sendAdd((Player) commandSender);
        }

        return true;
    }
}
