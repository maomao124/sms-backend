package mao.sms_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import mao.sms_api.service.BlackListService;
import mao.sms_dao.mapper.BlackListMapper;
import mao.sms_entity.entity.BlackListEntity;
import mao.tools_databases.mybatis.conditions.Wraps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service.impl
 * Class(类名): BlackListServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 15:08
 * Version(版本): 1.0
 * Description(描述)： 黑名单
 */

@Slf4j
@Service
public class BlackListServiceImpl extends ServiceImpl<BlackListMapper, BlackListEntity> implements BlackListService
{
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public List<String> listByType(String type)
    {
        ValueOperations<String, List<String>> valueOperations = redisTemplate.opsForValue();
        List<String> phones = valueOperations.get("Black_" + type);
        if (CollectionUtils.isEmpty(phones))
        {
            List<BlackListEntity> blackListEntities = baseMapper.selectList(Wraps.<BlackListEntity>lbQ()
                    .eq(BlackListEntity::getType, type));
            phones = blackListEntities.stream().map(BlackListEntity::getContent).collect(Collectors.toList());
            valueOperations.set("Black_" + type, phones, 60, TimeUnit.SECONDS);
        }
        return phones;
    }
}