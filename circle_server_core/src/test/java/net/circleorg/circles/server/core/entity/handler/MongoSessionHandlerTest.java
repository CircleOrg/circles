package net.circleorg.circles.server.core.entity.handler;

import org.junit.Assert;
import org.junit.Test;
import org.mongolink.MongoSession;

public class MongoSessionHandlerTest {
	
	@Test
	public void testCreateSession() throws IllegalAccessException
	{
		MongoSession ms = MongoSessionHandler.createSession();
		Assert.assertNotNull(ms);
		
		MongoSessionHandler.closeSession();
	}

	@Test
	public void testCurrentSession() throws IllegalAccessException
	{
		MongoSessionHandler.createSession();
		MongoSession ms = MongoSessionHandler.currentSession();
		Assert.assertNotNull(ms);
		
		MongoSessionHandler.closeSession();
	}

}
