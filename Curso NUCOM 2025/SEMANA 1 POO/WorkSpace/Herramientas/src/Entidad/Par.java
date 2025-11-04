package Entidad;

public class Par {
    private Object clave;
    private Object valor;

    public Par(Object clave, Object valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public Object getClave() {
        return clave;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "[" + clave + "=" + valor + "]";
    }
}
