package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // Agrega el método findByNombre para buscar productos por nombre
    List<Producto> findByNombre(String nombre);

    

}


