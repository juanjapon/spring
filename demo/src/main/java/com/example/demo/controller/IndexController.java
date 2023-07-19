package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexController.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexController.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexController.listar.titulo}")
	private String textoListar;
	
	
	@GetMapping(value={"/index","/","/home",""})
	public String index(ModelMap model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	 @RequestMapping("/perfil")
	 public String perfil(Model model) {
		 Usuario usuario=new Usuario();
		 usuario.setNombre("Juan");
		 usuario.setApellido("Mendoza");
		 usuario.setEmail("juanjapon@prueba.com");
		 
		 model.addAttribute("usuario",usuario);
		 model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		 
		 return "perfil";
	 }
	 
	 @RequestMapping("/listar")
	 public String listar(Model model) {

		 model.addAttribute("titulo", textoListar);
		 
		 
		 return "listar";
	 }
	 
	 @ModelAttribute("usuarios")
	 public List<Usuario> poblarUsuarios(){
		 List<Usuario> usuarios=new ArrayList<>();
	     usuarios.add(new Usuario("Juan", "Rodriguez", "rodri12@correo.com"));
	     usuarios.add(new Usuario("Carlos", "Perez", "cperez@prueba.com"));
	     usuarios.add(new Usuario("Gloria", "Velez", "gvelez2001@gvp.com"));
	     
	     return usuarios;
	 }

}
