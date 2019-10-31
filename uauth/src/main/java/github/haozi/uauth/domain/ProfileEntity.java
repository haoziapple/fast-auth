package github.haozi.uauth.domain;

import github.haozi.uauth.domain.enumeration.Sex;
import github.haozi.uauth.framework.BaseEntity;
import lombok.ToString;
import org.nutz.dao.entity.annotation.*;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 14:25
 */
@Table("t_ius_profile")
@ToString
public class ProfileEntity extends BaseEntity {

    @Column(hump = true)
    @Comment("名称")
    private String name;

    @Column(hump = true)
    @Comment("登录账户")
    private String accountName;

    @Column(hump = true)
    @Comment("登录密码")
    private String password;

    @Column(hump = true)
    @Comment("性别")
    private Sex sex;

    @Column(hump = true)
    @Comment("身份证号")
    private String idNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
