package com.example.backend.controlador;

import com.example.backend.entidades.Perfume;
import com.example.backend.servicio.PerfumeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PerfumeControlador {
@Autowired
    private PerfumeServicio servicio;
@GetMapping("/productos")
    public String listarPerfumes(Model modelo){
    modelo.addAttribute("perfumes",servicio.listarTodosLosPerfumes());
    return "pages/Inventario";}
@GetMapping("/")
        public String mostrarInicio(){
    return "pages/login";
}
@GetMapping("/productos/nuevo")
public String mostrarFormulario(Model modelo){
    Perfume perfume=new Perfume();
    modelo.addAttribute("perfume",perfume);
    return "pages/crear_producto";
}
@PostMapping("/productos")
public String guardarProducto(@ModelAttribute("perfume") Perfume perfume){
servicio.guardarPerfume(perfume);
return "redirect:/productos";
}
@GetMapping("/productos/editar/{id}")
public String mostrarProductoEditar(@PathVariable long id, Model modelo){
    modelo.addAttribute("perfume",servicio.obtenerProductoPorId(id));
return "editarProducto";

}
@PostMapping("/productos/{id}")
public String actualizarProducto(@PathVariable long id,@ModelAttribute("perfume") Perfume perfume,Model modelo){
    Perfume perfumeExistente=servicio.obtenerProductoPorId(id);
    perfumeExistente.setId(id);
    perfumeExistente.setNombre(perfume.getNombre());
    perfumeExistente.setCantidad(perfume.getCantidad());
    perfumeExistente.setGenero(perfume.getGenero());
    perfumeExistente.setFragancia(perfume.getFragancia());
servicio.actualizarProducto(perfumeExistente);
    return "redirect:/productos";
}
@GetMapping("productos/{id}")
    public String eliminarProducto(@PathVariable long id){
    servicio.eliminarProducto(id);
    return "redirect:/productos";
}
}

