package net.novelmc.novelengine.util;

import org.json.JSONObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PlayerDatabase extends NovelBase {
    private List<String[]> players;

    public PlayerDatabase() {
        players = new ArrayList<>();
    }

    public void load() {
        players.clear();

        if(config.isSQLEnabled())
        {
            Connection c = SQLManager.getConnection();

            try
            {
                ResultSet result = c.prepareStatement("SELECT * FROM players").executeQuery();
                while (result.next()) {
                    add(result.getString("name"), result.getString("ip"));
                }
            } catch (SQLException ex)
            {
                NLog.severe(ex);
                return;
            }
        }
        else
        {
            JSONObject playerJson = plugin.sqlManager.getDatabase().getJSONObject("players");
            for(String key : playerJson.keySet())
            {
                JSONObject obj = playerJson.getJSONObject(key);
                add(obj.getString("name"), obj.getString("ip"));
            }
        }

        NLog.info("Successfully loaded " + players.size() + " cached players!");
    }

    public boolean containsName(String name) {
        for(String[] data : players) {
            if(data[0].equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    public boolean containsIp(String ip) {
        for(String[] data : players) {
            if(data[1].equalsIgnoreCase(ip)) return true;
        }
        return false;
    }

    private String[] getDataByName(String name) {
        for(String[] data : players) {
            if(data[0].equalsIgnoreCase(name)) return data;
        }
        return new String[] {null, null};
    }

    private String[] getDataByIp(String ip) {
        for(String[] data : players) {
            if(data[1].equalsIgnoreCase(ip)) return data;
        }
        return new String[] {null, null};
    }

    public String getIp(String name) {
        return getDataByName(name)[1];
    }

    public void add(String name, String ip) {
        if(containsName(name)) {
            players.remove(getDataByName(name));
        }
        players.add(new String[] {name, ip});
    }

    public String getName(String ip) {
        return getDataByName(ip)[0];
    }
}
