package entidades;

import java.util.Date;

public class Evento {
  private TipoEvento tipo;
  private Date data;

  public Evento(TipoEvento tipo, Date data) {
    this.tipo = tipo;
    this.data = data;
  }

  public Date getData() {
    return data;
  }

  public TipoEvento getTipo() {
    return tipo;
  }
}
