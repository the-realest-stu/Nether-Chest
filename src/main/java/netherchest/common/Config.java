package netherchest.common;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.config.Configuration;

public class Config {
	
	private final static String CATEGORY_GENERAL = "all.general";
	
	private final static List<String> PROPERTY_ORDER_GENERAL = new ArrayList<String>();
	
	public static float TEXT_SCALE;
	public static float EXPLOSION_RADIUS;
	public static boolean NETHER_EXPLOSION;
	public static String RECIPE;
	public static int PARTICLE_COUNT;
	public static boolean ENABLE_AUTOMATION;
	
	public static void readConfig() {
		Configuration cfg = CommonProxy.config;
		try {
			cfg.load();
			initGeneralConfig(cfg);
		} catch (Exception e1) {

		} finally {
			if (cfg.hasChanged()) {
				cfg.save();
			}
		}
	}
	
	private static void initGeneralConfig(Configuration cfg) {
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General Options");

		TEXT_SCALE = cfg.getFloat("ItemStack Text Scale", CATEGORY_GENERAL, 0.75F, 0.5F, 1F, "the number used to scale the text size of the number of items in a stack in nether chests");
		PARTICLE_COUNT = cfg.getInt("Particle Count", CATEGORY_GENERAL, 2, 0, 128, "the number of particles generated by each nether chest every time they do a random display tick");
		ENABLE_AUTOMATION = cfg.getBoolean("Enable Automation", CATEGORY_GENERAL, true, "set to false to prevent things like hoppers from being able to insert or extract from nether chests");
		EXPLOSION_RADIUS = cfg.getFloat("Explosion Strength", CATEGORY_GENERAL, 8F, 0F, 64F, "the strength of the explosion created when opening a nether chest in the nether");
		NETHER_EXPLOSION = cfg.getBoolean("Explode in Nether", CATEGORY_GENERAL, true, "set to false to prevent nether chests from exploding in the nether");
		RECIPE = cfg.getString("Recipe", CATEGORY_GENERAL, "minecraft:blaze_powder", "this item will be used as the central ingredient of the nether chest's recipe");
		
		PROPERTY_ORDER_GENERAL.add("ItemStack Text Scale");
		PROPERTY_ORDER_GENERAL.add("Particle Count");
		PROPERTY_ORDER_GENERAL.add("Enable Automation");
		PROPERTY_ORDER_GENERAL.add("Explode in Nether");
		PROPERTY_ORDER_GENERAL.add("Explosion Strength");
		PROPERTY_ORDER_GENERAL.add("Recipe");
		
		cfg.setCategoryPropertyOrder(CATEGORY_GENERAL, PROPERTY_ORDER_GENERAL);
	}

}
