package org.garden.cfg;

public interface CfgClient {

	String getValue(String key);

	String setValue(String key, String value);

}
