
public class FoodProduct implements Comparable<FoodProduct> {
	
	    private String Name;
	    private Float Price ;
	    private Integer Index ;
	    
	    public FoodProduct()
	    {
	    	
	    }
	    
	    public String getName() {
			return Name;
		}

		public void setName(String name) {
			Name = name;
		}

		public Float getPrice() {
			return Price;
		}

		public void setPrice(Float price) {
			Price = price;
		}

		public Integer getIndex() {
			return Index;
		}

		public void setIndex(Integer index) {
			Index = index;
		}

		public FoodProduct(String n, Float p , Integer i) {
	   	     Name = n ;
	  	     Price = p;
	  	     Index =  i ;  	     	    
       }
	    
	    @Override
	    public int compareTo(FoodProduct o) {	       	      
	       return  o.getIndex().compareTo(this.getIndex()) ; 
	    }
	    
	    @Override
	    public String toString()
	    {
	    	return "Name = "+Name+": Price = "+Price+": Healthy Eating Index ="+Index ;
	    }

	    
}
