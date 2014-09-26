package org.cam.proxy.hibernate;

import org.hibernate.*;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * A wrapper of {@link org.hibernate.Query} .
 *
 * <p>
 *     Because QueryImpl probably can't not be dynamic proxied using jdk.
 * </p>
 */
public class QueryWrapper implements Query{

    private final Query query;

    public QueryWrapper(Query query){
        this.query = query;
    }

    public Query getQuery(){
        return this.query;
    }

    @Override
    public String getQueryString() {
        return getQuery().getQueryString();
    }

    @Override
    public Integer getMaxResults() {
        return getQuery().getMaxResults();
    }

    @Override
    public Query setMaxResults(int maxResults) {
        return getQuery().setMaxResults(maxResults);
    }

    @Override
    public Integer getFirstResult() {
        return getQuery().getFirstResult();
    }

    @Override
    public Query setFirstResult(int firstResult) {
        return getQuery().setFirstResult(firstResult);
    }

    @Override
    public Query setFlushMode(FlushMode flushMode) {
        return getQuery().setFlushMode(flushMode);
    }

    @Override
    public Query setCacheMode(CacheMode cacheMode) {
        return getQuery().setCacheMode(cacheMode);
    }

    @Override
    public Query setCacheable(boolean cacheable) {
        return getQuery().setCacheable(cacheable);
    }

    @Override
    public Query setCacheRegion(String cacheRegion) {
        return getQuery().setCacheRegion(cacheRegion);
    }

    @Override
    public Query setTimeout(int timeout) {
        return getQuery().setTimeout(timeout);
    }

    @Override
    public Query setFetchSize(int fetchSize) {
        return getQuery().setFetchSize(fetchSize);
    }

    @Override
    public Query setReadOnly(boolean readOnly) {
        return getQuery().setReadOnly(readOnly);
    }

    @Override
    public LockOptions getLockOptions() {
        return getQuery().getLockOptions();
    }

    @Override
    public Query setLockOptions(LockOptions lockOptions) {
        return getQuery().setLockOptions(lockOptions);
    }

    @Override
    public Query setLockMode(String alias, LockMode lockMode) {
        return getQuery().setLockMode(alias,lockMode);
    }

    @Override
    public String getComment() {
        return getQuery().getComment();
    }

    @Override
    public Query setComment(String comment) {
        return getQuery().setComment(comment);
    }

    @Override
    public Query addQueryHint(String hint) {
        return getQuery().addQueryHint(hint);
    }

    @Override
    public String[] getReturnAliases() {
        return getQuery().getReturnAliases();
    }

    @Override
    public String[] getNamedParameters() {
        return getQuery().getNamedParameters();
    }

    @Override
    public Iterator iterate() {
        return getQuery().iterate();
    }

    @Override
    public ScrollableResults scroll() {
        return getQuery().scroll();
    }

    @Override
    public ScrollableResults scroll(ScrollMode scrollMode) {
        return getQuery().scroll(scrollMode);
    }

    @Override
    public List list() {
        return getQuery().list();
    }

    @Override
    public Object uniqueResult() {
        return getQuery().uniqueResult();
    }

    @Override
    public int executeUpdate() {
        return getQuery().executeUpdate();
    }

    @Override
    public Query setParameter(int position, Object val, Type type) {
        return getQuery().setParameter(position,val,type);
    }

    @Override
    public Query setParameter(String name, Object val, Type type) {
        return getQuery().setParameter(name,val,type);
    }

    @Override
    public Query setParameter(int position, Object val) {
        return getQuery().setParameter(position,val);
    }

    @Override
    public Query setParameter(String name, Object val) {
        return getQuery().setParameter(name,val);
    }

    @Override
    public Query setParameters(Object[] values, Type[] types) {
        return getQuery().setParameters(values,types);
    }

    @Override
    public Query setParameterList(String name, Collection values, Type type) {
        return getQuery().setParameterList(name,values,type);
    }

    @Override
    public Query setParameterList(String name, Collection values) {
        return getQuery().setParameterList(name,values);
    }

    @Override
    public Query setParameterList(String name, Object[] values, Type type) {
        return getQuery().setParameterList(name,values,type);
    }

    @Override
    public Query setParameterList(String name, Object[] values) {
        return getQuery().setParameterList(name,values);
    }

    @Override
    public Query setProperties(Object bean) {
        return getQuery().setProperties(bean);
    }

    @Override
    public Query setProperties(Map bean) {
        return getQuery().setProperties(bean);
    }

    @Override
    public Query setString(int position, String val) {
        return getQuery().setString(position,val);
    }

    @Override
    public Query setCharacter(int position, char val) {
        return getQuery().setCharacter(position,val);
    }

    @Override
    public Query setBoolean(int position, boolean val) {
        return getQuery().setBoolean(position,val);
    }

    @Override
    public Query setByte(int position, byte val) {
        return getQuery().setByte(position,val);
    }

    @Override
    public Query setShort(int position, short val) {
        return getQuery().setShort(position,val);
    }

