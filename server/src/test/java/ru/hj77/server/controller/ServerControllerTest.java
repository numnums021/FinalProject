package ru.hj77.server.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.hj77.server.dto.ClientDTO;
import ru.hj77.server.service.ServerService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class ServerControllerTest {

    @Mock
    private ServerService service;

    @InjectMocks
    ServerController serverController;

    @Test
    void testShowAllClients() {
        when(service.getAllClients()).thenReturn(new ArrayList<ClientDTO>());

        List<ClientDTO> clientDTOList = serverController.showAllClients();

        verify(service).getAllClients();
    }

    @Test
    void testGetClient() {
        when(service.getClient(anyLong())).thenReturn(null);

        serverController.getClient(1L);

        verify(service).getClient(1L);
    }

    @Test
    void testWithdrawMoneyFromTheCard() {
        when(service.withdrawMoneyFromTheCard(anyLong(), anyLong(), anyDouble()))
                .thenReturn(10.5);

        serverController.withdrawMoneyFromTheCard(1L, 1L, 10);

        verify(service).withdrawMoneyFromTheCard(1L, 1L, 10);
    }

    @Test
    void testDepositMoneyFromTheCard() {
        when(service.depositMoneyFromTheCard(anyLong(), anyLong(), anyDouble()))
                .thenReturn(10.5);

        serverController.depositMoneyFromTheCard(1L, 1L, 10);

        verify(service).depositMoneyFromTheCard(1L, 1L, 10);
    }
}