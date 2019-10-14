package com.example.dddcorestudy;

import com.github.rozidan.springboot.modelmapper.ConfigurationConfigurer;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfiguration extends ConfigurationConfigurer {

    @Override
    public void configure(Configuration configuration) {
        configuration.setMatchingStrategy(MatchingStrategies.STRICT);
    }

}
