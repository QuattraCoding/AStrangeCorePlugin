package org.example.Teams;

import org.bukkit.scoreboard.Team;
import org.example.Main;
import org.example.utils.Utils;

public class BadAdmin extends TeamTemplate {
    public BadAdmin(Main plugin) {
        super(plugin,plugin.getConfig().getStringList("modTeamNames").get(1));
        customiseTeams();
    }

    @Override
    public void customiseTeams() {
        team.setPrefix(Utils.chat("BadMOD "));
        team.setDisplayName(Utils.chat("&d&lMOD "));
        team.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.NEVER);
    }
}
