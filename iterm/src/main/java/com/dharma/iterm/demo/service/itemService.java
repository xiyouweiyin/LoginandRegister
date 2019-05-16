package com.dharma.iterm.demo.service;

import com.dharma.iterm.demo.dao.itemDao;
import com.dharma.iterm.demo.entity.item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class itemService {
    @Autowired
    private itemDao itemDao;
    public List<item> getAllItem() {
        return itemDao.findAll();
    }

    public item getItemById(Integer id) {
        return itemDao.getItemById(id);
    }


//    public void addItem(String item_name, Integer count, String comment, String name) {
//        item item=new item(item_name,count,comment,name);
//        itemDao.save(item);
//    }

    public void addItem(List<item> items) {
        itemDao.saveAll(items);
    }

    @Transactional
    public void deleteById(Integer id) {
        itemDao.deleteById(id);
    }

    public void updateById(item item) {
        itemDao.save(item);
    }
}
