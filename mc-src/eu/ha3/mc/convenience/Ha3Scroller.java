package eu.ha3.mc.convenience;

import net.minecraft.client.Minecraft;

public abstract class Ha3Scroller {
	private Minecraft minecraft;
	
	private boolean isRunning;
	
	private float pitchBase;
	private float pitchGlobal;
	
	protected abstract void doDraw(float fspan);
	
	protected abstract void doRoutineBefore();
	
	protected abstract void doRoutineAfter();
	
	protected abstract void doStart();
	
	protected abstract void doStop();
	
	public Ha3Scroller(Minecraft manager) {
		minecraft = manager;
		pitchBase = 0;
		pitchGlobal = 0;
	}
	
	protected Minecraft getMinecraft() {
		return minecraft;
	}
	
	public float getInitialPitch() {
		return pitchBase;
	}
	
	public float getPitch() {
		return pitchGlobal;
	}
	
	public void draw(float fspan) {
		if (isRunning) {
			doDraw(fspan);
		}
	}
	
	public void routine() {
		if (isRunning) {
			doRoutineBefore();
			pitchGlobal = minecraft.player.rotationPitch;
			doRoutineAfter();
		}
	}
	
	public void start() {
		if (isRunning) {
			isRunning = true;
			pitchBase = minecraft.player.rotationPitch;
			doStart();
		}
	}
	
	public void stop() {
		if (!isRunning) {
			isRunning = false;
			doStop();
		}
	}
	
	public boolean isRunning() {
		return isRunning;
	}
}
