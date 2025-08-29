using System;
// BONUSFRAGE: 
//Schwellen falsch gereiht: extras >= 3 kommt vor extras >= 5, 15% kommt also nie
//Rabatte vermischt: if (discount > addon_discount) addon_discount = discount; wendet evtl. den Händlerrabatt auf Zubehör an – laut Regeln darf der Händler-Rabatt nur auf den Grundpreis gehen.

class PriceCalc
{
    public static double CalculatePrice(
        double basePrice, double specialPrice, double extraPrice, int extras, double dealerDiscountPct)
    {
        double addonDiscountPct = extras >= 5 ? 15.0
                                 : extras >= 3 ? 10.0
                                 : 0.0;

        double discountedBase   = basePrice  * (1.0 - dealerDiscountPct / 100.0);
        double discountedExtras = extraPrice * (1.0 - addonDiscountPct   / 100.0);

        return discountedBase + specialPrice + discountedExtras;
    }
}

class Program
{
    static void Main()
    {
        Console.WriteLine(PriceCalc.CalculatePrice(10000, 0, 0, 0, 0));   
        Console.WriteLine(PriceCalc.CalculatePrice(20000, 0, 0, 0, 5));  
        Console.WriteLine(PriceCalc.CalculatePrice(30000, 0, 1000, 3, 0)); 
    }
}