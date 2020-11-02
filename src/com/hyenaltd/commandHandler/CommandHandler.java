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

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender executor, Command cmd, String label, String[] args)
    {
        switch(cmd.getName().toLowerCase())
        {
            case "webhook":
                if(args.length==0)
                    executor.sendMessage(ChatColor.DARK_BLUE+"-====== Webhook Help ======-"+ChatColor.RESET +
                            "\n/webhook help - Shows this message");
                else if(args[0].equals("help"))
                    executor.sendMessage(ChatColor.DARK_BLUE+"-====== Webhook Help ======-"+ChatColor.RESET +
                            "\n/webhook help - Shows this message");
                break;
            default:
                return false;
        }

        return true;
    }
}
