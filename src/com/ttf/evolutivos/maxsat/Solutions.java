package com.ttf.evolutivos.maxsat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Solutions {
	ArrayList<Solution> solutions;

	public Solutions() {

	}

	public ArrayList<Solution> getSolutions() {
		return solutions;
	}

	/**
	 * Cruza dos padres usando cruzamiento de un solo punto, usando la
	 * probabilidad de cruzamiento establecida en <code>Main</code>
	 * 
	 * @param parent1
	 *            El padre 1
	 * @param parent2
	 *            El padre 2
	 * @return Una lista de hijos resultado del cruzamiento
	 */
	public ArrayList<Solution> singlePointCross(Solution parent1,
			Solution parent2) {
		ArrayList<Solution> offspring = new ArrayList<Solution>();

		// Soluciones temporales
		Solution temp1, temp2;

		Random random;
		int crossPoint;

		if (Math.random() < Main.getCrossRate()) {
			random = new Random(new Date().getTime());
			crossPoint = random.nextInt(Solution.getSize());
			temp1 = new Solution();
			temp2 = new Solution();

			for (int i = 0; i < crossPoint; i++) {
				temp1.getSolution()[i] = parent1.getSolution()[i];
				temp2.getSolution()[i] = parent2.getSolution()[i];
			}

			for (int i = crossPoint; i < Solution.getSize(); i++) {
				temp1.getSolution()[i] = parent2.getSolution()[i];
				temp2.getSolution()[i] = parent1.getSolution()[i];
			}

			offspring.add(temp1);
			offspring.add(temp2);
		} else {
			offspring.add(parent1);
			offspring.add(parent2);
		}

		return offspring;
	}

	/**
	 * Elige dos padres por torneo
	 * @return Una lista con dos padres
	 */
	public ArrayList<Solution> chooseParentsByTournament() {
		ArrayList<Solution> parents = new ArrayList<Solution>();
		ArrayList<Solution> tournamentParticipants = new ArrayList<Solution>();
		
		Random random = new Random(new Date().getTime());
		
		int bestFitness = 0;
		Solution parent = new Solution();
		
		int populationSize = Main.getSolutions().size();
		int participantsNumber = populationSize / 3;		
		
		for (int i = 0; i < participantsNumber; i++ ) {
			tournamentParticipants.add(Main.getSolutions().get(random.nextInt(populationSize)));
		}
		
		for (Solution solution : tournamentParticipants){
			if (solution.getFitness() > bestFitness){
				parent = solution;
			}
		}
		
		parents.add(parent);
		
		tournamentParticipants = new ArrayList<Solution>();
		for (int i = 0; i < participantsNumber; i++ ) {
			tournamentParticipants.add(Main.getSolutions().get(random.nextInt(populationSize)));
		}
		
		for (Solution solution : tournamentParticipants){
			if (solution.getFitness() > bestFitness){
				parent = solution;
			}
		}
		
		parents.add(parent);
		
		return parents;
	}	
}
