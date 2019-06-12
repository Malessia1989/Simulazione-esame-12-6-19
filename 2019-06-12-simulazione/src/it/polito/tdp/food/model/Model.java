package it.polito.tdp.food.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.Condiment;
import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	FoodDao dao;
	Graph<Condiment, DefaultWeightedEdge> grafo;
	Map<Integer,Condiment> idMap;
	
	public Model() {
		dao= new FoodDao();
		idMap=new HashMap<Integer, Condiment>();
		dao.listAllCondiment(idMap); 
	}
	

	public boolean isValid(String numero) {
		
		return numero.matches("\\d+(\\.|\\,){0,1}\\d*");
	}

	public String creaGrafo(String numero) {
		grafo= new SimpleWeightedGraph<Condiment, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		List<ArchiePeso> result= dao.getArchiePeso(numero, idMap);
		for(ArchiePeso a: result) {
			Graphs.addEdgeWithVertices(grafo, a.getC1(), a.getC2(), a.getPeso());
		}
		
		
		System.out.println("vertici: " +grafo.vertexSet().size());
		System.out.println("archi: " +grafo.edgeSet().size());
		for(DefaultWeightedEdge edge: grafo.edgeSet()) {
			System.out.println(edge +" peso: "+grafo.getEdgeWeight(edge));
		}
		return null;
	}



}
