package restaurantes;

public interface ISujeto {
    
    public void registrarObservador(IObservador o);
    public void notificarObservadores();
 
}