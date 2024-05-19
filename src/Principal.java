import com.google.gson.Gson;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        Consulta consulta = new Consulta();

        while (true) {
            System.out.println("***************************************************************");
            System.out.println("Bienvenido/a al conversor de monedas:");
            System.out.println(" ");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println(" ");
            System.out.println("Elija una opción: ");
            System.out.println("******************************************************************");

            System.out.print("Ingrese una opción: ");
            String opcion = lectura.nextLine();

            if (opcion.equals("7")) {
                System.out.println("Saliendo del conversor de monedas...");
                break;
            }

            try {
                System.out.print("Ingrese el valor a convertir: ");
                double valor = Double.parseDouble(lectura.nextLine());

                switch (opcion) {
                    case "1":
                        Monedas dolarAPesoArg = consulta.BuscaMoneda("USD");
                        double tasaDolarAPesoArg = dolarAPesoArg.conversion_rates().get("ARS");
                        System.out.println(valor + " Dólares = " + (valor * tasaDolarAPesoArg) + " Pesos argentinos");
                        break;
                    case "2":
                        Monedas pesoArgADolar = consulta.BuscaMoneda("ARS");
                        double tasaPesoArgADolar = pesoArgADolar.conversion_rates().get("USD");
                        System.out.println(valor + " Pesos argentinos = " + (valor * tasaPesoArgADolar) + " Dólares");
                        break;
                    case "3":
                        Monedas dolarARealBr = consulta.BuscaMoneda("USD");
                        double tasaDolarARealBr = dolarARealBr.conversion_rates().get("BRL");
                        System.out.println(valor + " Dólares = " + (valor * tasaDolarARealBr) + " Reales brasileños");
                        break;
                    case "4":
                        Monedas realBrADolar = consulta.BuscaMoneda("BRL");
                        double tasaRealBrADolar = realBrADolar.conversion_rates().get("USD");
                        System.out.println(valor + " Reales brasileños = " + (valor * tasaRealBrADolar) + " Dólares");
                        break;
                    case "5":
                        Monedas dolarAPesoCol = consulta.BuscaMoneda("USD");
                        double tasaDolarAPesoCol = dolarAPesoCol.conversion_rates().get("COP");
                        System.out.println(valor + " Dólares = " + (valor * tasaDolarAPesoCol) + " Pesos colombianos");
                        break;
                    case "6":
                        Monedas pesoColADolar = consulta.BuscaMoneda("COP");
                        double tasaPesoColADolar = pesoColADolar.conversion_rates().get("USD");
                        System.out.println(valor + " Pesos colombianos = " + (valor * tasaPesoColADolar) + " Dólares");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, ingrese un número entre 1 y 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor ingresado no válido. Por favor, ingrese un número válido.");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación");
                break;
            }
        }

        lectura.close();
    }
}
