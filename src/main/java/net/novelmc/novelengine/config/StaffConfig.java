package net.novelmc.novelengine.config;

import net.novelmc.novelengine.NovelEngine;
import net.novelmc.novelengine.util.NLog;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class StaffConfig extends YamlConfiguration
{

    private static StaffConfig config;
    private NovelEngine plugin;
    private File file;

    public StaffConfig(NovelEngine plugin)
    {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), "staff.yml");
<<<<<<< HEAD

        if (!file.exists())
        {
            saveDefault();
        }
=======
        saveDefault();
>>>>>>> 433c31f41b8f455e354d2838e9062d7472422bbb
    }

    public void load()
    {
        try
        {
            super.load(file);
        }
        catch (Exception ex)
        {
            NLog.severe(ex);
        }
    }

    public void save()
    {
        try
        {
            super.save(file);
        }
        catch (Exception ex)
        {
            NLog.severe(ex);
        }
    }

    private void saveDefault()
    {
        plugin.saveResource("staff.yml", false);
    }
}
