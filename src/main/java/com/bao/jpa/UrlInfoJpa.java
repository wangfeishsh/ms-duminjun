/*
 * Copyright (c) 2015. 上海趣医网络科技有限公司 版权所有
 * Shanghai QuYi Network Technology Co., Ltd. All Rights Reserved.
 *
 * This is NOT a freeware,use is subject to license terms.
 */

package com.bao.jpa;

import com.bao.model.UrlInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UrlInfoJpa extends CrudRepository<UrlInfo, Long> {

}
