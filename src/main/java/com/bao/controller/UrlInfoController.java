package com.bao.controller;

import com.bao.jpa.UrlInfoJpa;
import com.bao.model.UrlInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public String updateUrlInfo(@PathParam("id") String id , @RequestBody UrlInfo urlInfo){
        urlInfo.setId(Long.parseLong(id));
        urlInfoJpa.save(urlInfo);
        return "success";
    }
}
