package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.example.config.Result;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class UserService extends ServiceImpl<UserMapper,User> implements IUserService{

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String from;

    public boolean saveUser(User user){

//        if(user.getUserId() == null){
//            return save(user);
//        }else{
//            return updateById(user);
//        }
        return saveOrUpdate(user);
    }

    @Override
    public Result login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name",user.getUserName());
        queryWrapper.eq("user_password",user.getUserPassword());
        User one = getOne(queryWrapper);

        if(one!=null){
            //String token = UUID.randomUUID().toString();
            //String token = String.valueOf(random(10));
            //存到redis，并设置30分钟过期时间
//            RedisUtils.INSTANCE.set(token, JSON.toJSONString(user),60*30 );
            //设置token
            String token = TokenUtils.getToken(one.getUserId().toString(),one.getUserPassword());

            return new Result(true,token,user);
//
        }else{
            return new Result(false,user);
        }
//        return new Result(true,user);


//        String token = UUID.randomUUID().toString();
//
//        //存到redis，并设置30分钟过期时间
//        RedisUtils.INSTANCE.set(token, JSON.toJSONString(user),60*30 );
//
////            Map<String, Object> map = new HashMap<>();
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("uToken", token);
//        map.put("tokenUser", user);
//        return new AjaxResult(true,map);
    }

    //尝试加入验证码
    //public boolean withCode(User user, HttpSession session){
//        try {
//            SimpleMailMessage mailMessage = new SimpleMailMessage();
//
//            mailMessage.setSubject("验证码邮件");
//
//            String code = randomCode();
//            //将随机数放置到session中
//            session.setAttribute("email",email);
//            session.setAttribute("code",code);
//
//            mailMessage.setText("您收到的验证码是："+code);//内容
//
//            mailMessage.setTo(email);//发给谁
//
//            mailMessage.setFrom(from);//你自己的邮箱
//
//            mailSender.send(mailMessage);//发送
//            return  true;
//        } catch (MailException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

//}
          //第二次尝试对照验证码
//     public Boolean ycode(Library library) {
//         QueryWrapper<Library> queryWrapper2 = new QueryWrapper<>();
//         queryWrapper2.eq("code_value", library.getCodeValue());
//         Library two = getOne(queryWrapper2);
//         return
//     }




//    public AjaxResult sendMess(User user){
//        UserService us = new UserService();
//        HashMap<String, Object> map = new HashMap<>();
//        if(us.login(user)){
//            String token = UUID.randomUUID().toString();
//
//            //存到redis，并设置30分钟过期时间
//            RedisUtils.INSTANCE.set(token, JSON.toJSONString(user),60*30 );
//
////            Map<String, Object> map = new HashMap<>();
//            map.put("uToken", token);
//            map.put("tokenUser", user);
//            return new AjaxResult(true,map);
//        }else{
//            return new AjaxResult(false,map);
//        }
//    }
//
//    public boolean trytext(User user){
//        UserService us = new UserService();
//        return us.login(user);
//    }

    //    @Autowired
//    private UserMapper userMapper;
//
//    public int save(User user){
//        if(user.getUserName() == null){
//            return userMapper.insert(user);
//        }else{
//            return userMapper.update(user);
//        }
//    }
}
