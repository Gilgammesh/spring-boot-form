package com.santandertech.form.webapp.contollers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.santandertech.form.webapp.editors.CiudadPropertyEditor;
import com.santandertech.form.webapp.editors.MayusculaEditor;
import com.santandertech.form.webapp.editors.RolesEditor;
import com.santandertech.form.webapp.models.domain.Ciudad;
import com.santandertech.form.webapp.models.domain.Rol;
import com.santandertech.form.webapp.models.domain.Usuario;
import com.santandertech.form.webapp.services.CiudadService;
import com.santandertech.form.webapp.services.RolService;
import com.santandertech.form.webapp.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidador validador;

	@Autowired
	private CiudadService ciudadService;

	@Autowired
	private RolService rolService;

	@Autowired
	private CiudadPropertyEditor ciudadEditor;

	@Autowired
	private RolesEditor rolesEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// binder.setValidator(validador); // setea el nuevo validator y se reemplaza
		// por el actual
		binder.addValidators(validador); // se añade el validador
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		// binder.registerCustomEditor(Date.class, "fechaNac", new
		// CustomDateEditor(dateFormat, false));

		// binder.registerCustomEditor(String.class, new MayusculaEditor());
		binder.registerCustomEditor(String.class, "nombre", new MayusculaEditor());

		binder.registerCustomEditor(Ciudad.class, "ciudad", ciudadEditor);
		binder.registerCustomEditor(Rol.class, "roles", rolesEditor);

	}

	// Lista simple como arraylist
	@ModelAttribute("ciudades")
	public List<String> ciudades() {
		return Arrays.asList("Tarapoto", "Moyobamba", "Rioja", "Lamas", "Tocache", "Juanjui", "Bellavista");
	}

	// Lista como map
	@ModelAttribute("ciudadesMap")
	public Map<String, String> ciudadesMap() {
		Map<String, String> ciudades = new HashMap<String, String>();
		ciudades.put("ta", "Tarapoto");
		ciudades.put("mo", "Moyobamba");
		ciudades.put("ri", "Rioja");
		ciudades.put("la", "Lamas");
		ciudades.put("to", "Tocache");
		ciudades.put("ju", "Juanjui");
		ciudades.put("be", "Bellavista");
		return ciudades;
	}

	@ModelAttribute("ciudadesModel")
	public List<Ciudad> ciudadesModel() {
		/*
		 * return Arrays.asList( new Ciudad(1, "ta", "Tarapoto"), new Ciudad(2, "mo",
		 * "Moyobamba"), new Ciudad(3, "ri", "Rioja"), new Ciudad(4, "la", "Lamas"), new
		 * Ciudad(5, "to", "Tocache"), new Ciudad(6, "ju", "Juanjui"), new Ciudad(7,
		 * "be", "Bellavista"));
		 */
		return ciudadService.listar();
	}

	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString() {
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}

	@ModelAttribute("listaRolesMap")
	public Map<String, String> listaRolesMap() {
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_MODERATOR", "Moderador");
		return roles;
	}

	@ModelAttribute("listaRoles")
	public List<Rol> listaRoles() {
		return rolService.listar();
	}

	@ModelAttribute("genero")
	public List<String> genero() {
		return Arrays.asList("Hombre", "Mujer");
	}

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Carlos");
		usuario.setApellido("Santander");
		usuario.setIdentificador("UID-1897");
		usuario.setHabilitar(true);
		usuario.setValorSecreto("este es un valor secreto");
		usuario.setCiudad(new Ciudad(2, "mo", "Moyobamba"));
		usuario.setRoles(Arrays.asList(new Rol(2, "ROLE_USER", "Usuario")));
		usuario.setFechaNac(new Date());
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
	public String enviarForm(@Valid Usuario usuario, BindingResult result, Model model) {

		// validador.validate(usuario, result);

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
		
		
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name="usuario", required = false) Usuario usuario, Model model, SessionStatus status) {
		
		if (usuario == null) {
			return "redirect:/form";
		}
		
		model.addAttribute("titulo", "Resultado del Formulario");
		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}

}
