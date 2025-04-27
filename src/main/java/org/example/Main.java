package org.example;

import org.bukkit.Bukkit;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.Scoreboard;
import org.example.CommandExecutor.CommandExecutor;
import org.example.Listeners.OnPlayerJoinAndLeave;
import org.example.MinecraftChat.Add.ShowAdd;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public static ArrayList<Player> onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
    public static ArrayList<Player> admins;
    static public Scoreboard staticScoreboard;
    public static List<String> admin;
    static public Configuration config;
    static public Logger logger;
    BukkitTask add;

    @Override
    public void onEnable(){
        config = this.getConfig();
        admin = config.getStringList("modTeamNames");
        logger = this.getLogger();
        new CommandExecutor(this);
        new OnPlayerJoinAndLeave(this);
        // task1 = new UpdateAdminArray(this).runTaskTimerAsynchronously(this, 0, 5);
        add = new ShowAdd(this).runTaskTimer(this, 0, 20*60);

        updatePlayerCount();
        Bukkit.broadcastMessage("aStrangeCore is working succesfully.");
    }

    @Override
    public void onDisable(){
        if (!(Main.admins == null)){
            Main.admins.clear();
        }
        if (!add.isCancelled()){
            add.cancel();
        }
        Bukkit.broadcastMessage("admins cleared");
        updatePlayerCount();
        Bukkit.broadcastMessage("aStrangeCore has shut down.");
    }

    public static void updatePlayerCount(){
        onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        Bukkit.broadcastMessage(String.valueOf(onlinePlayers));
    }

}
