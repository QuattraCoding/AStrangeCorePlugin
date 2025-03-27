package org.example.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.checkerframework.checker.units.qual.A;
import org.example.Commands.AdminChatCommand;
import org.example.Commands.UpdateAdminList;
import org.example.Main;

import java.util.ArrayList;
import java.util.HashSet;

public class OnPlayerJoinAndLeave implements Listener {

    Main plugin;

    public OnPlayerJoinAndLeave(Main plugin){
        this.plugin = plugin;

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Main.onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        UpdateAdminList.updateAdmins();
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        Main.onlinePlayers = new ArrayList<>(Bukkit.getOnlinePlayers());
        UpdateAdminList.updateAdmins();
    }


}
