/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mz.vizensa.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.print.DocFlavor;
import mz.vizensa.dao.FuncionarioDAO;

/**
 *
 * @author fred
 */
public class Funcionario {

    private int funCodigo;
    private String funNome;
    private String funApelido;
    private String funTipoFuncionario;
    private String funNr_bi;
    private String funGenero;
    private String funEstado_civil;
    private int contaco1;
    private int contaco2;
    private String funEmail;
    private Date funData;
    private String funCargo;
    private float funSalario;
    private long funNr_conta;
    private boolean funAutenticavel;
    private Morada morada;
    static FuncionarioDAO fdao;
    Button info;

    public Button getInfo() {
        return info;
    }

    public void setInfo(Button info) {
        this.info = info;
    }

    public Funcionario(Button info, int funCodigo, String nome, String funCargo, String funTipoFuncionario) {
        this.funCodigo = funCodigo;
        this.funTipoFuncionario = funTipoFuncionario;
        this.funCargo = funCargo;
        this.info = info;
        this.funNome = nome;
    }

    public Funcionario(String funNome, String funApelido) {
        this.funNome = funNome;
        this.funApelido = funApelido;
    }

    public Funcionario() {
    }

    public Funcionario(int funCodigo, String funNome, String funApelido, String funTipoFuncionario, String funNr_bi, String funGenero, String funEstado_civil, int contaco1, int contaco2, String funEmail, Date funData, String funCargo, float funSalario, long funNr_conta, boolean funAutenticavel, Morada morada) {
        this.funCodigo = funCodigo;
        this.funNome = funNome;
        this.funApelido = funApelido;
        this.funTipoFuncionario = funTipoFuncionario;
        this.funNr_bi = funNr_bi;
        this.funGenero = funGenero;
        this.funEstado_civil = funEstado_civil;
        this.contaco1 = contaco1;
        this.contaco2 = contaco2;
        this.funEmail = funEmail;
        this.funData = funData;
        this.funCargo = funCargo;
        this.funSalario = funSalario;
        this.funNr_conta = funNr_conta;
        this.funAutenticavel = funAutenticavel;
        this.morada = morada;
    }
    public Funcionario( String funNome, String funApelido, String funTipoFuncionario, String funNr_bi, String funGenero, String funEstado_civil, int contaco1, int contaco2, String funEmail, Date funData, String funCargo, float funSalario, long funNr_conta, Morada morada) {
        
        this.funNome = funNome;
        this.funApelido = funApelido;
        this.funTipoFuncionario = funTipoFuncionario;
        this.funNr_bi = funNr_bi;
        this.funGenero = funGenero;
        this.funEstado_civil = funEstado_civil;
        this.contaco1 = contaco1;
        this.contaco2 = contaco2;
        this.funEmail = funEmail;
        this.funData = funData;
        this.funCargo = funCargo;
        this.funSalario = funSalario;
        this.funNr_conta = funNr_conta;
     
        this.morada = morada;
    }

    public int getFunCodigo() {
        return funCodigo;
    }

    
    public void setFunCodigo(int funCodigo) {
        this.funCodigo = funCodigo;
    }

    public String getFunNome() {
        return funNome;
    }

    public void setFunNome(String funNome) {
        this.funNome = funNome;
    }

    public String getFunApelido() {
        return funApelido;
    }

    public void setFunApelido(String funApelido) {
        this.funApelido = funApelido;
    }

    public String getFunTipoFuncionario() {
        return funTipoFuncionario;
    }

    public void setFunTipoFuncionario(String funTipoFuncionario) {
        this.funTipoFuncionario = funTipoFuncionario;
    }

    public String getFunNr_bi() {
        return funNr_bi;
    }

    public void setFunNr_bi(String funNr_bi) {
        this.funNr_bi = funNr_bi;
    }

    public String getFunGenero() {
        return funGenero;
    }

    public void setFunGenero(String funGenero) {
        this.funGenero = funGenero;
    }

    public String getFunEstado_civil() {
        return funEstado_civil;
    }

    public void setFunEstado_civil(String funEstado_civil) {
        this.funEstado_civil = funEstado_civil;
    }

    public int getContaco1() {
        return contaco1;
    }

    public void setContaco1(int contaco1) {
        this.contaco1 = contaco1;
    }

    public int getContaco2() {
        return contaco2;
    }

    public void setContaco2(int contaco2) {
        this.contaco2 = contaco2;
    }

    public String getFunEmail() {
        return funEmail;
    }

    public void setFunEmail(String funEmail) {
        this.funEmail = funEmail;
    }

    public Date getFunData() {
        return funData;
    }

    public void setFunData(Date funData) {
        this.funData = funData;
    }

    public String getFunCargo() {
        return funCargo;
    }

    public void setFunCargo(String funCargo) {
        this.funCargo = funCargo;
    }

    public float getFunSalario() {
        return funSalario;
    }

    public void setFunSalario(float funSalario) {
        this.funSalario = funSalario;
    }

    public long getFunNr_conta() {
        return funNr_conta;
    }

    public void setFunNr_conta(long funNr_conta) {
        this.funNr_conta = funNr_conta;
    }

    public boolean isFunAutenticavel() {
        return funAutenticavel;
    }

    public void setFunAutenticavel(boolean funAutenticavel) {
        this.funAutenticavel = funAutenticavel;
    }

    public Morada getMorada() {
        return morada;
    }

    public void setMorada(Morada morada) {
        this.morada = morada;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "funCodigo=" + funCodigo + ", funNome=" + funNome + ", funApelido=" + funApelido + ", funTipoFuncionario=" + funTipoFuncionario + ", funNr_bi=" + funNr_bi + ", funGenero=" + funGenero + ", funEstado_civil=" + funEstado_civil + ", contaco1=" + contaco1 + ", contaco2=" + contaco2 + ", funEmail=" + funEmail + ", funData=" + funData + ", funCargo=" + funCargo + ", funSalario=" + funSalario + ", funNr_conta=" + funNr_conta + ", funAutenticavel=" + funAutenticavel + ", morada=" + morada + '}';
    }
    public void salvar(){
         fdao.inserir(this);
    }
    public  List<Funcionario> todos() {
        ArrayList<Funcionario> list = new ArrayList<>();
        fdao = new FuncionarioDAO();

        for (Funcionario funcionario : fdao.BuscarFuncionarios()) {
            Button botao = new Button();
            botao.setStyle("-fx-background-color: transparent;;-fx-background-radius:0px;");
            ImageView img = new ImageView(new Image(Funcionario.class.getResourceAsStream("icons8-info-64.png")));
            img.setFitHeight(35);
            img.setFitWidth(35);
            botao.setGraphic(img);
            Funcionario func = new Funcionario(botao, 12, funcionario.getFunNome(), funcionario.getFunCargo(), funcionario.getFunTipoFuncionario());
            func.setFunApelido(funcionario.getFunApelido());
            func.setFunCodigo(funcionario.getFunCodigo());
            func.setContaco1(funcionario.getContaco1());
            func.setContaco2(funcionario.getContaco2());
            func.setFunAutenticavel(funcionario.isFunAutenticavel());
            func.setFunEmail(funcionario.getFunEmail());
            func.setFunGenero(funcionario.getFunGenero());
            func.setFunEstado_civil(funcionario.getFunEstado_civil());
            func.setFunNr_bi( funcionario.getFunNr_bi());
            func.setFunNr_conta(funcionario.getFunNr_conta());
            func.setFunSalario(funcionario.getFunSalario());
            func.setMorada(funcionario.getMorada());
            func.setFunData(funcionario.getFunData());
            list.add(func);

        }
        return list;
    }
}