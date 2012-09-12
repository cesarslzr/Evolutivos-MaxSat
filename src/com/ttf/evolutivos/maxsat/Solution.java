package com.ttf.evolutivos.maxsat;

public class Solution {
	private static int SIZE = 32;  
	private boolean[] solution;
	private int fitness;
	
	public Solution() {
		solution = new boolean[SIZE];
	}
	
	public void generateRandomSolution() {		
		for (int i = 0; i < SIZE; i++){
			solution[i] = Math.random() < 0.5d ? true:false;
		}
	}
	
	/**
	 * Muta una solución usando la probabilidad 
	 * @return La solución
	 */
	public boolean[] mutate(){
		boolean[] newSolution = new boolean[SIZE];
				
		for (int i = 0; i < SIZE; i++) {
			if(Math.random() < Main.getMutateRate()){
				newSolution[i] = ! solution[i];
			} else {
				newSolution[i] = solution[i];
			}
		}
		
		return newSolution;
	}
	
	public int getFitness() {
		return fitness;
	}
	
	/**
	 * Devuelve el fitness de una solución
	 * @return El fitness de la solución
	 */
	public int calculateFitness(){
		fitness = 0;		
		int absoluteIndex;
		boolean sign = false;
				
		/**
		 * Recorre todas las cláusulas
		 */
		for (Clausule clausule : Main.getClausules()){
			for (int i = 0; i < Clausule.getSize(); i++){				
				if (clausule.getIndexes()[i] < 0){
					sign = false;
				} else {
					sign = true;
				}
				
				absoluteIndex = Math.abs(clausule.getIndexes()[i]) - 1;
				
				/**
				 * Una variable de la clausula es verdadera y
				 * la cláusula es verdadera 
				 */
				if ( (solution[absoluteIndex] && sign) ||
					 (!solution[absoluteIndex] && !sign)){
					fitness++;
					break;
				}
			}					
		}
		
		return fitness;
	}
	
	public boolean[] getSolution() {
		return solution;
	}
	
	public static int getSize(){
		return SIZE;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();  
		for (int i = 0; i < SIZE; i++){
			sb.append(solution[i]?"1 ": "0 ");
		}
		
		return sb.toString();
	}
	
	public String toPrettyString(){
		StringBuilder sb = new StringBuilder();  
		for (int i = 0; i < SIZE; i++){
			sb.append("X");
			sb.append(i);
			sb.append(solution[i]?" = true ": " = false ");
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
