package pkg;

public class ContoCorrente {
	String titolare;
	int nMovimenti;
	final int maxMovimenti = 50;
	double saldo;

	ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		nMovimenti = 0;
	}

	void preleva(double x) throws BancaException {
		saldo -= (nMovimenti < maxMovimenti) ? x : x + 0.50;

		if (saldo < 0)
			throw new BancaException("Il conto è in rosso");

		nMovimenti++;
	}

	double restituisciSaldo() {
		return saldo;
	}
}
