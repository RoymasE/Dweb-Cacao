package com.cacaormpresa.cacaormpresa.deseodeinterfas;
import com.cacaormpresa.cacaormpresa.Entity.Almacen;
import com.cacaormpresa.cacaormpresa.Entity.Cache;
import com.cacaormpresa.cacaormpresa.Entity.Libre;
import com.cacaormpresa.cacaormpresa.Entity.Proceso;
import com.cacaormpresa.cacaormpresa.Entity.Proveedor;
import com.cacaormpresa.cacaormpresa.Entity.Trabajadores;
import com.cacaormpresa.cacaormpresa.Entity.Transporte;
import com.cacaormpresa.cacaormpresa.Entity.Record;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;



//*****Importes manuales 





//***********




///INterface del repositorio
interface interfacetrans extends JpaRepository<Transporte, String >{}
interface interfacetraba extends JpaRepository<Trabajadores, String >{}
interface interfaceRecor extends JpaRepository<Record, Integer >{}
interface interfaceprov extends JpaRepository<Proveedor, String>{}
interface interfaceproceso extends JpaRepository<Proceso, Integer>{}
interface interfacel extends JpaRepository<Libre, String>{}
interface interfacecache extends JpaRepository<Cache, String>{}
interface interfacealm extends JpaRepository<Almacen, String >{}


//servicio
@Service
public class servicio{
private final  interfacetrans repo1;
private final  interfacetraba repo2;
private final  interfaceRecor repo3;

private final interfaceprov repo4;
private final interfaceproceso repo5;
	private final interfacel repo6; private interfacecache repo7;
	
private final interfacealm repo8;
	

	



//Cronstuctor

    public servicio(interfacetrans repo1, interfacetraba repo2, interfaceRecor repo3, interfaceprov repo4, interfaceproceso repo5, interfacel repo6, interfacecache repo7, interfacealm repo8) {
        this.repo1 = repo1;
        this.repo2 = repo2;
        this.repo3 = repo3;
        this.repo4 = repo4;
        this.repo5 = repo5;
        this.repo6 = repo6;
        this.repo7 = repo7;
        this.repo8 = repo8;
    }
//*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
	//*-*-*-**-*-*-**-*-*--*-*--*-*---*-*-*-*-*
	//**-*-*--*****-*-*-*-*-*-*-*-*
	//Listar todos los datos 


//*----------Almacen -------------*

//*-lista all en todas -*
	public List<Almacen> listar1almacen(){
return repo8.findAll();
}

//*-busqueda por busqueda -*
	public Almacen listar1uno1almacen(String id){ return repo8.findById(id).get();}
//*-eliminar un reguistre -*
	public void eliminar1almacen(String id){ repo8.deleteById(id);}
//*-actualizar un reguistro -*
	public void actualizar1almacen(String id, Almacen almacen){
	Almacen almacendb = repo8.findById(id).get();
		almacendb.setCatidad(almacen.getCatidad());
	
		almacendb.setPrecioproveedor(almacen.getPrecioproveedor());
		almacendb.setPrecioventa(almacen.getPrecioventa());
		almacendb.setProceso(almacen.getProceso());
		almacendb.setProveedor(almacen.getProveedor());
		almacendb.setTipodeproducto(almacen.getTipodeproducto());
                almacendb.setTransporte(almacen.getTransporte());
			repo8.save(almacendb);
	
	
	
	
	}
	
	
//*-crear un reguistro -*
	public void crear1almacen(Almacen almacen){
	repo8.save(almacen);
	}
	
	
//*-??? -*
//*-----------------------*/
	

//*-----------Libre------------*

//*-lista all en todas -*
	public List<Libre> listarlibre(){return repo6.findAll();}
	
//*-busqueda por busqueda -*
	public Libre listar1uno1libre(String id){return repo6.findById(id).get();}
	
//*-eliminar un reguistre -*
	
