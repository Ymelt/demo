package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.Word;
import com.example.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/word")
public class WordController {

//    @Autowired
//    private WordMapper wordMapper;

    @Autowired
    private WordService wordService;

//    @PostMapping
//    public Integer insert(@RequestBody Word word){
//        return wordMapper.insert(word);
//    }

    @GetMapping
    public List<Word> index(){
        return wordService.list();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return wordService.removeById(id);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Word word){
        return wordService.saveWord(word);
    }


    @GetMapping("/page")
    public IPage<Word> findPage(@RequestParam Integer pageNum,
                                @RequestParam Integer pageSize,
                                @RequestParam(defaultValue = "") String keyword){
        IPage<Word> page = new Page<>(pageNum,pageSize);
        QueryWrapper<Word> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("content",keyword);
        queryWrapper.orderByDesc("user_id");
        return wordService.page(page,queryWrapper);
    }
}
