package com.tianjiqx.controller;


import com.tianjiqx.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tianjiqx on 2017/6/26.
 */
@RestController
public class FeginController {

    @Autowired
    private ShareService shareService;

    @GetMapping(value = "/share/shares/")
    public List<Object> shareList()
    {
        return shareService.shareList();
    }
    @GetMapping(value = "/share/{id}")
    public Object shareFindOne(@PathVariable("id") Integer id){
        return shareService.shareFindOne(id);
    }
    @PostMapping(value = "/share/add/")
    public Object addShare(@RequestParam("tile") String tile,
                          @RequestParam("sharer") String sharer,
                          @RequestParam("description")String description){
        return shareService.addShare(tile,sharer,description);
    }
    @DeleteMapping(value = "/share/delete/{id}")
    public void deleteShare(@PathVariable("id") Integer id){
        shareService.deleteShare(id);
    }
    @PutMapping(value = "/share/update/{id}/")
    public Object updateShare(@PathVariable("id") Integer id,
                        @RequestParam("tile") String tile,
                        @RequestParam("sharer") String sharer,
                        @RequestParam("description")String description){
        return shareService.update(id,tile,sharer,description);
    }
    @GetMapping(value = "/share/")
    public List<Object> findBySharer(@RequestParam("sharer") String sharer){
        return shareService.findBySharer(sharer);
    }

    @GetMapping(value ="/hi")
    public String hi()
    {
        return "hi test";
    }
}
