int a = 17;
int b = 23;

Swap<int>(ref a, ref b);

Console.WriteLine($"{a}, {b}");

string st1 = "Hola";
string st2 = "Mundo";

Swap<string>(ref st1, ref st2);
Console.WriteLine($"{st1}, {st2}");

int i = (int)Mayor(100, 55);
Console.WriteLine(i);

Console.ReadKey();
void Swap<T>(ref T a, ref T b)
{
    T temp = a;
    a = b;
    b = temp;  
}

T Mayor<T>  (T a, T b) where T : IComparable
{   
    if (a.CompareTo(b) > 0) return a;
    return b;
}

/*
IComparable Mayor(IComparable a, IComparable b)
{
    if (a.CompareTo(b) > 0) return a;
    return b;
}
*/