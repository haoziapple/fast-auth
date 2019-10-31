package github.haozi.uauth.service.dto;

import github.haozi.uauth.domain.enumeration.Sex;
import github.haozi.uauth.framework.BaseDTO;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 14:21
 */
public class ProfileDTO extends BaseDTO {
    private String name;

    private String accountName;

    private String password;

    private Sex sex;

    private String idNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
