package com.santandertech.form.webapp.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getMethod().equalsIgnoreCase("post")) {
			return true;
		}
		
		
		if (handler instanceof HandlerMethod) {
			HandlerMethod metodo = (HandlerMethod) handler;
			logger.info("es un método del controlador: " + metodo.getMethod().getName());
		}

		logger.info("TiempoTranscurridoInterceptor: preHandle() entrando ...");

		long tiempoIni = System.currentTimeMillis();
		request.setAttribute("tiempoIni", tiempoIni);

		Random random = new Random();
		Integer delay = random.nextInt(500);
		Thread.sleep(delay);

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		if(request.getMethod().equalsIgnoreCase("post")) {
			return;
		}
		
		long tiempoFin = System.currentTimeMillis();
		long tiempoIni = (long) request.getAttribute("tiempoIni");
		long tiempoTrans = tiempoFin - tiempoIni;

		if (handler instanceof HandlerMethod && modelAndView != null) {
			modelAndView.addObject("tiempoTrans", tiempoTrans);
		}

		logger.info("Tiempo Transcurrido: " + tiempoTrans + " milisegundos");
		logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo ...");

	}

}
