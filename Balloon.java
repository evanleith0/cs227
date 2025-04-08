package hw1;

/**
 * This is the main balloon class.
 */
public class Balloon {
	
	/**
	 * Stores the current ground position of the balloon.
	 */
	private int groundPosition;
	
	/**
	 * Stores the maximum ground position the balloon can go.
	 */
	private int maxGroundPosition;
	
	/**
	 * Stores the maximum altitude the balloon can go.
	 */
	private int maxAltitude;
	
	/**
	 * Stores the amount of fuel the balloon can hold.
	 */
	private double tankCapacity;
	
	/**
	 * Stores the current fuel amount.
	 */
	private double fuelAmount;
	
	/**
	 * Stores the maximum rate the fuel can burn.
	 */
	private double maxBurnRate;
	
	/**
	 * Stores the current vertical velocity the balloon is traveling.
	 */
	private int verticalVelocity;
	
	/**
	 * Stores the current horizontal velocity the balloon is traveling.
	 */
	private int horizontalVelocity;
	
	/**
	 * Stores the current altitude of the balloon.
	 */
	private int altitude;
	
	/**
	 * Stores the time past.
	 */
	private int time;
	
	/**
	 * Stores the initial ground position of the balloon.
	 */
	private int initialGroundPosition;
	
	/**
	 * Initializes the balloon with all of the given parameters.
	 * @param groundPosition Takes in the starting ground position.
	 * @param maxGroundPosition Takes in the maximum ground position the balloon can travel.
	 * @param maxAltitude Takes in the maximum altitude the balloon can go.
	 * @param tankCapacity Takes in the maximum amount of fuel the balloon can hold.
	 */
	public Balloon(int groundPosition, int maxGroundPosition, 
			int maxAltitude, double tankCapacity) {
		this.groundPosition = groundPosition;
		initialGroundPosition = groundPosition;
		this.maxGroundPosition = maxGroundPosition;
		this.maxAltitude = maxAltitude;
		this.tankCapacity = tankCapacity;
	}
	
	/**
	 * Gets the current vertical velocity.
	 * @return Returns the vertical velocity.
	 */
	public int getVerticalVelocity() {
		return verticalVelocity;
	}

	/**
	 * Gets the current horizontal velocity.
	 * @return Returns the horizontal velocity
	 */
	public int getHorizontalVelocity() {
		return horizontalVelocity;
	}
	
	/**
	 * Gets the current altitude.
	 * @return Returns the altitude.
	 */
	public int getAltitude() {
		return altitude;
	}
	
	/**
	 * Gets the maximum altitude the balloon can go.
	 * @return Returns the maximum altitude.
	 */
	public int getMaxAltitude() {
		return maxAltitude;
	}
	
	/**
	 * Gets the current position of the balloon in reference to the ground.
	 * @return Returns the ground position.
	 */
	public int getGroundPosition() {
		return groundPosition;
	}
	
	/**
	 * Gets the farthest position the balloon can travel.
	 * @return Returns the maximum ground position.
	 */
	public int getMaxGroundPosition() {
		return maxGroundPosition;
	}
	
	/**
	 * Gets the current amount of fuel.
	 * @return Returns the fuel amount
	 */
	public double getFuel() {
		return fuelAmount;
	}
	
	/**
	 * Gets the maximum capacity of the tank.
	 * @return Returns the maximum tank capacity.
	 */
	public double getTankCapacity() {
		return tankCapacity;
	}
	
	/**
	 * Gets the maximum burn rate of the fuel.
	 * @return Returns the burn rate of the fuel
	 */
	public double getMaxBurnRate() {
		return maxBurnRate;
	}
	/**
	 * Sets the capacity of the fuel tank.
	 * @param tankCapacity Takes in a new value for tank capacity.
	 */
	public void setTankCapacity(double tankCapacity) {
		this.tankCapacity = tankCapacity;
	}
	
	/**
	 * Sets the maximum burn rate of the fuel.
	 * @param maxBurnRate Takes in a new burn rate value.
	 */
	public void setMaxBurnRate(double maxBurnRate) {
		this.maxBurnRate = maxBurnRate;
	}
	
	/**
	 * Sets the amount of time the simulation has run.
	 * @param time Takes in an amount of time past.
	 */
	public void setTime(int time) {
		this.time = time;
	}
	/**
	 * Sets the ground position back to its original value.
	 */
	public void restoreInitialGroundPosition() {
		groundPosition = initialGroundPosition;
	}
	
	/**
	 * Gets the amount of seconds past the current minute.
	 * @return Returns the amount of spare seconds after the last minute.
	 */
	public int getSeconds() {
		return time % 60;
	}
	
	/**
	 * Gets the amount of minutes past in the current hour.
	 * @return  Returns the amount of spare minutes after the last hour.
	 */
	public int getMinutes() {
		return (time % 3600) / 60;
	}
	/**
	 * Gets the number of hours passed.
	 * @return Returns the number of hours past.
	 */
	public int getHours() {
		return time / 3600;
	}
	
	/**
	 * Changes the vertical velocity by the given delta.
	 * @param delta Changes the vertical velocity by the delta.
	 */
	public void adjustVerticalVelocity(int delta) {
		verticalVelocity += delta;
	}
	
	/**
	 * Changes the horizontal velocity by the given delta.
	 * @param delta Changes the horizontal velocity by the delta.
	 */
	public void adjustHorizontalVelocity(int delta) {
		horizontalVelocity += delta;
	}
	
	/**
	 * Adds the given amount of fuel into the tank.
	 * @param amount Amount of fuel that wants to be added.
	 * @return Returns the amount of fuel that was actually added.
	 */
	public double addFuel(double amount) {
		double fuelAmountBefore = fuelAmount;
		fuelAmount = Math.min(tankCapacity, amount + fuelAmount);
		return fuelAmount - fuelAmountBefore;
	}
	
	/**
	 * Simulates the passing of one second. Increments time, altitude, ground position, and fuel.
	 * @return Returns the amount of fuel burned
	 */
	public double oneSecondUpdate() {
		time += 1;
		altitude = Math.min(Math.max(verticalVelocity + altitude, 0), maxAltitude);
		groundPosition = (maxGroundPosition + horizontalVelocity + groundPosition) % maxGroundPosition;
		double fuelAmountBefore = fuelAmount;
		fuelAmount -=  Math.min(maxBurnRate, fuelAmount);
		return fuelAmountBefore - fuelAmount;
	}
}
