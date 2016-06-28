/*
 * Copyright (c) 2015. 上海趣医网络科技有限公司 版权所有
 * Shanghai QuYi Network Technology Co., Ltd. All Rights Reserved.
 *
 * This is NOT a freeware,use is subject to license terms.
 */

package com.bao.jpa;

import com.bao.model.UrlInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface UrlInfoJpa extends JpaRepository<UrlInfo, Long> {

    @Modifying
    @Transactional
    @Query("update UrlInfo u set u.url =?1 , u.desc=?2 where u.id =?3 ")
    int update(String url, String desc ,Long id);
}
