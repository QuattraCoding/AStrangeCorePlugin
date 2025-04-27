package org.example.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.CommandExecutor.CommandExecutor;
import org.example.Main;
import org.example.MinecraftChat.Add.ShowAdd;

import javax.annotation.Nonnull;
import java.util.Arrays;

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

            if (args.length == 0){
                plr = (Player) sender;
                showAdd.run();
            }
            else if (args.length == 1) {
                Player plr = Bukkit.getServer().getPlayer(Arrays.toString(args));
                if (plr == null){
                    sender.sendMessage("Not a player. usage: /showAdd <Player> ");
                }
                else {
                    ShowAdd.sendAdd(plr);
                }
            }

        }
        return true;
    }

}