    @Override
    public Query setInteger(int position, int val) {
        return getQuery().setInteger(position,val);
    }

    @Override
    public Query setLong(int position, long val) {
        return getQuery().setLong(position,val);
    }

    @Override
    public Query setFloat(int position, float val) {
        return getQuery().setFloat(position,val);
    }

    @Override
    public Query setDouble(int position, double val) {
        return getQuery().setDouble(position,val);
    }

    @Override
    public Query setBinary(int position, byte[] val) {
        return getQuery().setBinary(position,val);
    }

    @Override
    public Query setText(int position, String val) {
        return getQuery().setText(position,val);
    }

    @Override
    public Query setSerializable(int position, Serializable val) {
        return getQuery().setSerializable(position,val);
    }

    @Override
    public Query setLocale(int position, Locale locale) {
        return getQuery().setLocale(position,locale);
    }

    @Override
    public Query setBigDecimal(int position, BigDecimal number) {
        return getQuery().setBigDecimal(position,number);
    }

    @Override
    public Query setBigInteger(int position, BigInteger number) {
        return getQuery().setBigInteger(position,number);
    }

    @Override
    public Query setDate(int position, Date date) {
        return getQuery().setDate(position,date);
    }

    @Override
    public Query setTime(int position, Date date) {
        return getQuery().setTime(position,date);
    }

    @Override
    public Query setTimestamp(int position, Date date) {
        return getQuery().setTimestamp(position,date);
    }

    @Override
    public Query setCalendar(int position, Calendar calendar) {
        return getQuery().setCalendar(position,calendar);
    }

    @Override
    public Query setCalendarDate(int position, Calendar calendar) {
        return getQuery().setCalendarDate(position,calendar);
    }

    @Override
    public Query setString(String name, String val) {
        return getQuery().setString(name,val);
    }

    @Override
    public Query setCharacter(String name, char val) {
        return getQuery().setCharacter(name,val);
    }

    @Override
    public Query setBoolean(String name, boolean val) {
        return getQuery().setBoolean(name,val);
    }

    @Override
    public Query setByte(String name, byte val) {
        return getQuery().setByte(name,val);
    }

    @Override
    public Query setShort(String name, short val) {
        return getQuery().setShort(name,val);
    }

    @Override
    public Query setInteger(String name, int val) {
        return getQuery().setInteger(name,val);
    }

    @Override
    public Query setLong(String name, long val) {
        return getQuery().setLong(name,val);
    }

    @Override
    public Query setFloat(String name, float val) {
        return getQuery().setFloat(name,val);
    }

    @Override
    public Query setDouble(String name, double val) {
        return getQuery().setDouble(name,val);
    }

    @Override
    public Query setBinary(String name, byte[] val) {
        return getQuery().setBinary(name,val);
    }

    @Override
    public Query setText(String name, String val) {
        return getQuery().setText(name,val);
    }

    @Override
    public Query setSerializable(String name, Serializable val) {
        return getQuery().setSerializable(name,val);
    }

    @Override
    public Query setLocale(String name, Locale locale) {
        return getQuery().setLocale(name,locale);
    }

    @Override
    public Query setBigDecimal(String name, BigDecimal number) {
        return getQuery().setBigDecimal(name,number);
    }

    @Override
    public Query setBigInteger(String name, BigInteger number) {
        return getQuery().setBigInteger(name,number);
    }

    @Override
    public Query setDate(String name, Date date) {
        return getQuery().setDate(name,date);
    }

    @Override
    public Query setTime(String name, Date date) {
        return getQuery().setTime(name,date);
    }

    @Override
    public Query setTimestamp(String name, Date date) {
        return getQuery().setTimestamp(name,date);
    }

    @Override
    public Query setCalendar(String name, Calendar calendar) {
        return getQuery().setCalendar(name,calendar);
    }

    @Override
    public Query setCalendarDate(String name, Calendar calendar) {
        return getQuery().setCalendarDate(name,calendar);
    }

    @Override
    public Query setEntity(int position, Object val) {
        return getQuery().setEntity(position,val);
    }

    @Override
    public Query setEntity(String name, Object val) {
        return getQuery().setEntity(name,val);
    }

    @Override
    public Query setResultTransformer(ResultTransformer transformer) {
        return getQuery().setResultTransformer(transformer);
    }

    @Override
    public FlushMode getFlushMode() {
        return getQuery().getFlushMode();
    }

    @Override
    public CacheMode getCacheMode() {
        return getQuery().getCacheMode();
    }

    @Override
    public boolean isCacheable() {
        return getQuery().isCacheable();
    }

    @Override
    public String getCacheRegion() {
        return getQuery().getCacheRegion();
    }

    @Override
    public Integer getTimeout() {
        return getQuery().getTimeout();
    }

    @Override
    public Integer getFetchSize() {
        return getQuery().getFetchSize();
    }

    @Override
    public boolean isReadOnly() {
        return getQuery().isReadOnly();
    }

    @Override
    public Type[] getReturnTypes() {
        return getQuery().getReturnTypes();
    }
}
