package org.example.Commands;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.example.CommandExecutor.CommandExecutor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.example.Main;
import org.example.utils.Utils;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Objects;

public class AdminChatCommand extends Command {
    Main plugin;
    static Scoreboard scr;
    //public static ArrayList<Player> staticAdmins;

    public AdminChatCommand(){
        super("adminChat");
        this.usageMessage = "";
        plugin = CommandExecutor.staticPlugin;
        scr = Objects.requireNonNull(plugin.getServer().getScoreboardManager()).getMainScoreboard();
    }

    @Override
    public boolean execute(@Nonnull CommandSender commandSender,@Nonnull String s,@Nonnull String[] args) {
        Main.admins = new ArrayList<>(UpdateAdminList.update(plugin.getConfig().getStringList("modTeamNames")));
        String namePlate = "&7(Admin chat) <" + commandSender.getName() + "> ";
        if(args.length == 0){
            commandSender.sendMessage(Utils.chat("&c not enough arguments "));
        }
        else {
            String message = String.join(" ", args);
            for(Player admin : Main.admins){
                admin.sendRawMessage(Utils.chat(namePlate + message));
            }
        }
        return true;
    }

}
