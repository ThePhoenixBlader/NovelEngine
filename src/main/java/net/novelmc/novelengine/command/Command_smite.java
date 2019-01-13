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
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandParameters(description = "Smites a bad player", usage = "/<command> <player> [reason]", source = SourceType.BOTH, rank = Rank.TRAINEE)
<<<<<<< HEAD
public class Command_smite extends CommandBase
{

    @Override
=======
public class Command_smite
{

>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args)
    {
        if (args.length < 1)
        {
            return false;
        }

        Player player = Bukkit.getPlayer(args[0]);
        String reason = null;
        if (player == null)
        {
            sender.sendMessage(ChatColor.RED + "Cannot find that player.");
            return true;
        }

        if (args.length > 2)
        {
            reason = StringUtils.join(args, " ", 1, args.length);
        }

        NUtil.playerAction(sender, "Smiting " + player.getName()
<<<<<<< HEAD
                + (reason != null ? NEW_LINE + " Reason: " + ChatColor.YELLOW + reason + NEW_LINE : ""), true);
=======
                + (reason != null ? "\n Reason: " + ChatColor.YELLOW + reason + "\n" : ""), true);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
        player.setGameMode(GameMode.SURVIVAL);
        player.setOp(false);
        player.getInventory().clear();
        player.getWorld().strikeLightningEffect(player.getLocation());
        player.setHealth(0);
        player.sendMessage(ChatColor.DARK_GRAY + "You have been smitten by " + sender.getName()
<<<<<<< HEAD
                + (reason != null ? NEW_LINE + "Reason: " + ChatColor.GRAY + reason : ""));
=======
                + (reason != null ? "\nReason: " + ChatColor.GRAY + reason : ""));
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
        return true;
    }
}
