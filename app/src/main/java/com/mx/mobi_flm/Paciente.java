package com.mx.mobi_flm;

import com.google.firebase.Timestamp;


public class Paciente {
    private String profissional;
    private String nome;
    private String sobrenome;
    private String email;
    private String celular;
    private Integer doencas;
    private Timestamp inictb;
    private Timestamp inichiv;

    public Paciente() {
    }

    public Paciente(Paciente p) {
        this.profissional = p.profissional;
        this.nome = p.nome;
        this.sobrenome = p.sobrenome;
        this.email = p.email;
        this.celular = p.celular;
        this.doencas = p.doencas;
        this.inictb = p.inictb;
        this.inichiv = p.inichiv;

    }

    public Paciente(String profissional, String nome, String sobrenome, String email, String celular, Integer doencas, Timestamp inictb, Timestamp inichiv) {

        profissional = profissional;
        nome = nome;
        sobrenome = sobrenome;
        email = email;
        celular = celular;
        doencas = doencas;
        inictb = inictb;
        inichiv = inichiv;
    }

    public String getProfissional() {
        return profissional;
    }

    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Integer getDoencas() {
        return doencas;
    }

    public void setDoencas(Integer doencas) {
        this.doencas = doencas;
    }

    public Timestamp getInictb() {
        return inictb;
    }

    public void setInictb(Timestamp inictb) {
        this.inictb = inictb;
    }

    public Timestamp getInichiv() {
        return inichiv;
    }

    public void setInichiv(Timestamp inichiv) {
        this.inichiv = inichiv;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "profissional='" + profissional + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", doencas=" + doencas +
                ", inictb=" + inictb +
                ", inichiv=" + inichiv +
                '}';
    }
}
