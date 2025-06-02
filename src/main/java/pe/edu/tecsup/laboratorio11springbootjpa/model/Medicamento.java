package pe.edu.tecsup.laboratorio11springbootjpa.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codMedicamento;

    @Column(name = "descripcionMed", nullable = false, length = 255)
    private String descripcionMed;

    @Column(name = "fechaFabricacion", nullable = false)
    private LocalDate fechaFabricacion;

    @Column(name = "fechaVencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "Presentacion", length = 255)
    private String presentacion;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "precioVentaUni", precision = 10, scale = 2)
    private BigDecimal precioVentaUni;

    @Column(name = "precioVentaPres", precision = 10, scale = 2)
    private BigDecimal precioVentaPres;

    @Column(name = "Marca", length = 255)
    private String marca;

    // Relación ManyToOne con Especialidad
    @ManyToOne
    @JoinColumn(name = "CodEspec", nullable = false)
    private Especialidad especialidad;


    public Medicamento() { }

    public Medicamento(Integer codMedicamento,
                       String descripcionMed,
                       LocalDate fechaFabricacion,
                       LocalDate fechaVencimiento,
                       String presentacion,
                       Integer stock,
                       BigDecimal precioVentaUni,
                       BigDecimal precioVentaPres,
                       String marca,
                       Especialidad especialidad) {
        this.codMedicamento = codMedicamento;
        this.descripcionMed = descripcionMed;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
        this.presentacion = presentacion;
        this.stock = stock;
        this.precioVentaUni = precioVentaUni;
        this.precioVentaPres = precioVentaPres;
        this.marca = marca;
        this.especialidad = especialidad;
    }

    // getters y setters
    public Integer getCodMedicamento() { return codMedicamento; }
    public void setCodMedicamento(Integer codMedicamento) { this.codMedicamento = codMedicamento; }

    public String getDescripcionMed() { return descripcionMed; }
    public void setDescripcionMed(String descripcionMed) { this.descripcionMed = descripcionMed; }

    public LocalDate getFechaFabricacion() { return fechaFabricacion; }
    public void setFechaFabricacion(LocalDate fechaFabricacion) { this.fechaFabricacion = fechaFabricacion; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getPresentacion() { return presentacion; }
    public void setPresentacion(String presentacion) { this.presentacion = presentacion; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public BigDecimal getPrecioVentaUni() { return precioVentaUni; }
    public void setPrecioVentaUni(BigDecimal precioVentaUni) { this.precioVentaUni = precioVentaUni; }

    public BigDecimal getPrecioVentaPres() { return precioVentaPres; }
    public void setPrecioVentaPres(BigDecimal precioVentaPres) { this.precioVentaPres = precioVentaPres; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public Especialidad getEspecialidad() { return especialidad; }
    public void setEspecialidad(Especialidad especialidad) { this.especialidad = especialidad; }
}