package org.cam.proxy.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;

/**
 * Created by wuyaohui on 14-10-8.
 */
public class RegexTestUtils {

    private static final Logger LOG = LoggerFactory.getLogger(RegexTestUtils.class);

    public static void logGroups(Matcher m){
        while(m.find()){
            for(int i=0;i<m.groupCount();i++){
                LOG.debug("group {} : {}",i,m.group(i));
            }
        }
    }
}
