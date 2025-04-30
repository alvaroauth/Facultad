class A{
    char c;
    static string? st;
    void metodo1(){
        st = "string";
        c = 'A';
        c = st[0];
    }
    static void metodo2(){
        //new ClaseA().c = 'a';
        st = "st2";
        //c = 'B';
        //new A().st = "otro string";

    }
}