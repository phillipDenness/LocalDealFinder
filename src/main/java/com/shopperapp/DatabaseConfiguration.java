package com.shopperapp;

import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class DatabaseConfiguration {

	private String dbName;
	private String userName;
	private String password;
	private String hostname;
	private String port = "3306";

    private Properties loadProperties(String propertiesFile) throws Exception{
        Resource resource = new ClassPathResource(propertiesFile);
        Properties props = PropertiesLoaderUtils.loadProperties(resource);

        return props;
    }
    
    public DatabaseConfiguration() throws Exception {
    
    	String filename = "mysql_local.properties";
    	
    	Properties prop = loadProperties(filename);
        dbName = prop.getProperty("dbName");
        userName = prop.getProperty("userName");
        password = prop.getProperty("password");
        hostname = prop.getProperty("hostname");
        port = prop.getProperty("port");
    }

	public String getDbName() {
		return dbName;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getHostname() {
		return hostname;
	}
	public String getPort() {
		return port;
	}
}