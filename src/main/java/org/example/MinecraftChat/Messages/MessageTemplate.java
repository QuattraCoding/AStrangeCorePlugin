package org.example.MinecraftChat.Messages;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.example.Main;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Objects;

public abstract class MessageTemplate {
    Main plugin;
    Scoreboard scr;
    public ArrayList<TextComponent> strings;
    public static TextComponent space = new TextComponent("\u00A0".repeat(30));


    public MessageTemplate(Main plugin) {
        this.plugin = plugin;
        this.scr = Objects.requireNonNull(plugin.getServer().getScoreboardManager()).getMainScoreboard();
        this.strings = buildMessage();

    }

    public MessageTemplate(Main plugin ,Player plr){
        this.plugin = plugin;
        this.scr = Objects.requireNonNull(plugin.getServer().getScoreboardManager()).getMainScoreboard();
        //needs strings defined in child class. from buildMessagePlayer

    }

    public static ArrayList<TextComponent> buildMessage() {
        return null;
    }

    static public ArrayList<TextComponent> buildMessagePlayer(@Nonnull Player plr){
        return null;
        //necessary
    }

    public static TextComponent createCenteredTextComponent(int padding,@Nonnull TextComponent message1,@Nonnull TextComponent message2) {
        int totalChatWidth = 320; // Approximate Minecraft chat width in pixels

        // Approximate character widths
        int spaceWidth = 4; // Normal space
        int charWidthAvg = 6; // Approximate average character width

        // Estimate text widths
        int msg1Width = message1.getText().length() * charWidthAvg;
        int msg2Width = message2.getText().length() * charWidthAvg;

        // Calculate total used width and remaining space
        int totalUsedWidth = msg1Width + msg2Width;
        int remainingWidth = totalChatWidth - totalUsedWidth - (padding * 2 * spaceWidth);

        // Calculate spacing
        int spaceCount = remainingWidth / spaceWidth / 2; // Divide by 2 for equal spacing
        String spacing = " ".repeat(Math.max(0, spaceCount));

        // Create padding
        String sidePadding = " ".repeat(Math.max(0, padding));

        // Construct final message
        TextComponent finalMessage = new TextComponent(sidePadding); // Start with padding
        finalMessage.addExtra(message1);
        finalMessage.addExtra(spacing);
        finalMessage.addExtra(message2);
        finalMessage.addExtra(sidePadding); // End with padding

        return finalMessage;
    }

    static public String createCenteredTextComponent(String text) {
        int CENTER_PX = 154; // The center of a chat message in pixels (MC uses pixel-based alignment)

        int messagePxSize = 0;
        boolean previousCode = false;
        boolean isBold = false;

        for (char c : text.toCharArray()) {
            if (c == '§') {
                previousCode = true;
                continue;
            } else if (previousCode) {
                previousCode = false;
                if (c == 'l' || c == 'L') {
                    isBold = true;
                    continue;
                } else isBold = false;
            }

            int charWidth = getCharWidth(c, isBold);
            messagePxSize += charWidth + 1;
        }

        int halvedMessageSize = messagePxSize / 2;
        int toCompensate = CENTER_PX - halvedMessageSize;
        int spaceLength = getCharWidth(' ', false) + 1;
        int compensated = 0;
        StringBuilder sb = new StringBuilder();
        while (compensated < toCompensate) {
            sb.append(" ");
            compensated += spaceLength;
        }

        return (sb.toString() + text);
    }

    private static int getCharWidth(char c, boolean isBold) {
        return switch (c) {
            case 'i', 'l', '|', '!', 'I' -> isBold ? 4 : 2;
            case 't', ' ' -> isBold ? 5 : 3;
            case 'f' -> isBold ? 5 : 4;
            case 'k', 'K', 'A', 'M', 'N', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                 'a', 'b', 'c', 'd', 'e', 'g', 'h', 'j', 'm', 'n', 'o', 'p', 'q', 'r', 's', 'u', 'v', 'w', 'x', 'y',
                 'z', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'L', 'O', 'P', 'Q', 'R', 'S', 'T', 'U' -> isBold ? 7 : 6;
            default -> isBold ? 6 : 5;
        };
    }

    public enum MessageEnum {
        NonPlayer,
        Player,
        other;

        private MessageEnum(){

        }
    }

    public int instancedBuildMessage(MessageEnum messageEnum){

        int i;

        switch (messageEnum){
            case NonPlayer ->
                    i = 1;
            case Player ->
                    i = 2;
            case other ->
                    i = 3;
            case null, default -> i = 0;
        }

        return i;
    }

}
