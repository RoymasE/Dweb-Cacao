package com.cacaormpresa.cacaormpresa.service;

import com.cacaormpresa.cacaormpresa.entity.*;
import com.cacaormpresa.cacaormpresa.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
public class DataInitializerService implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final AreaPlantaRepository areaPlantaRepository;
    private final ProveedorRepository proveedorRepository;
    private final ClienteRepository clienteRepository;
    private final CajonRepository cajonRepository;
    private final LoteCacaoRepository loteRepository;
    private final MonitoreoFermentacionRepository monitoreoRepository;
    private final ControlSecadoRepository controlSecadoRepository;
    private final PesajeGranosRepository pesajeGranosRepository;
    private final PesajePolvoRepository pesajePolvoRepository;
    private final PedidoVentaRepository pedidoRepository;
    private final PackingListRepository packingListRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializerService(UsuarioRepository usuarioRepository,
                                  AreaPlantaRepository areaPlantaRepository,
                                  ProveedorRepository proveedorRepository,
                                  ClienteRepository clienteRepository,
                                  CajonRepository cajonRepository,
                                  LoteCacaoRepository loteRepository,
                                  MonitoreoFermentacionRepository monitoreoRepository,
                                  ControlSecadoRepository controlSecadoRepository,
                                  PesajeGranosRepository pesajeGranosRepository,
                                  PesajePolvoRepository pesajePolvoRepository,
                                  PedidoVentaRepository pedidoRepository,
                                  PackingListRepository packingListRepository,
                                  PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.areaPlantaRepository = areaPlantaRepository;
        this.proveedorRepository = proveedorRepository;
        this.clienteRepository = clienteRepository;
        this.cajonRepository = cajonRepository;
        this.loteRepository = loteRepository;
        this.monitoreoRepository = monitoreoRepository;
        this.controlSecadoRepository = controlSecadoRepository;
        this.pesajeGranosRepository = pesajeGranosRepository;
        this.pesajePolvoRepository = pesajePolvoRepository;
        this.pedidoRepository = pedidoRepository;
        this.packingListRepository = packingListRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) {
        if (usuarioRepository.count() > 0) {
            return; // Ya existen datos
        }

        System.out.println(">>> Inicializando datos base de Cacao Premium del Perú S.A.C. <<<");

        // 1. Usuarios con roles
        usuarioRepository.save(new Usuario("admin", passwordEncoder.encode("admin123"), "Marco Antonio", "Zúñiga", "admin@cacaopremium.pe", Rol.ADMIN));
        usuarioRepository.save(new Usuario("gerente", passwordEncoder.encode("gerente123"), "Edward", "Marticorena", "gerente@cacaopremium.pe", Rol.GERENTE));
        usuarioRepository.save(new Usuario("jefeplanta", passwordEncoder.encode("jefe123"), "Fabian", "Morocho", "planta@cacaopremium.pe", Rol.JEFE_PLANTA));
        usuarioRepository.save(new Usuario("acopiador", passwordEncoder.encode("acopio123"), "Erickson", "Ramírez", "acopio@cacaopremium.pe", Rol.ACOPIADOR));
        usuarioRepository.save(new Usuario("vendedor", passwordEncoder.encode("ventas123"), "Fernando", "Rivadeneira", "ventas@cacaopremium.pe", Rol.VENDEDOR));
        usuarioRepository.save(new Usuario("calidad", passwordEncoder.encode("calidad123"), "Carlos", "Paredes", "calidad@cacaopremium.pe", Rol.SUPERVISOR_CALIDAD));

        // 2. Áreas de planta
        areaPlantaRepository.save(new AreaPlanta("Acopio y Recepción", "Recepción y pesaje de cacao en baba de agricultores", "Erickson Ramírez"));
        areaPlantaRepository.save(new AreaPlanta("Cajones de Fermentación", "Etapa bioquímica crítica en cajones de madera (4-6 días)", "Fabian Morocho"));
        areaPlantaRepository.save(new AreaPlanta("Patio de Secadores Solares", "Reducción de humedad hasta el 7%", "Carlos Paredes"));
        areaPlantaRepository.save(new AreaPlanta("Almacén de Granos (Sección 1)", "Almacén y pesaje de granos secos en sacos de 60 kg", "Fabian Morocho"));
        areaPlantaRepository.save(new AreaPlanta("Molienda y Derivados (Sección 2)", "Tostado, prensado y pulverización para polvo de cacao", "Fabian Morocho"));
        areaPlantaRepository.save(new AreaPlanta("Logística y Despacho Marítimo", "Consolidación de contenedores y Packing List para exportación", "Fernando Rivadeneira"));

        // 3. Proveedores de Acopio (Agricultores asociados de San Martín)
        Proveedor prov1 = proveedorRepository.save(new Proveedor("Carlos Huamán Tanchiva", "45879632", "Sector Juanjuí - Mariscal Cáceres", "Parcela El Edén", "CONTR-COM-01", "942112233", 8.5));
        Proveedor prov2 = proveedorRepository.save(new Proveedor("Asociación de Productores de Tocache", "20548796321", "Comunidad Santa Lucía - Tocache", "Parcelas Valle del Sol", "CONTR-COM-02", "942556677", 25.0));
        Proveedor prov3 = proveedorRepository.save(new Proveedor("Rosa Melina Delgado Salas", "41258963", "Sector Huicungo - San Martín", "Fundo La Esperanza", "CONTR-COM-03", "942998811", 12.0));

        // 4. Clientes Internacionales
        Cliente cl1 = clienteRepository.save(new Cliente("Schoko Import GmbH", "Alemania", "Hans Weber", "contact@schoko-import.de", "+49 40 1234567", "Hafenstrasse 45, Hamburgo"));
        Cliente cl2 = clienteRepository.save(new Cliente("Pacific Cacao Traders LLC", "Estados Unidos", "Sarah Miller", "orders@pacificcacao.com", "+1 415 555 0199", "789 Market St, San Francisco, CA"));
        Cliente cl3 = clienteRepository.save(new Cliente("Swiss Artisan Chocolatiers AG", "Suiza", "Laurent Blanc", "achats@swissartisanchoc.ch", "+41 22 888 4400", "Rue du Rhône 12, Ginebra"));

        // 5. Cajones de fermentación de madera
        CajonFermentacion cajon1 = cajonRepository.save(new CajonFermentacion("CAJ-01", 1000.0, "Laurel"));
        CajonFermentacion cajon2 = cajonRepository.save(new CajonFermentacion("CAJ-02", 1000.0, "Tornillo"));
        CajonFermentacion cajon3 = cajonRepository.save(new CajonFermentacion("CAJ-03", 800.0, "Cedro"));

        // 6. Lote 1: Cosechado, Fermentado, Secado y Pesado en Sección 1
        LoteCacao lote1 = new LoteCacao("LOTE-2026-001", LocalDate.now().minusDays(15), LocalDate.now().minusDays(15), prov1, cajon1, "Cacao Criollo Fino de Aroma", 2500.0);
        lote1.setEstado(LoteCacao.EstadoLote.EN_ALMACEN_GRANOS);
        lote1.setObservaciones("Cacao de excelente fermentación y aroma frutal");
        loteRepository.save(lote1);

        // Monitoreo de fermentación lote 1 (6 días)
        monitoreoRepository.save(new MonitoreoFermentacion(lote1, 1, LocalDate.now().minusDays(15), 35.0, false, "Inicio de fermentación en cajón CAJ-01"));
        monitoreoRepository.save(new MonitoreoFermentacion(lote1, 2, LocalDate.now().minusDays(14), 42.0, true, "Primer volteo realizado"));
        monitoreoRepository.save(new MonitoreoFermentacion(lote1, 3, LocalDate.now().minusDays(13), 47.5, true, "Temperatura óptima alcanzada (47.5 °C)"));
        monitoreoRepository.save(new MonitoreoFermentacion(lote1, 4, LocalDate.now().minusDays(12), 48.0, true, "Tercer volteo. Fase acética controlada"));
        monitoreoRepository.save(new MonitoreoFermentacion(lote1, 5, LocalDate.now().minusDays(11), 46.5, false, "Descenso gradual de temperatura"));
        monitoreoRepository.save(new MonitoreoFermentacion(lote1, 6, LocalDate.now().minusDays(10), 45.0, false, "Fermentación completada con éxito"));

        // Control de secado lote 1 (humedad al 7%)
        controlSecadoRepository.save(new ControlSecado(lote1, LocalDate.now().minusDays(9), LocalDate.now().minusDays(4), 7.0, 1000.0, 5, "Secado solar óptimo completado"));

        // Pesaje Sección 1 (Granos)
        pesajeGranosRepository.save(new PesajeSeccionGranos(lote1, LocalDate.now().minusDays(4), 1000.0, "Grado 1 (Exportación)", "Granos homogéneos listos para exportación"));

        // 7. Lote 2: Procesado a Sección 2 (Polvo de cacao)
        LoteCacao lote2 = new LoteCacao("LOTE-2026-002", LocalDate.now().minusDays(12), LocalDate.now().minusDays(12), prov2, cajon2, "Trinitario", 2000.0);
        lote2.setEstado(LoteCacao.EstadoLote.EN_PROCESAMIENTO);
        loteRepository.save(lote2);

        monitoreoRepository.save(new MonitoreoFermentacion(lote2, 1, LocalDate.now().minusDays(12), 36.0, false, "Recepción en cajón CAJ-02"));
        monitoreoRepository.save(new MonitoreoFermentacion(lote2, 2, LocalDate.now().minusDays(11), 43.0, true, "Volteo"));
        monitoreoRepository.save(new MonitoreoFermentacion(lote2, 3, LocalDate.now().minusDays(10), 47.0, true, "Fase acética"));
        monitoreoRepository.save(new MonitoreoFermentacion(lote2, 4, LocalDate.now().minusDays(9), 48.5, true, "Pico de temperatura"));

        controlSecadoRepository.save(new ControlSecado(lote2, LocalDate.now().minusDays(8), LocalDate.now().minusDays(3), 7.2, 800.0, 5, "Secado finalizado"));
        pesajeGranosRepository.save(new PesajeSeccionGranos(lote2, LocalDate.now().minusDays(3), 800.0, "Grado 1", "Materia prima para molienda"));

        // Procesamiento en Sección 2: 300 kg derivados a polvo
        pesajePolvoRepository.save(new PesajeSeccionPolvo(lote2, LocalDate.now().minusDays(2), 300.0, 160.0, 105.0, 35.0, "Molienda y prensado de polvo fino de cacao"));

        // 8. Lote 3: Actualmente en Fermentación
        cajon3.setEstado(CajonFermentacion.EstadoCajon.EN_FERMENTACION);
        cajonRepository.save(cajon3);
        LoteCacao lote3 = new LoteCacao("LOTE-2026-003", LocalDate.now().minusDays(2), LocalDate.now().minusDays(2), prov3, cajon3, "Cacao Criollo Fino de Aroma", 1800.0);
        lote3.setEstado(LoteCacao.EstadoLote.EN_FERMENTACION);
        loteRepository.save(lote3);
        monitoreoRepository.save(new MonitoreoFermentacion(lote3, 1, LocalDate.now().minusDays(2), 37.0, false, "Primer día en fermentador"));
        monitoreoRepository.save(new MonitoreoFermentacion(lote3, 2, LocalDate.now().minusDays(1), 46.0, true, "Segundo día volteo ok"));

        // 9. Pedido de exportación confirmado y Packing List marítimo
        PedidoVenta pedido1 = new PedidoVenta("PED-2026-001", cl1, LocalDate.now().minusDays(3),
                PedidoVenta.SeccionProducto.SECCION_1_GRANOS, 300.0, 8.50, "Puerto de Hamburgo, Alemania", "Cacao fino de aroma grado 1");
        pedido1.setEstadoPedido(PedidoVenta.EstadoPedido.DESPACHADO);
        pedidoRepository.save(pedido1);

        packingListRepository.save(new PackingList("PKL-2026-001", pedido1, LocalDate.now().minusDays(1),
                "Puerto del Callao, Perú", "Puerto de Hamburgo, Alemania", "Hapag-Lloyd Express",
                "HL-CONT-984512", "PERU-ADUANA-7841", 5, 300.0, 310.0, "5 sacos de yute de 60 kg debidamente paletizados"));

        System.out.println(">>> Datos base cargados exitosamente. Listo para pruebas en Postman! <<<");
    }
}
