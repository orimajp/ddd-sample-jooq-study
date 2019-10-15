package com.example.dddcorestudy.application.facade.booking.internal.assembler;

import com.example.dddcorestudy.application.facade.booking.dto.LegDTO;
import com.example.dddcorestudy.application.facade.booking.dto.RouteCandidateDTO;
import com.example.dddcorestudy.domain.model.cargo.Itinerary;
import com.example.dddcorestudy.domain.model.cargo.Leg;
import com.example.dddcorestudy.domain.model.location.Location;
import com.example.dddcorestudy.domain.model.location.LocationRepository;
import com.example.dddcorestudy.domain.model.location.UnLocode;
import com.example.dddcorestudy.domain.model.voyage.Voyage;
import com.example.dddcorestudy.domain.model.voyage.VoyageNumber;
import com.example.dddcorestudy.domain.model.voyage.VoyageRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItineraryCandidateDTOAssembler {

    /**
     * @param itinerary itinerary
     * @return A route candidate DTO
     */
    public RouteCandidateDTO toDTO(final Itinerary itinerary) {
        final List<LegDTO> legDTOS = itinerary.legs().stream()
                .map(this::toLegDTO)
                .collect(Collectors.toList());
        return new RouteCandidateDTO(legDTOS);
    }

    /**
     * @param leg leg
     * @return A leg DTO
     */
    protected LegDTO toLegDTO(final Leg leg) {
        final VoyageNumber voyageNumber = leg.voyage().voyageNumber();
        final UnLocode from = leg.loadLocation().unLocode();
        final UnLocode to = leg.unloadLocation().unLocode();
        return new LegDTO(voyageNumber.idString(), from.idString(), to.idString(), leg.loadTime(), leg.unloadTime());
    }

    /**
     * @param routeCandidateDTO route candidate DTO
     * @param voyageRepository voyage repository
     * @param locationRepository location repository
     * @return An itinerary
     */
    public Itinerary fromDTO(final RouteCandidateDTO routeCandidateDTO,
                             final VoyageRepository voyageRepository,
                             final LocationRepository locationRepository) {
        final List<Leg> legs = routeCandidateDTO.getLegs().stream()
                .map(legDTO -> {
                    final VoyageNumber voyageNumber = new VoyageNumber(legDTO.getVoyageNumber());
                    final Voyage voyage = voyageRepository.find(voyageNumber);
                    final Location from = locationRepository.find(new UnLocode(legDTO.getFrom())).orElseThrow(() -> new RuntimeException("元ロケーションがnullです。"));
                    final Location to = locationRepository.find(new UnLocode(legDTO.getTo())).orElseThrow(() -> new RuntimeException("先ロケーションがnullです。"));
                    return new Leg(voyage, from, to, legDTO.getLoadTime(), legDTO.getUnloadTime());})
                .collect(Collectors.toList());
        return new Itinerary(legs);
    }

}
