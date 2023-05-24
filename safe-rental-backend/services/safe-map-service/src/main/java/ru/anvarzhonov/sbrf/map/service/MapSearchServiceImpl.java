package ru.anvarzhonov.sbrf.map.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.anvarzhonov.sbrf.box.request.GetSafesForOfficesRq;
import ru.anvarzhonov.sbrf.box.response.GetSafesForOfficesResponse;
import ru.anvarzhonov.sbrf.map.dto.OfficeDto;
import ru.anvarzhonov.sbrf.map.entities.OfficeBranch;
import ru.anvarzhonov.sbrf.map.mapper.OfficeBranchMapper;
import ru.anvarzhonov.sbrf.map.repository.OfficeBranchRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MapSearchServiceImpl implements MapSearchService {
    @Value("${box-service.url}")
    public String BOX_PATH;
    private final OfficeBranchRepository repository;
    private final OfficeBranchMapper mapper;

    @Override
    @Cacheable(value = "offices-with-free-safes")
    public List<OfficeDto> findAvailableSafes() {

        List<OfficeBranch> officeBranches = repository.findAll();
        List<OfficeDto> officeDtos = mapper.officeEntitiesToOfficeDtos(officeBranches);

        var restTemplate = new RestTemplate();

        officeDtos.forEach(office -> {
                    var request = GetSafesForOfficesRq.builder()
                            .officeId(office.getId())
                            .build();
                    var response = restTemplate.postForObject(BOX_PATH + "/box/getSafesForOffices",
                            request,
                            GetSafesForOfficesResponse.class);

                    office.setSafes(response.getData().getSafes());
                });

        return officeDtos;
    }
}