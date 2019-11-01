package github.haozi.uauth.domain;

import github.haozi.uauth.domain.enumeration.Sex;
import github.haozi.uauth.framework.BaseEntity;
import lombok.Data;
import lombok.ToString;
import org.nutz.dao.entity.annotation.*;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 14:25
 */
@Table("t_ius_profile")
// TODO 为什么lombok的注解不起作用了
@ToString
@Data
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

    @Column(hump = true)
    @Comment("年龄")
    private Integer age;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
