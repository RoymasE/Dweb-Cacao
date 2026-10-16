package com.cacaormpresa.cacaormpresa.dto;

import java.util.Map;

public class DashboardSummaryDto {

    private Double totalCosechadoKg;
    private Double totalGranosSecosKg;
    private Double stockDisponibleGranosKg;
    private Double totalPolvoCacaoKg;
    private Double stockDisponiblePolvoKg;
    private Double totalExportadoKg;
    private Double totalVentasUsd;
    private Long lotesEnFermentacion;
    private Long lotesEnSecado;
    private Long pedidosPendientes;
    private Long alertasTemperaturaActivas;
    private Map<String, Double> distribucionPorVariedad;
    private Map<String, Double> exportacionesPorPais;

    public DashboardSummaryDto() {}

    public Double getTotalCosechadoKg() {
        return totalCosechadoKg;
    }

    public void setTotalCosechadoKg(Double totalCosechadoKg) {
        this.totalCosechadoKg = totalCosechadoKg;
    }

    public Double getTotalGranosSecosKg() {
        return totalGranosSecosKg;
    }

    public void setTotalGranosSecosKg(Double totalGranosSecosKg) {
        this.totalGranosSecosKg = totalGranosSecosKg;
    }

    public Double getStockDisponibleGranosKg() {
        return stockDisponibleGranosKg;
    }

    public void setStockDisponibleGranosKg(Double stockDisponibleGranosKg) {
        this.stockDisponibleGranosKg = stockDisponibleGranosKg;
    }

    public Double getTotalPolvoCacaoKg() {
        return totalPolvoCacaoKg;
    }

    public void setTotalPolvoCacaoKg(Double totalPolvoCacaoKg) {
        this.totalPolvoCacaoKg = totalPolvoCacaoKg;
    }

    public Double getStockDisponiblePolvoKg() {
        return stockDisponiblePolvoKg;
    }

    public void setStockDisponiblePolvoKg(Double stockDisponiblePolvoKg) {
        this.stockDisponiblePolvoKg = stockDisponiblePolvoKg;
    }

    public Double getTotalExportadoKg() {
        return totalExportadoKg;
    }

    public void setTotalExportadoKg(Double totalExportadoKg) {
        this.totalExportadoKg = totalExportadoKg;
    }

    public Double getTotalVentasUsd() {
        return totalVentasUsd;
    }

    public void setTotalVentasUsd(Double totalVentasUsd) {
        this.totalVentasUsd = totalVentasUsd;
    }

    public Long getLotesEnFermentacion() {
        return lotesEnFermentacion;
    }

    public void setLotesEnFermentacion(Long lotesEnFermentacion) {
        this.lotesEnFermentacion = lotesEnFermentacion;
    }

    public Long getLotesEnSecado() {
        return lotesEnSecado;
    }

    public void setLotesEnSecado(Long lotesEnSecado) {
        this.lotesEnSecado = lotesEnSecado;
    }

    public Long getPedidosPendientes() {
        return pedidosPendientes;
    }

    public void setPedidosPendientes(Long pedidosPendientes) {
        this.pedidosPendientes = pedidosPendientes;
    }

    public Long getAlertasTemperaturaActivas() {
        return alertasTemperaturaActivas;
    }

    public void setAlertasTemperaturaActivas(Long alertasTemperaturaActivas) {
        this.alertasTemperaturaActivas = alertasTemperaturaActivas;
    }

    public Map<String, Double> getDistribucionPorVariedad() {
        return distribucionPorVariedad;
    }

    public void setDistribucionPorVariedad(Map<String, Double> distribucionPorVariedad) {
        this.distribucionPorVariedad = distribucionPorVariedad;
    }

    public Map<String, Double> getExportacionesPorPais() {
        return exportacionesPorPais;
    }

    public void setExportacionesPorPais(Map<String, Double> exportacionesPorPais) {
        this.exportacionesPorPais = exportacionesPorPais;
    }
}
