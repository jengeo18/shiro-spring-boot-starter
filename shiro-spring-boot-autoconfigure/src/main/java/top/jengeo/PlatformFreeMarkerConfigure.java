package top.jengeo;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jajeo on 02/09/2017.
 */
@Component
public class PlatformFreeMarkerConfigure implements InitializingBean {
    @Autowired
    private Configuration configuration;

    @Override
    public void afterPropertiesSet() throws Exception {
        // 配置可以在页面上使用shiro标签
        configuration.setSharedVariable("shiro", new ShiroTags());
    }
}
