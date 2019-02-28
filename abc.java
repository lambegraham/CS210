class Solve
{
	//-----------------------------------------------------------
	// The boolean expression (in CNF) we are trying to solve ---
	// A negative number means NOT. So "-1" means NOT(X1) -------
	// * Stay away from variable 0 (X0) for this reason ---------
	// * You cannot have a NOT(X0) because -0 is the same as 0 --
	//-----------------------------------------------------------
	static int formula[][]=
	{
		//One row for each clause...
		//Change below this line --------------------------------
		//-------------------------------------------------------
		{-1,2,-3},
		{1,2,-3},
		{-1,-2,3},
		{1,-2,-3}
		//-------------------------------------------------------
		//Change above this line --------------------------------
	};

	// We will use this string to hold potential solutions
	// solution[i] will represent the value of Xi
	// For example solution[1] will represent the value of X1
	// It might be a "0" for False, a "1" for True, or a " " (space) for no value/don't care.
	static String solution;

	//This will hold the total number of variables in our solution
	//Of course maybe all variables aren't used.
	static int variables;


	//--------------------------------------------
	//-- Set everything up -----------------------
	//--------------------------------------------
	public static void main(String args[])
	{
		printFormula();

		countVariables();

		//Find a solution
		findSolution();

	}

	//-------------------------------------------------------------------
	//--- Check all solutions -------------------------------------------
	//-------------------------------------------------------------------
	public static void findSolution()
	{
		//There are 2^n combinations - from 0 all the way to (2^n)-1
		//where n is the number of variables
		int combinations=(int) Math.pow(2,variables);

		//Go through each combination
		for(int i=0;i<combinations;i++)
		{
			//Try the ith combination as a potential solution
			buildSolution(i);
			//Does this solution make the boolean expression true?
			if(isSolutionCorrect())
			{
				System.out.println("I found a solution!");
				printSolution();
				//We found a solution - we can stop searching now
				return;
			}
		}

		//Ooops - we tried all solutions and none of them worked
		System.out.println("This expression has no solution (unsatisfiable)!");
	}


	//-------------------------------------------------------------------
	//-- Create a string to represent a possible solution ---------------
	//-------------------------------------------------------------------
	public static void buildSolution(int i)
	{
		if(variables>30)
		{
			System.out.println("Maximum number of allowed variables is 30");
			System.exit(0);
		}

		String temp=Integer.toBinaryString(i);

		//We should have 1 digit for each boolean variable
		//Add extra digits (zeroes) to the left hand side if required
		while(temp.length()<variables)
		{
			temp="0"+temp;
		}

		solution=" "+temp; //cheap and nasty trick!
		//The space ensures that if we want to find the value for Xi, we can look at solution.charAt(i)
		//(There is no X0 - so we put a space there)
	}


	//-------------------------------------------------------------------
	//-- Print the current (possible) solution --------------------------
	//-------------------------------------------------------------------
	public static void printSolution()
	{
		System.out.println(solution);
	}


	//-------------------------------------------------------------------
	//-- How many variables in the Boolean expression -------------------
	//-------------------------------------------------------------------
	public static void countVariables()
	{
		int maxVar=0;
		for(int i=0;i<formula.length;i++)
		{
			int clause[]=formula[i];
			for(int j=0;j<clause.length;j++)
			{
				if(Math.abs(clause[j])>maxVar)
					maxVar=Math.abs(clause[j]);
			}
		}

		//Store the maximum we found
		variables=maxVar;

		System.out.println("There are "+variables+" variables");
	}


	//-------------------------------------------------------------------
	//-- Display the boolean expression ---------------------------------
	//-------------------------------------------------------------------
	public static void printFormula()
	{
		String OR=" \u2228 ";
		String AND=" \u2227 ";
		String NOT="\u0305";

		System.out.println("\n{");
		System.out.print("\t");
		//--------------------------------------------
		for(int i=0;i<formula.length;i++)
		{
			if(i>0) System.out.print(AND);
			int clause[]=formula[i];
			System.out.print("{");
			for(int j=0;j<clause.length;j++)
			{
				if(j>0) System.out.print(OR);
				if(clause[j]>0) System.out.print("X"+clause[j]);
				else            System.out.print("X"+NOT+(-clause[j]));

			}

			System.out.print("}");
		}

		//--------------------------------------------
		System.out.println("");
		System.out.println("}\n");
	}


	//-------------------------------------------------------------------
	//-- Check the current solution -------------------------------------
	//-------------------------------------------------------------------
	public static boolean isSolutionCorrect()
	{
		for(int i=0;i<formula.length;i++)
		{
			int truecount=0;
			int clause[]=formula[i];
			for(int j=0;j<clause.length;j++)
			{
				int variable=clause[j];

				if(variable<0)
				{
					variable=-variable;
					if(solution.charAt(variable)=='0') truecount++;
				}
				else
				{
					if(solution.charAt(variable)=='1') truecount++;
				}
			}

			if(truecount==0) return false;
		}

		return true;
	}

}
class Solve
{
	//-----------------------------------------------------------
	// The boolean expression (in CNF) we are trying to solve ---
	// A negative number means NOT. So "-1" means NOT(X1) -------
	// * Stay away from variable 0 (X0) for this reason ---------
	// * You cannot have a NOT(X0) because -0 is the same as 0 --
	//-----------------------------------------------------------
	static int formula[][]=
	{
		//One row for each clause...
		//Change below this line --------------------------------
		//-------------------------------------------------------
		{1 ,2,-3},
		{-1,-2,3},
		{2 ,3,-4},
		{-2,-3,4},
		{1 ,3,4},
		{-1,-3,-4},
		{-1,2,4},
		{1,-2,-4}
		//-------------------------------------------------------
		//Change above this line --------------------------------
	};

