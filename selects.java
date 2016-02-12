
public class selects {
String query(String s){
	 String[] words = s.split(" ");
	 int k = words.length;
	 String condition=null;
	 int i=0;
	 String result=null;
	   for(;i<k;i++){
		   if(words[i].equals("(")){
			   condition=words[++i];
			   for(i++;!words[i].equals(")");i++){
			   condition=condition+" "+words[i];
		   }
			   break;
		   }
		   
	   }
	   i++;
	 if(words[i].equals("(")){
		 i++;
		 String send=words[i];
		 for (int q=i+1;q<k-1;q++){
			 send=send+" "+words[q];
		 }
		 //System.out.println(send);
		 result="( "+nested(send)+" )";
		}
	 else{
		 result=words[i];
	 }
	 String sum=" select * from "+result+" where "+condition;
	 return sum;
	   
	    
 }

String nested(String s){
	 String[] words = s.split(" ");
	String result=null;
	if(words[0].equals("select")){
    	selects select=new selects();
    	//System.out.println(s);
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
    
	return result;
}
}
