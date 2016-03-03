package com.calculater;

import java.util.List;

public class ExpressionCalculater
{
	
	public static String[] ops = {"=", ">", "<", "!="};
	
	public static int getRightExpression(List<String> esps, List<String> varNames, List<String> varValues)
	{
		for(int i = 0; i < esps.size(); i++)
		{
			System.out.println(esps.get(i));
		}
		for(int i = 0; i < varNames.size(); i++)
		{
			System.out.println(varNames.get(i));
		}
		for(int i = 0; i < varValues.size(); i++)
		{
			System.out.println(varValues.get(i));
		}
		
		
		for(int i = 0; i < esps.size(); i++)
		{
			String source = esps.get(i);
			for(int j = 0; j < varNames.size(); j++)
			{
				source = source.replaceAll(varNames.get(j), varValues.get(j));
			}
			System.out.println(source);
			String op = "=";
			int opseq = 0;
			for(int j = 0; j < ops.length; j++)
			{
				if(source.contains(ops[j]))
				{
					op = ops[j];
					opseq = j;
				}
			}
			String[] subesp = source.split(op);
			//System.out.println(subesp[0]);
			int result1 = SubExpressionCalculater.main(subesp[0]);
			int result2 = SubExpressionCalculater.main(subesp[1]);
			
			if(result1 == result2 && opseq == 0)
			{
				return i;
			}
			else if(result1 > result2 && opseq == 1)
			{
				return i;
			}
			else if(result1 < result2 && opseq == 2)
			{
				return i;
			}
			else if(result1 != result2 && opseq == 3)
			{
				return i;
			}
			else
			{
				continue;
			}
			
		}
		return -1;
	}
}