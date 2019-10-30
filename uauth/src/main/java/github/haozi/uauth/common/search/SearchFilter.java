package github.haozi.uauth.common.search;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/***
 * 用来查询搜索的实体类型
 * <pre>
 *      fieldName.equals='something'
 *      fieldName.searchNull=true
 *      fieldName.searchNull=false
 *      fieldName.in='something','other'
 * </pre>
 * @author wanghao
 * @Description
 * @date 2019-10-29 19:52
 */
public class SearchFilter<FIELD_TYPE> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 是否查询空值
     */
    private Boolean searchNull;
    /**
     * 按等于查询
     */
    private FIELD_TYPE equals;
    /**
     * 按in查询
     */
    private List<FIELD_TYPE> in;

    public FIELD_TYPE getEquals() {
        return equals;
    }

    public SearchFilter<FIELD_TYPE> setEquals(FIELD_TYPE equals) {
        this.equals = equals;
        return this;
    }

    public Boolean getSearchNull() {
        return searchNull;
    }

    public SearchFilter<FIELD_TYPE> setSearchNull(Boolean searchNull) {
        this.searchNull = searchNull;
        return this;
    }

    public List<FIELD_TYPE> getIn() {
        return in;
    }

    public SearchFilter<FIELD_TYPE> setIn(List<FIELD_TYPE> in) {
        this.in = in;
        return this;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SearchFilter<?> filter = (SearchFilter<?>) o;
        return Objects.equals(equals, filter.equals) &&
                Objects.equals(searchNull, filter.searchNull) &&
                Objects.equals(in, filter.in);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equals, searchNull, in);
    }

    @Override
    public String toString() {
        return getFilterName() + " ["
                + (getEquals() != null ? "equals=" + getEquals() + ", " : "")
                + (getIn() != null ? "in=" + getIn() + ", " : "")
                + (getSearchNull() != null ? "searchNull=" + getSearchNull() : "")
                + "]";
    }

    protected String getFilterName() {
        return this.getClass().getSimpleName();
    }
}
