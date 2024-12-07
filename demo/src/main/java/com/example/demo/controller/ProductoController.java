package com.example.demo.Controller;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private PersonaRepository personaRepository;

    // Método GET /proyecto/numero
    @GetMapping("/numero")
    public List<Integer> getNumeros() {
        Random random = new Random();
        return IntStream.range(0, 10).map(i -> random.nextInt(100)).boxed().collect(Collectors.toList());
    }

    // Método POST /proyecto/pares
    @PostMapping("/pares")
    public Map<String, List<Integer>> getParesImpares(@RequestBody List<Integer> numeros) {
        List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        List<Integer> impares = numeros.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());

        Map<String, List<Integer>> response = new HashMap<>();
        response.put("pares", pares);
        response.put("impares", impares);
        return response;
    }

    // Método POST /proyecto/validacorreo
    @PostMapping("/validacorreo")
    public String validarCorreo(@RequestBody String correo) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (correo.matches(emailRegex)) {
            return "Correo válido";
        } else {
            return "Correo no válido";
        }
    }

    // Método POST /proyecto/crearArchivo
    @PostMapping("/crearArchivo")
    public String crearArchivo(@RequestBody List<Persona> personas) throws IOException {
        File file = new File("personas.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Persona persona : personas) {
                writer.write(persona.getNombre() + "|" + persona.getApellidoPaterno() + "|" + persona.getApellidoMaterno() + "|" + persona.getEdad());
                writer.newLine();
            }
        }
        return "Archivo creado con éxito";
    }

    // Método POST /proyecto/crearUsuario
    @PostMapping("/crearUsuario")
    public Long crearUsuario(@RequestBody Persona persona) {
        Persona usuarioGuardado = personaRepository.save(persona);
        return usuarioGuardado.getId();
    }
}
