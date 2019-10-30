package github.haozi.uauth.common.util;

import java.util.UUID;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-30 10:02
 */
public class IdWorker {
    /**
     * 主机和进程的机器码
     */
    private static final Sequence worker = new Sequence();

    public static long getId() {
        return worker.nextId();
    }

    public static String getIdStr() {
        return String.valueOf(worker.nextId());
    }

    /**
     * <p>
     * 获取去掉"-" UUID
     * </p>
     */
    public static synchronized String get32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
