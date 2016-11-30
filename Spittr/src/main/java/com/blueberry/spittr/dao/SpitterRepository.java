package com.blueberry.spittr.dao;

import com.blueberry.spittr.beans.Spitter;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by Administrator on 11/23/2016.
 */
public interface SpitterRepository {

    @Cacheable(value = "spittleCache", condition = "!#username.isEmpty()"
            , unless = "#result.id<0"
    )
    Spitter findByUsername(String username);

}
