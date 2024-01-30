
public class Nino {
	
	private String pizarra;
	
	public Nino() {
		this.pizarra = "";
	}

	public String getPizarra() {
		return pizarra;
	}

	public void setPizarra(String pizarra) {
		this.pizarra = pizarra;
	}
	
	public void limpiarPizarra() {
		this.pizarra = "";
	}

	@Override
	public String toString() {
		return "Nino [pizarra=" + pizarra + "]";
	}
	
	
	

}
