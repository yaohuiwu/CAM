package org.cam.core.sql;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.cam.core.FactoryHelper;
import org.cam.core.parser.ParserUtil;

/**
 * Reference a table in sql statement.
 */
public class TableRef{

    private String name ;
    private String as ;
    private String alias ;

    private String securityView ;

    public TableRef(String originalString) {

        String[] splits = StringUtils.split(StringUtils.trim(originalString));
        if(splits.length==0){
            throw new IllegalArgumentException("empty originalString");
        }
        this.name = splits[0];

        if(splits.length > 1 ){
            if(splits.length > 2){
                this.as = splits[1];
                this.alias = splits[2];
            }else{
                this.alias = splits[1];
            }
        }
    }


    public String getName() {
        return name;
    }

    public String getAs() {
        return as;
    }

    public String getAlias() {
        return alias;
    }

    public String getSecurityView() {
        return securityView;
    }

    public void setSecurityView(String securityView) {
        if(Strings.isNullOrEmpty(securityView) || ParserUtil.isAll(securityView)){
            this.securityView = toOriginalString();
            return ;
//                throw new IllegalArgumentException("null securityView");
        }

//        if(ParserUtil.isAll(securityView)) {
//            this.securityView = toOriginalString();
//            return ;
//        }
        StringBuilder s = new StringBuilder();
        s.append("(select * from ");

        s.append(this.name);
        s.append(" where ");
        s.append(securityView);
        s.append(")");
        s.append(" ");
        s.append(getAliasString());
        this.securityView = s.toString();
    }

    @Override
    public String toString() {
        return "TableRef{" +
                "name='" + name + '\'' +
                ", as='" + as + '\'' +
                ", alias='" + alias + '\'' +
                ", securityView='" + securityView + '\'' +
                '}';
    }

    public String toOriginalString(){
        StringBuilder s = new StringBuilder();
        s.append(this.name);
        if(this.alias!=null){
            if(this.as!=null){
                s.append(" ");
                s.append(this.as);
            }
            s.append(" ");
            s.append(this.alias);
        }
        return s.toString();
    }

    public String getAliasString(){
        StringBuilder s = new StringBuilder();
        if(!Strings.isNullOrEmpty(this.alias)){
            if(!Strings.isNullOrEmpty(this.as)){
                s.append(this.as);
            }
            s.append(this.alias);
        }else{
            s.append(this.name);
            s.append("_alias");
        }
        return s.toString();
    }
}
