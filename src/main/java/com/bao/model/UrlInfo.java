package com.bao.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by asus on 2016/6/28.
 */
@Data
@Entity
@Table(name = "urlInfo")
public class UrlInfo {
    @Id
    private Long id;
    private String url;
    private String desc;
}
