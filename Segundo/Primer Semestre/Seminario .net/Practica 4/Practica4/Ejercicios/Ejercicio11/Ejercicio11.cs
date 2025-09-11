class Ejercicio11{
    public static void ejecutar(){

        string? st,st1,st2,st3,st4;
        st1 = "st1";
        st2 = "st2";
        st3 = "st3";
        st4 = null;
        
        /*
        if (st1 == null)
        {
        if (st2 == null)
        {
        st = st3;
        }
        else
        {
        st = st2;
        }
        }
        else
        {
        st = st1;
        }
        if (st4 == null)
        {
        st4 = "valor por defecto";
        }
        */

        st = st1 ?? st2 ?? st3;
        st4 ??= "Valor por defecto";
    }
}