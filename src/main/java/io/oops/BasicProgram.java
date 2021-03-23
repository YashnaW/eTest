package io.oops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;


public class BasicProgram {
	
	/*A bouquet consists of different types of flowers, Roses, Jasmines, Lilys etc. Consider a rose costs 1$, jasmine costs 2$, Lily costs 3$. The cost of the bouquet is the sum of the cost of the flowers in it.  Use the object-oriented approach to design the above situation and write utility method to calculate the cost of the given bouquet.
  */
	public static void main(String args[])
	{
		 List<Integer> val = null;
		 BiConsumer<Integer, List<Integer>> Lis = (g,k)->{
				for(int l=0; l<k.size(); l++)
				{
					 k.set(l,g*k.get(l));
					
				}
				System.out.println(k.stream().mapToInt(Integer::intValue).sum());
			};
		List<Flower> flowers = new ArrayList<Flower>();
		flowers.addAll(Arrays.asList(new Rose(), new Jasmine(), new Lily() ));
		val = flowers.stream().map(c->c.calculateCost()).collect(Collectors.toList());
		Lis.accept(10, val);
		
	}
}


 


