package net.circleorg.circles.api;

import java.util.Locale;
import java.util.UUID;

import net.circleorg.circles.api.entity.Device.DeviceType;

public interface Devices {
	
	/**
	 * Register a device for the given user.
	 * @param locale
	 * @param userId
	 * @param deviceType
	 * @param nativeDeviceId
	 * @return
	 */
	public GenericResult registerDevice(Locale locale, UUID userId, DeviceType deviceType, String nativeDeviceId);

}
