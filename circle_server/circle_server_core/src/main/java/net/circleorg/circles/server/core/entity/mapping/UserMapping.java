package net.circleorg.circles.server.core.entity.mapping;

import net.circleorg.circles.api.entity.User;

import org.mongolink.domain.mapper.AggregateMap;;

public class UserMapping extends AggregateMap<User> {

	@Override
	public void map() {
		id().onProperty(element().getId()).auto();
	}

}
