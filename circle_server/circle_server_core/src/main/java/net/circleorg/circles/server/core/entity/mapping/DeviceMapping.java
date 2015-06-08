package net.circleorg.circles.server.core.entity.mapping;

import net.circleorg.circles.api.entity.Device;

import org.mongolink.domain.mapper.AggregateMap;

public class DeviceMapping extends AggregateMap<Device> {

	@Override
	public void map() {
		id().onProperty(element().getId()).auto();
	}

}
