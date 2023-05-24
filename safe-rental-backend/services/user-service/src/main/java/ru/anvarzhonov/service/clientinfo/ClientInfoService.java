package ru.anvarzhonov.service.clientinfo;

import ru.anvarzhonov.entity.client.Client;

public interface ClientInfoService {

    Client getClientInfo(Long clientId);

    Client saveOrUpdateClientInfo();
}
