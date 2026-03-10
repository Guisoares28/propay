package com.example.paypro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.paypro.dtos.UsuarioRequestDto;
import com.example.paypro.services.UsuarioService;

import jakarta.validation.Valid;



@Controller
public class UsuarioController {
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/usuario/form")
	public String formularioCadastroUsuario(Model model) {
		model.addAttribute("usuario", new UsuarioRequestDto());
		return "cadastro-usuario";
	}
	
	@PostMapping("/usuario")
	public String cadastrarUsuario(@Valid @ModelAttribute("usuario") UsuarioRequestDto dto,
			BindingResult result, RedirectAttributes redirectAttributes) {
			
		if(result.hasErrors()) {
			return "cadastro-usuario";
		}
		
		usuarioService.cadastrarUsuario(dto);
		
		redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso");
		
		return "redirect:/login-form";
	}
}