	// We will use this string to hold potential solutions
	// solution[i] will represent the value of Xi
	// For example solution[1] will represent the value of X1
	// It might be a "0" for False, a "1" for True, or a " " (space) for no value/don't care.
	static String solution;

	//This will hold the total number of variables in our solution
	//Of course maybe all variables aren't used.
	static int variables;


	//--------------------------------------------
	//-- Set everything up -----------------------
	//--------------------------------------------
	public static void main(String args[])
	{
		printFormula();

		countVariables();

		//Find a solution
		findSolution();

	}

	//-------------------------------------------------------------------
	//--- Check all solutions -------------------------------------------
	//-------------------------------------------------------------------
	public static void findSolution()
	{
		//There are 2^n combinations - from 0 all the way to (2^n)-1
		//where n is the number of variables
		int combinations=(int) Math.pow(2,variables);

		//Go through each combination
		for(int i=0;i<combinations;i++)
		{
			//Try the ith combination as a potential solution
			buildSolution(i);
			//Does this solution make the boolean expression true?
			if(isSolutionCorrect())
			{
				System.out.println("I found a solution!");
				printSolution();
				//We found a solution - we can stop searching now
				return;
			}
		}

		//Ooops - we tried all solutions and none of them worked
		System.out.println("This expression has no solution (unsatisfiable)!");
	}


	//-------------------------------------------------------------------
	//-- Create a string to represent a possible solution ---------------
	//-------------------------------------------------------------------
	public static void buildSolution(int i)
	{
		if(variables>30)
		{
			System.out.println("Maximum number of allowed variables is 30");
			System.exit(0);
		}

		String temp=Integer.toBinaryString(i);

		//We should have 1 digit for each boolean variable
		//Add extra digits (zeroes) to the left hand side if required
		while(temp.length()<variables)
		{
			temp="0"+temp;
		}

		solution=" "+temp; //cheap and nasty trick!
		//The space ensures that if we want to find the value for Xi, we can look at solution.charAt(i)
		//(There is no X0 - so we put a space there)
	}


	//-------------------------------------------------------------------
	//-- Print the current (possible) solution --------------------------
	//-------------------------------------------------------------------
	public static void printSolution()
	{
		System.out.println(solution);
	}


	//-------------------------------------------------------------------
	//-- How many variables in the Boolean expression -------------------
	//-------------------------------------------------------------------
	public static void countVariables()
	{
		int maxVar=0;
		for(int i=0;i<formula.length;i++)
		{
			int clause[]=formula[i];
			for(int j=0;j<clause.length;j++)
			{
				if(Math.abs(clause[j])>maxVar)
					maxVar=Math.abs(clause[j]);
			}
		}

		//Store the maximum we found
		variables=maxVar;

		System.out.println("There are "+variables+" variables");
	}


	//-------------------------------------------------------------------
	//-- Display the boolean expression ---------------------------------
	//-------------------------------------------------------------------
	public static void printFormula()
	{
		String OR=" \u2228 ";
		String AND=" \u2227 ";
		String NOT="\u0305";

		System.out.println("\n{");
		System.out.print("\t");
		//--------------------------------------------
		for(int i=0;i<formula.length;i++)
		{
			if(i>0) System.out.print(AND);
			int clause[]=formula[i];
			System.out.print("{");
			for(int j=0;j<clause.length;j++)
			{
				if(j>0) System.out.print(OR);
				if(clause[j]>0) System.out.print("X"+clause[j]);
				else            System.out.print("X"+NOT+(-clause[j]));

			}

			System.out.print("}");
		}

		//--------------------------------------------
		System.out.println("");
		System.out.println("}\n");
	}


	//-------------------------------------------------------------------
	//-- Check the current solution -------------------------------------
	//-------------------------------------------------------------------
	public static boolean isSolutionCorrect()
	{
		for(int i=0;i<formula.length;i++)
		{
			int truecount=0;
			int clause[]=formula[i];
			for(int j=0;j<clause.length;j++)
			{
				int variable=clause[j];

				if(variable<0)
				{
					variable=-variable;
					if(solution.charAt(variable)=='0') truecount++;
				}
				else
				{
					if(solution.charAt(variable)=='1') truecount++;
				}
			}

			if(truecount==0) return false;
		}

		return true;
	}

}