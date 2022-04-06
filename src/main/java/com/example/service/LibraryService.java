package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Library;
import com.example.mapper.LibraryMapper;
import org.springframework.stereotype.Service;

@Service
public class LibraryService extends ServiceImpl<LibraryMapper,Library> {


    @Override
    public boolean saveOrUpdate(Library library) {
        return super.saveOrUpdate(library);
    }

    //第三次尝试对证验证码
    public Boolean ycode(Library library) {
        QueryWrapper<Library> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("code_value", library.getCodeValue());
        Library two = getOne(queryWrapper2);
        return two!=null;
    }


}
