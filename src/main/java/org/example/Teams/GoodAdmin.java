package org.example.Teams;

import org.bukkit.scoreboard.Team;
import org.example.Main;
import org.example.utils.Utils;

public class GoodAdmin extends TeamTemplate {
    public GoodAdmin(Main plugin) {
        super(plugin, plugin.getConfig().getStringList("modTeamNames").get(2));
        customiseTeams();
    }

    @Override
    public void customiseTeams() {
        team.setPrefix(Utils.chat("GoodMOD "));
        team.setDisplayName(Utils.chat("&b&lMOD "));
        team.setOption(Team.Option.COLLISION_RULE, Team.OptionStatus.NEVER);
    }
}
