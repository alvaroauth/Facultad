public class Matriz
{
    private double[,] datos;

    public Matriz(int filas, int columnas){
        datos = new double[filas, columnas];
    }

    public Matriz(double[,] matriz){
        int filas = matriz.GetLength(0);
        int columnas = matriz.GetLength(1);
        datos = new double[filas, columnas];
        Array.Copy(matriz, datos, matriz.Length);
    }

    public void SetElemento(int fila, int columna, double elemento){
        datos[fila, columna] = elemento;
    }

    public double GetElemento(int fila, int columna){
        return datos[fila, columna];
    }

    public void imprimir(){
        imprimir("{0,8:F2}");
    }

    public void imprimir(string formatString){
        int filas = datos.GetLength(0);
        int columnas = datos.GetLength(1);
        for (int i = 0; i < filas; i++){
            for (int j = 0; j < columnas; j++)
                Console.Write(string.Format(formatString, datos[i, j]));
            Console.WriteLine();
        }
    }

    public double[] GetFila(int fila){

        int columnas = datos.GetLength(1);
        double[] filaDatos = new double[columnas];

        for (int j = 0; j < columnas; j++)
            filaDatos[j] = datos[fila, j];

        return filaDatos;
    }

    public double[] GetColumna(int columna){

        int filas = datos.GetLength(0);
        double[] columnaDatos = new double[filas];

        for (int i = 0; i < filas; i++)
            columnaDatos[i] = datos[i, columna];

        return columnaDatos;
    }

    public double[] GetDiagonalPrincipal(){

        int filas = datos.GetLength(0);
        int columnas = datos.GetLength(1);
    
        if (filas != columnas) throw new InvalidOperationException("La matriz debe ser cuadrada para obtener la diagonal principal.");

        double[] diagonal = new double[filas];

        for (int i = 0; i < filas; i++)
            diagonal[i] = datos[i, i];
        return diagonal;
    }

    public double[] GetDiagonalSecundaria()
    {
        int filas = datos.GetLength(0);
        int columnas = datos.GetLength(1);

        if (filas != columnas) throw new InvalidOperationException("La matriz debe ser cuadrada para obtener la diagonal secundaria.");

        double[] diagonal = new double[filas];
        for (int i = 0; i < filas; i++)
            diagonal[i] = datos[i, columnas - i - 1];
        return diagonal;
    } 
    

    public double[][] getArregloDeArreglo()
    {
        int filas = datos.GetLength(0);
        int columnas = datos.GetLength(1);
        double[][] arreglo = new double[filas][];
        for (int i = 0; i < filas; i++)
        {
            arreglo[i] = new double[columnas];
            for (int j = 0; j < columnas; j++)
            {
                arreglo[i][j] = datos[i, j];
            }
        }
        return arreglo;
    }

    public void sumarle(Matriz m){
        if (datos.GetLength(0) != m.datos.GetLength(0) || datos.GetLength(1) != m.datos.GetLength(1))
            throw new ArgumentException("Las matrices deben tener las mismas dimensiones");

        for (int i = 0; i < datos.GetLength(0); i++){
            for (int j = 0; j < datos.GetLength(1); j++)
                datos[i, j] += m.datos[i, j];
        }
    }

    public void restarle(Matriz m){

        if (datos.GetLength(0) != m.datos.GetLength(0) || datos.GetLength(1) != m.datos.GetLength(1))
            throw new ArgumentException("Las matrices deben tener las mismas dimensiones");

        for (int i = 0; i < datos.GetLength(0); i++){

            for (int j = 0; j < datos.GetLength(1); j++)
                datos[i, j] -= m.datos[i, j];
        }
    }

    public void multiplicarPor(Matriz m){
        if (datos.GetLength(1) != m.datos.GetLength(0))
            throw new ArgumentException("El número de columnas de la primera matriz debe ser igual al número de filas de la segunda");

        int filas = datos.GetLength(0);
        int columnas = m.datos.GetLength(1);
        int intermedio = datos.GetLength(1);
        double[,] resultado = new double[filas, columnas];

        for (int i = 0; i < filas; i++){

            for (int j = 0; j < columnas; j++){

                double suma = 0;
                for (int k = 0; k < intermedio; k++)
                    suma += datos[i, k] * m.datos[k, j];
                resultado[i, j] = suma;
            }
        }

        datos = resultado;
    }
} 
