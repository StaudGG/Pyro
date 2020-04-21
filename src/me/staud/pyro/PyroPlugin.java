package me.staud.pyro;

import me.staud.pyro.armor.ArmorListener;
import me.staud.pyro.armor.EquipEvent;
import me.staud.pyro.command.*;
import me.staud.pyro.listener.ChatListener;
import me.staud.pyro.listener.DamageListener;
import me.staud.pyro.listener.IllegalPluginListener;
import me.staud.pyro.listener.PyroListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PyroPlugin extends JavaPlugin implements Listener {

    public static PyroPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        registerCommands();
        registerListeners();

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Pyro enabling.....");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Version 1.2");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Developed by Staud");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Pyro has sucessfully enabled!");
    }

    private void registerCommands() {
        getCommand("pyro").setExecutor(new PyroCommand());
        getCommand("lore").setExecutor(new LoreCommand());
        getCommand("rename").setExecutor(new RenameCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("invsee").setExecutor(new InvseeCommand());
    }
    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PyroListener(), this);
        pm.registerEvents(new DamageListener(), this);
        pm.registerEvents(new EquipEvent(), this);
        pm.registerEvents(new ArmorListener(), this);
        pm.registerEvents(new ChatListener(), this);
        pm.registerEvents(new IllegalPluginListener(), this);
    }

    public static PyroPlugin getInstance() {
        return instance;
    }
}