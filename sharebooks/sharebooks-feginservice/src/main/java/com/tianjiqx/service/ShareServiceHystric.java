package com.tianjiqx.service;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianjiqx on 2017/6/26.
 */
@Component
public class ShareServiceHystric implements ShareService {

    //private String errorMsg = "sorry, share service call fail.";

    @Override
    public List<Object> shareList() {
        //List<Share> shareList = new ArrayList<Share>();
        return null;
    }

    @Override
    public Object shareFindOne(Integer id) {
        return null;
    }

    @Override
    public Object addShare(String tile, String sharer, String description) {
        return null;
    }

    @Override
    public void deleteShare(Integer id) {

    }

    @Override
    public Object update(Integer id, String tile, String sharer, String description) {
        return null;
    }

    @Override
    public List<Object> findBySharer(String sharer) {
        return null;
    }
}
