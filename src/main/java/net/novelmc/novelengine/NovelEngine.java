package net.novelmc.novelengine;

<<<<<<< HEAD
import net.novelmc.novelengine.banning.BanManager;
import net.novelmc.novelengine.command.util.CommandLoader;
=======
import net.novelmc.novelengine.architect.ArchitectList;
import net.novelmc.novelengine.banning.BanManager;
import net.novelmc.novelengine.command.CommandLoader;
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
import net.novelmc.novelengine.config.ArchitectConfig;
import net.novelmc.novelengine.config.Config;
import net.novelmc.novelengine.config.StaffConfig;
import net.novelmc.novelengine.listener.EventModeListener;
import net.novelmc.novelengine.listener.PlayerListener;
import net.novelmc.novelengine.listener.ServerListener;
<<<<<<< HEAD
import net.novelmc.novelengine.ptero.PteroManager;
import net.novelmc.novelengine.rank.architect.ArchitectList;
import net.novelmc.novelengine.rank.staff.StaffList;
import net.novelmc.novelengine.util.NLog;
import net.novelmc.novelengine.util.PlayerDatabase;
import net.novelmc.novelengine.util.SQLManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

=======
import net.novelmc.novelengine.staff.StaffList;
import net.novelmc.novelengine.util.NLog;
import net.novelmc.novelengine.util.SQLManager;
import org.bukkit.plugin.java.JavaPlugin;

>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
public class NovelEngine extends JavaPlugin
{

    public static NovelEngine plugin;
<<<<<<< HEAD
    public ArchitectConfig architectConfig;
    public BanManager banManager;
    public CommandLoader commandLoader;
    public Config config;
    public EventModeListener eventModeListener;
    public PlayerListener playerListener;
    public PlayerDatabase playerDatabase;
    public ServerListener serverListener;
    public SQLManager sqlManager;
    public StaffConfig staffConfig;
    public StaffList staffList;
    public ArchitectList architectList;
    public PteroManager pteroManager;
=======
    public ArchitectConfig ac;
    public BanManager bm;
    public CommandLoader cl;
    public Config config;
    public EventModeListener eml;
    public PlayerListener pl;
    public ServerListener srl;
    public SQLManager sql;
    public StaffConfig staff;
    public StaffList sl;
    public ArchitectList al;
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb

    @Override
    public void onLoad()
    {
<<<<<<< HEAD
        plugin = this;
        config = new Config(plugin);
        staffConfig = new StaffConfig(plugin);
        architectConfig = new ArchitectConfig(plugin);
=======
        this.plugin = this;
        config = new Config(plugin);
        staff = new StaffConfig(plugin);
        ac = new ArchitectConfig(plugin);
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    }

    @Override
    public void onEnable()
    {
<<<<<<< HEAD
        plugin = this;

        config.load();
        staffConfig.load();
        architectConfig.load();
        config.save();
        staffConfig.save();
        architectConfig.save();
        sqlManager = new SQLManager(plugin);

        if (!sqlManager.init())
=======
        this.plugin = this;

        config.load();
        staff.load();
        ac.load();

        sql = new SQLManager(plugin);

        if (!sql.init())
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
        {
            NLog.severe("Unable to connect to MySQL database! Shutting down...");
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

<<<<<<< HEAD
        staffList = new StaffList();
        architectList = new ArchitectList();
        banManager = new BanManager();
        commandLoader = new CommandLoader("Command_");
        playerListener = new PlayerListener();
        playerDatabase = new PlayerDatabase();
        serverListener = new ServerListener();
        eventModeListener = new EventModeListener();
        pteroManager = new PteroManager();
        pteroManager.connect(getConfig().getString("pterodactyl.apikey"));

        commandLoader.registerCommands();


        NLog.info("The plugin has been enabled!");

=======
        sl = new StaffList(plugin);
        al = new ArchitectList(plugin);
        bm = new BanManager(plugin);
        cl = new CommandLoader();
        pl = new PlayerListener(plugin);
        srl = new ServerListener(plugin);
        eml = new EventModeListener(plugin);


        NLog.info("The plugin has been enabled!");
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    }

    @Override
    public void onDisable()
    {
<<<<<<< HEAD

=======
        this.plugin = null;

        config.save();
        staff.save();
        ac.save();
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb

        NLog.info("The plugin has been disabled!");
    }
}
