package uniquindio.edu.co.model;

import java.time.LocalTime;

public class Empleado {

    private String nombreEmpleado;
    private String numeroCedula;
    private LocalTime horaIngreso;
    private LocalTime horaSalida;
    private Empresa empresaAsignada;
    private LocalTime horaIngresoEmpleado;

    public Empleado() {
    }

    public Empleado(String nombreEmpleado, String numeroCedula, LocalTime horaIngreso, LocalTime horaSalida, Empresa empresaAsignada, LocalTime horaIngresoEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.numeroCedula = numeroCedula;
        this.horaIngreso = horaIngreso;
        this.horaSalida = horaSalida;
        this.empresaAsignada = empresaAsignada;
        this.horaIngresoEmpleado = horaIngresoEmpleado;
    }

    public String getNombre() {
        return nombreEmpleado;
    }

    public void setNombre(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getCedula() {
        return numeroCedula;
    }

    public void setCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public LocalTime getHoraEntrada() {
        return horaIngreso;
    }

    public void setHoraEntrada(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Empresa getOwnedByEmpresa() {
        return empresaAsignada;
    }

    public void setOwnedByEmpresa(Empresa empresaAsignada) {
        this.empresaAsignada = empresaAsignada;
    }

    public LocalTime getHoraEntradaEmpleado() {
        return horaIngresoEmpleado;
    }

    public void setHoraEntradaEmpleado(LocalTime horaIngresoEmpleado) {
        this.horaIngresoEmpleado = horaIngresoEmpleado;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombreEmpleado='" + nombreEmpleado + '\'' +
                ", numeroCedula='" + numeroCedula + '\'' +
                ", horaIngreso=" + horaIngreso +
                ", horaSalida=" + horaSalida +
                ", empresaAsignada=" + empresaAsignada +
                ", horaIngresoEmpleado=" + horaIngresoEmpleado +
                '}';
    }

    public boolean llegoTarde(LocalTime horaIngresoEmpresa) {
        boolean esTarde = false;
        if (horaIngreso.isAfter(horaIngresoEmpresa)) {
            esTarde = true;
        }
        return esTarde;
    }
}