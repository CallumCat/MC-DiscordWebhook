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

import okhttp3.*;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.json.*;

import java.io.IOException;

public class Sender
{
    public static void playerJoin(Player player, Server server, String url)
    {
        if(!(Webhook.checkUrl(url)))
            return;

        try
        {
            JSONObject obj = new JSONObject().put("content", "**"+player.getName()+"** Joined the server! Online count: **"+server.getOnlinePlayers().size()+"/"+server.getMaxPlayers()+"**");

            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), obj.toString());
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

            client.newCall(request).execute();
        }
        catch(IOException e)
        {
            Webhook.logError(e);
        }
    }

    public static void playerLeave(Player player, Server server, String url)
    {
        if(!(Webhook.checkUrl(url)))
            return;

        try
        {
            long count = server.getOnlinePlayers().size()-1;
            JSONObject obj = new JSONObject().put("content", "**"+player.getName()+"** Left the server! Online count: **"+count+"/"+server.getMaxPlayers()+"**");

            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), obj.toString());
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

            client.newCall(request).execute();
        }
        catch(IOException e)
        {
            Webhook.logError(e);
        }
    }

    public static void startup(Server server, String url)
    {
        if(!(Webhook.checkUrl(url)))
            return;

        try
        {
            JSONObject obj = new JSONObject().put("content", "The server is online! Max players: **32**");

            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), obj.toString());
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

            client.newCall(request).execute();
        }
        catch(IOException e)
        {
            Webhook.logError(e);
        }
    }

    public static void shutdown(Server server, String url)
    {
        if(!(Webhook.checkUrl(url)))
            return;

        try
        {
            JSONObject obj = new JSONObject().put("content", "The server is going offline! Online players: **"+server.getOnlinePlayers().size()+"**");

            OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), obj.toString());
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();

            client.newCall(request).execute();
        }
        catch(IOException e)
        {
            Webhook.logError(e);
        }
    }
}
