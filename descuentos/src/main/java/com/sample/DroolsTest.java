package com.sample;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	public static final void main(String[] args) {
		try {
		    // load up the knowledge base
		    KieServices ks = KieServices.Factory.get();
		    KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");
			
			kSession.addEventListener( new DebugAgendaEventListener() );
			kSession.addEventListener( new DebugRuleRuntimeEventListener() );
			
			KieRuntimeLogger logger = ks.getLoggers().newThreadedFileLogger( kSession, "./descuentos", 1000 );

			final List<Recepcion> recepciones = getRecepciones();
				
			for(Recepcion recepcion:recepciones ){
				kSession.insert(recepcion);
			}
			
			for(Recepcion recepcion:recepciones ){
				kSession.insert(recepcion.getDespacho());
			}
			
			/*final List<Despacho> listaDespachos = getDespachos();
			for (Despacho despacho : listaDespachos) {
				kSession.insert(despacho);
			}*/
			
			
		    kSession.fireAllRules();
		    logger.close();
		    // and then dispose the session
		    kSession.dispose();
		    //showResults(orders);
		    
		    //showDespachos(getDespachos());
//		      showRecepcion(getRecepciones());
		    
		    
		} catch (Throwable t) {
		    t.printStackTrace();
		}
    }
	
	private static List<Recepcion> getRecepciones(){
		List<Recepcion> lista = new ArrayList<Recepcion>();

		//regla 1 pone hora, fecha y despacho
		lista.add(new Recepcion(null,new Codigo(1,"RJO",""),1));
		
//		//regla 2, pone hora, fecha y despacho
//		lista.add(new Recepcion(null,new Codigo(2,"AMA",""),2));
//		
//		//relga 3, al crearse el despacho con el movil, se cambia el estado de movil a asignado
//		Despacho desp1 = new Despacho(new Movil(new EstadoMovil("Disponible"), 
//				1, "Movil 1"),new Desenlace(1,"Desenlace Ejemplo"),1);
//		Recepcion recp=new Recepcion(desp1,new Codigo(1,"VDE",""),1);
//		recp.setFecha_reg(1);
//		recp.setHora_reg(1);
//		lista.add(recp);
//		
//		//regla4, asignar desenlace a despacho nuevo
//		Despacho desp2 = new Despacho(null,null,1);
//		Recepcion recp1=new Recepcion(desp2,new Codigo(1,"VDE",""),1);
//		recp1.setFecha_reg(1);
//		recp1.setHora_reg(1);
//		lista.add(recp1);
//
//		//regla5, cuando termina el despacho, cambiar estado del movil a disponible
//		Despacho desp3 = new Despacho(new Movil(new EstadoMovil("Asignado"), 
//				1, "Movil 1"),new Desenlace(1,"Fallecimiento en domicilio"),1);
//		Recepcion recp2=new Recepcion(desp3,new Codigo(1,"VDE",""),1);
//		recp2.setFecha_reg(1);
//		recp2.setHora_reg(1);
//		lista.add(recp2);
//		
//		//regla6, al crearse una recepcion se le setea la hora y fecha de recepcion
//		lista.add(new Recepcion(null,new Codigo(2,"VDE",""),2));
//		
//		//regla3 y regla4
//		Despacho desp4 = new Despacho(new Movil(new EstadoMovil("Disponible"), 
//				1, "Movil 1"),null,1);
//		Recepcion recp3=new Recepcion(desp4,new Codigo(1,"VDE",""),1);
//		recp3.setFecha_reg(1);
//		recp3.setHora_reg(1);
//		lista.add(recp3);
		
		
		
		return lista;
	};
	
	
	/* ESTO NO VA, DEBEN ESTAR ASOCIADOS A RECEPCIÓN (SOLUCIONADO)
	private static List<Despacho> getDespachos(){
		List<Despacho> lista = new ArrayList<Despacho>();
		
		//despacho vacio para reglas 3 y 4
		Despacho desp1 = new Despacho();
		desp1.setMovil(new Movil(new EstadoMovil("No Disponible"), 
				1, "Movil 1"));
		Desenlace desenlace = new Desenlace(1, "Desenlace Ejemplo");
		desp1.setDesenlace(desenlace);
		lista.add(desp1);
		
		//despacho para regla 5
		Despacho desp2 = new Despacho(new Movil(new EstadoMovil("No Disponible"), 
				2, "Movil 2"),new Desenlace(1,""),1);
		lista.add(desp2);
		
		return lista;
	};
	
	
	private static void showDespachos(List<Despacho> listDespachos){
		for (Despacho d : listDespachos){
			System.out.println("------------------------------------------"
					+ "\nDATOS DEL DESPACHO: "
					+ "\n- Despacho Nro: "+d.getNrodespacho()
					+ "\n          -----------"
					+ "\n  - Movil Id         : "+d.getMovil().getId()
					+ "\n  - Movil Descripcion: "+d.getMovil().getDescripcion()
					+ "\n  - Movil Estado     : "+d.getMovil().getEstado().getEstado()
					+ "\n          -----------"
					+ "\n  - Desenlace Id  :"+d.getDesenlace().getId()
					+ "\n  - Desenlace Desc: "+d.getDesenlace().getDesenlace()
					+ "\n  - Movil Estado  : "+d.getMovil().getEstado().getEstado());
		}
	}*/
	
//	private static void showRecepcion(List<Recepcion> listRecepcion){
//		for (Recepcion r: listRecepcion){
//			System.out.println("------------------------------------------"
//					+ "\nDATOS DE RECEPCION: "
//					+ "\n-Nro Recepcion : "+r.getNrorecepcion()
//					+ "\n-Fecha   : "+ r.getFecha_reg()+ " - Hora: "+r.getHora_reg()
//					+ "\n-  Codigo Nro  : "+r.getCodigo().getCodigo()
//					+ "\n-  Codigo Desc :"+r.getCodigo().getDescripcion()
//					+ "\n          -----------"
//					+ "\n-  Despacho Nro:"+r.getDespacho().getNrodespacho()
//					+ "\n          -----------"
//					+ "\n  - Movil Id         : "+r.getDespacho().getMovil().getId()
//					+ "\n  - Movil Descripcion: "+r.getDespacho().getMovil().getDescripcion()
//					+ "\n  - Movil Estado     : "+r.getDespacho().getMovil().getEstado().getEstado()
//					+ "\n          -----------"
//					+ "\n  - Desenlace Id  :"+r.getDespacho().getDesenlace().getId()
//					+ "\n  - Desenlace Desc: "+r.getDespacho().getDesenlace().getDesenlace()
//					+ "\n  - Movil Estado  : "+r.getDespacho().getMovil().getEstado().getEstado()
//		     );
//		}
//	}
   
}
