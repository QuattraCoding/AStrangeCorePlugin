package org.example.Teams;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.example.Main;

public abstract class TeamTemplate  {

    Main plugin;
    public static String name;
    public Team team;
    Scoreboard scrbrd;

    public TeamTemplate(Main plugin, String name){
        this.plugin = plugin;
        TeamTemplate.name = name;
        this.scrbrd = Main.staticScoreboard;
        addTeamToScoreBoard();
        customiseTeams();
    }

    public void addTeamToScoreBoard(){
        team = scrbrd.registerNewTeam(name);
    }

    abstract public void customiseTeams();

}
