package org.example.Commands;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.example.CommandExecutor.CommandExecutor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.example.Main;
import javax.annotation.Nonnull;
import java.util.*;

public class UpdateAdminList extends Command {
    static Main plugin;
    static List<String> str;
    static Scoreboard scr;
    public UpdateAdminList(){
        super("updateadminlist");
        this.usageMessage = "";
        plugin = CommandExecutor.staticPlugin;
        str = plugin.getConfig().getStringList("modTeamNames");
        scr = AdminChatCommand.scr;
    }

    @Override
    public boolean execute(@Nonnull CommandSender commandSender,@Nonnull String s,@Nonnull String[] strings) {
        updateAdmins();
        Bukkit.broadcastMessage(String.valueOf(Main.admins));
        return true;
    }

    static public Collection<? extends Player> update(List<String> strings){
        Collection<Player> admins = new HashSet<>();
        ArrayList<Team> teams = new ArrayList<>(updateTeams(strings));
            for (Team t : teams ){
                info("Checking team: " + t.getName());
                for (String p : t.getEntries()){
                    if (!admins.contains(plugin.getServer().getPlayer(p)) && Bukkit.getOnlinePlayers().contains(plugin.getServer().getPlayer(p))){
                    admins.add(plugin.getServer().getPlayer(p));
                    }
                }
            }
        return admins;
    }

    static public Collection<? extends Team> updateTeams(List<String> str){
        Collection<Team> teamCollection = new HashSet<>();
        /*
        * Creates teams that should be checked. adds those to Collection that is returned
        */
        for (String s : str){
            if (scr.getTeam(s) != null){
                Team team = scr.getTeam(s);
                teamCollection.add(team);
                info(s + " exists. now instanciated.");
            }
            else {
                    info("No Team with name " + s + " exists.");
            }
        }
        /*
        * default option, when no teams are found.
        */
        if (teamCollection.isEmpty()){
            info("teamCollection is empty, no teams found");
            Collection<Team> defaultCollection = new HashSet<>();
            Team team = scr.registerNewTeam("default_team");
            Bukkit.broadcastMessage("Default team has been created. no teams has been found.");
            defaultCollection.add(team);
            return defaultCollection;
        }
        return teamCollection;
    }

    static public void updateAdmins(){
        Main.admins = new ArrayList<>(update(Main.admin));
    }

    static public void info(String str){
        //localised info for logger.
        plugin.getLogger().info(str);
    }
}
