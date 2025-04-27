package org.example.MinecraftChat.Messages.BuiltMessages;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.example.MinecraftChat.CenteredMessages.CenterMessage;
import org.example.Main;
import org.example.MinecraftChat.Messages.MessageTemplate;
import org.example.MinecraftChat.Add.AddComponents.GreenRedTextComponent;

import javax.annotation.Nonnull;
import java.util.ArrayList;


public class ChooseTeam extends MessageTemplate {
    public ChooseTeam(Main plugin, Player plr) {
        super(plugin, plr);
    }

    static public ArrayList<TextComponent> buildMessagePlayer(@Nonnull Player plr) {
        ArrayList<TextComponent> strings = new ArrayList<>();

        TextComponent red = GreenRedTextComponent.RedGreenTextComponentFactory(GreenRedTextComponent.redOrGreen.RED, plr);
        TextComponent green = GreenRedTextComponent.RedGreenTextComponentFactory(GreenRedTextComponent.redOrGreen.GREEN, plr);
        red.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/showred"));
        green.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/showgreen"));
        TextComponent newText = createCenteredTextComponent(15, red, green);
        TextComponent choose = new TextComponent("Choose team");
        choose.setColor(ChatColor.DARK_GRAY);
        TextComponent textComponent = new TextComponent(CenterMessage.sendCenteredMessage(ChatColor.DARK_GRAY + choose.getText()));

        strings.add(space);
        strings.add(textComponent);
        strings.add(space);
        strings.add(space);
        strings.add(space);
        strings.add(newText);
        strings.add(space);
        strings.add(space);

        return strings;
    }

}



