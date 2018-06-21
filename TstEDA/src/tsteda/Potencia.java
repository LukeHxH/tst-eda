package tsteda;

public class Potencia {
	
	public int pot(int i, int j) {
		if (j == 0)
			return 1;
		return i * pot (i, j - 1);
	}
	
}
