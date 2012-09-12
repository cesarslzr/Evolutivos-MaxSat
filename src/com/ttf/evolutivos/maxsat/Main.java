package com.ttf.evolutivos.maxsat;

import java.util.ArrayList;

public class Main {
	private static ArrayList<Clausule> clausules = new ArrayList<Clausule>();
	private static ArrayList<Solution> solutions = new ArrayList<Solution>();
	
	private static double MUTATE_RATE = 0.005d;
	private static double CROSS_RATE = 0.6d;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	private static void read(){
		
	}

	public static double getMutateRate(){
		return MUTATE_RATE;
	}
	
	public static double getCrossRate(){
		return CROSS_RATE;
	}
	
	/**
	 * Devuelve el conjunto de cláusulas a procesar
	 * @return 
	 */
	public static ArrayList<Clausule> getClausules() {
		return clausules;
	}
	
	/**
	 * Devuelve la población de soluciones actuales
	 * @return 
	 */
	public static ArrayList<Solution> getSolutions() {
		return solutions;
	}
}
