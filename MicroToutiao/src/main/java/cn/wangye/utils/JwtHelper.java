package cn.wangye.utils;

import com.alibaba.druid.util.StringUtils;
import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@ConfigurationProperties(prefix = "jwt.token")//等同于@Value,会自动装配数据和集合数据
public class JwtHelper {

    private long tokenExpiration; //有效时间,单位毫秒 1000毫秒 == 1秒
    private String tokenSignKey;  //当前程序签名秘钥

    //生成token字符串
    public String createToken(Long userId) {
        String token = Jwts.builder()
                .setSubject("YYGH-USER")
                //token的失效时间，将在未来的某一刻失效，当前时间加上有效时间，并不会向session一样进行数据的刷新
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration * 1000 * 60))
                .claim("userId", userId)
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }


    //从token字符串获取userid
    public Long getUserId(String token) {
        if (StringUtils.isEmpty(token)) return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Integer userId = (Integer) claims.get("userId");
        return userId.longValue();
    }


    //判断token是否有效 过期返回true,没有过期返回false
    public boolean isExpiration(String token) {
        try {
            boolean isExpire = Jwts.parser()
                    .setSigningKey(tokenSignKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration().before(new Date());
            //没有过期，有效，返回false
            return isExpire;
        } catch (Exception e) {
            //过期出现异常，返回true
            return true;
        }
    }
}
