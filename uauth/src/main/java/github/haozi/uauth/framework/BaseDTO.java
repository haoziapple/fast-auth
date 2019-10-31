package github.haozi.uauth.framework;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-31 13:53
 */
@JsonIgnoreProperties
public class BaseDTO {
    private String id;
    private String creator;
    private String modifier;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date updateTime;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
