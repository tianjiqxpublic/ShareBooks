package com.tianjiqx.service;



import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tianjiqx on 2017/6/26.
 */
@FeignClient(value = "sharebooks-shareservice",fallback = ShareServiceHystric.class)
public interface ShareService {

    @GetMapping(value = "/share/shares/")
    public List<Object> shareList();
    @GetMapping(value = "/share/{id}")
    public Object shareFindOne(@PathVariable("id") Integer id);
    @PostMapping(value = "/share/add/")
    public Object addShare(@RequestParam("tile") String tile,
                          @RequestParam("sharer") String sharer,
                          @RequestParam("description")String description);
    @DeleteMapping(value = "/share/delete/{id}")
    public void deleteShare(@PathVariable("id") Integer id);
    @PutMapping(value = "/share/update/{id}/")
    public Object update(@PathVariable("id") Integer id,
                        @RequestParam("tile") String tile,
                        @RequestParam("sharer") String sharer,
                        @RequestParam("description")String description);
    @GetMapping(value = "/share/")
    public List<Object> findBySharer(@RequestParam("sharer") String sharer);

}
