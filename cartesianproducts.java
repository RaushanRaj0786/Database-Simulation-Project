
public class cartesianproducts {
	String query(String s){
		 String[] words = s.split(" ");
		 int k = words.length;
		 String send1=null;
		 //String send2=null;
		 int i=0;
		 String relation1=null;
		 String sum="select * from ";
		 int lp=0;
		 
		   for(;i<k-1;i++){
			   if(lp!=0){
				   sum=sum+" , ";
			   }
			   if(words[i].equals("{")){
				   send1=words[++i];
				   for(i++;!words[i].equals("}");i++){
				   send1=send1+" "+words[i];
				   //System.out.println(send1);
			   }
				   
				   //System.out.println(send1);  
				   relation1=nested(send1);
				   lp=1;
				   sum=sum+relation1;
				   
			   }
			   
		   }
		   
		   System.out.println(sum);  
		  /* for(;i<k;i++){
			   if(words[i].equals("{")){
				   send2=words[++i];
				   for(i++;!words[i].equals("}");i++){
				   send2=send2+" "+words[i];
			   }
				   break;
			   }
			   
		   }
		   i++;*/
		   
		  // String relation1=nested(send1);
		   //String relation2=nested(send2);
		   
		   
		 
		// String sum="select * from "+relation1+" , "+relation2;
		 return sum;
		   
		    
	 }

	String nested(String s){
		 String[] words = s.split("\\s+");
		String result=null;
		if(words[0].equals("select")){
	    	selects select=new selects();
	    	 result=select.query(s);
	    }
	    else if(words[0].equals("project")){
	    	projects project=new projects();
	    	 result=project.query(s);
	    }
	    else if(words[0].equals("naturaljoin")){
	    	naturaljoins naturaljoin=new naturaljoins();
	    	result=naturaljoin.query(s);
	    }
	    else if(words[0].equals("cartesianproduct")){
	    	cartesianproducts cartesianproduct=new cartesianproducts();
	    	 result=cartesianproduct.query(s);
	    }
	    else{
	    	result=s;
	    }
		return result;
	}
}
