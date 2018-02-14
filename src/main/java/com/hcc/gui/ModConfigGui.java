/*
 *     Hypixel Community Client, Client optimized for Hypixel Network
 *     Copyright (C) 2018  HCC Dev Team
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.hcc.gui;

import com.hcc.HCC;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.awt.*;
import java.io.IOException;

public class ModConfigGui extends GuiScreen {
    /**
     * current tab
     */
    private Tabs currentTab = Tabs.HOME;

    @Override
    public void initGui() {
        super.initGui();
        this.buttonList.add(Tabs.HOME.setButton(new GuiButton(0, getX(0), getY(), 50, 25, "HOME")));
        this.buttonList.add(Tabs.SETTINGS.setButton(new GuiButton(1, getX(1), getY(), 50, 25, "SETTINGS")));
        this.buttonList.add(Tabs.ADDONS.setButton(new GuiButton(2, getX(2), getY(), 50, 25, "ADDONS")));
        this.buttonList.add(Tabs.FRIENDS.setButton(new GuiButton(3, getX(3), getY(), 50, 25, "FRIENDS")));
        this.buttonList.add(Tabs.ABOUT.setButton(new GuiButton(4, getX(4), getY(), 50, 25, "ABOUT")));
        this.buttonList.add(Tabs.CHROMAHUD.setButton(new GuiButton(5, getX(5), getY(), 50, 25, "DISPLAY")));

    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        //background
        drawRect(width / 5, height / 5, width - width / 5, height - height / 5, new Color(0, 0, 0, 100).getRGB());

        //TODO: Draw string for each tab
        switch (currentTab) {
            case HOME:
                break;
            case SETTINGS:
                break;
            case ADDONS:
                break;
            case FRIENDS:
                break;
            case CHROMAHUD: {
                if (Minecraft.getMinecraft().thePlayer == null) {
                    drawCenteredString(fontRendererObj, "Please use this while in a world or on a server", width / 2, (height - height / 2) - 12, 0xFFFFFF);
                } else {
                    Minecraft.getMinecraft().displayGuiScreen(HCC.INSTANCE.getChromaHUD().getConfigGuiInstance());
                }
                break;
            }
            case ABOUT:
                drawCenteredString(fontRendererObj, "Developed by Sk1er, CoalOres, Kevin and Cubxity", width / 2, (height - height / 5) - 12, 0xFFFFFF);
                break;
        }
        super.drawScreen(mouseX, mouseY, partialTicks);

        // Tab highlight
        drawRect(getX(currentTab.getIndex()), getY() + 22, getX(currentTab.getIndex() + 1), getY() + 20, new Color(149, 201, 144).getRGB());
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        for (Tabs t : Tabs.values())
            if (t.getIndex() == button.id)
                currentTab = t;
        updateTabs();
    }

    private void updateTabs() {
        //TODO: Make all components invisible here


        //TODO: Make components visible corresponding to tab
        switch (currentTab) {
            case HOME:
                break;
            case SETTINGS:
                break;
            case ADDONS:
                break;
            case FRIENDS:
                break;
            case ABOUT:
                break;
            case CHROMAHUD:
                break;
        }
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    private int getX(int n) {
        return (width / 5) + (50 * n);
    }

    private int getY() {
        return height / 5;
    }

    private enum Tabs {
        HOME(null, 0),
        SETTINGS(null, 1),
        ADDONS(null, 2),
        FRIENDS(null, 3),
        ABOUT(null, 4),
        CHROMAHUD(null, 5);

        private GuiButton button;
        private int index;

        Tabs(GuiButton button, int index) {
            this.button = button;
            this.index = index;
        }

        public GuiButton setButton(GuiButton button) {
            this.button = button;
            return this.button;
        }

        public GuiButton getButton() {
            return button;
        }

        public int getIndex() {
            return index;
        }
    }
}