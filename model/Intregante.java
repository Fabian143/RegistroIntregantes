package model;

/** Entidad que permite conocer y modificar la información de un intregante */
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
    private static String[] proyectoEducativo={"Ingeniería de sistemas","Ingeniería indrustial","Ingeniería electrica","Ingenieria electronica","Ingenieria civil"};
    private String proyectoCurricular;

    /** Constructor con las variables principlaes y algo que selecciona de los arreglos fijos */
    public Intregante(String nombre, String apellido,String repositorio,boolean estudianteNuevo,byte seleccionadorCarrera){
        this.nombre = nombre;
        this.apellido = apellido;
        this.repositorio = repositorio;
        setTipoEstudiante(estudianteNuevo);
        setProyectoCurricular(seleccionadorCarrera);
    }

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

    public String getTipoEstudiante(){
        return tipoEstudiante;
    }
    
    /**Le asigna un valor al tipo de estudiante salido del arreglo fijo apartir de un booleano */
    public void setTipoEstudiante(boolean esNuevo){
        if(esNuevo){
            this.tipoEstudiante=TipoEstudiante[0];
        }else{
            this.tipoEstudiante=TipoEstudiante[1];
        }
    }

    public String getProyectoCurricular(){
        return proyectoCurricular;
    }
    /**Se le asigna un valor al proyecto curricular apartir del arreglo fijo*/
    public void setProyectoCurricular(byte s){
        switch(s){
            case 1 -> this.proyectoCurricular= proyectoEducativo[0];
            case 2 -> this.proyectoCurricular= proyectoEducativo[1];
            case 3 -> this.proyectoCurricular= proyectoEducativo[2];
            case 4 -> this.proyectoCurricular= proyectoEducativo[3];
            case 5 -> this.proyectoCurricular= proyectoEducativo[4];        
           
    }
    }

	public byte getSeleccionadorCarrera() {
		return seleccionadorCarrera;
	}

	public void setSeleccionadorCarrera(byte seleccionadorCarrera) {
		this.seleccionadorCarrera = seleccionadorCarrera;
	}

	public String getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(String repositorio) {
		this.repositorio = repositorio;
	}

	public boolean isEstudianteNuevo() {
		return estudianteNuevo;
	}

	public void setEstudianteNuevo(boolean estudianteNuevo) {
		this.estudianteNuevo = estudianteNuevo;
	}
    

}
