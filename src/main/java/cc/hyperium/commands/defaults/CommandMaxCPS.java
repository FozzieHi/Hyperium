/*
 *     Copyright (C) 2018  Hyperium <https://hyperium.cc/>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cc.hyperium.commands.defaults;


import cc.hyperium.Hyperium;
import cc.hyperium.commands.BaseCommand;
import cc.hyperium.handlers.handlers.chat.GeneralChatHandler;
import net.minecraft.client.gui.GuiNewChat;

/**
 * A simple command to clear your chat history & sent commands,
 * simply calls the {@link GuiNewChat#clearChatMessages()} method
 *
 * @author boomboompower
 */
public class CommandMaxCPS implements BaseCommand {

    @Override
    public String getName() {
        return "maxcps";
    }

    @Override
    public String getUsage() {
        return "/maxcps <max>";
    }

    @Override
    public void onExecute(String[] args) {
        if (args.length == 1) {
            try {
                int i = Integer.parseInt(args[0]);
                Hyperium.INSTANCE.getHandlers().getConfigOptions().maxCps = i;
                GeneralChatHandler.instance().sendMessage("Set max CPS to " + i);

            } catch (Exception e) {
                GeneralChatHandler.instance().sendMessage(getUsage());

            }
        } else {
            GeneralChatHandler.instance().sendMessage(getUsage());
        }

    }
}
