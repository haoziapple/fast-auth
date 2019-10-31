package github.haozi.uauth.framework;

import github.haozi.uauth.common.util.IdWorker;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.EL;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.interceptor.annotation.PrevInsert;
import org.nutz.dao.interceptor.annotation.PrevUpdate;

import java.util.Date;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-31 13:42
 */
public class BaseEntity {
    //注意,字符串主键用@Name,与属性名称无关!!!
    @Name
    // 可以是 uuid() uuid(32)
    // @Prev(els = @EL("uuid()"))
    @PrevInsert(els = @EL("$me.genId()"))
    private String id;
    @Column(hump = true)
    private String creator;
    @Column(hump = true)
    private String modifier;
    @Column(hump = true)
    @PrevInsert(now = true)
    private Date createTime;
    @Column(hump = true)
    @PrevUpdate(now = true)
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    /**
     * 生成主键id
     * @return
     */
    public String genId() {
        return IdWorker.getIdStr();
    }
}
