package ru.anvarzhonov.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.anvarzhonov.sbrf.base.rest.BaseApiResponse;
import ru.anvarzhonov.sbrf.box.request.UpdateStatusRq;
import ru.anvarzhonov.sbrf.box.response.GetSafeInfoByIdResponse;

@FeignClient(name= "box-service", path = "/box", url = "${services.box-service.url}")
public interface BoxServiceClient {
    @PostMapping("/updateStatus")
    BaseApiResponse updateSafeStatus(@RequestBody UpdateStatusRq request);

    @GetMapping("/{safeId}")
    GetSafeInfoByIdResponse getSafeById(@PathVariable Long safeId);
}
