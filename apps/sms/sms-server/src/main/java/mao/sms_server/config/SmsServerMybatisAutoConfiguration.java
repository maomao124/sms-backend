package mao.sms_server.config;

import lombok.extern.slf4j.Slf4j;
import mao.tools_databases.datasource.BaseMybatisConfiguration;
import mao.tools_databases.properties.DatabaseProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_server.config
 * Class(类名): SmsServerMybatisAutoConfiguration
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/28
 * Time(创建时间)： 19:20
 * Version(版本): 1.0
 * Description(描述)： 无
 */

@Slf4j
@Configuration
public class SmsServerMybatisAutoConfiguration extends BaseMybatisConfiguration
{

    public SmsServerMybatisAutoConfiguration(DatabaseProperties databaseProperties)
    {
        super(databaseProperties);
    }

    @PostConstruct
    public void init()
    {
        log.info("初始化 SmsServerMybatisAutoConfiguration mybatis 配置");
    }
}
