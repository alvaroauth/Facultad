class AA
{
    private static int a; // Campo estático privado

    private static readonly int b; // Campo estático privado de solo lectura (readonly)

    AA() { } // Constructor de instancia

    public AA(int i) : this() { } // Constructor de instancia, público, llama a constructor sin parámetros

    static AA() => b = 2; // Constructor estático

    int c; // Campo de instancia privado (por defecto)

    public static void A1() => a = 1; // Método estático público

    public int A1(int a) => AA.a + a; // Método de instancia público

    public static int A2; // Campo estático público

    static int A3 => 3; // Propiedad estática privada de solo lectura (solo get, no auto-implementada)

    private int A4() => 4; // Método de instancia privado

    public int A5 { get => 5; } // Propiedad de instancia pública, solo lectura (solo get, no auto-implementada)

    int A6 { set => c = value; } // Propiedad de instancia privada, solo escritura (solo set, no auto-implementada)

    public int A7 { get; set; } // Propiedad de instancia pública, lectura-escritura, auto-implementada

    public int A8 { get; } = 8; // Propiedad de instancia pública, solo lectura, inicializada en declaración (no auto-implementada estrictamente porque tiene inicialización)

    public int this[int i] => i; // Indexador público de solo lectura
}