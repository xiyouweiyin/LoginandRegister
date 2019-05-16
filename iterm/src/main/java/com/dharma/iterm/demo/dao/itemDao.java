package com.dharma.iterm.demo.dao;

import com.dharma.iterm.demo.entity.item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface itemDao extends JpaRepository<item,String> {

    item getItemById(Integer id);

    void deleteById(Integer id);
}
