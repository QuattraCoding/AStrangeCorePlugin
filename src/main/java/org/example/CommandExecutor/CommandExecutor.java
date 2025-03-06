package org.example.CommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.example.Commands.AdminChatCommand;
import org.example.Commands.UpdateAdminList;
import org.example.Main;

import javax.annotation.Nonnull;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class CommandExecutor implements org.bukkit.command.CommandExecutor {

    Main plugin;
    public static Main staticPlugin;
    ArrayList<Command> commands;

    public CommandExecutor(Main plugin){
    this.plugin = plugin;
    CommandExecutor.staticPlugin = plugin;
    //commands  = (ArrayList<Command>) DynamicClassLoader.loadClasses(Command.class);
        commands = new ArrayList<>();
        commands.add(new AdminChatCommand());
        commands.add(new UpdateAdminList());
        for (Command c : commands){
        Objects.requireNonNull(plugin.getCommand(c.getName())).setExecutor(this);
        Bukkit.broadcastMessage(c.getName() + " instanciated command.");
    }
    }


    @Override
    public boolean onCommand(@Nonnull CommandSender commandSender,@Nonnull Command command,@Nonnull String label,@Nonnull String[] args) {
        for (Command c : commands) {
            if (c.getName().equalsIgnoreCase(command.getName())) {
                c.execute(commandSender, label, args);
                return true;
            }
        }
        commandSender.sendMessage("no command found.");
        return false;
    }

}
