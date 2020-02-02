public class Purchase
{
   private int invoiceNumber;
   private double saleAmount;
   private double saleTaxAmount;
  
   public void setInvoiceNumber(int num)
   {
      invoiceNumber = num;
   }
   public void setSaleAmount(double amt)
   {
      saleAmount = amt;
     
   }
    public void setSaleTaxAmount(double amt)
   {
      saleTaxAmount = amt;     
   }
   public double getSaleAmount()
   {
      return saleAmount;
   }
   public double getSaleTaxAmount()
   {
      return saleTaxAmount;
   }
   public int getInvoiceNumber()
   {
      return invoiceNumber;
   }
   @Override
   public String toString()
   {
      return "Invoice Number: " + invoiceNumber +"  SaleAmount: $" + saleAmount + "  SaleAmountTax: $" + saleTaxAmount ;
   }
}