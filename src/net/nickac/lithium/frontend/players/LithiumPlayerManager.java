

/*
 * MIT License
 *
 * Copyright (c) 2017 NickAc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.nickac.lithium.frontend.players;

import lombok.NonNull;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by NickAc for Lithium!
 */
public class LithiumPlayerManager {
	private HashMap<UUID, LithiumPlayer> players = new HashMap<>();

	public LithiumPlayerManager() {
	}

	public LithiumPlayer getPlayer(Player p) {
		return players.get(p.getUniqueId());
	}

	public void addPlayer(Player p) {
		players.put(p.getUniqueId(), new LithiumPlayer(p, false));
	}

	public boolean isUsingLithium(Player p) {
		return players.containsKey(p.getUniqueId()) && players.get(p.getUniqueId()).isUsingLithium();
	}

	public void setUsingLithium(UUID u, boolean using) {
		if (players.containsKey(u)) {
			players.get(u).setUsingLithium(using);
		}
	}

	public void removePlayer(@NonNull Player player) {
		players.remove(player.getUniqueId());
	}
}
