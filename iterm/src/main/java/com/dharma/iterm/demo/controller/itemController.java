package com.dharma.iterm.demo.controller;

import com.dharma.iterm.demo.entity.item;
import com.dharma.iterm.demo.service.itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class itemController {
    @Autowired
    private itemService itemService;

    //采用缓存查看所有数据
    @Cacheable(value ="items")
    @GetMapping(value = "/all")
    public List<item> getAllItem(){
        return itemService.getAllItem();
    }

    //使用缓存，根据ID查询数据
    @Cacheable(value = "itemById",key = "#id",unless = "#result.id>2")
    @GetMapping(value = "/itemById/{id}")
    public item getItemById(@PathVariable Integer id){
        if (id>3){
            item item=new item("null",0,"输入有误，没有该项目","null");
            return item;
        }

        return itemService.getItemById(id);
    }

    //使用方法体，将数据插入数据库(json格式)
    @RequestMapping(value = "/add",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
    public void add(@RequestBody List<item> items ){
        itemService.addItem(items);
    }

    //使用缓存，根据ID删除数据
    @CacheEvict(value = "delete",key = "#id")
    @DeleteMapping(value = "deleteById/{id}")
    public void deleteById(@PathVariable Integer id){
        itemService.deleteById(id);
    }

    //使用缓存更新数据
    @CachePut(value = "update",key = "#item.id")
    @PutMapping(value = "/update/{id}")
    public String updateById(@RequestBody item item){
        itemService.updateById(item);
        return "Update Successful";
    }

}
