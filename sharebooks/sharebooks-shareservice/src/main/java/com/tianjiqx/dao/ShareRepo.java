package com.tianjiqx.dao;

import com.tianjiqx.model.Share;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by tianjiqx on 2017/6/25.
 */
public interface ShareRepo extends JpaRepository<Share,Integer> {
    //根据分享者查询
    public List<Share> findBySharer(String sharer);
}
