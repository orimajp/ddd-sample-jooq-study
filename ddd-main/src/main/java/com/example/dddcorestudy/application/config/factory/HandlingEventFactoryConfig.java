package com.example.dddcorestudy.application.config.factory;

import com.example.dddcorestudy.domain.model.cargo.CargoRepository;
import com.example.dddcorestudy.domain.model.handling.HandlingEventFactory;
import com.example.dddcorestudy.domain.model.location.LocationRepository;
import com.example.dddcorestudy.domain.model.voyage.VoyageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HandlingEventFactoryConfig {

    private final CargoRepository cargoRepository;
    private final VoyageRepository voyageRepository;
    private final LocationRepository locationRepository;

    @Bean
    public HandlingEventFactory handlingHistory() {
        return new HandlingEventFactory(cargoRepository, voyageRepository, locationRepository);
    }

}
