package eu.ha3.mc.quick.keys;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.settings.KeyBinding;
import eu.ha3.mc.haddon.supporting.SupportsKeyEvents;
import eu.ha3.mc.haddon.supporting.SupportsTickEvents;

/**
 * Watches for key changes and notifies the given mod
 */
public class KeyWatcher implements SupportsTickEvents {
	private final SupportsKeyEvents watcher;
	private final List<KeyBinding> keys;
	
	public KeyWatcher(SupportsKeyEvents keyWatcher) {
		watcher = keyWatcher;
		keys = new ArrayList<KeyBinding>();
	}
	
	/**
	 * Adds a new keybinding to watch for changes.
	 */
	public void add(KeyBinding key) {
		keys.add(key);
	}
	
	@Override
	public void onTick()
	{
		for (KeyBinding key : this.keys)
            // dag edit getIsKeyPressed() -> isPressed()
			if (key.isPressed())
			{
				this.watcher.onKey(key);
			}
		}
	}
}
