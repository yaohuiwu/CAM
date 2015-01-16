package org.cam.core.domain;

import com.google.common.collect.Sets;
import org.cam.core.cache.Copyable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wuyaohui on 14-9-30.
 */
public class StringSet implements Copyable{

    private Set<String> idSet;

    public StringSet() {
    }

    public StringSet(Set<String> roleIdSet) {
        this.idSet = roleIdSet;
    }

    public Set<String> getIdSet() {
        return idSet;
    }

    @Override
    public Copyable copy() {
        if(idSet.isEmpty()){
            return new StringSet(Collections.EMPTY_SET);
        }
        Set<String> setCpy = new HashSet<>(idSet.size());
        setCpy.addAll(idSet);
        return new StringSet(setCpy);
    }

    public static Set<String> safeGet(StringSet set){
        return set !=null ? set.getIdSet() : null;
    }

    @Override
    public String toString() {
        return "StringSet{" +
                "idSet=" + idSet +
                '}';
    }
}
