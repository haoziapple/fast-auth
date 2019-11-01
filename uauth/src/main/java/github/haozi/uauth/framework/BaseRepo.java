package github.haozi.uauth.framework;

import github.haozi.uauth.common.PageInfo;
import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Criteria;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

/**
 * 持久层Repo基类，提供基本的数据库操作
 *
 * @author wanghao
 * @Description
 * @date 2019-10-31 17:27
 */
public class BaseRepo<E_TYPE> {
    @Autowired
    protected Dao dao;

    /**
     * 插入单条记录，主键自动生成，见BaseEntity中的genId()方法
     * 注意entity中的Id字段会被设值
     *
     * @param entity
     * @return
     * @see BaseEntity
     */
    public E_TYPE create(E_TYPE entity) {
        E_TYPE added = dao.insert(entity);
        return added;
    }

    /**
     * 批量插入记录，主键自动生成，见BaseEntity中的genId()方法
     * 注意entity中的Id字段会被设值
     *
     * @param entities
     * @return
     */
    public List<E_TYPE> batchCreate(List<E_TYPE> entities) {
        return dao.insert(entities);
    }

    /**
     * 根据Id更新单条记录
     *
     * @param entity
     * @return
     */
    public int update(E_TYPE entity) {
        int updated = dao.update(entity);
        return updated;
    }

    /**
     * 根据condition批量更新
     *
     * @param chain
     * @param condition
     * @return
     */
    public int conditionUpdate(Chain chain, Condition condition) {
        // 还是根据entity的Id进行筛选更新，但是又添加了condition条件，感觉没什么用
        // int updated = dao.update(chain, condition);
        int updated = dao.update(getEntityClass(), chain, condition);
        return updated;
    }

    /**
     * 不分页查询
     *
     * @param condition
     * @return
     */
    public List<E_TYPE> query(Condition condition) {
        return dao.query(getEntityClass(), condition, null);
    }

    /**
     * 分页查询
     *
     * @param condition
     * @param pager
     * @return
     */
    public PageInfo<E_TYPE> pageQuery(Condition condition, Pager pager) {
        if (pager == null) {
            pager = new Pager(1, 20);
        }
        pager.setRecordCount(count(condition));

        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(pager.getPageNumber());
        pageInfo.setPageSize(pager.getPageSize());
        pageInfo.setTotal(pager.getRecordCount());
        pageInfo.setPages(pager.getPageCount());
        if (pageInfo.getTotal() == 0) {
            pageInfo.setList(new ArrayList(0));
        } else {
            pageInfo.setList(dao.query(getEntityClass(), condition, pager));
        }
        return pageInfo;
    }

    public int count(Condition condition) {
        return dao.count(getEntityClass(), condition);
    }

    /**
     * 根据id获取一条记录详情
     *
     * @param id
     * @return
     */
    public E_TYPE detail(String id) {
        return (E_TYPE) dao.fetch(getEntityClass(), id);
    }

    /**
     * 根据id批量获取详情
     *
     * @param idList
     * @return
     */
    public List<E_TYPE> batchDetails(List<String> idList) {
        Criteria cnd = Cnd.cri();
        cnd.where().andIn("id", idList.toArray(new String[]{}));
        return dao.query(getEntityClass(), cnd);
    }

    /**
     * 根据id删除一条记录
     *
     * @param id
     * @return
     */
    public int delete(String id) {
        int deleted = dao.delete(getEntityClass(), id);
        return deleted;
    }

    /**
     * 根据id批量删除
     *
     * @param idList
     * @return
     */
    public int batchDelete(List<String> idList) {
        int deleted = dao.delete(batchDetails(idList));
        return deleted;
    }


    protected Class getEntityClass() {
        return (Class<E_TYPE>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
