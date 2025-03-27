package org.example.bukkitRunnables;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
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
import org.example.bukkitRunnables.AddComponents.GreenRedTextComponent;

import java.util.*;

public class ShowAdd extends BukkitRunnable {
    Main plugin;
    Scoreboard scr;
    ArrayList<Team> teams;
    List<String> teamNames;
    ArrayList<BaseComponent> strings;

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
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_FALL, 1, 1);
        }

    }
    static public void createSpaces(Integer length){
        String str = " ".repeat(Math.max(0, length));
    }

    public void sendAdd(Player plr) {
        strings = new ArrayList<>(buildMessage(plr));
        for(BaseComponent obj : strings){
            plr.spigot().sendMessage(obj);

        }
    }

    static public BaseComponent createTextComponentCompound(Integer before, TextComponent message1, TextComponent message2){
        BaseComponent txtComp = new TextComponent();
        //txtComp.setText(CenterMessage.sendBlankMessage(before));
        txtComp.addExtra(message1);
        //txtComp.addExtra(CenterMessage.sendBlankMessage(5));
        txtComp.addExtra(message2);
        txtComp.addExtra(new TextComponent("this is an added extra"));
        //txtComp.addExtra(CenterMessage.sendBlankMessage(before));
        return txtComp;
    }

    public Collection<BaseComponent> buildMessage(Player plr){
        Collection<BaseComponent> strings = new HashSet<>();
        TextComponent red = GreenRedTextComponent.RedGreenTextComponentFactory(GreenRedTextComponent.redOrGreen.RED, plr);
        TextComponent green = GreenRedTextComponent.RedGreenTextComponentFactory(GreenRedTextComponent.redOrGreen.GREEN, plr);
        BaseComponent newText = createTextComponentCompound(4, red, green);


        //strings.add(new TextComponent(CenterMessage.sendBlankMessage(30)));
        //strings.add(new TextComponent(CenterMessage.sendBlankMessage(30)));
        strings.add(newText);
        //strings.add(new TextComponent(CenterMessage.sendBlankMessage(30)));
        //strings.add(new TextComponent(CenterMessage.sendBlankMessage(30)));

        return strings;
    }
}
