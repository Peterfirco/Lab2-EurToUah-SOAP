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
            System.out.print("������� ���������� ����: ");
            double eur = scanner.nextDouble();
            
            ConverterCurrencyStub stub = new ConverterCurrencyStub();
            
            ConvertEURtoUAH convert = new ConvertEURtoUAH();
            convert.setEur(eur);
            
            ConvertEURtoUAHResponse res = stub.convertEURtoUAH(convert);
            
            System.out.println("���� �i���i��� EUR: " + eur + " ���� ���i�������: " + res.get_return() + " ���");
            
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
