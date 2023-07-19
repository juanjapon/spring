package com.example.di;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.di.models.domain.Producto;
import com.example.di.models.domain.ItemFactura;

@Configuration
public class AppConfig {

	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		Producto producto1= new Producto("Camara Sony",100);
		Producto producto2= new Producto("Kindle paperwhite",139);
		
		ItemFactura lines1=new ItemFactura(producto1,2);
		ItemFactura lines2=new ItemFactura(producto2,4);
		
		return Arrays.asList(lines1,lines2);
	}
	
	@Bean("itemsFacturaOficina")
	public List<ItemFactura> registrarItemsOficina(){
		Producto producto1= new Producto("Monitor LG LCD 24",250);
		Producto producto2= new Producto("notebook Asus",500);
		Producto producto3= new Producto("Impresora HP multifuncional",80);
		Producto producto4= new Producto("Escritorio oficina",300);
		
		ItemFactura lines1=new ItemFactura(producto1,2);
		ItemFactura lines2=new ItemFactura(producto2,2);
		ItemFactura lines3=new ItemFactura(producto3,1);
		ItemFactura lines4=new ItemFactura(producto4,1);
		
		return Arrays.asList(lines1,lines2,lines3,lines4);
	}
}
