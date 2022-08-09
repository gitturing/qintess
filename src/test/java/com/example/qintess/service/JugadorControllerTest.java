package com.example.qintess.service;

import com.example.qintess.controller.JugadorController;
import com.example.qintess.model.Jugador;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JugadorController.class)
public class JugadorControllerTest {

    @MockBean
    private JugadorService jugadorService;

    @Autowired
    @InjectMocks
    private JugadorController JugadorController;

    @Test
    public void listJugadoresOkTest(){

        var jugador= Jugador.builder().age(30).name("andres").build();
        List<Jugador> list = Arrays.asList(jugador);
        Mockito.when(jugadorService.listJugadoresEdad()).thenReturn(list);
        var resul = JugadorController.listJugadores();
        Assert.assertNotNull(resul);
    }

}
