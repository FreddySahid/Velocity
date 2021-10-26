package mx.uv;
public class Usuario {
    String nombre = "";
    String carrera = "";
    String id = "";

    public Usuario(String nombre, String carrera){
        this.setNombre(nombre);
        this.setCarrera(carrera);
        this.setId(id);


    }
    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public String getCarrera() {
        return carrera;
    }
    public String getNombre() {
        return nombre;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
