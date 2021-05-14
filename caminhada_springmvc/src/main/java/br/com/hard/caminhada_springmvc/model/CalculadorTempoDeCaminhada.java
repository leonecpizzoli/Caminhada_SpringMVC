package br.com.hard.caminhada_springmvc.model;

import java.time.LocalTime;

public class CalculadorTempoDeCaminhada {

	// Velocidade Minima de um Adulto (5km/h)
	private final float MIN_VELOCIDADE_MEDIA_POR_HORA_EM_KM = 5.f;
	// Velocidade Maxima de um Adulto (6.5km/h)
	private final float MAX_VELOCIDADE_MEDIA_POR_HORA_EM_KM = 6.5f;

	public Caminhada calcularTempo(final float distanciaEmKm) {

		float tempoMaximo = distanciaEmKm / MIN_VELOCIDADE_MEDIA_POR_HORA_EM_KM;
		float tempoMinimo = distanciaEmKm / MAX_VELOCIDADE_MEDIA_POR_HORA_EM_KM;

		LocalTime horaMaxima = LocalTime.of((int) tempoMaximo, (int) (60 * (tempoMaximo - ((int) tempoMaximo))));
		LocalTime horaMinima = LocalTime.of((int) tempoMinimo, (int) (60 * (tempoMinimo - ((int) tempoMinimo))));

		Caminhada caminhada = new Caminhada();

		caminhada.setTempoMaximo(horaMaxima);
		caminhada.setTempoMinimo(horaMinima);

		return caminhada;
	}

}
