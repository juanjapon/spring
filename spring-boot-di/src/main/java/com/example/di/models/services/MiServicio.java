package com.example.di.models.services;

import org.springframework.stereotype.Service;

@Service("miServicioSimple")
public class MiServicio implements IMiServicio{

	@Override
	public String operacion() {
		return "ejecutando algún proceso simple...";
	}
}
