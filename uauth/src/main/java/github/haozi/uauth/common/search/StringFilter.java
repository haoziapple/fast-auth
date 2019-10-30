package github.haozi.uauth.common.search;

import java.util.Objects;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 19:59
 */
public class StringFilter extends SearchFilter<String> {
    private static final long serialVersionUID = 1L;

    private String contains;

    public String getContains() {
        return contains;
    }

    public StringFilter setContains(String contains) {
        this.contains = contains;
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
        if (!super.equals(o)) {
            return false;
        }
        final StringFilter that = (StringFilter) o;
        return Objects.equals(contains, that.contains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), contains);
    }

    @Override
    public String toString() {
        return getFilterName() + " ["
                + (getContains() != null ? "contains=" + getContains() + ", " : "")
                + (getEquals() != null ? "equals=" + getEquals() + ", " : "")
                + (getSearchNull() != null ? "searchNull=" + getSearchNull() : "")
                + "]";
    }
}
