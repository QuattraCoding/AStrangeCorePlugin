package org.example.CenteredMessages;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class CenterMessage {

    static public String sendCenteredMessage(String text) {
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

    static public TextComponent sendBlankMessage(int spaceCount) {
        return new TextComponent(" ".repeat(Math.max(0, spaceCount)));
    }

    static public TextComponent sendBlankCenteredMessage(Player player) {
        int CENTER_PX = 154; // The center of the chat in pixels
        int spaceWidth = getCharWidth(' ', false) + 1;
        int totalSpaces = CENTER_PX / spaceWidth;

        return new TextComponent(sendBlankMessage(totalSpaces));
    }
}
