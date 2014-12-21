package main;

import enumeration.EnumerationOnline;
import enumeration.EnumerationTriee;
import pbl.PblBinPack;
import pbl.PblPartition;
import solution.SolutionWalkerBinPackBestFit;
import solution.SolutionWalkerBinPackFirstFit;
import solution.SolutionWalkerBinPackNextFit;
import solution.SolutionWalkerPartitionBestFit;
import solution.SolutionWalkerPartitionNextFit;

public class Main {

	public static void main(String[] args) {
		int n = 50;
		int[] p = { 99, 99, 96, 96, 92, 92, 91, 88, 87, 86,
					85, 76, 74, 72, 69, 67, 67, 62, 61, 56,
					52, 51, 49, 46, 44, 42, 40, 40, 33, 33,
					30, 30, 29, 28, 28, 27, 25, 24, 23, 22,
					21, 20, 17, 14, 13, 11, 10, 7, 7, 3
				  };
		int c = 100;
		
		/*int n = 5;
		int[] p = { 3, 2, 4, 5, 1 };
		int c = 6;*/
		
		/*int n = 5;
		int[] p = { 3, 2, 4, 6, 1 };
		int c = 6;*/
		
		long startTime;
		
		PblBinPack pb = new PblBinPack(n, p, c);
		EnumerationOnline eno = new EnumerationOnline(n, p);
		EnumerationTriee ent = new EnumerationTriee(n, p);
		
		SolutionWalkerBinPackNextFit swnfo = new SolutionWalkerBinPackNextFit(pb, eno);
		System.out.println("------------------------------------");
		System.out.println("-----Bin Pack Next Fit Online-------");
		System.out.println("------------------------------------");
		startTime = System.nanoTime();
		while(!swnfo.terminated()) {
			swnfo.nextPartialSolution();
		}
		System.out.println("Execution: " + ((System.nanoTime() - startTime)/1000) + "us");
		swnfo.current().display();
		
		SolutionWalkerBinPackNextFit swnft = new SolutionWalkerBinPackNextFit(pb, ent);
		System.out.println("------------------------------------");
		System.out.println("-----Bin Pack Next Fit Triee--------");
		System.out.println("------------------------------------");
		startTime = System.nanoTime();
		while(!swnft.terminated()) {
			swnft.nextPartialSolution();
		}
		System.out.println("Execution: " + ((System.nanoTime() - startTime)/1000) + "us");
		swnft.current().display();
		
		eno.reset();
		ent.reset();
		
		SolutionWalkerBinPackFirstFit swffo = new SolutionWalkerBinPackFirstFit(pb, eno);
		System.out.println("------------------------------------");
		System.out.println("-----Bin Pack First Fit Online------");
		System.out.println("------------------------------------");
		startTime = System.nanoTime();
		while(!swffo.terminated()) {
			swffo.nextPartialSolution();
		}
		System.out.println("Execution: " + ((System.nanoTime() - startTime)/1000) + "us");
		swffo.current().display();
		
		SolutionWalkerBinPackFirstFit swfft = new SolutionWalkerBinPackFirstFit(pb, ent);
		System.out.println("------------------------------------");
		System.out.println("-----Bin Pack First Fit Triee-------");
		System.out.println("------------------------------------");
		startTime = System.nanoTime();
		while(!swfft.terminated()) {
			swfft.nextPartialSolution();
		}
		System.out.println("Execution: " + ((System.nanoTime() - startTime)/1000) + "us");
		swfft.current().display();
		
		eno.reset();
		ent.reset();
		
		SolutionWalkerBinPackBestFit swbfo = new SolutionWalkerBinPackBestFit(pb, eno);
		System.out.println("------------------------------------");
		System.out.println("-----Bin Pack Best Fit Online-------");
		System.out.println("------------------------------------");
		startTime = System.nanoTime();
		while(!swbfo.terminated()) {
			swbfo.nextPartialSolution();
		}
		System.out.println("Execution: " + ((System.nanoTime() - startTime)/1000) + "us");
		swbfo.current().display();
		
		SolutionWalkerBinPackBestFit swbft = new SolutionWalkerBinPackBestFit(pb, ent);
		System.out.println("------------------------------------");
		System.out.println("-----Bin Pack Best Fit Triee--------");
		System.out.println("------------------------------------");
		startTime = System.nanoTime();
		while(!swbft.terminated()) {
			swbft.nextPartialSolution();
		}
		System.out.println("Execution: " + ((System.nanoTime() - startTime)/1000) + "us");
		swbft.current().display();
		
		eno.reset();
		ent.reset();
		
		System.out.print("\n\n\n");
		
		PblPartition pp = new PblPartition(n, p);
		
		SolutionWalkerPartitionNextFit swpnfo = new SolutionWalkerPartitionNextFit(pp, eno);
		System.out.println("------------------------------------");
		System.out.println("-----Partition Next Fit Online------");
		System.out.println("------------------------------------");
		startTime = System.nanoTime();
		while(!swpnfo.terminated()) {
			swpnfo.nextPartialSolution();
		}
		System.out.println("Execution: " + ((System.nanoTime() - startTime)/1000) + "us");
		swpnfo.current().display();
		
		SolutionWalkerPartitionNextFit swpnft = new SolutionWalkerPartitionNextFit(pp, ent);
		System.out.println("------------------------------------");
		System.out.println("-----Partition Next Fit Triee-------");
		System.out.println("------------------------------------");
		startTime = System.nanoTime();
		while(!swpnft.terminated()) {
			swpnft.nextPartialSolution();
		}
		System.out.println("Execution: " + ((System.nanoTime() - startTime)/1000) + "us");
		swpnft.current().display();
		
		eno.reset();
		ent.reset();
		
		SolutionWalkerPartitionBestFit swpbfo = new SolutionWalkerPartitionBestFit(pp, eno);
		System.out.println("------------------------------------");
		System.out.println("-----Partition Best Fit Online------");
		System.out.println("------------------------------------");
		startTime = System.nanoTime();
		while(!swpbfo.terminated()) {
			swpbfo.nextPartialSolution();
		}
		System.out.println("Execution: " + ((System.nanoTime() - startTime)/1000) + "us");
		swpbfo.current().display();
		
		SolutionWalkerPartitionBestFit swpbft = new SolutionWalkerPartitionBestFit(pp, ent);
		System.out.println("------------------------------------");
		System.out.println("-----Partition Best Fit Triee-------");
		System.out.println("------------------------------------");
		startTime = System.nanoTime();
		while(!swpbft.terminated()) {
			swpbft.nextPartialSolution();
		}
		System.out.println("Execution: " + ((System.nanoTime() - startTime)/1000) + "us");
		swpbft.current().display();
	}

}
