package com.mx.mobi_flm;

import java.util.Date;

public class TomarMedicacao {
    private String paciente;
    private Date data;
    private String foto;

    public TomarMedicacao() {
    }

    public TomarMedicacao(String paciente, Date data, String foto) {
        this.paciente = paciente;
        this.data = data;
        this.foto = foto;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
