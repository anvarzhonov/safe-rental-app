package ru.anvarzhonov.service.box;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anvarzhonov.feign.BoxServiceClient;
import ru.anvarzhonov.sbrf.base.BusinessException;
import ru.anvarzhonov.sbrf.base.rest.BaseApiResponse;
import ru.anvarzhonov.sbrf.box.dto.SafeDto;
import ru.anvarzhonov.sbrf.box.dto.SafeStatus;
import ru.anvarzhonov.sbrf.box.request.UpdateStatusRq;
import ru.anvarzhonov.sbrf.box.response.GetSafeInfoByIdResponse;

@Service
@RequiredArgsConstructor

public class BoxServiceImpl implements BoxService {
    private final BoxServiceClient client;

    @Override
    public void executeUpdateSafeStatus(Long safeId, SafeStatus status) {
        BaseApiResponse safeUpdateResponse = client.updateSafeStatus(UpdateStatusRq.builder()
                .safeId(safeId)
                .status(status)
                .build());

        checkStatus(safeUpdateResponse);
    }

    @Override
    public SafeDto executeGetSafeInfoById(Long safeId) {
        GetSafeInfoByIdResponse safeByIdResponse = client.getSafeById(safeId);

        checkStatus(safeByIdResponse);

        return safeByIdResponse.getSafeInfo();
    }

    private <T extends BaseApiResponse> void checkStatus(T response) {
        if (response.getStatus().equals(BaseApiResponse.Status.ERROR)) {
            throw new BusinessException("Произошла ошибка во время создания договора. Ошибка: "
                    + response.getErrMessage());
        }
    }
}
