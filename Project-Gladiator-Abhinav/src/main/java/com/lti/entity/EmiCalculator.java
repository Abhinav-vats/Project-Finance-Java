package com.lti.entity;

public class EmiCalculator {

	
		private int p;//amount
		private float r;//rate
		private int n;
		public double emi;
		public EmiCalculator(int p, float r, int n)//amount,rate,year 
		{
			super();
			this.p = p;
			this.r = r/1200;
			this.n = n*12;
		}
		public double calcEmi() {
			emi=(p*r*Math.pow(1+r,n))/(Math.pow(1+r,n)-1);
			return emi;
		}
		
		
	}


