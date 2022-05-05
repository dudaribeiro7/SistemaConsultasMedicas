// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.model;

public class Questionario {
    private boolean hospitalizado;
    private String motivoHospital;
    private boolean operado;
    private String motivoOperado;
    private boolean epilepsia;
    private boolean alcool;
    private boolean tabagismo;
    private boolean sinusite;
    private boolean rinite;
    private boolean asma;
    private boolean osteoporose;
    private boolean artrose;
    private boolean diabetes;
    private int tipoDiabetes;
    private boolean hipertensao;
    private boolean alergia;
    private String qualAlergia;
    private String obs;

    public Questionario(){
        this.motivoHospital = "";
        this.motivoOperado = "";
        this.qualAlergia = "";
    }

    public Questionario(boolean hospitalizado, String motivoHospital, boolean operado, String motivoOperado, boolean epilepsia, boolean alcool, boolean tabagismo, boolean sinusite, boolean rinite, boolean asma, boolean osteoporose, boolean artrose, boolean diabetes, int tipoDiabetes, boolean hipertensao, boolean alergia, String qualAlergia, String obs) {
        this.hospitalizado = hospitalizado;
        this.motivoHospital = motivoHospital;
        this.operado = operado;
        this.motivoOperado = motivoOperado;
        this.epilepsia = epilepsia;
        this.alcool = alcool;
        this.tabagismo = tabagismo;
        this.sinusite = sinusite;
        this.rinite = rinite;
        this.asma = asma;
        this.osteoporose = osteoporose;
        this.artrose = artrose;
        this.diabetes = diabetes;
        this.tipoDiabetes = tipoDiabetes;
        this.hipertensao = hipertensao;
        this.alergia = alergia;
        this.qualAlergia = qualAlergia;
        this.obs = obs;
    }

    public boolean isHospitalizado() {
        return hospitalizado;
    }

    public String getMotivoHospital() {
        return motivoHospital;
    }

    public boolean isOperado() {
        return operado;
    }

    public String getMotivoOperado() {
        return motivoOperado;
    }

    public boolean isEpilepsia() {
        return epilepsia;
    }

    public boolean isAlcool() {
        return alcool;
    }

    public boolean isTabagismo() {
        return tabagismo;
    }

    public boolean isSinusite() {
        return sinusite;
    }

    public boolean isRinite() {
        return rinite;
    }

    public boolean isAsma() {
        return asma;
    }

    public boolean isOsteoporose() {
        return osteoporose;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public int getTipoDiabetes() {
        return tipoDiabetes;
    }

    public boolean isHipertensao() {
        return hipertensao;
    }

    public boolean isAlergia() {
        return alergia;
    }

    public String getQualAlergia() {
        return qualAlergia;
    }

    public boolean isArtrose() {
        return artrose;
    }

    public String getObs() {
        return obs;
    }
}
