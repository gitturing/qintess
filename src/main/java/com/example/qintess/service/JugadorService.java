package com.example.qintess.service;

import com.example.qintess.model.Jugador;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class JugadorService {


    public List<Jugador> listJugadoresEdad() {
        List<Jugador> jugadors = listJugadores();

        Map<Integer, List<Jugador>> integerJugadorMap = jugadors.stream().collect(
                Collectors.groupingBy(Jugador::getAge,
                        Collectors.toList())
        );
        return procesarJugadores(integerJugadorMap);
    }


    public List<Jugador> listJugadoresOrder() {
        List<Jugador> jugadors = listJugadores();

        Map<Integer, List<Jugador>> integerJugadorMap = jugadors.stream().collect(
                Collectors.groupingBy(Jugador::getAge,
                        Collectors.toList())
        );
        for (Map.Entry<Integer, List<Jugador>> entry : integerJugadorMap.entrySet()) {
            entry.getValue().sort(new Comparator<Jugador>() {
                @Override
                public int compare(Jugador o1, Jugador o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

        }
        return procesarJugadores(integerJugadorMap);
    }


    private List<Jugador> procesarJugadores(Map<Integer, List<Jugador>> integerJugadorMap) {
        Map<Integer, String> result = new HashMap<>();
        for (Map.Entry<Integer, List<Jugador>> entry : integerJugadorMap.entrySet()) {
            for (Jugador jugadorList : entry.getValue()) {
                if (result.containsKey(jugadorList.getAge())) {
                    var name = result.get(jugadorList.getAge());
                    var newName = jugadorList.getName();
                    name = name + " , " + newName;
                    result.put(jugadorList.getAge(), name);
                } else {
                    result.put(jugadorList.getAge(), jugadorList.getName());
                }
            }
        }
        return result.entrySet().stream()
                .map(x -> new Jugador(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
    }


    private List<Jugador> listJugadores() {
        final List<Jugador> nationalTeam = new ArrayList<>();
        nationalTeam.add(new Jugador(37, "Claudio Bravo"));
        nationalTeam.add(new Jugador(36, "Jean Beausejour"));
        nationalTeam.add(new Jugador(34, "Gonzalo Jara"));
        nationalTeam.add(new Jugador(33, "Gary Medel"));
        nationalTeam.add(new Jugador(32, "Mauricio Isla"));
        nationalTeam.add(new Jugador(31, "Charles Aránguiz"));
        nationalTeam.add(new Jugador(33, "Arturo Vidal"));
        nationalTeam.add(new Jugador(34, "Matias Fernandez"));
        nationalTeam.add(new Jugador(36, "Jorge Valdivia"));
        nationalTeam.add(new Jugador(31, "Alexis Sánchez"));
        nationalTeam.add(new Jugador(30, "Eduardo Vargas"));
        return nationalTeam;
    }

}
