package org.example.Messages.BuiltMessages;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.example.CommandExecutor.CommandExecutor;
import org.example.Main;
import org.example.Messages.MessageTemplate;
import org.example.bukkitRunnables.AddComponents.GreenRedTextComponent;
import org.example.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GreenMessage extends MessageTemplate {
    static List<String> greenMessageLoreList;
    static List<String> greenMessageInfoList;
    static Player plr;

    static ArrayList<TextComponent> strings;

    static TextComponent[] lore = new TextComponent[4];
    static TextComponent[] explanation = new TextComponent[3];

    public GreenMessage(Main plugin) {
        super(plugin);
    }

    static public ArrayList<TextComponent> buildMessage(Player plr) {
        GreenMessage.plr = plr;
        greenMessageLoreList = CommandExecutor.staticPlugin.getConfig().getStringList("greenTeamExplanation.Lore");
        greenMessageInfoList = CommandExecutor.staticPlugin.getConfig().getStringList("greenTeamExplanation.Explanation");

        TextComponent greenTeam = new TextComponent(createCenteredTextComponent(ChatColor.GREEN + "Green Team"));

        lore[0] = new TextComponent(Utils.chat("&2&l"+ createCenteredTextComponent(greenMessageLoreList.getFirst())));
        lore[1] = new TextComponent(Utils.chat("&2&l"+ createCenteredTextComponent(greenMessageLoreList.get(1))));
        lore[2] = new TextComponent(Utils.chat("&2&l"+ createCenteredTextComponent(greenMessageLoreList.get(2))));
        lore[3] = new TextComponent(Utils.chat("&2&l"+ createCenteredTextComponent(greenMessageLoreList.get(3))));

        explanation[0] = new TextComponent(Utils.chat("&7&l"+ createCenteredTextComponent(greenMessageInfoList.getFirst())));
        explanation[1] = new TextComponent(Utils.chat("&7&l"+ createCenteredTextComponent(greenMessageInfoList.get(1))));
        explanation[2] = new TextComponent(Utils.chat("&7&l"+ createCenteredTextComponent(greenMessageInfoList.get(2))));

        ArrayList<TextComponent> strings = new ArrayList<>();

        strings.add(space);
        strings.add(greenTeam);
        strings.add(space);
        strings.add(lore[0]);
        strings.add(lore[1]);
        strings.add(lore[2]);
        strings.add(lore[3]);
        strings.add(space);
        strings.add(explanation[0]);
        strings.add(explanation[1]);
        strings.add(explanation[2]);
        strings.add(space);
        strings.add(space);
        strings.add(join());
        strings.add(space);

        return strings;
    }

    public static TextComponent join(){
        TextComponent txt = GreenRedTextComponent.RedGreenTextComponentFactory(GreenRedTextComponent.redOrGreen.GREEN, plr);
        return txt;
    }

    static public void sendAdd(Player plr) {
        strings = GreenMessage.buildMessage(plr);
        for(BaseComponent obj : strings){
            plr.spigot().sendMessage(obj);
        }
    }
}
