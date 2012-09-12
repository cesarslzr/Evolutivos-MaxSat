package com.ttf.evolutivos.maxsat;

/**
 * Define una clausula
 * @author Cesar
 *
 */
public class Clausule {
	private static int SIZE = 3;
	private int[] indexes;
	
	public Clausule() {
		indexes = new int[SIZE];
	}

	public int[] getIndexes() {
		return indexes;
	}
	
	public static int getSize(){
		return SIZE;
	}
}
