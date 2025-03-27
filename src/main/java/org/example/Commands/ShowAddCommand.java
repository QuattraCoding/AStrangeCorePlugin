package org.example.Commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.CommandExecutor.CommandExecutor;
import org.example.Main;
import org.example.bukkitRunnables.ShowAdd;

import javax.annotation.Nonnull;

public class ShowAddCommand extends Command {

    Main plugin;
    Player plr;
    ShowAdd showAdd;

    public ShowAddCommand() {
        super("showAdd");
        plugin = CommandExecutor.staticPlugin;
        showAdd = new ShowAdd(plugin);
    }

    @Override
    public boolean execute(@Nonnull CommandSender sender,@Nonnull String label,@Nonnull String[] args) {
        if(sender instanceof Player){
            plr = (Player) sender;
            showAdd.run();
        }
        return true;
    }

}
