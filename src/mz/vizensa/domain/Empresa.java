/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.domain;

/**
 *
 * @author doroteia
 */
public class Empresa {
    private int idEmpresa;
    private String empNome;
    private String empTelfone;
    private String empLogotipo;
    private String emmEmail;

    public Empresa() {
    }
    
    
    public Empresa( String empNome, String empTelfone, String empLogotipo, String emmEmail) {
       
        this.empNome = empNome;
        this.empTelfone = empTelfone;
        this.empLogotipo = empLogotipo;
        this.emmEmail = emmEmail;
    }

    
    
    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getEmpNome() {
        return empNome;
    }

    public void setEmpNome(String empNome) {
        this.empNome = empNome;
    }

    public String getEmpTelfone() {
        return empTelfone;
    }

    public void setEmpTelfone(String empTelfone) {
        this.empTelfone = empTelfone;
    }

    public String getEmpLogotipo() {
        return empLogotipo;
    }

    public void setEmpLogotipo(String empLogotipo) {
        this.empLogotipo = empLogotipo;
    }

    public String getEmmEmail() {
        return emmEmail;
    }

    public void setEmmEmail(String emmEmail) {
        this.emmEmail = emmEmail;
    }

    @Override
    public String toString() {
        return "Empresa{" + "idEmpresa=" + idEmpresa + ", empNome=" + empNome + ", empTelfone=" + empTelfone + ", empLogotipo=" + empLogotipo + ", emmEmail=" + emmEmail + '}';
    }
    
    
}
