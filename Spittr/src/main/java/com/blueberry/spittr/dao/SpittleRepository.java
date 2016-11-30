package com.blueberry.spittr.dao;

import com.blueberry.spittr.beans.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 * 借助 SpringData 实现自动化的Jpa Repository
 */
public interface SpittleRepository extends JpaRepository<Spitter, Long> ,SpitterSweeper{
    Spitter findByUsername(String username);
}