	public void eliminar1libre(String id){repo6.deleteById(id);}
	
//*-actualizar un reguistro -*
	public void actualizar1libre(String id, Libre libre){
        Libre libredb = repo6.findById(id).get();
        libredb.setSlote1(libre.getSlote1());
        libredb.setSlote2(libre.getSlote2());
        libredb.setSlote3(libre.getSlote3());
        libredb.setSlote4(libre.getSlote4());
       repo6.save(libredb);

        
        }
	
//*-crear un reguistro -*
	public void crear1reguistro(Libre libre){
	
	
	repo6.save(libre);
	}
	
	
//*-??? -*
//*-----------------------*/
	//*---------Proveedor--------------*

//*-lista all en todas -*
	public List<Proveedor> listar1todos1proveedor(){
	return repo4.findAll();
	}
//*-busqueda por busqueda -*
	public Proveedor listar1uno1proveedor(String id){
	return repo4.findById(id).get();
	}
//*-eliminar un reguistre -*
	public void Eliminar1proveedor(String id){
	repo4.deleteById(id);
	}
//*-actualizar un reguistro -*
	public void Actualizarproveedor(String id, Proveedor proveedor){
	Proveedor proveedordb = repo4.findById(id).get();
		
	proveedordb.setBolsasdecacao(proveedor.entrega(2));
        proveedordb.setEntregenbruto(proveedor.entrega(true));
        proveedordb.setEstadodesaco(proveedor.entrega(1));
      repo4.save(proveedordb);
	}
//*-crear un reguistro -*
	public void Crear1proveedor(Proveedor proveedor){
	repo4.save(proveedor);
	
	}
//*-??? -*
//*-----------------------*/
	/*---------Trabajadores--------------*

//*-lista all en todas -*/
	public List<Trabajadores> listar1trabajadores(){
	return repo2.findAll();
	
	}

//*-busqueda por busqueda -*
	public Trabajadores listar1uno1trabajador(String id){
	return repo2.findById(id).get();
	
	}
//*-eliminar un reguistre -*
	public void Elminar1trabajador(String id){repo2.deleteById(id);}
//*-actualizar un reguistro -*
	public void Actualizar1trabjadador(String id, Trabajadores trabajador){
        Trabajadores trabajadoredb = repo2.findById(id).get();
        trabajadoredb.setApellido(trabajador.getApellido());
                trabajadoredb.setContrasenna(trabajador.getContrasenna());
        trabajadoredb.setFinserv(trabajador.getFinserv());

              
        trabajadoredb.setTiempodes(trabajador.getTiempodes());

              repo2.save(trabajadoredb);

        }
//*-crear un reguistro -*
	public void crear1trabajador(Trabajadores trabajador){
	repo2.save(trabajador);
	
	}
//*-??? -*
//*-----------------------*/
	/*----------Cache-------------*

//*-lista all en todas -*/
	public List<Cache> listar1chaches(){
	return repo7.findAll();
	
	}
//*-busqueda por busqueda -*
	public Cache lisatar1uno1cache(String id){
	return repo7.findById(id).get();
	}
//*-eliminar un reguistre -*
	public void eliminar1cache(String id){
	repo7.deleteById(id);
	}
//*-actualizar un reguistro -*
	public void Actualizar1cache(String id, Cache cache){
	Cache cachedb = repo7.findById(id).get();
        cachedb.setSlote1(cache.getSlote1());
                cachedb.setSlote2(cache.getSlote2());
        cachedb.setSlote3(cache.getSlote3());
        cachedb.setSlote4(cache.getSlote4());
repo7.save(cachedb);
        
        
        
	}
//*-crear un reguistro -*
        public void crear1cache(Cache cache){
		repo7.save(cache);
		}
        
        
//*-??? -*
//*-----------------------*/
//*-----------Proceso------------*

//*-lista all en todas -*/
	public List<Proceso> lista1proceso(){
	
	return repo5.findAll();
	
	}
//*-busqueda por busqueda -*
	public Proceso busqueda1uno1proceso(int id){
	return repo5.findById(id).get();
	
	}
	
	
//*-eliminar un reguistre -*
	public void eliminar1proceso(int id){
	
	repo5.deleteById(id);
	}
	
	
//*-actualizar un reguistro -*
	public void Actualizar1proceso(int id, Proceso proceso){
	Proceso procesodb = repo5.findById(id).get();
        procesodb.setAlmacen(proceso.getAlmacen());
        procesodb.setGradodefermentacion(proceso.getGradodefermentacion());
        procesodb.setHumedad(proceso.isHumedad());
        procesodb.setMoho(proceso.isMoho());
        repo5.save(procesodb);
	
	}
//*-crear un reguistro -*
	public void crear1proceso(Proceso proceso){
	repo5.save(proceso);
	}
        
//*-??? -*
//*-----------------------*/
	//*---------Record--------------*

//*-lista all en todas -*
	public List<Record> listar1record(){
	return repo3.findAll();
	}
//*-busqueda por busqueda -*
	public Record lista1uno1record(int id){
	return repo3.findById(id).get();
	}
//*-eliminar un reguistre -*
public void eliminar1record(	int id){
repo3.deleteById(id);
}
	//*-actualizar un reguistro -*
	public void actualizacion1record(int id, Record record){
	Record dbrecor = repo3.findById(id).get();
        dbrecor.setEnsascado(record.isEnsascado());
        dbrecor.setPeso(record.getPeso());
        
        repo3.save(dbrecor);
        
	}
//*-crear un reguistro -*
public void crear1record( Record record){
repo3.save(record);

}
//*-??? -*
//*-----------------------*/
	//*----------Transporte-------------*

//*-lista all en todas -*
	public List<Transporte> listar1transporte(){
	
	return repo1.findAll();
	}
	
//*-busqueda por busqueda -*
	public Transporte lista1uno1transporte(String id){
	return repo1.findById(id).get();
	
	}
//*-eliminar un reguistre -*
	public void eliminar1transporte(String id){
	repo1.deleteById(id);
	}
//*-actualizar un reguistro -*
	public void actualizar1transporte(String id, Transporte transporte){
	Transporte dbtransporte = repo1.findById(id).get();
        dbtransporte.setA(transporte.getA());
	dbtransporte.setCompradordecaco(transporte.getCompradordecaco());
        dbtransporte.setKgtransportados(transporte.getKgtransportados());
        dbtransporte.setPreciodecompra(transporte.getPreciodecompra());
        dbtransporte.setPreciodetransporte(transporte.getPreciodetransporte());
        dbtransporte.setRecord(transporte.getRecord());
       repo1.save(dbtransporte);
	}
//*-crear un reguistro -*
        public void guardar1transporte(Transporte transporte){
        repo1.save(transporte);
        }
        
//*-??? -*
//*-----------------------*/




}

