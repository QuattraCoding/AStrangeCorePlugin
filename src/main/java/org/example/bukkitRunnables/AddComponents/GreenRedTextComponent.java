package org.example.bukkitRunnables.AddComponents;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.example.Commands.ShowAddCommand;

import javax.annotation.Nonnull;

import static net.md_5.bungee.api.chat.ClickEvent.Action.RUN_COMMAND;

public class GreenRedTextComponent {
    static String str;
    static public TextComponent RedGreenTextComponentFactory(@Nonnull redOrGreen redOrGreen,@Nonnull Player plr){
        TextComponent txtComp = new TextComponent();


        switch(redOrGreen){
            case GREEN -> {
                ClickEvent clickEvent;
                str = "/team join turtle " + plr.getName();
            txtComp.setText("Join Green Team");
            txtComp.setColor(ChatColor.GREEN);
            clickEvent = new ClickEvent(RUN_COMMAND, str);
            txtComp.setClickEvent(clickEvent);
            }
            case RED -> {
                ClickEvent clickEvent;
                str = "/team join Not_turtle_aka_red " + plr.getName();
                txtComp.setText("Join Red Team");
                txtComp.setColor(ChatColor.RED);
                clickEvent = new ClickEvent(RUN_COMMAND, str);
                txtComp.setClickEvent(clickEvent);
            }
            case null, default -> Bukkit.broadcastMessage("not red or green, this shouldn't happen LMAO");
        }
    return txtComp;
    }

    public enum redOrGreen{
        RED,
        GREEN;

        private redOrGreen() {

        }
    }

}
