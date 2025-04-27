package org.example.MinecraftChat.Add;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.example.Main;
import org.example.MinecraftChat.Messages.BuiltMessages.ChooseTeam;

import java.util.*;

public class ShowAdd extends BukkitRunnable {
    Main plugin;
    Scoreboard scr;
    ArrayList<Team> teams;
    List<String> teamNames;
    static ArrayList<TextComponent> strings;

    public ShowAdd(Main plugin){
        this.plugin = plugin;
        scr = Objects.requireNonNull(plugin.getServer().getScoreboardManager()).getMainScoreboard();
        teamNames = plugin.getConfig().getStringList("modTeamNames");
    }

    @Override
    public void run() {
        Main.onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        if (!Main.onlinePlayers.isEmpty()){
            Main.logger.info("Add running.");
            for (Player p : Main.onlinePlayers){
                boolean isInTeam = false;
                for(Team t : scr.getTeams()){
                    if (t.getEntries().contains(p.getName()) && Main.onlinePlayers.contains(p)){
                        isInTeam = true;
                    }
                }
                if (!isInTeam){
                    sendAdd(p);
                    p.playSound(p, Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
                }
            }
        }

    }

    static public void sendAdd(Player plr) {
        strings = ChooseTeam.buildMessagePlayer(plr);
        for(BaseComponent obj : strings){
            plr.spigot().sendMessage(obj);
        }
    }

}
