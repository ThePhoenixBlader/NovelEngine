package net.novelmc.novelengine.banning;

import lombok.Getter;
import lombok.Setter;
<<<<<<< HEAD
import net.novelmc.novelengine.util.NLog;
import net.novelmc.novelengine.util.NUtil;
import net.novelmc.novelengine.util.NovelBase;
import net.novelmc.novelengine.util.SQLManager;
import org.bukkit.ChatColor;
import org.json.JSONObject;
=======
import net.novelmc.novelengine.NovelEngine;
import net.novelmc.novelengine.util.NLog;
import net.novelmc.novelengine.util.NUtil;
import org.bukkit.ChatColor;
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

<<<<<<< HEAD
public class Ban extends NovelBase
=======
public class Ban
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
{

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String ip;
    @Getter
    @Setter
    private String by;
    @Getter
    @Setter
    private String reason;
    @Getter
    @Setter
    private Date expiry;
    @Getter
    @Setter
    private BanType type = BanType.NORMAL;

    public String getKickMessage()
    {
        if (type == BanType.PERMANENT_IP)
        {
            return ChatColor.RED
<<<<<<< HEAD
                    + "Your IP address is currently permanently banned from this server." + NEW_LINE
                    + "Reason: " + ChatColor.YELLOW + (reason != null ? reason : "Reason not specified") + NEW_LINE
=======
                    + "Your IP address is currently permanently banned from this server.\n"
                    + "Reason: " + ChatColor.YELLOW + (reason != null ? reason : "Reason not specified") + "\n"
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
                    + ChatColor.RED + "Banned by: " + ChatColor.YELLOW + by;
        }
        if (type == BanType.PERMANENT_NAME)
        {
            return ChatColor.RED
<<<<<<< HEAD
                    + "Your name is currently permanently banned from this server." + NEW_LINE
                    + "Reason: " + ChatColor.YELLOW + (reason != null ? reason : "Reason not specified") + NEW_LINE
=======
                    + "Your name is currently permanently banned from this server.\n"
                    + "Reason: " + ChatColor.YELLOW + (reason != null ? reason : "Reason not specified") + "\n"
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
                    + ChatColor.RED + "Banned by: " + ChatColor.YELLOW + by;
        }
        if (type == BanType.IP)
        {
            return ChatColor.RED
<<<<<<< HEAD
                    + "Your IP address is currently banned from this server." + NEW_LINE
                    + "Reason: " + ChatColor.YELLOW + (reason != null ? reason : "Reason not specified") + NEW_LINE
                    + ChatColor.RED + "Your ban will expire on "
                    + ChatColor.YELLOW + NUtil.DATE_FORMAT.format(expiry);
=======
                    + "Your IP address is currently banned from this server.\n"
                    + "Reason: " + ChatColor.YELLOW + (reason != null ? reason : "Reason not specified") + "\n"
                    + ChatColor.RED + "Banned by: " + ChatColor.YELLOW + by + "\n"
                    + ChatColor.RED + "Your ban will expire on "
                    + ChatColor.YELLOW + NUtil.dateToString(expiry);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
        }

        // Normal ban
        return ChatColor.RED
<<<<<<< HEAD
                + "You're currently banned from this server." + NEW_LINE
                + "Reason: " + ChatColor.YELLOW + (reason != null ? reason : "Reason not specified") + NEW_LINE
                + ChatColor.RED + "Banned by: " + ChatColor.YELLOW + by + NEW_LINE
                + ChatColor.RED + "Your ban will expire on "
                + ChatColor.YELLOW + NUtil.DATE_FORMAT.format(expiry);
=======
                + "You're currently banned from this server.\n"
                + "Reason: " + ChatColor.YELLOW + (reason != null ? reason : "Reason not specified") + "\n"
                + ChatColor.RED + "Banned by: " + ChatColor.YELLOW + by + "\n"
                + ChatColor.RED + "Your ban will expire on "
                + ChatColor.YELLOW + NUtil.dateToString(expiry);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    }

    public boolean isExpired()
    {
        if (expiry == null)
        {
            return false;
        }

        return expiry.after(new Date());
    }

    public void save()
    {
<<<<<<< HEAD
        if(config.isSQLEnabled())
        {
            Connection c = SQLManager.getConnection();
            try {
                PreparedStatement statement = c.prepareStatement("INSERT INTO bans (name, ip, `by`, reason, expiry, type) VALUES (?, ?, ?, ?, ?, ?)");
                statement.setString(1, name);
                statement.setString(2, ip);
                statement.setString(3, by);
                statement.setString(4, reason);
                statement.setLong(5, expiry.getTime());
                statement.setString(6, type.toString());
                statement.executeUpdate();
            } catch (SQLException ex) {
                NLog.severe(ex);
            }
        }
        else
            {
            JSONObject database = plugin.sqlManager.getDatabase();
            JSONObject bans = database.getJSONObject("bans");

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", name);
            jsonObject.put("ip", ip);
            jsonObject.put("by", by);
            jsonObject.put("reason", reason);
            jsonObject.put("expiry", expiry);
            jsonObject.put("type", type);

            bans.put(name, jsonObject);
            database.put("bans", bans);
            plugin.sqlManager.saveDatabase(database);
=======
        Connection c = NovelEngine.plugin.sql.getConnection();
        try
        {
            PreparedStatement statement = c.prepareStatement("INSERT INTO bans (name, ip, `by`, reason, expiry, type) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, ip);
            statement.setString(3, by);
            statement.setString(4, reason);
            statement.setLong(5, NUtil.getUnixTime(expiry));
            statement.setString(6, type.toString());
            statement.executeUpdate();
        }
        catch (SQLException ex)
        {
            NLog.severe(ex);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
        }
    }

    public void delete()
    {
<<<<<<< HEAD
        if(config.isSQLEnabled())
        {
            Connection c = SQLManager.getConnection();
            try {
                PreparedStatement statement = c.prepareStatement("DELETE FROM bans WHERE name = ? OR ip = ?");
                statement.setString(1, name);
                statement.setString(2, ip);
                statement.executeUpdate();
            } catch (SQLException ex) {
                NLog.severe(ex);
            }
        }
        else
            {
            JSONObject database = plugin.sqlManager.getDatabase();
            JSONObject bans = database.getJSONObject("bans");
            bans.remove(name);
            database.put("bans", bans);

            plugin.sqlManager.saveDatabase(database);
=======
        Connection c = NovelEngine.plugin.sql.getConnection();
        try
        {
            PreparedStatement statement = c.prepareStatement("DELETE FROM bans WHERE name = ? OR ip = ?");
            statement.setString(1, name);
            statement.setString(2, ip);
            statement.executeUpdate();
        }
        catch (SQLException ex)
        {
            NLog.severe(ex);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
        }
    }
}