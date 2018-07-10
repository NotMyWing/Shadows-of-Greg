package gregicadditions;

import gregicadditions.item.GAMetaItems;
import gregicadditions.recipes.GARecipeAddition;
import gregicadditions.recipes.GARecipeRemoval;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = GregicAdditions.MODID,
        name = GregicAdditions.NAME,
        version = GregicAdditions.VERSION,
        dependencies = "required-after:gregtech"
)
public class GregicAdditions
{
    public static final String MODID = "gtadditions";
    public static final String NAME = "Gregic Additions";
    public static final String VERSION = "@VERSION@";

    @SidedProxy(
            modId = MODID,
            clientSide = "gregicadditions.ClientProxy",
            serverSide = "gregicadditions.CommonProxy"
    )
    public static CommonProxy proxy;

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        GAMetaItems.init();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {}

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        GARecipeRemoval.postInit();
        GARecipeAddition.postInit();
    }
}
