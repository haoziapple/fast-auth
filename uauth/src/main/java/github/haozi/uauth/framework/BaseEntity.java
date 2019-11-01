package github.haozi.uauth.framework;

import github.haozi.uauth.common.util.IdWorker;
import org.nutz.dao.entity.annotation.*;
import org.nutz.dao.interceptor.annotation.PrevInsert;
import org.nutz.dao.interceptor.annotation.PrevUpdate;

import java.util.Date;

/**
 * 数据库实体基类
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
    @Comment("主键")
    private String id;
    @Column(hump = true)
    @Comment("创建者")
    private String creator;
    @Column(hump = true)
    @Comment("修改者")
    private String modifier;
    @Column(hump = true)
    @PrevInsert(now = true)
    @Comment("创建时间")
    private Date createTime;
    @Column(hump = true)
    @Comment("修改时间")
    @PrevUpdate(now = true)
    private Date updateTime;

    @Column(hump = true)
    @ColDefine(width = 512)
    @Comment("备注")
    private String remark;

    @Column(hump = true)
    @ColDefine(width = 1024)
    @Comment("扩展字段-业务方使用")
    private String ext;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    /**
     * 生成主键id
     * @return
     */
    public String genId() {
        return IdWorker.getIdStr();
    }
}
