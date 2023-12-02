package compras;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;



class TestCarrito {

	@Test
	void testCostoFinalDescuentoFijo() {
		 Producto producto1 = new Producto("café", "345",2000);
	     Producto producto2 = new Producto("azúcar", "3445",2000);
		 Producto producto3 = new Producto("pimienta", "456",200);
		 Carrito miCarrito = new Carrito(producto1, producto2, producto3, LocalDateTime.parse("2023-01-13T11:12:00"));
		 Descuento desFijo = new DescuentoFijo(2000);
		 
		 float valorFinal= miCarrito.costoFinal(desFijo);
		 assertEquals(valorFinal, 4000);
	}
	
	

	@Test
	void testCostoFinalDescuentoPorcentaje() {
		 Producto producto1 = new Producto("café", "345",4000);
	     Producto producto2 = new Producto("azúcar", "3445",4000);
		 Producto producto3 = new Producto("pimienta", "456",200);
		 Carrito miCarrito = new Carrito(producto1, producto2, producto3, LocalDateTime.parse("2023-01-13T11:12:00"));
		 Descuento desfijo = new DescuentoPorcentaje(0.50F);
	   
		 float valorFinal= miCarrito.costoFinal(desfijo);
		 assertEquals(valorFinal, 5000);
	}
	@Test
	void testCostoFinalDescuentoPorcentajeConTope() {
		 Producto producto1 = new Producto("café", "345",4000);
	     Producto producto2 = new Producto("azúcar", "3445",4000);
		 Producto producto3 = new Producto("pimienta", "456",200);
		 Carrito miCarrito = new Carrito(producto1, producto2, producto3, LocalDateTime.parse("2023-01-13T11:12:00"));
		 Descuento desPorcentaje = new DescPorcentajeConTope(0.50F);
		 desPorcentaje.setValorDesc(0.20F);
		 
		 float valorFinal= miCarrito.costoFinal(desPorcentaje);
		 assertEquals(valorFinal, 8000);

	}
}
