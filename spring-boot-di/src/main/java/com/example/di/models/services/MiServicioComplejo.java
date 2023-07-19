package com.example.di.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("miServicioComplejo")
@Primary
public class MiServicioComplejo implements IMiServicio{

	@Override
	public String operacion() {
		return "ejecutando algún proceso complejo...";
	}
}
