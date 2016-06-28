package com.bao.controller;

import com.bao.mapper.UrlInfoMapper;
import com.bao.model.UrlInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by asus on 2016/6/28.
 */
@RestController
public class UrlInfoController {
    @Autowired
    private UrlInfoMapper mapper;

    @RequestMapping(value = "/urls" , method = RequestMethod.GET)
    public List<UrlInfo> getInfo(){
        return mapper.selectAll();
    }

    @RequestMapping(value = "/urls/{id}" , method = RequestMethod.POST)
    public String updateUrlInfo(@PathVariable("id") String id , @RequestBody UrlInfo urlInfo){
        UrlInfo old =  mapper.findById(Long.parseLong(id));
        if(null==old){
            return "not exist";
        }else{
            urlInfo.setId(Long.parseLong(id));
            mapper.update(urlInfo);
        }
        return "success";
    }
}
