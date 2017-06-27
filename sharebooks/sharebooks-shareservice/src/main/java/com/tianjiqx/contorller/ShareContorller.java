package com.tianjiqx.contorller;

import com.tianjiqx.dao.ShareRepo;
import com.tianjiqx.model.Share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tianjiqx on 2017/6/25.
 */
@RestController
public class ShareContorller {
    @Autowired
    private ShareRepo shareRepo;

    //查找所有的分享的书单
    @GetMapping(value = "/share/shares/")
    public List<Share> shareList(){
        return shareRepo.findAll();
    }

    //查找某一本书单
    @GetMapping(value = "/share/{id}")
    public Share shareFindOne(@PathVariable("id") Integer id){
        return shareRepo.findOne(id);
    }
    //新增一个书单
    @PostMapping(value = "/share/add/")
    public Share addShare(@RequestParam("tile") String tile,
                          @RequestParam("sharer") String sharer,
                          @RequestParam("description")String description){

        Share share = new Share(tile,sharer,description);
        return shareRepo.save(share);
    }
    //删除
    @DeleteMapping(value = "/share/delete/{id}")
    public void deleteShare(@PathVariable("id") Integer id)
    {
        shareRepo.delete(id);
    }

    //更新
    @PutMapping(value = "/share/update/{id}/")
    public Share update(@PathVariable("id") Integer id,
                       @RequestParam("tile") String tile,
                       @RequestParam("sharer") String sharer,
                       @RequestParam("description")String description){

        Share share = new Share(tile,sharer,description);
        share.setId(id);
        return shareRepo.save(share);
    }

    //按分享者查找
    @GetMapping(value = "/share/")
    public List<Share> findBySharer(@RequestParam("sharer") String sharer)
    {
        return  shareRepo.findBySharer(sharer);
    }

}

