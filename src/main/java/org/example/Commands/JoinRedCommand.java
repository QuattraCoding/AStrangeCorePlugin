package org.example.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.example.CommandExecutor.CommandExecutor;
import org.example.Main;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class JoinRedCommand extends Command {
    Main plugin;
    Scoreboard scr;

    public JoinRedCommand() {
        super("ascred");
        this.plugin = CommandExecutor.staticPlugin;
        this.scr = Objects.requireNonNull(plugin.getServer().getScoreboardManager()).getMainScoreboard();

    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player plr){
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "Team join Not_turtle_aka_red " + plr.getName());
        }
        return true;
    }
}
