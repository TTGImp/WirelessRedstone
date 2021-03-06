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
package net.slimevoid.wirelessredstone.client.overrides;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.slimevoid.wirelessredstone.api.IBlockRedstoneWirelessOverride;

public class BlockRedstoneWirelessOverrideSMP implements
        IBlockRedstoneWirelessOverride {

    @Override
    public boolean beforeBlockRedstoneWirelessAdded(World world, int x, int y, int z) {
        return (world.isRemote);
    }

    @Override
    public void afterBlockRedstoneWirelessAdded(World world, int x, int y, int z) {
    }

    @Override
    public boolean beforeBlockRedstoneWirelessRemoved(World world, int x, int y, int z, Block block, int m) {
        return (world.isRemote);
    }

    @Override
    public void afterBlockRedstoneWirelessRemoved(World world, int x, int y, int z) {
    }

    @Override
    public boolean beforeBlockRedstoneWirelessActivated(World world, int x, int y, int z, EntityPlayer entityplayer) {
        return (world.isRemote);
    }

    @Override
    public void afterBlockRedstoneWirelessActivated(World world, int x, int y, int z, EntityPlayer entityplayer) {
    }

    @Override
    public boolean beforeBlockRedstoneWirelessNeighborChange(World world, int x, int y, int z, Block block) {
        return (world.isRemote);
    }

    @Override
    public void afterBlockRedstoneWirelessNeighborChange(World world, int x, int y, int z, Block block) {
    }

    @Override
    public boolean beforeUpdateRedstoneWirelessTick(World world, int x, int y, int z, Random random) {
        return (world.isRemote);
    }

    @Override
    public void afterUpdateRedstoneWirelessTick(World world, int x, int y, int z, Random random) {
    }

    @Override
    public boolean shouldOverrideTextureAt(IBlockAccess iblockaccess, int x, int y, int z, int side) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public IIcon getBlockTexture(IBlockAccess iblockaccess, int x, int y, int z, int side, IIcon output) {
        // TODO Auto-generated method stub
        return null;
    }
}
