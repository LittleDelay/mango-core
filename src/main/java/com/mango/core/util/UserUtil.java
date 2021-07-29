package com.mango.core.util;

import cn.hutool.system.UserInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * 用户操作相关方法
 *
 * @author xs.Liu
 * @version 1.0.0
 * @since 2021/7/29 17:38
 */
@Slf4j
public class UserUtil {

//    public static UserInfo getUser() {
//        return threadLocal.get();
//    }

    public static Long getUserId() {
//        UserInfo user = getUser();
//        return Optional.ofNullable(user).orElse(new UserInfo()).getUserId();
        return 1L;
    }

}
