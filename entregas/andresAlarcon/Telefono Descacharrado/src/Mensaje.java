public class Mensaje {
  private String texto;

  public Mensaje(String texto) {
    this.texto = texto;
  }

  public String getMensaje() {
    return texto;
  }

  public void setMensaje(String texto) {
    this.texto = texto;
  }

  public void limpiar() {
    this.texto = "";
  }
}