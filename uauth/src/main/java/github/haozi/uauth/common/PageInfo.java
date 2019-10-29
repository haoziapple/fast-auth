package github.haozi.uauth.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 19:01
 */
public class PageInfo<T> implements Serializable {
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //排序
    private String orderBy;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
