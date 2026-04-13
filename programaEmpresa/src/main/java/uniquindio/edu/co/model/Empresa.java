package uniquindio.edu.co.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombreEmpresa;
    private List<Empleado> empleados;
    private LocalTime horaIngresoEmpresa;

    public Empresa() {
    }

    public Empresa(String nombreEmpresa, LocalTime horaIngresoEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
        this.empleados = new ArrayList<>();
        this.horaIngresoEmpresa = horaIngresoEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public LocalTime getHoraIngresoEmpresa() {
        return horaIngresoEmpresa;
    }

    public void setHoraIngresoEmpresa(LocalTime horaIngresoEmpresa) {
        this.horaIngresoEmpresa = horaIngresoEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombreEmpresa='" + nombreEmpresa + '\'' +
                ", empleados=" + empleados +
                ", horaIngresoEmpresa=" + horaIngresoEmpresa +
                '}';
    }

    public String registrarEmpleado(String nombre, String cedula, LocalTime horaEntrada, LocalTime horaSalida, LocalTime horaEntradaEmpleado) {
        String mensaje = "";
        Empleado encontrado = buscarEmpleado(cedula);
        if (encontrado != null) {
            mensaje = "el empleado ya se encuentra registrado";
        } else {
            Empleado nuevoEmpleado = new Empleado();
            empleados.add(nuevoEmpleado);
            mensaje = "registro de empleado exitoso";
        }
        return mensaje;
    }

    public String actualizarEmpleado(String nombre, String cedula, LocalTime horaEntrada, LocalTime horaSalida, LocalTime horaEntradaEmpleado) {
        String mensaje = "";
        Empleado encontrado = buscarEmpleado(cedula);
        if (encontrado != null) {
            encontrado.setNombre(nombre);
            encontrado.setCedula(cedula);
            encontrado.setHoraEntrada(horaEntrada);
            encontrado.setHoraSalida(horaSalida);
            encontrado.setHoraEntradaEmpleado(horaEntradaEmpleado);
            mensaje = "actualizacion realizada correctamente";
        } else {
            mensaje = "no se encontro el empleado";
        }
        return mensaje;
    }

    public String borrarEmpleado(String nombre, String cedula, LocalTime horaEntrada, LocalTime horaSalida, LocalTime horaEntradaEmpleado) {
        String mensaje = "";
        Empleado encontrado = buscarEmpleado(cedula);
        if (encontrado != null) {
            empleados.remove(encontrado);
            mensaje = "empleado eliminado correctamente";
        } else {
            mensaje = "empleado no encontrado";
        }
        return mensaje;
    }

    public Empleado buscarEmpleado(String cedula) {
        Empleado auxEmpleado = null;
        for (Empleado e : empleados) {
            if (e.getCedula().equals(cedula)) {
                return auxEmpleado;
            }
        }
        return auxEmpleado;
    }

    //Metodo para verificar si un empleado llegó tarde
    public ArrayList<Empleado> consultarEmpleadosTarde(LocalTime horaIngresoEmpresa, LocalTime horaEntradaEmpleado) {
        ArrayList<Empleado> listaResultado = new ArrayList<>();
        for (int i = 0; i < empleados.size(); i++) {
            Empleado empAux = empleados.get(i);
            if (empAux.llegoTarde(horaIngresoEmpresa)) {
                listaResultado.add(empAux);
            }
        }
        return listaResultado;
    }
}