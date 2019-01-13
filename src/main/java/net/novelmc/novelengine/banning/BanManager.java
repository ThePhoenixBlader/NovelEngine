package net.novelmc.novelengine.banning;

import lombok.Getter;
import net.novelmc.novelengine.NovelEngine;
import net.novelmc.novelengine.util.NLog;
import net.novelmc.novelengine.util.NUtil;
<<<<<<< HEAD
import net.novelmc.novelengine.util.NovelBase;
import net.novelmc.novelengine.util.SQLManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;
import org.json.JSONObject;
=======
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerLoginEvent;
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

<<<<<<< HEAD
public class BanManager extends NovelBase
=======
public class BanManager
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
{

    @Getter
    private static List<Ban> bans;
<<<<<<< HEAD

    public BanManager()
    {
=======
    private static NovelEngine plugin;

    public BanManager(NovelEngine plugin)
    {
        this.plugin = plugin;
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
        bans = new ArrayList<>();
        bans.clear();
        loadBans();
    }

    public void loadBans()
    {
        bans.clear();
<<<<<<< HEAD

        if(config.isSQLEnabled())
        {
            Connection c = SQLManager.getConnection();

            try
            {
                ResultSet result = c.prepareStatement("SELECT * FROM bans").executeQuery();
                while (result.next()) {
                    addBan(result.getString("name"),
                            result.getString("ip"),
                            result.getString("by"),
                            result.getString("reason"),
                            new Date(result.getLong("expiry")),
                            BanType.valueOf(result.getString("type")));
                }
            } catch (SQLException ex)
            {
                NLog.severe(ex);
                return;
            }
        }
        else
            {
            JSONObject banJson = plugin.sqlManager.getDatabase().getJSONObject("bans");
            for(String key : banJson.keySet())
            {
                JSONObject obj = banJson.getJSONObject(key);

                addBan(obj.getString("name"),
                        obj.getString("ip"),
                        obj.getString("by"),
                        obj.getString("reason"),
                        new Date(obj.getLong("expiry")),
                        BanType.valueOf(obj.getString("type")));
            }
=======
        Connection c = plugin.sql.getConnection();

        try
        {
            ResultSet result = c.prepareStatement("SELECT * FROM bans").executeQuery();
            while (result.next())
            {
                Ban ban = new Ban();
                ban.setName(result.getString("name"));
                ban.setIp(result.getString("ip"));
                ban.setBy(result.getString("by"));
                ban.setReason(result.getString("reason"));
                ban.setExpiry(NUtil.getUnixDate(result.getLong("expiry")));
                BanType type = BanType.valueOf(result.getString("type"));
                ban.setType(type);
                bans.add(ban);
            }
        }
        catch (SQLException ex)
        {
            NLog.severe(ex);
            return;
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
        }

        removeExpiredBans();
        NLog.info("Successfully loaded " + bans.size() + " bans!");
    }

<<<<<<< HEAD
    public static void addBan(String name, String ip, String by, String reason, Date expiry, BanType type) {
        Ban ban = new Ban();
        ban.setName(name);
        ban.setIp(ip);
        ban.setBy(by);
        ban.setReason(reason);
        ban.setExpiry(expiry);
        ban.setType(type);

        if (!isBanned(ban))
        {
            bans.add(ban);
        }
=======
    public static void removeExpiredBans()
    {
        bans.stream().filter((ban) -> (ban.isExpired())).forEach(bans::remove);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    }

    public static void addBan(Ban ban)
    {
        if (isBanned(ban))
        {
            return;
        }

        bans.add(ban);
        ban.save();
    }

<<<<<<< HEAD
    public static void removeExpiredBans()
    {
        bans.stream().filter(Ban::isExpired).forEach(bans::remove);
=======
    public static void addBan(CommandSender sender, Player player, String reason, Date date, BanType type)
    {
        if (isBanned(player))
        {
            return;
        }

        Ban ban = new Ban();
        ban.setName(player.getName());
        ban.setIp(player.getAddress().getHostString());
        ban.setBy(sender.getName());
        ban.setReason(reason);
        ban.setExpiry(date);
        ban.setType(type);
        addBan(ban);
    }

    public static void addBan(CommandSender sender, String name, String ip, String reason, Date date, BanType type)
    {
        if (getBan(name) != null)
        {
            return;
        }

        Ban ban = new Ban();
        ban.setName(name);
        ban.setIp(ip);
        ban.setBy(sender.getName());
        ban.setReason(reason);
        ban.setExpiry(date);
        ban.setType(type);
        addBan(ban);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    }

    public static void removeBan(Ban ban)
    {
        if (!isBanned(ban))
        {
            return;
        }

        bans.remove(ban);
        ban.delete();
    }

    public static boolean isBanned(Ban ban)
    {
        removeExpiredBans();
        for (Ban b : bans)
        {
            if (b.getName().equals(ban.getName()) || b.getIp().equals(ban.getIp()))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isBanned(Player player)
    {
        removeExpiredBans();
        return getBan(player) != null;
    }

    public static boolean isIPBanned(String ip)
    {
        return getBansByType(BanType.IP).stream().anyMatch((ban) -> (ban.getIp().equals(ip)))
                || getBansByType(BanType.NORMAL).stream().anyMatch((ban) -> (ban.getIp().equals(ip)));
    }

    public static boolean isIPPermBanned(String ip)
    {
        return getBansByType(BanType.PERMANENT_IP).stream().anyMatch((ban) -> (ban.getIp().equals(ip)));
    }

    public static boolean isNamePermBanned(String name)
    {
        return getBansByType(BanType.PERMANENT_NAME).stream().anyMatch((ban) -> (ban.getName().equals(name)));
    }

    public static Ban getBan(Player player)
    {
        for (Ban ban : bans)
        {
            if (ban.getName() != null)
            {
                if (ban.getName().equals(player.getName()))
                {
                    return ban;
                }
            }

            if (ban.getIp() != null)
            {
                if (ban.getIp().equals(player.getAddress().getHostString()))
                {
                    return ban;
                }
            }
        }
        return null;
    }

    public static Ban getBan(String name, String ip)
    {
        for (Ban ban : bans)
        {
            if (ban.getName() != null)
            {
                if (ban.getName().equals(name))
                {
                    return ban;
                }
            }

            if (ban.getIp() != null)
            {
                if (ban.getIp().equals(ip))
                {
                    return ban;
                }
            }
        }
        return null;
    }

    public static Ban getBan(PlayerLoginEvent event)
    {
        return getBan(event.getPlayer().getName(), event.getAddress().getHostAddress());
    }

    public static Ban getBan(String name)
    {
        for (Ban ban : bans)
        {
            if (ban.getName().equals(name))
            {
                return ban;
            }
        }
        return null;
    }

    public static List<Ban> getBansByType(BanType type)
    {
        List<Ban> banType = new ArrayList<>();

        for (Ban ban : bans)
        {
            if (ban.getType().equals(type))
            {
                banType.add(ban);
            }
        }

        return banType;
    }
}