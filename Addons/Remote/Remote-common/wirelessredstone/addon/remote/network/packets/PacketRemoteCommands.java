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
package wirelessredstone.addon.remote.network.packets;

import java.util.HashMap;
import java.util.Map;

public class PacketRemoteCommands {
	public enum remoteCommands {
		activate, deactivate, changeFreq, updateReceiver, openGui;

		private int		value;
		private String	name;

		public int getCommand() {
			if (this != null) {
				return this.value;
			}
			return -1;
		}

		@Override
		public String toString() {
			if (this != null && this.name != null && !this.name.isEmpty()) {
				return this.name;
			}
			return "Command[" + this + " is not initialzed";
		}
	}

	public static void registerCommands() {
		remoteCommands.activate.value = 0;
		remoteCommands.activate.name = "activateRemote";
		registerCommand(remoteCommands.activate.name);
		remoteCommands.deactivate.value = 1;
		remoteCommands.deactivate.name = "deactivateRemote";
		registerCommand(remoteCommands.deactivate.name);
		remoteCommands.changeFreq.value = 2;
		remoteCommands.changeFreq.name = "changeRemoteFreq";
		registerCommand(remoteCommands.changeFreq.name);
		remoteCommands.updateReceiver.value = 3;
		remoteCommands.updateReceiver.name = "updateReceiver";
		registerCommand(remoteCommands.updateReceiver.name);
		remoteCommands.openGui.value = 4;
		remoteCommands.openGui.name = "openRemoteGui";
		registerCommand(remoteCommands.openGui.name);
	}

	public static String commandToString(int command) {
		for (remoteCommands value : remoteCommands.values()) {
			if (value != null & value.getCommand() == command) {
				return value.toString();
			}
		}
		String commandString = getRegisteredCommandString(command);
		if (!commandString.equals("")) {
			return commandString;
		}
		return "No Command Exists with value " + command;
	}

	private static String getRegisteredCommandString(int command) {
		if (commandList.containsKey(command)) {
			return commandList.get(command);
		}
		return "";
	}

	private static Map<Integer, String>	commandList	= new HashMap<Integer, String>();

	private static int getNextAvailableCommand() {
		return commandList.size() - 1;
	}

	public static void registerCommand(String name) {
		int nextID = getNextAvailableCommand();
		if (!commandList.containsKey(nextID)) {
			commandList.put(nextID,
							name);
		}
	}
}
