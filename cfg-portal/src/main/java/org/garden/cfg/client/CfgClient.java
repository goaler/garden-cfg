package org.garden.cfg.client;

public interface CfgClient {

	String getValue(String key);

	String setValue(String key, String value);

}
