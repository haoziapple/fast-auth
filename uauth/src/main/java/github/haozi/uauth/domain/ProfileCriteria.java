package github.haozi.uauth.domain;

import github.haozi.uauth.common.search.StringFilter;
import github.haozi.uauth.framework.Criteria;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.util.cri.Static;

import java.io.Serializable;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 20:02
 */
public class ProfileCriteria implements Serializable, Criteria {
    private static final long serialVersionUID = 1L;

    private StringFilter id;

    private StringFilter name;

    private StringFilter accountName;

    private StringFilter password;

    private StringFilter idNumber;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public StringFilter getId() {
        return id;
    }

    public void setId(StringFilter id) {
        this.id = id;
    }

    public StringFilter getName() {
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getAccountName() {
        return accountName;
    }

    public void setAccountName(StringFilter accountName) {
        this.accountName = accountName;
    }

    public StringFilter getPassword() {
        return password;
    }

    public void setPassword(StringFilter password) {
        this.password = password;
    }

    public StringFilter getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(StringFilter idNumber) {
        this.idNumber = idNumber;
    }

    @Override
    public Condition condition() {
        org.nutz.dao.sql.Criteria condition = Cnd.cri();
        // TODO 1. 使用反射遍历SearchFilter的字段 2.驼峰转下划线获取数据库字段名
        if (id != null) {
            if (id.getSearchNull() != null && id.getSearchNull()) {
                condition.where().and(new Static("id is null"));
            } else if (id.getEquals() != null) {
                condition.where().and("id", "=", id.getEquals());
            } else if (id.getIn() != null && id.getIn().size() > 0) {
                condition.where().andIn("id", id.getIn().toArray(new String[]{}));
            } else if (id.getContains() != null) {
                condition.where().andLike("id", id.getContains(), false);
            }
        }

        if (name != null) {
            if (name.getSearchNull() != null && name.getSearchNull()) {
                condition.where().and(new Static("name is null"));
            } else if (name.getEquals() != null) {
                condition.where().and("name", "=", name.getEquals());
            } else if (name.getIn() != null && name.getIn().size() > 0) {
                condition.where().andIn("name", name.getIn().toArray(new String[]{}));
            } else if (name.getContains() != null) {
                condition.where().andLike("name", name.getContains(), false);
            }
        }

        if (accountName != null) {
            if (accountName.getSearchNull() != null && accountName.getSearchNull()) {
                condition.where().and(new Static("account_name is null"));
            } else if (accountName.getEquals() != null) {
                condition.where().and("account_name", "=", id.getEquals());
            } else if (accountName.getIn() != null && accountName.getIn().size() > 0) {
                condition.where().andIn("account_name", accountName.getIn().toArray(new String[]{}));
            } else if (accountName.getContains() != null) {
                condition.where().andLike("account_name", accountName.getContains(), false);
            }
        }

        if (idNumber != null) {
            if (idNumber.getSearchNull() != null && idNumber.getSearchNull()) {
                condition.where().and(new Static("id_number is null"));
            } else if (idNumber.getEquals() != null) {
                condition.where().and("id_number", "=", idNumber.getEquals());
            } else if (idNumber.getIn() != null && idNumber.getIn().size() > 0) {
                condition.where().andIn("id_number", idNumber.getIn().toArray(new String[]{}));
            } else if (idNumber.getContains() != null) {
                condition.where().andLike("id_number", idNumber.getContains(), false);
            }
        }

        return condition;
    }
}
