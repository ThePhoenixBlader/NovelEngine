package net.novelmc.novelengine.command;

<<<<<<< HEAD
import net.novelmc.novelengine.command.util.CommandBase;
import net.novelmc.novelengine.command.util.CommandParameters;
import net.novelmc.novelengine.command.util.SourceType;
=======
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
import net.novelmc.novelengine.rank.Rank;
import net.novelmc.novelengine.util.NUtil;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
<<<<<<< HEAD
=======
import org.bukkit.ChatColor;
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandParameters(description = "Broadcast your message", usage = "/<command> <message>", source = SourceType.BOTH, rank = Rank.TRAINEE)
<<<<<<< HEAD
public class Command_say extends CommandBase
{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
    {
        if (args.length == 0)
=======
public class Command_say
{

    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
    {
        if (args.length < 0)
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
        {
            return false;
        }

<<<<<<< HEAD
        Bukkit.broadcastMessage(NUtil.colorize("&8<-> &3&lINFO &r&8("
                + Rank.getDisplay(sender).getColor() + Rank.getDisplay(sender).getTag()
                + " &7" + sender.getName() + "&8)&7: &f")
=======
        Bukkit.broadcastMessage(NUtil.colorize("&8<-> &3&lINFO"
                + " &7" + sender.getName()
                + Rank.getDisplay(sender).getColor() + Rank.getDisplay(sender).getTag() + "&8» &f")
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
                + StringUtils.join(args, " ", 0, args.length));
        return true;
    }
}
