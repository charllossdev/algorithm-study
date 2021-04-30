package common;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Common {
	public static InputStream systemIn(String input) {
		return new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
	}
}
