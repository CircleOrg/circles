package net.circleorg.circles.server.core.entity.handler;

import java.net.UnknownHostException;

import org.mongolink.MongoSession;
import org.mongolink.MongoSessionManager;
import org.mongolink.Settings;
import org.mongolink.UpdateStrategies;
import org.mongolink.domain.mapper.ContextBuilder;

import com.google.common.collect.Lists;
import com.mongodb.ServerAddress;

public class MongoSessionHandler {
	
	private static MongoSessionHandler instance = new MongoSessionHandler();
	
	private MongoSessionManager mongoSessionManager;
	
	private MongoSessionHandler() {
		ContextBuilder builder = new ContextBuilder("net.circles.server.db.mongo.mapping");
		Settings settings = null;
		try {
			// TODO load mongo server address+auth+db from jndi
			settings = Settings.defaultInstance()
			                    .withDefaultUpdateStrategy(UpdateStrategies.DIFF)
			                    .withDbName("circles")
			                    .withAddresses(Lists.newArrayList(new ServerAddress("localhost", 27017)));
//            .withAuthentication("user", "passwd");
		} catch (UnknownHostException e) {
			e.printStackTrace();
			assert(false); // shut down immediately
		}
		
		mongoSessionManager = MongoSessionManager.create(builder, settings);
	}
	
	private static ThreadLocal<MongoSession> ms = null;

	/**
	 * Create a {@link MongoSession} and bind it to the current Thread
	 * If already a MongoSession was created for the current Thread, this will cause an Exception
	 * @return the newly created MongoSession
	 * @throws IllegalAccessException 
	 */
	public static MongoSession createSession() throws IllegalAccessException {
		if (ms != null && ms.get() != null)
			throw new IllegalAccessException("Already a MongoSession bound to this Thread!");
		
		MongoSession session = instance.mongoSessionManager.createSession();
		session.start();
		ms = new ThreadLocal<MongoSession>();
		ms.set(session);
		return session;
	}

	/**
	 * Get the currently active {@link MongoSession}
	 * Will result in a NPE if {@link #createSession()} was not called before
	 * @return the currently active MongoSession for this Thread
	 */
	public static MongoSession currentSession() {
		return ms.get();
	}

	/**
	 * Commit and destroy the current session.
	 * Any subsequent calls to {@link #currentSession()} will result in a NPE
	 */
	public static void closeSession() {
		ms.get().stop();
		ms.set(null);
	}
}
