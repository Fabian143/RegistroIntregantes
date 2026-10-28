package model;

public class Intregante {
    private String nombre;
    private String apellido;
    private String repositorio;

    //variables necesarias para seleccionar que un estudiante sea nuevo o antiguo
    private boolean estudianteNuevo;
    private static String[] TipoEstudiante={"Nuevo","Antiguo"};
    private String tipoEstudiante;

    //variables necesesaria para seleccionar el proyecto curricular de un estudiante
    private byte seleccionadorCarrera;
    private static Sring[] proyectoEducativo={"Ingeniería de sistemas","Ingeniería indrustial","Ingeniería electrica","Ingenieria electronica","Ingenieria civil"}
    private String proyectoCurricular;


    public Intregante(String nombre, String apellido,String repositorio,boolean estudianteNuevo,byte seleccionadorCarrera){
        this.nombre = nombre;
        this.apellido = apellido;
        this.repositorio = repositorio;
        setTipoEstudiante(estudianteNuevo);
        setProyectoCurricular(seleccionadorCarrera);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void getTipoEstudiante(){
        return tipoEstudiante;
    }

    public void setTipoEstudiante(boolean esNuevo){
        if(esNuevo){
            this.tipoEstudiante=TipoEstudiante[0];
        }else{
            this.tipoEstudiante=TipoEstudiante[1];
        }

    public void getProyectoCurricular(){
        return proyectoCurricular;
    }

    public void setProyectoCurricular(byte s){
        Switch(s){
            case 1 -> this.proyectoCurricular= proyectoEducativo[0];
            case 2 -> this.proyectoCurricular= proyectoEducativo[1];
            case 3 -> this.proyectoCurricular= proyectoEducativo[2];
            case 4 -> this.proyectoCurricular= proyectoEducativo[3];
            case 5 -> this.proyectoCurricular= proyectoEducativo[4];        
    }
    }

}
