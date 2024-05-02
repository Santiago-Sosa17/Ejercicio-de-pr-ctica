package ejercicioParcial;

import java.util.Scanner;

public class Principal {
	private static final double PORCENTAJE_MALO = 0.25;
	private static final double PORCENTAJE_BUENO = 0.10;
	private static final double AUX = 0;
	private static final double PRUEBAS = 4;
	private static final String COMPARACION = "";

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String codigoTermotanque;
		double capacidadCalorica, perdidaCalorica;
		double deficienciaTermica;
		int cont = 1;
		int acumDeficiencia = 0;
		int acumDeficienciaMalo = 0;
		String termotanqueMinimo = "";
		double minimaDefTermica = Double.MAX_VALUE;
		String dios = "Fran";

		do {
			System.out.println("Ingrese el codigo de identificacion del termotanque: ");
			codigoTermotanque = sc.nextLine();

			if (!codigoTermotanque.equals(COMPARACION)) {

				do {
					System.out.println("Ingrese la capacidad calórica del termotanque: ");
					capacidadCalorica = Integer.parseInt(sc.nextLine());
				} while (capacidadCalorica <= AUX);
				do {

					System.out.println("Ingrese la pérdida calórica del termotanque: ");
					perdidaCalorica = Integer.parseInt(sc.nextLine());

					deficienciaTermica = (perdidaCalorica / capacidadCalorica);
					if (deficienciaTermica < PORCENTAJE_BUENO) {
						acumDeficiencia++;
						if (deficienciaTermica < minimaDefTermica) {
							minimaDefTermica = deficienciaTermica;
							termotanqueMinimo = codigoTermotanque;
						}

					} else if (deficienciaTermica > PORCENTAJE_MALO) {
						acumDeficienciaMalo++;
					}
					cont++;
				} while (cont <= PRUEBAS && acumDeficienciaMalo == AUX);

				if (acumDeficienciaMalo > AUX) {
					System.out.println("PÉRDIDA EXCESIVA DE CALORÍAS");
				} else {
					if (acumDeficiencia > AUX) {
						System.out.println("TERMOTANQUE APTO");
					} else {
						System.out.println("AISLACIÓN INSUFICIENTE");
					}
				}
				acumDeficienciaMalo = 0;
				acumDeficiencia = 0;
				
			}

		} while (!codigoTermotanque.equals(COMPARACION));

		System.out.println("El termotanque con la menor deficiencia térmica es: " + termotanqueMinimo
				+ " cuya deficiencia térmica es de: " + minimaDefTermica);
		sc.close();
	}

}
