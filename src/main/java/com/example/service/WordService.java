package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Word;
import com.example.mapper.WordMapper;
import org.springframework.stereotype.Service;

@Service
public class WordService extends ServiceImpl<WordMapper, Word> {
    public boolean saveWord(Word word){
        return saveOrUpdate(word);
    }
}
