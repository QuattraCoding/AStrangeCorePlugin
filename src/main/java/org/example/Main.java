package org.example;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.example.CommandExecutor.CommandExecutor;
import org.example.Listeners.OnPlayerJoinAndLeave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main extends JavaPlugin {

    public static ArrayList<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
    public static ArrayList<Player> admins;
    static public Scoreboard staticScoreboard;
    public static List<String> admin;
    BukkitTask task1;

    @Override
    public void onEnable(){
        admin = getConfig().getStringList("modTeamNames");
        new CommandExecutor(this);
        new OnPlayerJoinAndLeave(this);
        // task1 = new UpdateAdminArray(this).runTaskTimerAsynchronously(this, 0, 5);
        updatePlayerCount();
        Bukkit.broadcastMessage("aStrangeCore is working succesfully.");
    }

    @Override
    public void onDisable(){
        if (!Main.admins.isEmpty()){
            Main.admins.clear();
            Bukkit.broadcastMessage("admins cleared");
        }
        updatePlayerCount();
        Bukkit.broadcastMessage("aStrangeCore has shut down.");
    }

    public static void updatePlayerCount(){
        onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        Bukkit.broadcastMessage(String.valueOf(onlinePlayers));
    }

}
