package com.app.webservice;

import java.rmi.RemoteException;
import java.util.Scanner;

import org.apache.axis2.AxisFault;

import com.app.webservice.ConverterCurrencyStub.ConvertEURtoUAH;
import com.app.webservice.ConverterCurrencyStub.ConvertEURtoUAHResponse;

public class ConvertCurrencyClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("¬ведите количество евро: ");
            double eur = scanner.nextDouble();
            
            ConverterCurrencyStub stub = new ConverterCurrencyStub();
            
            ConvertEURtoUAH convert = new ConvertEURtoUAH();
            convert.setEur(eur);
            
            ConvertEURtoUAHResponse res = stub.convertEURtoUAH(convert);
            
            System.out.println("¬аша кiлькiсть EUR: " + eur + " буде дорiвнювати: " + res.get_return() + " грн");
            
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
