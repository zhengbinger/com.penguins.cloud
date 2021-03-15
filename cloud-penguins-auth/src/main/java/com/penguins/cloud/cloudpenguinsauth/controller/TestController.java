package com.penguins.cloud.cloudpenguinsauth.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Properties;

/**
 * @author zhengbing
 * @date 2021/2/23 09:52
 * @email mydreambing@126.com
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Value("${spring.datasource.url}")
    private String url;


    /**
     * 使用nacos的OPEN API 读取配置中心的配置
     *
     * @return
     */
    @GetMapping("getCityCodeListByNacosOpenAPI")
    public String getCityCodeListByNacosOpenAPI() {
//        Map<String, Object> paramMap = new HashMap<>(3);
//        // 租户信息，对应nacos命名空间id字段
//        paramMap.put("tenant", TEST_NAMESPACE);
//        // dataId
//        paramMap.put(Constants.DATAID, "CityCodeList");
//        // group
//        paramMap.put(Constants.GROUP, "DEFAULT_GROUP");
//        // url: http://127.0.0.1:8848/nacos/v1/cs/configs
//        String content = HttpUtil.get(SERVER_ADDR + "/nacos" + Constants.CONFIG_CONTROLLER_PATH, paramMap);
        // 因为我的配置内容是JSON数组字符串，这里将字符串转为JSON数组
        return null;
    }

    /**
     * 使用NacosFactory从nacos配置中心获取配置信息
     *
     * @return String
     */
    @SneakyThrows
    @GetMapping("getConfig")
    public String getCityCodeListByNacosFactory() throws Exception {
        Properties properties = new Properties();
        // nacos服务器地址，127.0.0.1:8848
        properties.put(PropertyKeyConst.SERVER_ADDR, "localhost:8848");
        // 配置中心的命名空间id
        properties.put(PropertyKeyConst.NAMESPACE, "dev");
        ConfigService configService = NacosFactory.createConfigService(properties);
        // 根据dataId、group定位到具体配置文件，获取其内容. 方法中的三个参数分别是: dataId, group, 超时时间
        String content = configService.getConfig("iap-system-provider.yml", "iap", 3000L);
        // 因为我的配置内容是JSON数组字符串，这里将字符串转为JSON数组
        Map<String, Object> map = YamlUtils.yamlHandler(content);
        System.out.println(map);
        return content;

    }

    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("auth")
    public String test() {
        return url;
    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @GetMapping("pass/{password}")
//    public String test2(String password) {
//        return new BCryptPasswordEncoder().encode(123456 + "");
//    }

}
