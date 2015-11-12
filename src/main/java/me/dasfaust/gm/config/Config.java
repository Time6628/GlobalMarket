package me.dasfaust.gm.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.bukkit.configuration.InvalidConfigurationException;

import me.dasfaust.gm.Core;

public class Config
{
public static String header = String.format("GlobalMarket config: v%s", Core.instance.getDescription().getVersion());
    
    public static class Defaults
    {
    	public static final ConfigDefault<String> PERSISTENCE_METHOD = new ConfigDefault<String>("persistence.method", "flat", null);
    	public static final ConfigDefault<String> PERSISTENCE_METHOD_REDIS_ADDRESS = new ConfigDefault<String>("persistence.redis.address", "localhost", null);
    	public static final ConfigDefault<Integer> PERSISTENCE_METHOD_REDIS_PORT = new ConfigDefault<Integer>("persistence.redis.port", 6379, null);
    	public static final ConfigDefault<Integer> PERSISTENCE_METHOD_REDIS_POOLSIZE = new ConfigDefault<Integer>("persistence.redis.poolSize", 16, null);
    	public static final ConfigDefault<String> PERSISTENCE_METHOD_REDIS_PASSWORD = new ConfigDefault<String>("persistence.redis.password", "", null);
    	public static final ConfigDefault<Integer> PERSISTENCE_METHOD_SAVEINTERVAL = new ConfigDefault<Integer>("persistence.saveInterval", 1200, null);
    	protected static final ConfigDefault<Object> NULL_PERSISTENCE_COMMENT = new ConfigDefault<Object>("persistence", null, new String[] {
    			"Persistence options. Valid options are 'flat' and 'redis' (Default: flat)",
		        "Pointing two GlobalMarket instances at the same Redis server allows them to share data.",
		        "If using a multi-server setup, set 'persistence.saveInterval' to zero on all but one server.",
                "Changing this requires a server restart"
    	});

    	// TODO
        public static final ConfigDefault<Integer> AUTO_CLICKER_DEFENSE_THRESHOLD = new ConfigDefault<Integer>("autoclicker_defense_threshold", 20, new String[] {
            "Minimum time in between click events in miliseconds before",
            "closing an inventory and logging the player. (Default: 20)"
        });
        // TODO
        public static final ConfigDefault<Boolean> AUTO_CLICKER_DEFENSE_LOGGING = new ConfigDefault<Boolean>("enable_autoclicker_logging", true, new String[] {
            "Will log names of potential players with autoclickers. (Default: true)"
        });
    	
        public static final ConfigDefault<String> LOCALE_FILENAME = new ConfigDefault<String>("locale_file", "en_US", new String[] {
            "Which locale file to use. Do not include .json! (Default: en_US)",
            "Locale files can be found and edited to your liking inside the plugin JAR.",
            "Be sure to migrate your edits when updating the plugin."
        });
        
        public static final ConfigDefault<Boolean> DISABLE_STOCK = new ConfigDefault<Boolean>("disable_stock_system", false, new String[] {
    		"Disables the stock system entirely. Listings will function like",
    		" they did in previous versions, minus the mailbox. Items will",
    		" go straight to the player's cursor. (Default: false)"
        });
        public static final ConfigDefault<Integer> STOCK_SLOTS = new ConfigDefault<Integer>("stock_slots", 16, new String[] {
            "How many stock slots to give each player. (Default: 16)"
        });
        // TODO: implementation. Build on login to prevent wonkyness
		public static final ConfigDefault<List<String>> STOCK_SLOTS_GROUPS = new ConfigDefault<List<String>>("stock_slots_groups", Arrays.asList(new String[] {"default:0"}), new String[] {
        	"Group-based stock slot assignment. Requires a permissions plugin",
        	" with Vault support. This setting will be added to the default slots.",
        	"<group-name>:<# of slots>"
        });
        public static final ConfigDefault<Integer> STOCK_SLOTS_SIZE = new ConfigDefault<Integer>("stock_slots_size", 320, new String[] {
            "How many items can be stored in a stock slot. (Default: 320)"
        });
        // TODO: implementation. Build on login to prevent wonkyness
 		public static final ConfigDefault<List<String>> STOCK_SLOTS_SIZE_GROUPS = new ConfigDefault<List<String>>("stock_slots_size_groups", Arrays.asList(new String[] {"default:0"}), new String[] {
         	"Group-based stock slot size assignment. Requires a permissions plugin",
         	" with Vault support. This setting will be added to the default slot size.",
         	"<group-name>:<size of slot>"
        });
        public static final ConfigDefault<Integer> STOCK_DELAY = new ConfigDefault<Integer>("stock_delay", 0, new String[] {
    		"Time in minutes to wait before allowing a player to retrieve newly",
    		" added stock. (Default: 0)"
        });
 		
