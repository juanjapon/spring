package com.juanjapon.form.app.controllers;



import org.springframework.beans.factory.annotation.Autowired;

//import java.util.HashMap;
//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.juanjapon.form.app.domain.Usuario;
import com.juanjapon.form.app.validations.UsuarioValidator;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("user")
public class FormController {

	@Autowired
	private UsuarioValidator validador;
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario=new Usuario();
		usuario.setNombre("John");
		usuario.setApellido("Doe");
		usuario.setIdentificador("123.456.789-K");
		model.addAttribute("titulo", "Formulario");
		model.addAttribute("user", usuario);
		return "form";
	}
	
	@PostMapping("/form")
	public String procesarFormulario(@Valid @ModelAttribute("user") Usuario usuario,BindingResult result,Model model, SessionStatus status) {

		validador.validate(usuario, result);
		model.addAttribute("titulo", "Resultado Form");
		if(result.hasErrors()) {
			/**Map<String,String> errores =new HashMap<>();
			result.getFieldErrors().forEach(err ->{
				errores.put(err.getField(),"El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
			});
			model.addAttribute("error", errores);**/
			
			return "form";
		}
		
		model.addAttribute("usuario",usuario);
		
		status.setComplete();
		
		return "resultado";
	}
}
