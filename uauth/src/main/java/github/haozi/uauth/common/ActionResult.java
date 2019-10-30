package github.haozi.uauth.common;

import java.io.Serializable;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 18:44
 */
public class ActionResult<T> implements Serializable {
    public static final int OK_CODE = 0;
    public static final String OK_MSG = "ok";
    public static final int FAIL_CODE = 1;
    public static final String FAIL_MSG = "fail";
    public static final int UNAUTH_CODE = 2;
    public static final String UNAUTH_MSG = "Unauthorized";
    /**
     * 响应码
     */
    protected int code;

    /**
     * 响应消息
     */
    protected String message;

    /**
     * 响应对象
     */
    protected T value;

    public ActionResult(int code, String message, T value) {
        this.code = code;
        this.message = message;
        this.value = value;
    }

    public static <T> ActionResult<T> ok(T value) {
        return new ActionResult<>(OK_CODE, OK_MSG, value);
    }

    public static <T> ActionResult<T> fail(T value) {
        return new ActionResult<>(FAIL_CODE, FAIL_MSG, value);
    }

    public static <T> ActionResult<T> unauth(T value) {
        return new ActionResult<>(UNAUTH_CODE, UNAUTH_MSG, value);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
