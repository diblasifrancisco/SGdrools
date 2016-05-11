package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.event.rule.DebugAgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.mvel2.ast.ForEachNode;

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
			
			final List<Despacho> listaDespachos = getDespachos();
			for (Despacho despacho : listaDespachos) {
				kSession.insert(despacho);
			}
			
		    kSession.fireAllRules();
		    logger.close();
		    // and then dispose the session
		    kSession.dispose();
		    //showResults(orders);
		    
		    
		} catch (Throwable t) {
		    t.printStackTrace();
		}
    }
	
	private static List<Recepcion> getRecepciones(){
		List<Recepcion> lista = new ArrayList<Recepcion>();
		lista.add(new Recepcion(new Despacho(),new Codigo(1,"RJO",""),1));
		lista.add(new Recepcion(new Despacho(),new Codigo(2,"AMA",""),2));
		lista.add(new Recepcion(new Despacho(),new Codigo(2,"VDE",""),4));
		return lista;
	};
	
	private static List<Despacho> getDespachos(){
		List<Despacho> lista = new ArrayList<Despacho>();
		
		//despacho vacio para reglas 3 y 4
		Despacho desp1 = new Despacho();
		desp1.setMovil(new Movil(new EstadoMovil("No Disponible"), 
				1, "Movil 1"));
		lista.add(desp1);
		
		//despacho para regla 5
		Despacho desp2 = new Despacho(new Movil(new EstadoMovil("No Disponible"), 
				2, "Movil 2"),new Desenlace(1,""),1);
		lista.add(desp2);
		
		return lista;
	};
	
	
	
	
    private static Order getOrderWithDefaultCustomer() {
		final Order order = new Order(getDefaultCustomer());
		order.addProduct(getProduct1());
		return order;
	}

	private static Order getOrderWithSilverCustomer() {
		final Order order = new Order(getSilverCustomer());
		order.addProduct(getProduct1());
		return order;
	}

	private static Order getOrderWithGoldCustomer() {
		final Order order = new Order(getGoldCustomer());
		order.addProduct(getProduct1());
		return order;
	}

	private static Order getOrderWithGoldCustomerAndTenProducts() {
		final Order order = new Order(getSilverCustomer());
		for (int i = 0; i < 10; i++) {
			order.addProduct(getProduct1());
		}
		return order;
	}

	private static Customer getDefaultCustomer() {
		return new Customer(Customer.DEFAULT_CUSTOMER, "Cliente estandar");
	}

	private static Customer getSilverCustomer() {
		return new Customer(Customer.SILVER_CUSTOMER, "Cliente SILVER");
	}

	private static Customer getGoldCustomer() {
		return new Customer(Customer.GOLD_CUSTOMER, "Cliente GOLD");
	}

	private static Product getProduct1() {
		return new Product(1, "Producto 1", 100d);
	}

	private static void showResults(List<Order> orders) {
		for (Order order : orders) {
			System.out.println("Cliente " + order.getCustomer() + " productos: " + order.getProducts().size()
					+ " Precio total: " + order.getTotalPrice());
		}
		
		
	}
	
	private static void showDespachos(List<Despacho> listDespachos){
		for (Despacho d : listDespachos){
			System.out.println("------------------------------------------"
					+ "\nDATOS DEL DESPACHO: "
					+ "\n  - Despacho Nro: "+d.getNrodespacho()
					+ "\n        -----------------"
					+ "\nDATOS DEL MOVIL"
					+ "\n  - Movil Id: "+d.getMovil().getId()
					+ "\n  - Movil Descripcion: "+d.getMovil().getDescripcion()
					+ "\n  - Movil Estado: "+d.getMovil().getEstado().getEstado());

		}
	}
   
}
