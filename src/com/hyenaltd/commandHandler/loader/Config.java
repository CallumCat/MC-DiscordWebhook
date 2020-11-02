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
package com.hyenaltd.commandHandler.loader;

import org.bukkit.configuration.file.FileConfiguration;

public class Config
{
    private final FileConfiguration config;

    public Config(FileConfiguration config)
    {
        this.config = config;
        config.addDefault("webhookUrl", "https://discordapp.com/api/webhooks");
        config.options().copyDefaults(true);
    }

    public String getUrl()
    {
        return config.getString("webhookUrl");
    }
}