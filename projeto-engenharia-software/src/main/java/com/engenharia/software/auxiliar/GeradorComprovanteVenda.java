/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.engenharia.software.auxiliar;

import com.engenharia.software.model.Venda;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author lobonegro
 */
public class GeradorComprovanteVenda {
    public void gerar(Venda venda) throws FileNotFoundException, IOException, PrintException {
                File home = FileSystemView.getFileSystemView().getHomeDirectory();
                String destino = home.getAbsolutePath() + "/comprovante.pdf";
                 
                //gera o pdf
                PdfDocument pdf = new PdfDocument(new PdfWriter(destino));
                Document document = new Document(pdf);
                document.add(new Paragraph("---VENDA---\n" + venda.toString()));
                document.close();
                                
                //imprimir pdf
                DocFlavor flavor = DocFlavor.BYTE_ARRAY.PDF;
                PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
                
                if (services.length > 0) {
                        DocPrintJob printJob = services[0].createPrintJob();
                        File file = new File(destino);
                        byte[] bytes = Files.readAllBytes(file.toPath());

                        Doc doc = new SimpleDoc(bytes, flavor, null);
                        printJob.print(doc, null);
                } else {
                  System.out.println("No PDF printer available.");
                }
                
                //apaga o pdf gerado
                File pdfGerado = new File(destino);
                pdfGerado.delete();
    }
}
