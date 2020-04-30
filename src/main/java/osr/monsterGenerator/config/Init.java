package osr.monsterGenerator.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class Init implements InitializingBean {

    Logger logger = LoggerFactory.getLogger(InitializingBean.class);

    @Override
    public void afterPropertiesSet()  {

    }
}