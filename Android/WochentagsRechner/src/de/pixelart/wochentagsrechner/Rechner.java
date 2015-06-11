package de.pixelart.wochentagsrechner;

/**
*
* @author Deniz Celebi
*/
public class Rechner {

   int tag = 0;
   int monat = 0;
   int jahr = 0;
   int jahr1 = 0;
   int jahr2 = 0;
   String temp = null;
   String ergebnis = null;
   
   
   
   public void Rechner(int neuerTag, int neuerMonat, int neuesJahr) {
       tag = neuerTag;
       monat = neuerMonat;
       jahr = neuesJahr;
       temp = String.valueOf(neuesJahr);
       jahr1 = Integer.valueOf(temp.substring(0,2));
       jahr2 = Integer.valueOf(temp.substring(2));
       
       berechne();
   }
   
   private void berechne() {
       int eTag;
       int eMonat;
       int eJahr1;
       int eJahr2;
       int eSchaltjahr = 0;
       int eFinal;
       
       // Tag berechnen
       eTag = tag % 7;
       
       // Monat berechnen
       eMonat = monatsZiffer(monat); 
       
       // Jahresziffer
       eJahr2 = (jahr2 + (jahr2 / 4)) % 7;
       
       // Jahrhundertsziffer
       eJahr1 = (3-(jahr1 % 4)) * 2;
       
       // Schaltjahr
       if(isSchaltjahr(jahr) && monat == 1 | monat == 2) {
           eSchaltjahr = 6;
       }
       
       // Wochentag berechnen
       eFinal = (eTag + eMonat + eJahr1 + eJahr2 + eSchaltjahr) % 7;
       ergebnis = ergebnis(eFinal);
   }
   
   private boolean isSchaltjahr(int jahr) {
       if(jahr%4 == 0) {
           if(jahr%100 == 0) {
               if(jahr%400 == 0) {
                   return true;
               }else {
                   return false;
               }
           }else {
               return true;
           }
       }else {
           return false;
       }
   }
   
   private int monatsZiffer(int monat) {
       switch(monat) {
           case 1:
               return 0;
           case 2:
               return 3;
           case 3:
               return 3;
           case 4:
               return 6;
           case 5:
               return 1;
           case 6:
               return 4;
           case 7:
               return 6;
           case 8:
               return 2;
           case 9:
               return 5;
           case 10:
               return 0;
           case 11:
               return 3;
           case 12:
               return 5;
       }
     return 0;
   }
   
   private String ergebnis(int zahl) {
       switch(zahl) {
           case 0:
               return "Sonntag";
           case 1:
               return "Montag";
           case 2:
               return "Dienstag";
           case 3:
               return "Mittwoch";
           case 4:
               return "Donnerstag";
           case 5:
               return "Freitag";
           case 6:
               return "Samstag";            
       }
       return "fehler";
   }
   
}