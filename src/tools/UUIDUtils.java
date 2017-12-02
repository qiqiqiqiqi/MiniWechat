package tools;

import java.util.UUID;

public class UUIDUtils {
	public static String createUserID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("\\-", "");
	}



}
