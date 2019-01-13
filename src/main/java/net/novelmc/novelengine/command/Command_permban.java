package net.novelmc.novelengine.command;

import net.novelmc.novelengine.banning.BanManager;
import net.novelmc.novelengine.banning.BanType;
<<<<<<< HEAD
import net.novelmc.novelengine.command.util.CommandBase;
import net.novelmc.novelengine.command.util.CommandParameters;
import net.novelmc.novelengine.command.util.SourceType;
=======
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
import net.novelmc.novelengine.rank.Rank;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CommandParameters(description = "Permanently ban a username or IP", usage = "/<command> <username | ip> [reason]", source = SourceType.BOTH, rank = Rank.MANAGER)
<<<<<<< HEAD
public class Command_permban extends CommandBase
{

    @Override
=======
public class Command_permban
{

>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
    {
        if (args.length < 1)
        {
            return false;
        }

        String reason = null;
        if (args.length > 2)
        {
            reason = StringUtils.join(args, " ", 1, args.length);
        }

        //check if input is IP
        Pattern patt = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher m = patt.matcher(args[0]);

        if (m.matches())
        {
            // check if the ip is banned
            if (BanManager.isIPPermBanned(args[0]))
            {
                sender.sendMessage(ChatColor.DARK_GRAY + "That IP is already permanently banned!");
                return true;
            }

<<<<<<< HEAD
            BanManager.addBan("", args[0], sender.getName(), reason, null, BanType.PERMANENT_IP);
=======
            BanManager.addBan(sender, "", args[0], reason, null, BanType.PERMANENT_IP);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
            sender.sendMessage(ChatColor.GRAY + "Added permanent ban for IP " + args[0]);
            return true;
        }

        // ban name
        if (BanManager.isNamePermBanned(args[0]))
        {
            sender.sendMessage(ChatColor.DARK_GRAY + "That name is already permanently banned!");
            return true;
        }

<<<<<<< HEAD
        BanManager.addBan(args[0], null, sender.getName(), reason, null, BanType.PERMANENT_NAME);
=======
        BanManager.addBan(sender, args[0], null, reason, null, BanType.PERMANENT_NAME);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
        sender.sendMessage(ChatColor.GRAY + "Added permanent ban for name " + args[0]);
        return true;
    }
}