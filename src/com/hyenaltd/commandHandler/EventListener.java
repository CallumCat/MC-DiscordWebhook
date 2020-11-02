/*
 * Copyright (C) 2017 Artu
 * Copyright (C) 2020 Hyena Plugins, Limited of Hampton Roads, Virginia.
 * Edited in 2020 by Muednei The Fox for Fuzzy Kingdom MC Server.
 * Updated dependencies and fixed commands, following GNU General Public License terms and agreement.
 * 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.hyenaltd.commandHandler;

import com.hyenaltd.commandHandler.loader.Config;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.PluginDisableEvent;

public class EventListener implements Listener
{
    private final Config config;

    public EventListener(Config config)
    {
        this.config = config;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        event.getPlayer().getServer().getLogger().info("A player joined the server! Sending an update to Discord...");
        Sender.playerJoin(event.getPlayer(), event.getPlayer().getServer(), config.getUrl());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        event.getPlayer().getServer().getLogger().info("A player left the server! Sending an update to Discord...");
        Sender.playerLeave(event.getPlayer(), event.getPlayer().getServer(), config.getUrl());
    }

    @EventHandler
    public void onPluginEnable(PluginEnableEvent event)
    {
        if(!(event.getPlugin().getName().equals("DiscordWebhook6")))
            return;
        	Sender.startup(event.getPlugin().getServer(), config.getUrl());
    }

    @EventHandler
    public void onPluginDisable(PluginDisableEvent event)
    {
        if(!(event.getPlugin().getName().equals("DiscordWebhook6")))
            return;
            Sender.shutdown(event.getPlugin().getServer(), config.getUrl());
    }
}
