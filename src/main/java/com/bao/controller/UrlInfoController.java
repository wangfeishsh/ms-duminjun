package com.bao.controller;

import com.bao.jpa.UrlInfoJpa;
import com.bao.model.UrlInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016/6/28.
 */
@RestController
public class UrlInfoController {
    @Autowired
    private UrlInfoJpa urlInfoJpa;
    @RequestMapping(value = "/urls" , method = RequestMethod.GET)
    public List<UrlInfo> getInfo(){
        List<UrlInfo> urlInfos = new ArrayList<>();
        Iterable<UrlInfo> it = urlInfoJpa.findAll();
        it.forEach(node->urlInfos.add(node));
        return urlInfos;
    }

    @RequestMapping(value = "/urls/{id}" , method = RequestMethod.POST)
    public String updateUrlInfo(@PathVariable("id") String id , @RequestBody UrlInfo urlInfo){
        UrlInfo old = urlInfoJpa.findOne(Long.parseLong(id));
        if(null==old){
            return "not exist";
        }else{
            urlInfo.setId(Long.parseLong(id));
            urlInfoJpa.delete(Long.parseLong(id));
            urlInfoJpa.save(urlInfo);
//            urlInfoJpa.update(urlInfo.getUrl(), urlInfo.getDesc(), Long.parseLong(id));
        }
        return "success";
    }
}
