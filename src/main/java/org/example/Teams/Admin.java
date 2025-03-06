package org.example.Teams;

import org.bukkit.scoreboard.Team;
import org.example.Main;
import org.example.utils.Utils;

public class Admin extends TeamTemplate {

    public Admin(Main plugin) {
        super(plugin, plugin.getConfig().getStringList("modTeamNames").getFirst());
        customiseTeams();
    }

    @Override
    public void customiseTeams() {
        team.setPrefix(Utils.chat("MOD "));
        team.setDisplayName(Utils.chat("&1&lMOD "));
        team.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.NEVER);
    }
}
