package org.example.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.example.CommandExecutor.CommandExecutor;
import org.example.Main;
import org.example.utils.Utils;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class JoinGreenCommand extends Command {
    Main plugin;
    Scoreboard scr;

    public JoinGreenCommand() {
        super("ascgreen");
        this.plugin = CommandExecutor.staticPlugin;
        this.scr = Objects.requireNonNull(plugin.getServer().getScoreboardManager()).getMainScoreboard();

    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player plr){
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Team join turtle " + plr.getName());
            plr.sendMessage(Utils.chat("&8&lYou have joined the &2&lGreen Team!"));
            plr.playSound(plr, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
        }
        return true;
    }
}
