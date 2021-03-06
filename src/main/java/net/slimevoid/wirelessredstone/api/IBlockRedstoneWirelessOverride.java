/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details. You should have received a copy of the GNU
 * Lesser General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>
 */
package net.slimevoid.wirelessredstone.api;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

/**
 * Block override.<br>
 * Used for injecting code into existing Wireless Blocks.<br>
 * Useful for addons that changes the mechanics of existing Blocks.<br>
 * NOTE: All methods must be implemented, content is optional.
 * 
 * Used by: BlockRedstoneWireless
 * 
 * @author ali4z
 */
public interface IBlockRedstoneWirelessOverride {
    /**
     * Triggers before the block is added to the world.
     * 
     * @param world
     *            The world object
     * @param x
     *            World X coordinate
     * @param y
     *            World Y coordinate
     * @param z
     *            World Z coordinate
     * 
     * @return Exits prematurely if true, skipping existing code.
     */
    public boolean beforeBlockRedstoneWirelessAdded(World world, int x, int y, int z);

    /**
     * Triggered after the Block is added to the world.
     * 
     * @param world
     *            The world object
     * @param x
     *            World X coordinate
     * @param y
     *            World Y coordinate
     * @param z
     *            World Z coordinate
     */
    public void afterBlockRedstoneWirelessAdded(World world, int x, int y, int z);

    /**
     * Triggers before the Block is removed from the world.
     * 
     * @param world
     *            The world object
     * @param x
     *            World X coordinate
     * @param y
     *            World Y coordinate
     * @param z
     *            World Z coordinate
     * @param m
     * @param block
     * 
     * @return Exits prematurely if true, skipping existing code.
     */
    public boolean beforeBlockRedstoneWirelessRemoved(World world, int x, int y, int z, Block block, int m);

    /**
     * Triggers after the Block is removed from the world.
     * 
     * @param world
     *            The world object
     * @param x
     *            World X coordinate
     * @param y
     *            World Y coordinate
     * @param z
     *            World Z coordinate
     */
    public void afterBlockRedstoneWirelessRemoved(World world, int x, int y, int z);

    /**
     * Triggers when the Block is activated/right clicked.<br>
     * Before any other code is run.
     * 
     * @param world
     *            The world object
     * @param x
     *            World X coordinate
     * @param y
     *            World Y coordinate
     * @param z
     *            World Z coordinate
     * @param entityplayer
     *            Player that activated the block.
     * 
     * @return Exits prematurely if true, skipping existing code.
     */
    public boolean beforeBlockRedstoneWirelessActivated(World world, int x, int y, int z, EntityPlayer entityplayer);

    /**
     * Triggers when the Block is activated/right clicked.<br>
     * After any other code is run.
     * 
     * @param world
     *            The world object
     * @param x
     *            World X coordinate
     * @param y
     *            World Y coordinate
     * @param z
     *            World Z coordinate
     * @param entityplayer
     *            Player that activated the block.
     */
    public void afterBlockRedstoneWirelessActivated(World world, int x, int y, int z, EntityPlayer entityplayer);

    /**
     * Triggers before the Block's neighboring Block changes.
     * 
     * @param world
     *            The world object
     * @param x
     *            World X coordinate
     * @param y
     *            World Y coordinate
     * @param z
     *            World Z coordinate
     * @param block
     *            Direction
     * 
     * @return Exits prematurely if true, skipping existing code.
     */
    public boolean beforeBlockRedstoneWirelessNeighborChange(World world, int x, int y, int z, Block block);

    /**
     * Triggers after the Block's neighboring Block changes.
     * 
     * @param world
     *            The world object
     * @param x
     *            World X coordinate
     * @param y
     *            World Y coordinate
     * @param z
     *            World Z coordinate
     * @param block
     *            Direction
     */
    public void afterBlockRedstoneWirelessNeighborChange(World world, int x, int y, int z, Block block);

    /**
     * Triggers before the Block is updated
     * 
     * @param world
     *            The world object
     * @param x
     *            World X coordinate
     * @param y
     *            World Y coordinate
     * @param z
     *            World Z coordinate
     * @param random
     *            Randomization object
     * 
     * @return Exits prematurely if true, skipping existing code.
     */
    public boolean beforeUpdateRedstoneWirelessTick(World world, int x, int y, int z, Random random);

    /**
     * Triggers after the Block is updated
     * 
     * @param world
     *            The world object
     * @param x
     *            World X coordinate
     * @param y
     *            World Y coordinate
     * @param z
     *            World Z coordinate
     * @param random
     *            Randomization object
     */
    public void afterUpdateRedstoneWirelessTick(World world, int x, int y, int z, Random random);

    /**
     * Return true if the texture override method should be called
     * 
     * @param iblockaccess
     * @param x
     * @param y
     * @param z
     * @param side
     * @return
     */
    public boolean shouldOverrideTextureAt(IBlockAccess iblockaccess, int x, int y, int z, int side);

    /**
     * Returns the existing texture or a new texture
     * @param iblockaccess
     * @param x
     * @param y
     * @param z
     * @param side
     * @param output
     * @return
     */
    public IIcon getBlockTexture(IBlockAccess iblockaccess, int x, int y, int z, int side, IIcon output);
}
