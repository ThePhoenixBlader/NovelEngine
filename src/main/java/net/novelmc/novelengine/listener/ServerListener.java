package net.novelmc.novelengine.listener;

<<<<<<< HEAD
import net.novelmc.novelengine.util.NUtil;
import net.novelmc.novelengine.util.NovelBase;
=======
import net.novelmc.novelengine.NovelEngine;
import net.novelmc.novelengine.util.NUtil;
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

<<<<<<< HEAD
import java.util.List;

public class ServerListener extends NovelBase implements Listener
{

    public ServerListener()
=======
public class ServerListener implements Listener
{

    public ServerListener(NovelEngine plugin)
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onServerListPing(ServerListPingEvent event)
    {
        if (Bukkit.hasWhitelist())
        {
            event.setMotd(ChatColor.RED + "Whitelist enabled!");
            return;
        }

        if (Bukkit.getOnlinePlayers().size() >= Bukkit.getMaxPlayers())
        {
            event.setMotd(ChatColor.RED + "Server is full!");
            return;
        }

<<<<<<< HEAD
        if (plugin.config.isStaffModeEnabled())
        {
            event.setMotd(ChatColor.RED + "Maintenance Mode enabled.");
            return;
        }
/*
        String motd = NUtil.colorize(NovelEngine.plugin.config.getMOTD());
        //motd = motd.replace("||", NEW_LINE);
        event.setMotd(motd);
*/
        List<String> motd = plugin.config.getMOTD();
        event.setMotd(NUtil.colorize(motd.get(1)) + NEW_LINE + NUtil.colorize(motd.get(2)));
=======
        String motd = NUtil.colorize(NovelEngine.plugin.config.getMOTD());
        motd = motd.replace("||", "\n");
        event.setMotd(motd);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    }
}
