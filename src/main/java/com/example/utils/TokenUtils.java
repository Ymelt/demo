package com.example.utils;

import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.util.unit.DataUnit;

import java.util.Calendar;
import java.util.Date;

public class TokenUtils {


    public static String getToken(String userId,String sign){
        return JWT.create().withAudience(userId)
                    .withExpiresAt(DateUtil.offsetHour(new Date(),2))
                    .sign(Algorithm.HMAC256(sign));
    }
}
