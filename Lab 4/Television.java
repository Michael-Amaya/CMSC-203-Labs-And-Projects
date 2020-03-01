/** 
* The purpose of this class is to model a television
* Michael Amaya - 02/20/2020
* 
* @author Michael Amaya
*/
public class Television {
	
	/** Manufacturer of the TV */
	private final String MANUFACTURER;
	
	/** Size of the TV Screen */
	private final int SCREEN_SIZE;
	
	private boolean powerOn;    // The powerState of the TV. 
	private int channel;		 // The current channel
	private int volume;			 // The current volume
	
	/** Constructor designed to instantiate the 
	 * brand and size of the televison.
	 * 
	 * @param brand  The brand of the television
	 * @param size   The size of the television
	 */
	public Television(String brand, int size) {
		// Initialize all global variables
		MANUFACTURER = brand;
		SCREEN_SIZE = size;
		channel = 0;
		volume = 20;
		powerOn = false;
	}
	
	/** Method designed to change the channel of the TV
	 * 
	 * @param station The channel to change to
	 */
	public void setChannel(int station) {
		channel = station;
	}
	
	/** Powers the TV on and off */
	public void power() {
		powerOn = !powerOn;
	}
	
	 /** Increases the volume of the TV */
	public void increaseVolume() {
		volume++;
	}
	
	/** Decreases the volume of the TV */ 
	public void decreaseVolume() {
		volume--;
	}
	
	/** Get the current channel
	 * 
	 * @return the currently set channel
	 */
	public int getChannel() {
		return channel;
	}
	
	/** Get the current volume
	 * 
	 * @return the currently set volume
	 */
	public int getVolume() {
		return volume;
	}
	
	/** The the manufacturer of the TV
	 * 
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return MANUFACTURER;
	}
	
	/** Return the size of the TV
	 * 
	 * @return the TV size
	 */
	public int getScreenSize() {
		return SCREEN_SIZE;
	}
}
