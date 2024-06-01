package com.resetBrz;

import com.resetBrz.commands.cmd;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    public void onEnable(){
        this.getCommand("ping").setExecutor(new cmd());
    }
    public void onDisable(){

    }
}
