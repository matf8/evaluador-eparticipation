package eParticipation.periferico.controller;

import eParticipation.periferico.model.Iniciativa;
import eParticipation.periferico.model.Evaluador;

import eParticipation.periferico.model.DtIniciativaEv;
import eParticipation.periferico.service.EvaluadorService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public class ControladorEvaluador implements EvaluadorService {	
			
	private Map<Long, Evaluador> evaluadores = new HashMap<>();
	
	public ControladorEvaluador() {	}	
		
	public DtIniciativaEv evaluarIniciativa(Iniciativa i) {	
		boolean result = setRandomEv();
		String desc = setRandomDesc(result);	
		DtIniciativaEv di = new DtIniciativaEv(i.getId(), i.getNombre(), i.getDescripcion(), i.getFecha(), i.getCreador(), i.getEstado(), i.getRecurso(), desc, result);		
		return di;			
	}	
	
	public void addEvaluador(Evaluador e) {
		evaluadores.put(e.getId(), e);
	}
	
	public void removeEvaluador(Evaluador e) {
		evaluadores.remove(e.getId());
	}
	
	public Evaluador getEvaluador(Long id) {
		return evaluadores.get(id);
	}
	
	public List<Evaluador> getEvaluadores() {
		return new ArrayList<Evaluador>(evaluadores.values());
	}	
	
	public void cargarEvaluadores() {
		Evaluador e1 = new Evaluador(Long.valueOf(1),"EV1");
		evaluadores.put(e1.getId(), e1);			
		e1 = new Evaluador(Long.valueOf(2),"EV2"); 		
		evaluadores.put(e1.getId(), e1);
		e1 = new Evaluador(Long.valueOf(3),"EV3"); 	
		evaluadores.put(e1.getId(), e1);
		e1 = new Evaluador(Long.valueOf(4),"EV4"); 	
		evaluadores.put(e1.getId(), e1);
		e1 = new Evaluador(Long.valueOf(5),"EV5");	
		evaluadores.put(e1.getId(), e1);
		e1 = new Evaluador(Long.valueOf(6),"EV6"); 	
		evaluadores.put(e1.getId(), e1);
		e1 = new Evaluador(Long.valueOf(7),"EV7");
		evaluadores.put(e1.getId(), e1);
		e1 = new Evaluador(Long.valueOf(8),"EV8");	
		evaluadores.put(e1.getId(), e1);
	}

	public String ping() {
		return "pong";
	}
	
	private String setRandomCreador() {	
		Random rand = new Random();
		int r = rand.nextInt(8);
		Evaluador k = getEvaluador(Long.valueOf(r)+1);		
		return k.getNombre();
	}
	
	public boolean setRandomEv() {		
		Random rand = new Random();		
		int n = rand.nextInt(evaluadores.size());
		if (n <= evaluadores.size() - 1)
			return true;
		else return false;		
	}
		
	public String setRandomDesc(boolean result) {		
		String k = setRandomCreador();
		if (result)
			return "evaluacion ok.\npor " + k;
		else return "declinada por falta de recursos.\npor " + k;
	}

}