        public static final ConfigDefault<Integer> LISTINGS_EXPIRE_TIME = new ConfigDefault<Integer>("listings_expire_time", 12, new String[] {
            "How many hours to wait before removing a listing. (Default: 12)",
            "Set to 0 to disable expiration"
        });
        
        public static final ConfigDefault<Double> LISTINGS_CUT_AMOUNT = new ConfigDefault<Double>("listings_cut_amount", 0.05, new String[] {
            "What percentage to deduct from a transaction. (Default: 0.05)",
            "Set to 0.0 to disable cuts"
        });
        
        public static final ConfigDefault<String> COMMAND_ROOT_NAME = new ConfigDefault<String>("command_root_name", "market", new String[] {
    		"The root prefix to all GlobalMarket commands. (Default: market)",
            "Changing this requires a server restart"
        });
        
        public static final ConfigDefault<Object> NULL_CREATION_MENU_COMMENT = new ConfigDefault<Object>("creation_menu_increments", null, new String[] {
    		"How much to increment or decrement when a number button is pressed",
    		"while in the listings creation menu."
        });
        public static final ConfigDefault<Integer> CREATION_MENU_INCREMENTS_1 = new ConfigDefault<Integer>("creation_menu_increments.1", 1, null);
        public static final ConfigDefault<Integer> CREATION_MENU_INCREMENTS_2 = new ConfigDefault<Integer>("creation_menu_increments.2", 5, null);
        public static final ConfigDefault<Integer> CREATION_MENU_INCREMENTS_3 = new ConfigDefault<Integer>("creation_menu_increments.3", 10, null);
        public static final ConfigDefault<Integer> CREATION_MENU_INCREMENTS_4 = new ConfigDefault<Integer>("creation_menu_increments.4", 50, null);
        public static final ConfigDefault<Integer> CREATION_MENU_INCREMENTS_5 = new ConfigDefault<Integer>("creation_menu_increments.5", 100, null);
        public static final ConfigDefault<Integer> CREATION_MENU_INCREMENTS_6 = new ConfigDefault<Integer>("creation_menu_increments.6", 500, null);
        public static final ConfigDefault<Integer> CREATION_MENU_INCREMENTS_7 = new ConfigDefault<Integer>("creation_menu_increments.7", 1000, null);
        public static final ConfigDefault<Integer> CREATION_MENU_INCREMENTS_8 = new ConfigDefault<Integer>("creation_menu_increments.8", 5000, null);
        public static final ConfigDefault<Integer> CREATION_MENU_INCREMENTS_9 = new ConfigDefault<Integer>("creation_menu_increments.9", 10000, null);
        
        public static final ConfigDefault<Boolean> ENABLE_DEBUG = new ConfigDefault<Boolean>("enable_debug", true, new String[] {
            "Enables debug output. Warning: gets /VERY/ spammy. (Default: false)"
        });
        
        public static final ConfigDefault<Boolean> ENABLE_METRICS = new ConfigDefault<Boolean>("enable_metrics", true, new String[] {
    		"Plugin Metrics helps the plugin developer track usage statistics. (Default: true)",
            "Changing this requires a server restart"
        });
    }
    
    public static class ConfigDefault<T>
    {
        public String path;
        public T value;
        public String[] comment;
        
        public ConfigDefault(String path, T value, String[] comment)
        {
            this.path = path;
            this.value = value;
            this.comment = comment;
        }
    }
    
    public AnnotatedYamlConfiguration config;
    public File configFile;
    
    public void load() throws FileNotFoundException, IOException, InvalidConfigurationException, IllegalArgumentException, IllegalAccessException
    {
    	config = new AnnotatedYamlConfiguration();
    	File folder = Core.instance.getDataFolder();
		if (!folder.exists())
		{
			folder.mkdir();
		}
		configFile = new File(Core.instance.getDataFolder().getAbsolutePath() + File.separator + "config.yml");
		if (!configFile.exists() && !configFile.createNewFile()) throw new IOException("config.yml could not be created");
		
		config.load(configFile);
		
		config.options().header(header);
		for(Field f : Defaults.class.getDeclaredFields())
		{
			if (f != null)
			{
				ConfigDefault<?> def = (ConfigDefault<?>) f.get(null);
				if (def.value != null)
				{
					config.addDefault(def.path, def.value);
				}
				if (def.comment != null)
				{
					config.setComment(def.path, def.comment);
				}
			}
		}
		config.options().copyDefaults(true);
		
		save();
    }
    
    public void save() throws IOException
    {
    	config.save(configFile);
    }
    
    @SuppressWarnings("unchecked")
	public <T> T get(ConfigDefault<T> def)
    {
    	if (config.isSet(def.path))
    	{
    		return (T) config.get(def.path);
    	}
    	return def.value;
    }
}
