import javax.swing.JOptionPane;

public class Actividad1 {

    public static int suma(int n) {
        int res = 0;
        if (n > 0) {
            res = suma(n - 1);
            if (n % 2 == 0) {
                res = res + n;
            }
        }
        return res;
    }

    public static int numero(int n) {
        int res = 0;
        if (n > 0) {
            res = numero(n - 1);
            res = res + (n * 2);
        }
        return res;
    }

    public static void main(String[] args) {
        String entrada = JOptionPane.showInputDialog("Ingrese un número entero (n):");
        if (entrada == null) {
            return;
        }
        int n = Integer.parseInt(entrada);

        int resultadoSuma = suma(n);
        int resultadoNumero = numero(n);

        String salida = "Resultados para n = " + n
                + "\n\nsuma(" + n + ") = " + resultadoSuma
                + "\nnumero(" + n + ") = " + resultadoNumero;

        JOptionPane.showMessageDialog(null, salida);
    }
}
