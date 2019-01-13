package net.novelmc.novelengine.command;

import net.novelmc.novelengine.banning.BanManager;
import net.novelmc.novelengine.banning.BanType;
<<<<<<< HEAD
import net.novelmc.novelengine.command.util.CommandBase;
import net.novelmc.novelengine.command.util.CommandParameters;
import net.novelmc.novelengine.command.util.SourceType;
import net.novelmc.novelengine.rank.Rank;
import net.novelmc.novelengine.util.NPlayer;
=======
import net.novelmc.novelengine.rank.Rank;
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
import net.novelmc.novelengine.util.NUtil;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CommandParameters(description = "Bans a bad player or IP", usage = "/<command> <player | ip> [reason]", source = SourceType.BOTH, rank = Rank.TRAINEE)
<<<<<<< HEAD
public class Command_ban extends CommandBase
{

    @Override
=======
public class Command_ban
{

>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
    {
        if (args.length < 1)
        {
            return false;
        }

        String reason = null;
<<<<<<< HEAD
        Pattern ipPattern = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher m = ipPattern.matcher(args[0]);
=======
        //check if input is IP
        Pattern pattern = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher m = pattern.matcher(args[0]);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
        if (m.matches())
        {
            if (BanManager.isIPBanned(args[0]))
            {
                sender.sendMessage(ChatColor.DARK_GRAY + "That IP is already banned!");
                return true;
            }

            if (args.length > 2)
            {
                reason = StringUtils.join(args, " ", 1, args.length);
            }
            else
            {
                sender.sendMessage(ChatColor.DARK_GRAY + "You must specify a reason!");
                return true;
            }

<<<<<<< HEAD
            if(reason != null) {
                NUtil.playerAction(sender, String.format("Banning IP: %s" + NEW_LINE + "Reason: " + ChatColor.YELLOW + "%s", args[0], reason), true);
            }
            else {
                NUtil.playerAction(sender, "Banning IP: " + args[0], true);
            }
            BanManager.addBan("", args[0], sender.getName(), reason, NUtil.parseDateOffset("1d"), BanType.IP);
            return true;
        }

        // Not ip
        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(args[0]);

        if (offlinePlayer.isOnline())
        {
            NPlayer player = (NPlayer)offlinePlayer.getPlayer();

            if (player.isBanned())
=======
            NUtil.playerAction(sender, "Banning IP: " + args[0]
                    + (reason != null ? "\n Reason: " + ChatColor.YELLOW + reason + "\n" : ""), true);
            BanManager.addBan(sender, "", args[0], reason, NUtil.parseDateOffset("1d"), BanType.IP);
            return true;
        }

        //not ip
        OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);

        if (player.isOnline())
        {
            Player p = player.getPlayer();

            if (BanManager.isBanned(p))
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
            {
                sender.sendMessage(ChatColor.DARK_GRAY + "That player is already banned!");
                return true;
            }

<<<<<<< HEAD
            if (args.length > 1)
            {
                reason = StringUtils.join(args, " ", 1, args.length);
            }

            if (reason != null)
            {
                NUtil.playerAction(sender, String.format(" - Banning %s" + NEW_LINE + "Reason: " + ChatColor.YELLOW + "%s", offlinePlayer.getName(), reason), true);
                player.kickPlayer(ChatColor.RED + "You have been banned!" + NEW_LINE + "Reason: " + ChatColor.YELLOW + reason);
            }
            else
            {
                NUtil.playerAction(sender, " - Banning " + offlinePlayer.getName(), true);
                player.kickPlayer(ChatColor.RED + "You have been banned!");
            }

            BanManager.addBan(player.getName(), player.getAddress().getHostString(), sender.getName(), reason, NUtil.parseDateOffset("1d"), BanType.NORMAL);
        }
        else
        {
            if(!plugin.playerDatabase.containsName(offlinePlayer.getName())) {
                sender.sendMessage(ChatColor.RED + "Offline player not found.");
                return true;
            }

            if (args.length > 1)
            {
                reason = StringUtils.join(args, " ", 1, args.length);
            }

            BanManager.addBan(offlinePlayer.getName(), plugin.playerDatabase.getIp(offlinePlayer.getName()), sender.getName(), reason, NUtil.parseDateOffset("1d"), BanType.NORMAL);

            if(reason != null)
            {
                NUtil.playerAction(sender, String.format(" - Banning %s" + NEW_LINE + "Reason: " + ChatColor.YELLOW + "%s", offlinePlayer.getName(), reason), true);
            }
            else
            {
                NUtil.playerAction(sender, " - Banning " + offlinePlayer.getName(), true);
            }
        }
=======
            if (args.length > 2)
            {
                reason = StringUtils.join(args, " ", 1, args.length);
            }
            else
            {
                sender.sendMessage(ChatColor.DARK_GRAY + "You must specify a reason!");
                return true;
            }

            NUtil.playerAction(sender, " - Banning " + player.getName()
                    + (reason != null ? "\n Reason: " + ChatColor.YELLOW + reason + "\n" : ""), true);

            BanManager.getBansByType(BanType.IP).stream().filter((ban) -> (ban.getIp().equals(p.getAddress().getHostString()))).forEachOrdered((ban) ->
            {
                BanManager.removeBan(ban);
            });

            BanManager.addBan(sender, p, reason, NUtil.stringToDate("1d"), BanType.NORMAL);
            p.kickPlayer(ChatColor.RED + "You have been banned!");
            return true;
        }

        //TODO: Offline bans

>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
        return true;
    }
}