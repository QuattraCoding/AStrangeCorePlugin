package org.example.bukkitRunnables;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentStyle;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.example.CenteredMessages.CenterMessage;
import org.example.Main;
import org.example.Messages.BuiltMessages.ChooseTeam;
import org.example.bukkitRunnables.AddComponents.GreenRedTextComponent;

import java.util.*;

import net.kyori.adventure.*;

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
        Main.logger.info("Add running.");
        for (Player p : Main.onlinePlayers){
            for(Team t : scr.getTeams()){
                if (t.getEntries().contains(p.getName()) && Main.onlinePlayers.contains(p)){
                 break;
                }
            }
            sendAdd(p);
            p.playSound(p.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 1, 1);
        }

    }

    static public void sendAdd(Player plr) {
        strings = ChooseTeam.buildMessagePlayer(plr);
        for(BaseComponent obj : strings){
            plr.spigot().sendMessage(obj);
        }
    }

}
