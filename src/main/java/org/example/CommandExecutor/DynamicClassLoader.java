package org.example.CommandExecutor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.example.Teams.TeamTemplate;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DynamicClassLoader {
    static List<Object> instances;
    public static List<?> loadClasses() {
        instances = new ArrayList<>();
        //if (c.equals(Command.class)){
            try {
                Reflections reflections = new Reflections("org.example.Commands");

                Set<Class<? extends Command>> classes = reflections.getSubTypesOf(Command.class);
                for (Class<? extends Command> cl : classes) {
                    try {
                        Object instance = cl.getDeclaredConstructor().newInstance();
                        instances.add(instance);
                    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                             InvocationTargetException e) {
                        Bukkit.broadcastMessage("could not instanciate one command");
                    }
                }
            }
            catch (Exception ignored){
            }
        return instances;
    }
}
