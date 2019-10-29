package github.haozi.uauth.common;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 19:06
 */
public class SearchCommonVO<T> {
    private int pageNum;
    private int pageSize;
    private T filters;
    private String orderBy;

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

    public T getFilters() {
        return filters;
    }

    public void setFilters(T filters) {
        this.filters = filters;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
