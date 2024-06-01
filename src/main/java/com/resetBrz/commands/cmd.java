package com.resetBrz.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class cmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (s.equalsIgnoreCase("ping")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;

                if (strings.length <= 0) {
                    player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "» " + ChatColor.GREEN + "Seu ping: " + ChatColor.GOLD + ((CraftPlayer) player).getHandle().ping);
                    return true;
                } else if (strings.length == 1) {
                    if (Bukkit.getPlayerExact(strings[0]) == null) {
                        player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "» " + ChatColor.RED + "O jogador " + ChatColor.GOLD + strings[0] + ChatColor.RED + " não foi encontrado.");
                        return true;
                    }
                    Player target = Bukkit.getPlayerExact(strings[0]);

                    player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "» " + ChatColor.GOLD + target.getName() + ChatColor.GREEN + " ping: " + ChatColor.GOLD + ((CraftPlayer) target).getHandle().ping);
                    return true;
                }
            } else {
                commandSender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "» " + ChatColor.GRAY + "Only players can use this command");
                return true;
            }
        }
        return true;
    }
}

