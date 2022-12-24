package mao.sms_api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import mao.sms_entity.entity.TemplateEntity;

/**
 * Project name(项目名称)：sms-backend
 * Package(包名): mao.sms_api.service
 * Interface(接口名): TemplateService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/12/24
 * Time(创建时间)： 15:06
 * Version(版本): 1.0
 * Description(描述)： 模板
 */

public interface TemplateService extends IService<TemplateEntity>
{
    /**
     * 通过code查询模板
     *
     * @param template 模板
     * @return {@link TemplateEntity}
     */
    TemplateEntity getByCode(String template);
}
