package org.example.utils;

import org.bukkit.ChatColor;

import java.util.logging.Level;
import java.util.logging.LogRecord;

public class Utils {

    public static String chat(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static LogRecord createLogRecord(String str) {
        return new LogRecord(Level.INFO, str);
    }


}
