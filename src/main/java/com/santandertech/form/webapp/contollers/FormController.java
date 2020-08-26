package com.santandertech.form.webapp.contollers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.santandertech.form.webapp.models.domain.Usuario;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Carlos");
		usuario.setApellido("Santander");
		usuario.setIdentificador("UID-1897");
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("usuario", usuario);
		return "formulario";
	}

	/*
	 * Primer método
	 * 
	 * @PostMapping("/form") public String enviarForm(Model
	 * model, @RequestParam(name = "username") String username,
	 * 
	 * @RequestParam String password, @RequestParam String email) {
	 * 
	 * Usuario usuario = new Usuario(); usuario.setUsername(username);
	 * usuario.setPassword(password); usuario.setEmail(email);
	 * 
	 * model.addAttribute("titulo", "Resultado del Formulario"); //
	 * model.addAttribute("username", username); // model.addAttribute("password",
	 * password); // model.addAttribute("email", email);
	 * model.addAttribute("usuario", usuario);
	 * 
	 * return "resultado"; }
	 */

	// Método mas limpio de código
	@PostMapping("/form")
	public String enviarForm(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario usuarios");
			/*
			 * Map<String, String> errores = new HashMap<>();
			 * result.getFieldErrors().stream().forEach(error -> {
			 * errores.put(error.getField(),
			 * "El campo ".concat(error.getField()).concat(" ").concat(error.
			 * getDefaultMessage())); }); model.addAttribute("error", errores);
			 */
			return "formulario";
		}
		model.addAttribute("titulo", "Resultado del Formulario");
		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}

}
