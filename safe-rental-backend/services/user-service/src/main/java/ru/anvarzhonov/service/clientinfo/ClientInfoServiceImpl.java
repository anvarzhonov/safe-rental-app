package ru.anvarzhonov.service.clientinfo;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.anvarzhonov.entity.client.Client;
import ru.anvarzhonov.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientInfoServiceImpl implements ClientInfoService {
    private final ClientRepository repository;

    @Override
    public Client getClientInfo(Long clientId) {
        Client client = repository.findById(clientId).orElseThrow(() ->
                new NotFoundException("Клиент с заданным id - " + clientId + " не найден"));

        return client;
    }

    @Override
    public Client saveOrUpdateClientInfo() {
        return null;
    }
}
