package br.com.hard.caminhada_springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.hard.caminhada_springmvc.model.CalculadorTempoDeCaminhada;
import br.com.hard.caminhada_springmvc.model.Caminhada;

@Controller
@RequestMapping("/")
public class CaminhadaController {
		
		private CalculadorTempoDeCaminhada calculadorTempoDeCaminhada = new CalculadorTempoDeCaminhada();
		
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String obtemValore(){
			return "/obtemValores";
		}
		
		@RequestMapping(value = "/exibeResultado", method = RequestMethod.GET)
		public String exibeResultado(@RequestParam(value = "distanciaEmKm", required = true) final Float distanciaEmKm, final Model model){
			
			Caminhada caminhada = calculadorTempoDeCaminhada.calcularTempo(distanciaEmKm);
			model.addAttribute("tempoMaximo", caminhada.getTempoMaximo());
			model.addAttribute("tempoMinimo", caminhada.getTempoMinimo());
			
			return "/exibeResultado";
		}
}
