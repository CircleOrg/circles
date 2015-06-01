package net.circleorg.circles.api.entity;

import java.util.UUID;

public class Device {
	
	public enum DeviceType {
		UNKNOWN,
		ANDROID,
		WINPHONE,
		IPHONE,
		WEB
	}
	
    private UUID id;
    private UUID userId;
    private DeviceType deviceType;
    private String nativeDeviceId;
    
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public DeviceType getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}
	public String getNativeDeviceId() {
		return nativeDeviceId;
	}
	public void setNativeDeviceId(String nativeDeviceId) {
		this.nativeDeviceId = nativeDeviceId;
	}
}
