package com.mx.mobi_flm;

import java.util.Date;

public class RelatarSentimento {

    private String paciente;
    private Date data;
    private Integer sentimento;
    private Integer sintoma;

    public RelatarSentimento() {
    }

    public RelatarSentimento(String paciente, Date data, Integer sentimento, Integer sintoma) {
        this.paciente = paciente;
        this.data = data;
        this.sentimento = sentimento;
        this.sintoma = sintoma;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getSentimento() {
        return sentimento;
    }

    public void setSentimento(Integer sentimento) {
        this.sentimento = sentimento;
    }

    public Integer getSintoma() {
        return sintoma;
    }

    public void setSintoma(Integer sintoma) {
        this.sintoma = sintoma;
    }
}