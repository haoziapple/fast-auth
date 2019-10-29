package github.haozi.uauth.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wanghao
 * @Description
 * @date 2019-10-29 14:22
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ProfileService {
}
