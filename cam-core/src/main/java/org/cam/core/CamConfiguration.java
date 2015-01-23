package org.cam.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Hold all the configuration for CAM system
 */
public class CamConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(CamConfiguration.class);

    private static final String CFG_FILE = "cam.properties" ;

    private String configFile ;
    private boolean passWithNoPermission ;
    private boolean allowNoEntityOfTable ;
    private boolean enableQueryListCache ;

    public CamConfiguration() {
        this(CFG_FILE);
    }

    public CamConfiguration(String configFile) {
        this.configFile = configFile;
        try(InputStream in = getClass().getClassLoader().getResourceAsStream(configFile)){
            load(in);
        }catch (IOException e){
            LOG.error("{}",e);
            throw new CamException("Error reading file "+configFile,e.getCause());
        }
    }

    private void load(InputStream inputStream) throws IOException{

        Properties prop = new Properties();
        prop.load(inputStream);

        LOG.debug("camConfiguration:{}",prop);

        passWithNoPermission = Boolean.valueOf(prop.getProperty("pass_with_no_permission","false"));
        allowNoEntityOfTable = Boolean.valueOf(prop.getProperty("allow_no_entity_of_table","false"));
        enableQueryListCache = Boolean.valueOf(prop.getProperty("enable_query_list_cache","false"));
    }

    public boolean isPassWithNoPermission() {
        return passWithNoPermission;
    }

    public boolean isAllowNoEntityOfTable() {
        return allowNoEntityOfTable;
    }

    public boolean isEnableQueryListCache() {
        return enableQueryListCache;
    }
}
