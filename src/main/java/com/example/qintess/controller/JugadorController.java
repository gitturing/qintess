package com.example.qintess.controller;

import com.example.qintess.model.Jugador;
import com.example.qintess.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @GetMapping(value = "/listAge", produces = {"application/json"})
    public ResponseEntity<List<Jugador>> listJugadores() {
        var list = jugadorService.listJugadoresEdad();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping(value = "/listOrder", produces = {"application/json"})
    public ResponseEntity<List<Jugador>> listJugadoresOrden() {
        var list = jugadorService.listJugadoresOrder();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
