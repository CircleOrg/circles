package net.circleorg.circles.api;

import java.util.Locale;

public interface Users {
	
	/**
	 * Register a new user with the given name, email and password.
	 * @param locale	User language
	 * @param name		User name
	 * @param email		User email, if not null, a confirmation mail will be sent to this address
	 * @param pwHash	Chosen password already hashed by the client
	 * @return			The result of the registration request
	 */
	public GenericResult registerUser(Locale locale, String name, String email, byte[] pwHash);
	
	/**
	 * Authenticate the user
	 * @param locale	User language
	 * @param login		User name of email
	 * @param pwHash	Password
	 * @return			The result of the authentication
	 */
	public GenericResult authenticateUser(Locale locale, String login, byte[] pwHash);

	/**
	 * Change the users password.
	 * @param locale
	 * @param login
	 * @param oldPwHash
	 * @param newPwHash
	 * @return
	 */
	public GenericResult changePassword(Locale locale, String login, byte[] oldPwHash, byte[] newPwHash);
	
	/**
	 * Request a password reset. Only valid with username and password!<br>
	 * Passwords can also be rest qith the device ID.
	 * @param locale
	 * @param name
	 * @param email
	 * @return
	 */
	public GenericResult resetPasswordRequest(Locale locale, String name, String email);
}
