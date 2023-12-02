package compras;

public class DescPorcentajeConTope extends DescuentoPorcentaje{
	
	private float tope;
	
	public DescPorcentajeConTope(float tope) {
		super(0);
		this.tope = tope;
		}

	public float getTope() {
		return this.tope;
	}
	
	public void setTope(float nuevoValor) {
		this.tope = nuevoValor;
	}
	
	@Override
	public void setValorDesc(float valor) {
		if(valor>this.tope) {
			super.setValorDesc(0);
			System.out.println("No se puede poner el valor porque superó el tope");
		}
		else {
			super.setValorDesc(valor);
		}
	}
}
