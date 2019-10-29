package github.haozi.uauth.service.dto;

import github.haozi.uauth.domain.enumeration.Sex;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 14:21
 */
public class ProfileDTO {
    private String id;

    private String name;

    private Sex sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
