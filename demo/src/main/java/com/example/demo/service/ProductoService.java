package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Producto;
import com.example.demo.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Método para guardar un producto
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Método para obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Método para obtener un producto por su id
    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    // Método para eliminar un producto por su id
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    // Método para actualizar un producto por su id

    public Producto actualizarProducto(Long id, Producto producto) {
        // Primero, buscamos el producto por su ID
        Optional<Producto> productoExistente = productoRepository.findById(id);

        if (productoExistente.isPresent()) {
            // Si el producto existe, obtenemos el producto actual
            Producto productoActualizado = productoExistente.get();

            // Actualizamos los campos del producto
            productoActualizado.setNombre(producto.getNombre());
            productoActualizado.setPrecio(producto.getPrecio());
            productoActualizado.setExistencia(producto.getExistencia());
            productoActualizado.setDescripcion(producto.getDescripcion());
            productoActualizado.setNombreprov(producto.getNombreprov());

            // Guardamos el producto actualizado en la base de datos
            return productoRepository.save(productoActualizado);
        } else {
            // Si el producto no se encuentra, lanzamos una excepción o lo manejamos de otra forma
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
    }

    // Método para buscar productos por nombre
    public List<Producto> findProductosByNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }
}
