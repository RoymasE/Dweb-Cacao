package com.cacaormpresa.cacaormpresa.dto;

public class BalanceMasaDto {

    private Double totalCosechadoBabaKg;
    private Double totalGranosSecosKg;
    private Double totalMateriaPrimaProcesadaKg;
    private Double totalPolvoCacaoProcesadoKg;
    private Double totalMantecaProcesadaKg;
    private Double totalExportadoKg;
    private Double totalMermasPerdidasKg;
    private Double porcentajeRendimiento;
    private String ecuacionFisicaVerificacion; // Muestra la correlación física

    public BalanceMasaDto() {}

    public BalanceMasaDto(Double totalCosechadoBabaKg, Double totalGranosSecosKg,
                          Double totalMateriaPrimaProcesadaKg, Double totalPolvoCacaoProcesadoKg,
                          Double totalMantecaProcesadaKg, Double totalExportadoKg,
                          Double totalMermasPerdidasKg, Double porcentajeRendimiento,
                          String ecuacionFisicaVerificacion) {
        this.totalCosechadoBabaKg = totalCosechadoBabaKg;
        this.totalGranosSecosKg = totalGranosSecosKg;
        this.totalMateriaPrimaProcesadaKg = totalMateriaPrimaProcesadaKg;
        this.totalPolvoCacaoProcesadoKg = totalPolvoCacaoProcesadoKg;
        this.totalMantecaProcesadaKg = totalMantecaProcesadaKg;
        this.totalExportadoKg = totalExportadoKg;
        this.totalMermasPerdidasKg = totalMermasPerdidasKg;
        this.porcentajeRendimiento = porcentajeRendimiento;
        this.ecuacionFisicaVerificacion = ecuacionFisicaVerificacion;
    }

    public Double getTotalCosechadoBabaKg() {
        return totalCosechadoBabaKg;
    }

    public void setTotalCosechadoBabaKg(Double totalCosechadoBabaKg) {
        this.totalCosechadoBabaKg = totalCosechadoBabaKg;
    }

    public Double getTotalGranosSecosKg() {
        return totalGranosSecosKg;
    }

    public void setTotalGranosSecosKg(Double totalGranosSecosKg) {
        this.totalGranosSecosKg = totalGranosSecosKg;
    }

    public Double getTotalMateriaPrimaProcesadaKg() {
        return totalMateriaPrimaProcesadaKg;
    }

    public void setTotalMateriaPrimaProcesadaKg(Double totalMateriaPrimaProcesadaKg) {
        this.totalMateriaPrimaProcesadaKg = totalMateriaPrimaProcesadaKg;
    }

    public Double getTotalPolvoCacaoProcesadoKg() {
        return totalPolvoCacaoProcesadoKg;
    }

    public void setTotalPolvoCacaoProcesadoKg(Double totalPolvoCacaoProcesadoKg) {
        this.totalPolvoCacaoProcesadoKg = totalPolvoCacaoProcesadoKg;
    }

    public Double getTotalMantecaProcesadaKg() {
        return totalMantecaProcesadaKg;
    }

    public void setTotalMantecaProcesadaKg(Double totalMantecaProcesadaKg) {
        this.totalMantecaProcesadaKg = totalMantecaProcesadaKg;
    }

    public Double getTotalExportadoKg() {
        return totalExportadoKg;
    }

    public void setTotalExportadoKg(Double totalExportadoKg) {
        this.totalExportadoKg = totalExportadoKg;
    }

    public Double getTotalMermasPerdidasKg() {
        return totalMermasPerdidasKg;
    }

    public void setTotalMermasPerdidasKg(Double totalMermasPerdidasKg) {
        this.totalMermasPerdidasKg = totalMermasPerdidasKg;
    }

    public Double getPorcentajeRendimiento() {
        return porcentajeRendimiento;
    }

    public void setPorcentajeRendimiento(Double porcentajeRendimiento) {
        this.porcentajeRendimiento = porcentajeRendimiento;
    }

    public String getEcuacionFisicaVerificacion() {
        return ecuacionFisicaVerificacion;
    }

    public void setEcuacionFisicaVerificacion(String ecuacionFisicaVerificacion) {
        this.ecuacionFisicaVerificacion = ecuacionFisicaVerificacion;
    }
}
