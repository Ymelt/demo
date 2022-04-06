package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Word;
import org.apache.ibatis.annotations.*;

import java.util.List;


//@Mapper //使用mybatisplus后配置放在其他一起
public interface WordMapper extends BaseMapper<Word> {
//    @Select("SELECT * from word")
//    List<Word> findAll();
//
//    @Insert("INSERT INTO word(content) VALUES (#{content})")
//    int insert(Word word);
//
//
//    @Delete("delete from word where user_id = #{id}")
//    Integer deleteById(@Param("id") Integer id);
//
//    @Select("select * from word where content like concat('%',#{keyword},'%') limit #{pageNum},#{pageSize}")
//    List<Word> selectPage(Integer pageNum, Integer pageSize,String keyword);
//
//    @Select("select count(*) from word where content like concat('%',#{keyword},'%')")
//    Integer selectTotal(String keyword);

}
