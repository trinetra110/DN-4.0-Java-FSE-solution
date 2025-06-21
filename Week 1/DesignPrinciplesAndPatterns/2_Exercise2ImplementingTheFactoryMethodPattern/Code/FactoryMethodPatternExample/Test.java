
public class Test {

    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        System.out.println("--- Testing Word Document ---");
        wordDoc.open();
        wordDoc.close();

        System.out.println("\n--- Testing PDF Document ---");
        pdfDoc.open();
        pdfDoc.close();

        System.out.println("\n--- Testing Excel Document ---");
        excelDoc.open();
        excelDoc.close();
    }
}
