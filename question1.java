import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    
    public static final String SEPARATOR = "@";
    /*
     * Complete the function below.
     *
 	 * Note: The questions in this test build upon each other. We recommend you
	 * copy your solutions to your text editor of choice before proceeding to
	 * the next question as you will not be able to revisit previous questions.
	 */
	public static class Data {
        String ticker,name;
        int quantity; 
        
        public Data()
        {
            
        }
        
        public void SetData(String s)
        {
           String holding_parts[] = s.split(",");
           ticker = holding_parts[0];
           name = holding_parts[1];
           quantity = Integer.parseInt(holding_parts[2]);
         }
         
         public String GetTicker()
         {
             return ticker;
         }
        
        public String GetData()
        {
            StringBuilder output = new StringBuilder("[");
            output.append(ticker+", ");
            output.append(name+", ");
            output.append(quantity+"]");
            return (output.toString());
         }
    }

    static String printHoldings(String portfolioString) {
        String portfolio_holdings[] = portfolioString.split("@");
        int size = portfolio_holdings.length;
        Data[] list = new Data[size];
        StringBuilder result = new StringBuilder();
        for(int i=0; i< size; i++)
        {
            list[i] = new Data();
            list[i].SetData(portfolio_holdings[i]);
        }
       Arrays.sort(list, new Comparator<Data>()
       {
            public int compare(Data first, Data second)
            {
                return first.GetTicker().compareTo(second.GetTicker());
            }
        });
        for(int i=0;i<size; i++)
        {
            result.append(list[i].GetData()+", ");
        }
       return result.substring(0,result.length()-2) ;
    }
    
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        String res;
        String _input;
        try {
            _input = in.nextLine();
        } catch (Exception e) {
            _input = null;
        }
        res = printHoldings(_input);
        System.out.println(res);
    }
}
